package home.attbuddy;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Aishwarya on 8/15/2016.
 */
public class See_Effect_Activity extends AppCompatActivity {

    Database_Helper_Miss miss;
    Database_Helper_Lectures entry;
    Database_Helper_Attendance stats;
    Database_Helper_Days days;

    @Override
    public void onBackPressed() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        TextView tv1 = (TextView) findViewById(R.id.username);
        tv1.setText("∞"+"MISS EFFECT"+"∞");

        stats = new Database_Helper_Attendance(this);
        entry = new Database_Helper_Lectures(this);
        miss = new Database_Helper_Miss(this);
        days = new Database_Helper_Days(this);
        updateDetails();

        Button finish=(Button)findViewById(R.id.finish_btn);
        finish.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        miss.deleteAllDetails();
                        Intent i1 = new Intent(See_Effect_Activity.this, List_Activity.class);
                        startActivity(i1);
                    }
                });
    }

    public ArrayList changeAttendance_new()
    {
        ArrayList<String> subjects_miss = changeSubjects();
        final ArrayList<Double> attendance_miss =new ArrayList<>();
        String weekDay;
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        weekDay = dayFormat.format(calendar.getTime());
        String Day= weekDay.toUpperCase();
        for (int i = 0; i <subjects_miss.size(); i++)
        {
            String temp = subjects_miss.get(i);
            int total = totalCountSubject(temp);
            int bunk = miss.getMissTitle(temp);
            Cursor get_att = stats.getAttended(temp);
            Cursor get_tot = stats.getTotal(temp);
            while(get_att.moveToNext()&&get_tot.moveToNext())
            {
                if(Day.equals("MONDAY"))
                {
                    attendance_miss.add(((get_att.getDouble(0)+total-bunk)/(get_tot.getDouble(0)+total))*100);
                }
                if(Day.equals("TUESDAY"))
                {
                    attendance_miss.add(((get_att.getDouble(0)+(total-monCount(temp))-bunk)/(get_tot.getDouble(0)+(total-monCount(temp))))*100);
                }
                if(Day.equals("WEDNESDAY"))
                {
                    attendance_miss.add(((get_att.getDouble(0)+(total-monCount(temp)-tueCount(temp))-bunk)/(get_tot.getDouble(0)+(total-monCount(temp)-tueCount(temp))))*100);
                }
                if(Day.equals("THURSDAY"))
                {
                    attendance_miss.add(((get_att.getDouble(0)+(total-monCount(temp)-tueCount(temp)-wedCount(temp))-bunk)/(get_tot.getDouble(0)+(total-monCount(temp)-tueCount(temp)-wedCount(temp))))*100);
                }
                if(Day.equals("FRIDAY"))
                {
                    attendance_miss.add(((get_att.getDouble(0)+(total-monCount(temp)-tueCount(temp)-wedCount(temp)-thuCount(temp))-bunk)/(get_tot.getDouble(0)+(total-monCount(temp)-tueCount(temp)-wedCount(temp)-thuCount(temp))))*100);
                }
                if(Day.equals("SATURDAY"))
                {
                    attendance_miss.add(((get_att.getDouble(0)+(total-monCount(temp)-tueCount(temp)-wedCount(temp)-thuCount(temp)-friCount(temp))-bunk)/(get_tot.getDouble(0)+(total-monCount(temp)-tueCount(temp)-wedCount(temp)-thuCount(temp)-friCount(temp))))*100);
                }
                if(Day.equals("SUNDAY"))
                {
                    attendance_miss.add(((get_att.getDouble(0)+(total-monCount(temp)-tueCount(temp)-wedCount(temp)-thuCount(temp)-friCount(temp)-satCount(temp))-bunk)/(get_tot.getDouble(0)+(total-monCount(temp)-tueCount(temp)-wedCount(temp)-thuCount(temp)-friCount(temp)-satCount(temp))))*100);
                }
            }
            get_att.close();
            get_tot.close();
        }
        return attendance_miss;
    }

    public ArrayList changeAttendance_old()
    {
        ArrayList<String> subjects_miss = changeSubjects();
        final ArrayList<Double> attendance_miss =new ArrayList<>();
        for (int i = 0; i <subjects_miss.size(); i++)
        {
            String temp = subjects_miss.get(i);
            Cursor get_att = stats.getAttended(temp);
            Cursor get_tot = stats.getTotal(temp);
            while(get_att.moveToNext()&&get_tot.moveToNext())
            {
                attendance_miss.add(get_att.getDouble(0)/get_tot.getDouble(0)*100);
            }
            get_att.close();
            get_tot.close();
        }
        return attendance_miss;
    }

    public ArrayList changeSubjects()
    {
        ArrayList<String> subjects_miss = new ArrayList<>();
        Cursor getit = miss.getSubjectsTitle();
        while(getit.moveToNext())
        {
            subjects_miss.add(getit.getString(0).toUpperCase());
        }
        getit.close();
        return subjects_miss;
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

    public void updateDetails()
    {
        Double tot = 0.0;
        ArrayList<Double> attendance_array=new ArrayList<>();
        attendance_array = attendance();
        Double bunk = Double.parseDouble(""+miss.resultUpdate());
        int temp = totalCount();
        Double occur = Double.parseDouble(""+temp);
        Double num = stats.getNum();
        Double den = stats.getDen();
        Double val = ((num+occur-bunk)/(den+occur))*100;
        String resultUp  = String.format("%.2f",val);
        for(int i=0;i<attendance_array.size();i++)
        {
            tot = tot +  attendance_array.get(i);
        }
        Double avg  = tot/attendance_array.size();
        String result  = String.format("%.2f",avg);
        Button total  = (Button) findViewById(R.id.total_btn);
        total.setText("TOTAL : "+result+"%--->"+resultUp+"%");
        ListView lv = (ListView) findViewById(R.id.subject_list);
        CustomAdapter lvAdapter = new CustomAdapter();
        lv.setAdapter(lvAdapter);
    }

    public int totalCountSubject(String title)
    {
        int k = miss.getDayValue();
        int total=0;
        if(k==11)
        {
            total = monCount(title);
        }
        if(k==12)
        {
            total = monCount(title)+tueCount(title);
        }
        if(k==13)
        {
            total = monCount(title)+tueCount(title)+wedCount(title);
        }
        if(k==14)
        {
            total = monCount(title)+tueCount(title)+wedCount(title)+thuCount(title);
        }
        if(k==15)
        {
            total = monCount(title)+tueCount(title)+wedCount(title)+thuCount(title)+friCount(title);
        }
        if(k==16)
        {
            total = monCount(title)+tueCount(title)+wedCount(title)+thuCount(title)+friCount(title)+satCount(title);
        }
        if(k==21)
        {
            total = (monCount(title))*2+tueCount(title)+wedCount(title)+thuCount(title)+friCount(title)+satCount(title);
        }
        if(k==22)
        {
            total = (monCount(title)+tueCount(title))*2+wedCount(title)+thuCount(title)+friCount(title)+satCount(title);
        }
        if(k==23)
        {
            total = (monCount(title)+tueCount(title)+wedCount(title))*2+thuCount(title)+friCount(title)+satCount(title);
        }
        if(k==24)
        {
            total = (monCount(title)+tueCount(title)+wedCount(title)+thuCount(title))*2+friCount(title)+satCount(title);
        }
        if(k==25)
        {
            total = (monCount(title)+tueCount(title)+wedCount(title)+thuCount(title)+friCount(title))*2+satCount(title);
        }
        if(k==26)
        {
            total = (monCount(title)+tueCount(title)+wedCount(title)+thuCount(title)+friCount(title)+satCount(title))*2;
        }
        return total;
    }

    public int totalCount()
    {
        int k = miss.getDayValue();
        int l = entry.weekCount();
        int total=0;
        if(k==11)
        {
            total = monTotCount();
        }
        if(k==12)
        {
            total = monTotCount()+tueTotCount();
        }
        if(k==13)
        {
            total = monTotCount()+tueTotCount()+wedTotCount();
        }
        if(k==14)
        {
            total = monTotCount()+tueTotCount()+wedTotCount()+thuTotCount();
        }
        if(k==15)
        {
            total = monTotCount()+tueTotCount()+wedTotCount()+thuTotCount()+friTotCount();
        }
        if(k==16)
        {
            total = monTotCount()+tueTotCount()+wedTotCount()+thuTotCount()+friTotCount()+satTotCount();
        }
        if(k==21)
        {
            total = l+monTotCount();
        }
        if(k==22)
        {
            total = l+monTotCount()+tueTotCount();
        }
        if(k==23)
        {
            total = l+monTotCount()+tueTotCount()+wedTotCount();
        }
        if(k==24)
        {
            total = l+monTotCount()+tueTotCount()+wedTotCount()+thuTotCount();
        }
        if(k==25)
        {
            total = l+monTotCount()+tueTotCount()+wedTotCount()+thuTotCount()+friTotCount();
        }
        if(k==26)
        {
            total = l+monTotCount()+tueTotCount()+wedTotCount()+thuTotCount()+friTotCount()+satTotCount();
        }
        return total;
    }

    public int monCount(String title)
    {
        Cursor param2 = entry.sub_ID(title);
        int count =0;
        while (param2.moveToNext())
        {
            Cursor param1 = days.getID();
            while(param1.moveToNext())
            {
                if(param2.getString(0).equals(param1.getString(1)))
                {
                    count++;
                }
            }
            param1.close();
        }
        param2.close();
        return count;
    }

    public int monTotCount()
    {
        Cursor param2 = entry.all_ID();
        int count =0;
        while (param2.moveToNext())
        {
            Cursor param1 = days.getID();
            while(param1.moveToNext())
            {
                if(param2.getString(0).equals(param1.getString(1)))
                {
                    count++;
                }
            }
            param1.close();
        }
        param2.close();
        return count;
    }

    public int tueCount(String title)
    {
        Cursor param2 = entry.sub_ID(title);
        int count =0;
        while (param2.moveToNext())
        {
            Cursor param1 = days.getID();
            while(param1.moveToNext())
            {
                if(param2.getString(0).equals(param1.getString(2)))
                {
                    count++;
                }
            }
            param1.close();
        }
        param2.close();
        return count;
    }

    public int tueTotCount()
    {
        Cursor param2 = entry.all_ID();
        int count =0;
        while (param2.moveToNext())
        {
            Cursor param1 = days.getID();
            while(param1.moveToNext())
            {
                if(param2.getString(0).equals(param1.getString(2)))
                {
                    count++;
                }
            }
            param1.close();
        }
        param2.close();
        return count;
    }

    public int wedCount(String title)
    {
        Cursor param2 = entry.sub_ID(title);
        int count =0;
        while (param2.moveToNext())
        {
            Cursor param1 = days.getID();
            while(param1.moveToNext())
            {
                if(param2.getString(0).equals(param1.getString(3)))
                {
                    count++;
                }
            }
            param1.close();
        }
        param2.close();
        return count;
    }

    public int wedTotCount()
    {
        Cursor param2 = entry.all_ID();
        int count =0;
        while (param2.moveToNext())
        {
            Cursor param1 = days.getID();
            while(param1.moveToNext())
            {
                if(param2.getString(0).equals(param1.getString(3)))
                {
                    count++;
                }
            }
            param1.close();
        }
        param2.close();
        return count;
    }

    public int thuCount(String title)
    {
        Cursor param2 = entry.sub_ID(title);
        int count =0;
        while (param2.moveToNext())
        {
            Cursor param1 = days.getID();
            while(param1.moveToNext())
            {
                if(param2.getString(0).equals(param1.getString(4)))
                {
                    count++;
                }
            }
            param1.close();
        }
        param2.close();
        return count;
    }

    public int thuTotCount()
    {
        Cursor param2 = entry.all_ID();
        int count =0;
        while (param2.moveToNext())
        {
            Cursor param1 = days.getID();
            while(param1.moveToNext())
            {
                if(param2.getString(0).equals(param1.getString(4)))
                {
                    count++;
                }
            }
            param1.close();
        }
        param2.close();
        return count;
    }

    public int friCount(String title)
    {
        Cursor param2 = entry.sub_ID(title);
        int count =0;
        while (param2.moveToNext())
        {
            Cursor param1 = days.getID();
            while(param1.moveToNext())
            {
                if(param2.getString(0).equals(param1.getString(5)))
                {
                    count++;
                }
            }
            param1.close();
        }
        param2.close();
        return count;
    }

    public int friTotCount()
    {
        Cursor param2 = entry.all_ID();
        int count =0;
        while (param2.moveToNext())
        {
            Cursor param1 = days.getID();
            while(param1.moveToNext())
            {
                if(param2.getString(0).equals(param1.getString(5)))
                {
                    count++;
                }
            }
            param1.close();
        }
        param2.close();
        return count;
    }

    public int satCount(String title)
    {
        Cursor param2 = entry.sub_ID(title);
        int count =0;
        while (param2.moveToNext())
        {
            Cursor param1 = days.getID();
            while(param1.moveToNext())
            {
                if(param2.getString(0).equals(param1.getString(6)))
                {
                    count++;
                }
            }
            param1.close();
        }
        param2.close();
        return count;
    }

    public int satTotCount()
    {
        Cursor param2 = entry.all_ID();
        int count =0;
        while (param2.moveToNext())
        {
            Cursor param1 = days.getID();
            while(param1.moveToNext())
            {
                if(param2.getString(0).equals(param1.getString(6)))
                {
                    count++;
                }
            }
            param1.close();
        }
        param2.close();
        return count;
    }

    class CustomAdapter extends BaseAdapter {

        ArrayList<String> subjects_array;
        ArrayList<Double> attendance_array_old;
        ArrayList<Double> attendance_array_new;


        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            subjects_array = changeSubjects();
            attendance_array_old = changeAttendance_old();
            attendance_array_new = changeAttendance_new();
            return attendance_array_old.size();
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
            LayoutInflater layoutInflater = LayoutInflater.from(See_Effect_Activity.this);
            View CustomView = layoutInflater.inflate(R.layout.show_change,parent,false);
            final TextView name = (TextView) CustomView.findViewById(R.id.sub_name);
            EditText attendance_old = (EditText) CustomView.findViewById(R.id.attend);
            EditText attendance_new = (EditText) CustomView.findViewById(R.id.total);
            attendance_old.setFocusable(false);
            attendance_new.setFocusable(false);
            // inflate the layout which contains imageview and textview which are aligned horizontally.
            //Assuming you inflated layout and got imageView and textview from that layout
            name.setText(subjects_array.get(position));
            Double temp_old = attendance_array_old.get(position);
            Double temp_new = attendance_array_new.get(position);
            if(temp_old==100.0)
            {
                attendance_old.setText(temp_old+"%");
                String result_new = String.format("%.2f",temp_new);
                attendance_new.setText(result_new+"%");
            }
            else
            {
                String result_old  = String.format("%.2f",temp_old);
                attendance_old.setText(result_old+"%");
                String result_new = String.format("%.2f",temp_new);
                attendance_new.setText(result_new+"%");
            }
            return CustomView;
        }

    }

}
