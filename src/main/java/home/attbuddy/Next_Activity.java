package home.attbuddy;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Aishwarya on 6/15/2016.
 */
public class Next_Activity extends AppCompatActivity {
    Button setup_timetable;
    Database_Helper_User login;
    String name;

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        login = new Database_Helper_User(this);

        Cursor res = login.getAllData();
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext())
        {
           name =  buffer.append(res.getString(1)).toString().toUpperCase();
        }
        res.close();


        TextView tv1 = (TextView) findViewById(R.id.username);
        TextView tv2 = (TextView) findViewById(R.id.details1);
        tv1.setText("∞"+name+"∞");
        tv2.setText("HELLO..."+name );
        onClickSetupTimeTable();
    }


    public void onClickSetupTimeTable() {
        setup_timetable=(Button)findViewById(R.id.setup_timetable);
        setup_timetable.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i1 = new Intent(Next_Activity.this,Setup_TimeTable_Activity.class);
                        startActivity(i1);
                    }
                }
    );

    }
    }
