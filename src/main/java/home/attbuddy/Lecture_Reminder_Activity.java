package home.attbuddy;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Aishwarya on 9/10/2016.
 */
public class Lecture_Reminder_Activity extends AppCompatActivity {

    Database_Helper_Lectures entry;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders_lectures);

        TextView tv1 = (TextView) findViewById(R.id.name);
        int id = getIntent().getIntExtra("click",0);
        Cursor sub = entry.setTitle(""+id);
        if(sub != null && sub.moveToFirst() )
        {
            tv1.setText("∞"+sub.getString(0).toUpperCase()+"∞");
        }
    }
}
