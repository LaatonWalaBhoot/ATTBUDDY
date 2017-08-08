package home.attbuddy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Aishwarya on 7/28/2016.
 */
public class GetAttendance_Activity extends AppCompatActivity {

    Database_Helper_Lectures entry;
    Database_Helper_User login;
    Database_Helper_Attendance stats;
    String name;
    Button finish;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getattendance);

        login = new Database_Helper_User(this);
        Cursor res = login.getAllData();
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext())
        {
            name =  buffer.append(res.getString(1)).toString().toUpperCase();
        }
        res.close();

        TextView tv1 = (TextView) findViewById(R.id.username);
        tv1.setText("∞"+name+"∞");

        stats = new Database_Helper_Attendance(this);

        entry = new Database_Helper_Lectures(this);
        Cursor sub = entry.getSubjectsTitle();
        final ArrayList<String> subjects_array=new ArrayList<>();
        if (sub.moveToFirst()) {
            do {
                subjects_array.add(sub.getString(0).toUpperCase()); //<< pass column index here instead of i

            } while (sub.moveToNext());
        }
        sub.close();

        ArrayAdapter<String> subjectsAdapter = new ArrayAdapter<>(this,R.layout.subjects,R.id.sub_name,subjects_array);
        final ListView lv = (ListView)findViewById(R.id.subject_list);
        lv.setAdapter(subjectsAdapter);
        Toast.makeText(getApplicationContext(), ""+lv.getLastVisiblePosition(), Toast.LENGTH_SHORT).show();


        finish=(Button)findViewById(R.id.finish_btn);
        finish.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final ArrayList<Double> attended = new ArrayList<>();
                        final ArrayList<Double> total = new ArrayList<>();
                        EditText et_attend;
                        EditText et_total;
                        int flag=0;
                        for (int i = 0; i < lv.getCount(); i++)
                        {
                            v=lv.getChildAt(i);
                            et_attend = (EditText) v.findViewById(R.id.attend);
                            et_total = (EditText) v.findViewById(R.id.total);
                            if(et_attend.getText().toString().length()>0&&et_total.getText().toString().length()>0)
                            {
                                if(Double.parseDouble(et_total.getText().toString())<Double.parseDouble(et_attend.getText().toString()))
                                {
                                    flag=1;
                                    et_attend.setError("CANNOT BE GREATER THAN TOTAL LECTURES");
                                }
                                else
                                {
                                    attended.add(Double.parseDouble(et_attend.getText().toString()));
                                    total.add(Double.parseDouble(et_total.getText().toString()));
                                    et_attend.setError(null);
                                    et_total.setError(null);
                                    flag=2;
                                }
                            }
                            else
                            {
                                if(et_attend.getText().toString().length()==0&&et_total.getText().toString().length()>0)
                                {
                                    et_attend.setError("THIS FIELD CANNOT BE BLANK");
                                }
                                else if(et_total.getText().toString().length()==0&&et_attend.getText().toString().length()>0)
                                {
                                    et_total.setError("THIS FIELD CANNOT BE BLANK");
                                }
                                else
                                {
                                    et_attend.setError("THIS FIELD CANNOT BE BLANK");
                                    et_total.setError("THIS FIELD CANNOT BE BLANK");
                                }
                               flag=0;
                            }
                        }
                        if(flag==2)
                        {
                            stats.insertAttendance(subjects_array,attended,total);
                            login.update(name.toUpperCase(),"END");
                            Intent i1 = new Intent(GetAttendance_Activity.this,List_Activity.class);
                            startActivity(i1);
                        }
                        else if(flag==1)
                        {
                            Toast.makeText(getApplicationContext(), "ATTENDED LECTURES CANNOT BE GREATER THAN TOTAL", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "FILL REQUIRED FIELDS", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    public View getViewByPosition(int position, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = listView.getLastVisiblePosition();

        if (position < firstListItemPosition || position > lastListItemPosition ) {
            return listView.getAdapter().getView(position, null, listView);
        } else {
            final int childIndex = position - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }
}
