package home.attbuddy;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static Button freshstart_btn;
    private static Button login_btn;
    Database_Helper_User login;

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = new Database_Helper_User(this);
        final Cursor res = login.getAllData();


        login_btn= (Button)findViewById(R.id.login_btn);
        freshstart_btn= (Button)findViewById(R.id.freshstart_btn);

        if(res.getCount()==0)
        {
            login_btn.setVisibility(View.GONE);
            onClickFreshStart();
        }
        else
        {
            StringBuffer buffer = new StringBuffer();
            while(res.moveToNext())
            {
                buffer.append(res.getString(1));
            }
            login_btn.setText(buffer);
            onClickName();
            onClickFreshStart();
        }
        res.close();
    }

    public void onClickFreshStart() {

        freshstart_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this,FreshStart_Activity.class);
                        startActivity(i);
                    }
                }
        );


    }

    public void onClickName() {

        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String state="";
                        Cursor res = login.getAllData();
                        while(res.moveToNext())
                        {
                            state = res.getString(2).toUpperCase();
                        }
                        if(state.equals("START"))
                        {
                            Intent i = new Intent(MainActivity.this,Next_Activity.class);
                            startActivity(i);
                        }
                        else if(state.equals("TIMETABLE"))
                        {
                            Intent i = new Intent(MainActivity.this,Timetable_Done_Activity.class);
                            startActivity(i);
                        }
                        else if(state.equals("END"))
                        {
                            Intent i = new Intent(MainActivity.this,List_Activity.class);
                            startActivity(i);
                        }
                        else
                        {
                            Intent i = new Intent(MainActivity.this,Next_Activity.class);
                            startActivity(i);
                        }
                        res.close();
                    }
                }
        );

    }
}
