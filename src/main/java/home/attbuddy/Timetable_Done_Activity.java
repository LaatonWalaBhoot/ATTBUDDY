package home.attbuddy;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Aishwarya on 6/15/2016.
 */
public class Timetable_Done_Activity extends AppCompatActivity {
    Button setup_lectures;
    Database_Helper_User login;
    String name;
    private Calendar cal;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable_done);
        onClickSetupLectures();

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
    }

    public void onClickSetupLectures() {
        setup_lectures=(Button)findViewById(R.id.setup_lectures);
        setup_lectures.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            Intent i1 = new Intent(Timetable_Done_Activity.this, GetAttendance_Activity.class);
                            startActivity(i1);
                    }
                }
        );

    }
}
