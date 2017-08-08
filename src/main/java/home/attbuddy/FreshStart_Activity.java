package home.attbuddy;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class FreshStart_Activity extends Activity {
    Button Next_btn;
    EditText Name, Conf_Name;
    Database_Helper_User login;
    Database_Helper_Lectures entry;
    Database_Helper_Attendance sub;
    Database_Helper_Days days;

    public void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        overridePendingTransition(R.anim.slide_up, 0);
        setContentView(R.layout.activity_fresh_start_);

        login = new Database_Helper_User(this);
        entry = new Database_Helper_Lectures(this);
        sub = new Database_Helper_Attendance(this);
        days = new Database_Helper_Days(this);

        Next_btn = (Button) findViewById(R.id.button);
        Name = (EditText) findViewById(R.id.name);
        Conf_Name = (EditText) findViewById(R.id.conf_name);


        //button listener
        Next_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Name.setError(null);
                Conf_Name.setError(null);
                if (!"".equals(Name.getText().toString())
                        && !"".equals(Conf_Name.getText().toString()))
                {
                    if((Name.getText().toString()).equals(Conf_Name.getText().toString()))
                    {
                        Cursor res = login.getAllData();
                        if(res.getCount()==0)
                        {
                            login.insert(Name.getText().toString().toUpperCase(),"START");
                            Intent i = new Intent(FreshStart_Activity.this, Next_Activity.class);
                            startActivity(i);
                        }
                        else
                        {
                            LayoutInflater inflater = getLayoutInflater();
                            View alertLayout = inflater.inflate(R.layout.alert, null);
                            AlertDialog.Builder alert = new AlertDialog.Builder(FreshStart_Activity.this);
                            alert.setTitle("∞ARE YOU SURE∞");
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
                                    login.delete();
                                    entry.deleteAllDetails();
                                    sub.deleteAllDetails();
                                    days.deleteAllDetails();
                                    login.insert(Name.getText().toString().toUpperCase(),"START");
                                    Intent i = new Intent(FreshStart_Activity.this, Next_Activity.class);
                                    startActivity(i);
                                    finish();
                                }
                            });
                            AlertDialog dialog = alert.create();
                            dialog.show();
                        }
                        res.close();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "ABOVE FIELDS DO NOT MATCH", Toast.LENGTH_SHORT).show();
                        Name.setError("BOTH NAMES DO NOT MATCH");
                        Conf_Name.setError("BOTH NAMES DO NOT MATCH");
                    }
                }
                else
                {
                    if("".equals(Name.getText().toString())&&!"".equals(Conf_Name.getText().toString()))
                    {
                        Name.setError("THIS FIELD CANNOT BE BLANK");
                        Toast.makeText(getApplicationContext(), "FILL REQUIRED FIELDS", Toast.LENGTH_SHORT).show();
                    }
                    else if("".equals(Conf_Name.getText().toString())&&!"".equals(Name.getText().toString()))
                    {
                        Conf_Name.setError("THIS FIELD CANNOT BE BLANK");
                        Toast.makeText(getApplicationContext(), "FILL REQUIRED FIELDS", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Name.setError("THIS FIELD CANNOT BE BLANK");
                        Conf_Name.setError("THIS FIELD CANNOT BE BLANK");
                        Toast.makeText(getApplicationContext(), "FILL REQUIRED FIELDS", Toast.LENGTH_SHORT).show();
                    }

                }
            }

        });

    }
}