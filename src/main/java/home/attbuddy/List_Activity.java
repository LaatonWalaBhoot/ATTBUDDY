package home.attbuddy;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Aishwarya on 6/15/2016.
 */
public class List_Activity extends Activity {

    TextView tv;
    Database_Helper_User login;
    String name;

    public void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        setContentView(R.layout.activity_list);

        login = new Database_Helper_User(this);

        Cursor res = login.getAllData();
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext())
        {
            name = buffer.append(res.getString(1)).toString().toUpperCase();
        }

        tv = (TextView) findViewById(R.id.username);
        tv.setText("∞"+name+"∞");
        onClickChangeTimeTable();
        onClickBunkEffect();
        onClickReminders();
        onClickAttendance();
    }

    public void onClickChangeTimeTable() {
        Button change_timetable = (Button) findViewById(R.id.change_timetable);
        change_timetable.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(List_Activity.this, Change_TimeTable_Activity.class);
                        startActivity(i);
                    }
                }
        );
    }

    public void onClickBunkEffect() {
        Button bunk_effect = (Button) findViewById(R.id.bunk_effect_btn);
        bunk_effect.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(List_Activity.this, Bunk_Effect_Activity.class);
                        startActivity(i);
                    }
                }
        );
    }

    public void onClickReminders() {
        Button reminders = (Button) findViewById(R.id.reminders_btn);
        reminders.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(List_Activity.this, Reminders_Activity.class);
                        startActivity(i);
                    }
                }
        );
    }

    public void onClickAttendance() {
        Button attendance = (Button) findViewById(R.id.attendance_btn);
        attendance.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(List_Activity.this, Attendance_Activity.class);
                        startActivity(i);
                    }
                }
        );
    }
}