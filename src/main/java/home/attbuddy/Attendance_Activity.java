package home.attbuddy;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Aishwarya on 7/28/2016.
 */
public class Attendance_Activity extends AppCompatActivity {

    Database_Helper_Lectures entry;
    Database_Helper_User login;
    Database_Helper_Attendance stats;
    Database_Helper_Days days;
    String name;
    Button finish;
    Button between;
    private Calendar cal;
    private int day;
    private int month;
    private int year;
    int start_day;
    int start_month;
    int start_year;
    TextView from_date;
    TextView to_date;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);

        login = new Database_Helper_User(this);
        stats = new Database_Helper_Attendance(this);
        entry = new Database_Helper_Lectures(this);
        days = new Database_Helper_Days(this);

        Cursor res = login.getAllData();

        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext())
        {
            name =  buffer.append(res.getString(1)).toString().toUpperCase();
        }
        res.close();

        TextView tv1 = (TextView) findViewById(R.id.username);
        tv1.setText("∞"+"ATTENDANCE"+"∞");
        updateDetails();

        finish=(Button)findViewById(R.id.finish_btn);
        finish.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i1 = new Intent(Attendance_Activity.this, List_Activity.class);
                        startActivity(i1);
                    }
                });
    }

    public void updateDetails()
    {
        Double tot = 0.0;
        ArrayList<Double> attendance_array=new ArrayList<>();
        attendance_array = attendance();
        for(int i=0;i<attendance_array.size();i++)
        {
                tot = tot +  attendance_array.get(i);
        }
        Double avg  = tot/attendance_array.size();
        String result  = String.format("%.2f",avg);
        Button total  = (Button) findViewById(R.id.total_btn);
        total.setText("TOTAL : "+result+"%");
        ListView lv = (ListView) findViewById(R.id.subject_list);
        CustomAdapter lvAdapter = new CustomAdapter();
        lv.setAdapter(lvAdapter);
    }

    public ArrayList subjects() {
        Cursor sub = entry.getSubjectsTitle();
        final ArrayList<String> subjects_array = new ArrayList<>();
        if (sub.moveToFirst()) {
            do {
                subjects_array.add(sub.getString(0).toUpperCase()); //<< pass column index here instead of i

            } while (sub.moveToNext());
        }
        sub.close();
        return subjects_array;
    }

    public ArrayList attendance()
    {
        ArrayList<String> subjects_array  = subjects();
        final ArrayList<Double> attendance_array=new ArrayList<>();
        for (int i = 0; i <subjects_array.size(); i++)
        {
            String temp = subjects_array.get(i);
            Cursor get_att = stats.getAttended(temp);
            Cursor get_tot = stats.getTotal(temp);
            while(get_att.moveToNext()&&get_tot.moveToNext())
            {
                    attendance_array.add(get_att.getDouble(0)/get_tot.getDouble(0)*100);
            }
            get_att.close();
            get_tot.close();
        }
        return attendance_array;
    }

    class CustomAdapter extends BaseAdapter {

        ArrayList<String> subjects_array;
        ArrayList<Double> attendance_array;


        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            subjects_array = subjects();
            attendance_array = attendance();
            return subjects_array.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(Attendance_Activity.this);
            View CustomView = layoutInflater.inflate(R.layout.edit_subjects,parent,false);
            final TextView name = (TextView) CustomView.findViewById(R.id.sub_name);
            EditText attendance = (EditText) CustomView.findViewById(R.id.sub_attendance);
            Button edit = (Button)CustomView.findViewById(R.id.edit);
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String temp = name.getText().toString().toUpperCase();
                    Cursor get_att = stats.getAttended(temp);
                    Cursor get_tot = stats.getTotal(temp);
                    LayoutInflater inflater = getLayoutInflater();
                    View alertLayout = inflater.inflate(R.layout.num_den, null);
                    AlertDialog.Builder alert = new AlertDialog.Builder(Attendance_Activity.this);
                    final EditText num = (EditText)alertLayout.findViewById(R.id.numerator);
                    final EditText den = (EditText)alertLayout.findViewById(R.id.denominator);
                    while(get_att.moveToNext()&&get_tot.moveToNext())
                    {
                            Double num_temp = get_att.getDouble(0);
                            Double den_temp = get_tot.getDouble(0);
                            num.setText(""+num_temp.intValue());
                            den.setText(""+den_temp.intValue());
                    }
                    alert.setTitle("∞"+temp+"∞");
                    // this is set the view from XML inside AlertDialog
                    alert.setView(alertLayout);
                    // disallow cancel of AlertDialog on click of back button and outside touch
                    alert.setCancelable(false);
                    alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //obj_tv[i].setText(before_change);
                        }
                    });

                    alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(Double.parseDouble(num.getText().toString())>Double.parseDouble(den.getText().toString()))
                            {
                                Toast.makeText(getApplicationContext(), "NUMERATOR CANNOT BE GREATER THAN DENOMINATOR", Toast.LENGTH_SHORT).show();
                            }
                            else if(Integer.parseInt(den.getText().toString())==0)
                            {
                                Toast.makeText(getApplicationContext(), "DENOMINATOR CANNOT BE ZERO", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                stats.updateDetails(temp,Double.parseDouble(num.getText().toString()),Double.parseDouble(den.getText().toString()));
                                updateDetails();
                            }
                        }
                    });
                    AlertDialog dialog = alert.create();
                    dialog.show();
                    get_att.close();
                    get_tot.close();
                }
            });
            attendance.setFocusable(false);
            // inflate the layout which contains imageview and textview which are aligned horizontally.
            //Assuming you inflated layout and got imageView and textview from that layout
            name.setText(subjects_array.get(position));
            Double temp = attendance_array.get(position);
            if(temp==100.0)
            {
                attendance.setText(temp+"%");
            }
            else
            {
                String result  = String.format("%.2f",temp);
                attendance.setText(result+"%");
            }
            return CustomView;
        }

    }
}
