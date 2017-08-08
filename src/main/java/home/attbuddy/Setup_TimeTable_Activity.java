package home.attbuddy;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.Toast;

public class Setup_TimeTable_Activity extends Activity implements View.OnClickListener {

    private int i;
    Database_Helper_Lectures entry;
    Database_Helper_Attendance stats;
    Database_Helper_Days days;
    Database_Helper_User login;
    String name;
    String sid;
    String stitle;
    String sname;
    String sfaculty;
    String slocation;

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
        setContentView(R.layout.activity_setup_timetable);
        importTitle();
        onClickNext();

        entry = new Database_Helper_Lectures(this);
        stats = new Database_Helper_Attendance(this);
        days = new Database_Helper_Days(this);
        login = new Database_Helper_User(this);

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

    public void alert(final int id)
    {
        sid=""+id;
        final TextView tv = (TextView)findViewById(id);
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.dialog, null);
        final EditText title = (EditText) alertLayout.findViewById(R.id.title);
        final EditText name = (EditText) alertLayout.findViewById(R.id.name);
        final EditText faculty = (EditText) alertLayout.findViewById(R.id.faculty);
        final EditText location = (EditText) alertLayout.findViewById(R.id.location);
        title.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        name.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        faculty.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        location.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        //final String before_change= obj_tv[i].getText().toString();

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("∞SET DETAILS∞");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);

        if(tv.getText().toString().equals("FILL DETAILS")||tv.getText().toString().equals("-----"))
        {
            title.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(!hasFocus)
                    {
                        Cursor get = entry.getDetailsbyTitle(title.getText().toString().toUpperCase());
                        while (get!=null && get.moveToNext())
                        {
                            sname = get.getString(2).toString().toUpperCase();
                            sfaculty = get.getString(3).toString().toUpperCase();
                            slocation = get.getString(4).toString().toUpperCase();
                        }
                        name.setText(sname);
                        faculty.setText(sfaculty);
                        location.setText(slocation);
                        get.close();
                    }
                    sname=null;
                    sfaculty=null;
                    slocation=null;
                }
            });

            alert.setNeutralButton("Leave Blank", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    entry.deleteDetails(sid);
                    tv.setText("-----");
                    tv.setBackgroundResource(R.drawable.cell_shape_onclick);
                }
            });

            alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(title.getText().toString().length()==0)
                    {
                        Toast.makeText(getApplicationContext(), "NO TITLE ENTERED", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        entry.insertDetails(sid,title.getText().toString(),name.getText().toString(),faculty.getText().toString(),location.getText().toString());
                        tv.setText(title.getText().toString().toUpperCase());
                        tv.setBackgroundResource(R.drawable.cell_shape_onclick);
                    }

                }
            });

            alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //obj_tv[i].setText(before_change);
                }
            });
        }
        else
        {

            Cursor ins = entry.getAllData(sid);
            StringBuffer buffer1 = new StringBuffer();
            StringBuffer buffer2 = new StringBuffer();
            StringBuffer buffer3 = new StringBuffer();
            StringBuffer buffer4 = new StringBuffer();
            while(ins.moveToNext())
            {
                stitle = buffer1.append(ins.getString(1)).toString().toUpperCase();
                sname = buffer2.append(ins.getString(2)).toString().toUpperCase();
                sfaculty = buffer3.append(ins.getString(3)).toString().toUpperCase();
                slocation = buffer4.append(ins.getString(4)).toString().toUpperCase();
            }
            ins.close();

            title.setText(stitle);
            name.setText(sname);
            faculty.setText(sfaculty);
            location.setText(slocation);

            title.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(!hasFocus)
                    {
                        Cursor get = entry.getDetailsbyTitle(title.getText().toString().toUpperCase());
                        while (get!=null && get.moveToNext())
                        {
                            StringBuffer buffer1 = new StringBuffer();
                            StringBuffer buffer2 = new StringBuffer();
                            StringBuffer buffer3 = new StringBuffer();
                            sname = buffer1.append(get.getString(2)).toString().toUpperCase();
                            sfaculty = buffer2.append(get.getString(3)).toString().toUpperCase();
                            slocation = buffer3.append(get.getString(4)).toString().toUpperCase();
                        }
                        name.setText(sname);
                        faculty.setText(sfaculty);
                        location.setText(slocation);
                        get.close();
                    }
                }
            });


            alert.setNeutralButton("Leave Blank", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    entry.deleteDetails(sid);
                    tv.setText("-----");
                    tv.setBackgroundResource(R.drawable.cell_shape_onclick);
                }
            });

            alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    entry.updateDetails(sid,title.getText().toString(),name.getText().toString(),faculty.getText().toString(),location.getText().toString());
                    tv.setText(title.getText().toString().toUpperCase());
                    tv.setBackgroundResource(R.drawable.cell_shape_onclick);
                }
            });

        }

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                //obj_tv[i].setText(before_change);
            }
        });

        AlertDialog dialog = alert.create();
        dialog.show();
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
                obj_tv[i].setText("FILL DETAILS");
            }
            set.close();
        }
    }

   public void onClickNext() {
        Button next=(Button)findViewById(R.id.next_button);
        next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor get = entry.getSubjectsTitle();
                        if(get.getCount()==0)
                        {
                            Toast.makeText(getApplicationContext(), "NO SUBJECTS FOUND, PLEASE FILL SUBJECTS", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Cursor res = login.getAllData();
                            while (res.moveToNext())
                            {
                                name = res.getString(1).toUpperCase();
                            }
                            res.close();
                            days.insertID(R.id.TextView12,R.id.TextView22,R.id.TextView32,R.id.TextView42,R.id.TextView52,R.id.TextView62);
                            days.insertID(R.id.TextView13,R.id.TextView23,R.id.TextView33,R.id.TextView43,R.id.TextView53,R.id.TextView63);
                            days.insertID(R.id.TextView14,R.id.TextView24,R.id.TextView34,R.id.TextView44,R.id.TextView54,R.id.TextView64);
                            days.insertID(R.id.TextView15,R.id.TextView25,R.id.TextView35,R.id.TextView45,R.id.TextView55,R.id.TextView65);
                            days.insertID(R.id.TextView16,R.id.TextView26,R.id.TextView36,R.id.TextView46,R.id.TextView56,R.id.TextView66);
                            days.insertID(R.id.TextView17,R.id.TextView27,R.id.TextView37,R.id.TextView47,R.id.TextView57,R.id.TextView67);
                            days.insertID(R.id.TextView18,R.id.TextView28,R.id.TextView38,R.id.TextView48,R.id.TextView58,R.id.TextView68);
                            days.insertID(R.id.TextView19,R.id.TextView29,R.id.TextView39,R.id.TextView49,R.id.TextView59,R.id.TextView69);
                            login.update(name.toUpperCase(),"TIMETABLE");
                            Intent i1 = new Intent(Setup_TimeTable_Activity.this,Timetable_Done_Activity.class);
                            startActivity(i1);
                        }
                        get.close();
                    }
                    });

       Button next_scroll1=(Button)findViewById(R.id.next_button_scroll1);
       next_scroll1.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Cursor get = entry.getSubjectsTitle();
                       if(get.getCount()==0)
                       {
                           Toast.makeText(getApplicationContext(), "NO SUBJECTS FOUND, PLEASE FILL SUBJECTS", Toast.LENGTH_SHORT).show();
                       }
                       else
                       {
                           Cursor res = login.getAllData();
                           while (res.moveToNext())
                           {
                               name = res.getString(1).toUpperCase();
                           }
                           res.close();
                           days.insertID(R.id.TextView12,R.id.TextView22,R.id.TextView32,R.id.TextView42,R.id.TextView52,R.id.TextView62);
                           days.insertID(R.id.TextView13,R.id.TextView23,R.id.TextView33,R.id.TextView43,R.id.TextView53,R.id.TextView63);
                           days.insertID(R.id.TextView14,R.id.TextView24,R.id.TextView34,R.id.TextView44,R.id.TextView54,R.id.TextView64);
                           days.insertID(R.id.TextView15,R.id.TextView25,R.id.TextView35,R.id.TextView45,R.id.TextView55,R.id.TextView65);
                           days.insertID(R.id.TextView16,R.id.TextView26,R.id.TextView36,R.id.TextView46,R.id.TextView56,R.id.TextView66);
                           days.insertID(R.id.TextView17,R.id.TextView27,R.id.TextView37,R.id.TextView47,R.id.TextView57,R.id.TextView67);
                           days.insertID(R.id.TextView18,R.id.TextView28,R.id.TextView38,R.id.TextView48,R.id.TextView58,R.id.TextView68);
                           days.insertID(R.id.TextView19,R.id.TextView29,R.id.TextView39,R.id.TextView49,R.id.TextView59,R.id.TextView69);
                           login.update(name.toUpperCase(),"TIMETABLE");
                           Intent i1 = new Intent(Setup_TimeTable_Activity.this,Timetable_Done_Activity.class);
                           startActivity(i1);
                       }
                       get.close();
                   }
               });

       Button next_scroll2=(Button)findViewById(R.id.next_button_scroll2);
       next_scroll2.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Cursor get = entry.getSubjectsTitle();
                       if(get.getCount()==0)
                       {
                           Toast.makeText(getApplicationContext(), "NO SUBJECTS FOUND, PLEASE FILL SUBJECTS", Toast.LENGTH_SHORT).show();
                       }
                       else
                       {
                           Cursor res = login.getAllData();
                           while (res.moveToNext())
                           {
                               name = res.getString(1).toUpperCase();
                           }
                           res.close();
                           days.insertID(R.id.TextView12,R.id.TextView22,R.id.TextView32,R.id.TextView42,R.id.TextView52,R.id.TextView62);
                           days.insertID(R.id.TextView13,R.id.TextView23,R.id.TextView33,R.id.TextView43,R.id.TextView53,R.id.TextView63);
                           days.insertID(R.id.TextView14,R.id.TextView24,R.id.TextView34,R.id.TextView44,R.id.TextView54,R.id.TextView64);
                           days.insertID(R.id.TextView15,R.id.TextView25,R.id.TextView35,R.id.TextView45,R.id.TextView55,R.id.TextView65);
                           days.insertID(R.id.TextView16,R.id.TextView26,R.id.TextView36,R.id.TextView46,R.id.TextView56,R.id.TextView66);
                           days.insertID(R.id.TextView17,R.id.TextView27,R.id.TextView37,R.id.TextView47,R.id.TextView57,R.id.TextView67);
                           days.insertID(R.id.TextView18,R.id.TextView28,R.id.TextView38,R.id.TextView48,R.id.TextView58,R.id.TextView68);
                           days.insertID(R.id.TextView19,R.id.TextView29,R.id.TextView39,R.id.TextView49,R.id.TextView59,R.id.TextView69);
                           login.update(name.toUpperCase(),"TIMETABLE");
                           Intent i1 = new Intent(Setup_TimeTable_Activity.this,Timetable_Done_Activity.class);
                           startActivity(i1);
                       }
                       get.close();
                   }
               });

       Button next_scroll3=(Button)findViewById(R.id.next_button_scroll3);
       next_scroll3.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Cursor get = entry.getSubjectsTitle();
                       if(get.getCount()==0)
                       {
                           Toast.makeText(getApplicationContext(), "NO SUBJECTS FOUND, PLEASE FILL SUBJECTS", Toast.LENGTH_SHORT).show();
                       }
                       else
                       {
                           Cursor res = login.getAllData();
                           while (res.moveToNext())
                           {
                               name = res.getString(1).toUpperCase();
                           }
                           res.close();
                           days.insertID(R.id.TextView12,R.id.TextView22,R.id.TextView32,R.id.TextView42,R.id.TextView52,R.id.TextView62);
                           days.insertID(R.id.TextView13,R.id.TextView23,R.id.TextView33,R.id.TextView43,R.id.TextView53,R.id.TextView63);
                           days.insertID(R.id.TextView14,R.id.TextView24,R.id.TextView34,R.id.TextView44,R.id.TextView54,R.id.TextView64);
                           days.insertID(R.id.TextView15,R.id.TextView25,R.id.TextView35,R.id.TextView45,R.id.TextView55,R.id.TextView65);
                           days.insertID(R.id.TextView16,R.id.TextView26,R.id.TextView36,R.id.TextView46,R.id.TextView56,R.id.TextView66);
                           days.insertID(R.id.TextView17,R.id.TextView27,R.id.TextView37,R.id.TextView47,R.id.TextView57,R.id.TextView67);
                           days.insertID(R.id.TextView18,R.id.TextView28,R.id.TextView38,R.id.TextView48,R.id.TextView58,R.id.TextView68);
                           days.insertID(R.id.TextView19,R.id.TextView29,R.id.TextView39,R.id.TextView49,R.id.TextView59,R.id.TextView69);
                           login.update(name.toUpperCase(),"TIMETABLE");
                           Intent i1 = new Intent(Setup_TimeTable_Activity.this,Timetable_Done_Activity.class);
                           startActivity(i1);
                       }
                       get.close();
                   }
               });
                    }

}

