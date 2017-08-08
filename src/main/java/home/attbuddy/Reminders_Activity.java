package home.attbuddy;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.LayoutInflater;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Reminders_Activity extends Activity implements View.OnClickListener {

    private int i;
    String upDated;
    Calendar c = Calendar.getInstance();//to add days
    Database_Helper_Lectures entry;

    private int[] tv_id = {R.id.TextView12,R.id.TextView13,R.id.TextView14,R.id.TextView15,R.id.TextView16,R.id.TextView17,R.id.TextView18,R.id.TextView19,
            R.id.TextView22,R.id.TextView23,R.id.TextView24,R.id.TextView25,R.id.TextView26,R.id.TextView27,R.id.TextView28,R.id.TextView29,
            R.id.TextView32,R.id.TextView33,R.id.TextView34,R.id.TextView35,R.id.TextView36,R.id.TextView37,R.id.TextView38,R.id.TextView39,
            R.id.TextView42,R.id.TextView43,R.id.TextView44,R.id.TextView45,R.id.TextView46,R.id.TextView47,R.id.TextView48,R.id.TextView49,
            R.id.TextView52,R.id.TextView53,R.id.TextView54,R.id.TextView55,R.id.TextView56,R.id.TextView57,R.id.TextView58,R.id.TextView59,
            R.id.TextView62,R.id.TextView63,R.id.TextView64,R.id.TextView65,R.id.TextView66,R.id.TextView67,R.id.TextView68,R.id.TextView69};

    TextView[] obj_tv = new TextView[48];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_timetable);
        entry = new Database_Helper_Lectures(this);
        onClickNextWeek();
        importTitle();

        for (i = 0; i < 48; i++) {
            obj_tv[i] = (TextView) findViewById(tv_id[i]);
            obj_tv[i].setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View v){
        switch(v.getId())
        {
            //Row 1
            case R.id.TextView12:
                alert(R.id.TextView12);
                break;
            case R.id.TextView13:
                alert(R.id.TextView13);
                break;
            case R.id.TextView14:
                alert(R.id.TextView14);
                break;
            case R.id.TextView15:
                alert(R.id.TextView15);
                break;
            case R.id.TextView16:
                alert(R.id.TextView16);
                break;
            case R.id.TextView17:
                alert(R.id.TextView17);
                break;
            case R.id.TextView18:
                alert(R.id.TextView18);
                break;
            case R.id.TextView19:
                alert(R.id.TextView19);
                break;

            //Row 2
            case R.id.TextView22:
                alert(R.id.TextView22);
                break;
            case R.id.TextView23:
                alert(R.id.TextView23);
                break;
            case R.id.TextView24:
                alert(R.id.TextView24);
                break;
            case R.id.TextView25:
                alert(R.id.TextView25);
                break;
            case R.id.TextView26:
                alert(R.id.TextView26);
                break;
            case R.id.TextView27:
                alert(R.id.TextView27);
                break;
            case R.id.TextView28:
                alert(R.id.TextView28);
                break;
            case R.id.TextView29:
                alert(R.id.TextView29);
                break;

            //Row 3
            case R.id.TextView32:
                alert(R.id.TextView32);
                break;
            case R.id.TextView33:
                alert(R.id.TextView33);
                break;
            case R.id.TextView34:
                alert(R.id.TextView34);
                break;
            case R.id.TextView35:
                alert(R.id.TextView35);
                break;
            case R.id.TextView36:
                alert(R.id.TextView36);
                break;
            case R.id.TextView37:
                alert(R.id.TextView37);
                break;
            case R.id.TextView38:
                alert(R.id.TextView38);
                break;
            case R.id.TextView39:
                alert(R.id.TextView39);
                break;

            //Row 4
            case R.id.TextView42:
                alert(R.id.TextView42);
                break;
            case R.id.TextView43:
                alert(R.id.TextView43);
                break;
            case R.id.TextView44:
                alert(R.id.TextView44);
                break;
            case R.id.TextView45:
                alert(R.id.TextView45);
                break;
            case R.id.TextView46:
                alert(R.id.TextView46);
                break;
            case R.id.TextView47:
                alert(R.id.TextView47);
                break;
            case R.id.TextView48:
                alert(R.id.TextView48);
                break;
            case R.id.TextView49:
                alert(R.id.TextView49);
                break;

            //Row 5
            case R.id.TextView52:
                alert(R.id.TextView52);
                break;
            case R.id.TextView53:
                alert(R.id.TextView53);
                break;
            case R.id.TextView54:
                alert(R.id.TextView54);
                break;
            case R.id.TextView55:
                alert(R.id.TextView55);
                break;
            case R.id.TextView56:
                alert(R.id.TextView56);
                break;
            case R.id.TextView57:
                alert(R.id.TextView57);
                break;
            case R.id.TextView58:
                alert(R.id.TextView58);
                break;
            case R.id.TextView59:
                alert(R.id.TextView59);
                break;

            //Row 6
            case R.id.TextView62:
                alert(R.id.TextView62);
                break;
            case R.id.TextView63:
                alert(R.id.TextView63);
                break;
            case R.id.TextView64:
                alert(R.id.TextView64);
                break;
            case R.id.TextView65:
                alert(R.id.TextView65);
                break;
            case R.id.TextView66:
                alert(R.id.TextView66);
                break;
            case R.id.TextView67:
                alert(R.id.TextView67);
                break;
            case R.id.TextView68:
                alert(R.id.TextView68);
                break;
            case R.id.TextView69:
                alert(R.id.TextView69);
                break;

        }

    }

    public void alert(int id)
    {
        Intent i = new Intent(Reminders_Activity.this,Lecture_Reminder_Activity.class);
        i.putExtra("click",id);
        startActivity(i);
    }


    public void importTitle()
    {
        long sid;
        entry = new Database_Helper_Lectures(this);
        for (i = 0; i < 48; i++) {
            obj_tv[i] = (TextView) findViewById(tv_id[i]);
            sid=tv_id[i];
            Cursor set = entry.setTitle(""+sid);
            if(set != null && set.moveToFirst() )
            {
                obj_tv[i].setText(set.getString(0).toUpperCase());
            }
            else
            {
                obj_tv[i].setText("-----");
            }
            set.close();
        }
    }

    public void onClickNextWeek() {
        Button next_week_button=(Button)findViewById(R.id.done_change_button);
        next_week_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Reminders_Activity.this,List_Activity.class);
                        startActivity(i);
                    }
                });

        Button next_week_button_scroll1=(Button)findViewById(R.id.done_change_button_scroll1);
        next_week_button_scroll1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Reminders_Activity.this,List_Activity.class);
                        startActivity(i);
                    }
                });

        Button next_week_button_scroll2=(Button)findViewById(R.id.done_change_button_scroll2);
        next_week_button_scroll2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Reminders_Activity.this,List_Activity.class);
                        startActivity(i);
                    }
                });

        Button next_week_button_scroll3=(Button)findViewById(R.id.done_change_button_scroll3);
        next_week_button_scroll3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Reminders_Activity.this,List_Activity.class);
                        startActivity(i);
                    }
                });
    }

}

