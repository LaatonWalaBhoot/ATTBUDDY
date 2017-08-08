package home.attbuddy;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TableRow;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Aishwarya on 6/27/2016.
 */
public class Bunk_Effect_Activity extends Activity implements View.OnClickListener{

    private int i;
    String upDated;
    Calendar c = Calendar.getInstance();//to add days
    Database_Helper_Lectures entry;
    Database_Helper_Miss miss;

    @Override
    public void onBackPressed()
    {
        miss.deleteAllDetails();
        Intent i = new Intent(Bunk_Effect_Activity.this,List_Activity.class);
        startActivity(i);
        finish();
    }


    private int[] tv_id = {R.id.TextView12,R.id.TextView13,R.id.TextView14,R.id.TextView15,R.id.TextView16,R.id.TextView17,R.id.TextView18,R.id.TextView19,
            R.id.TextView22,R.id.TextView23,R.id.TextView24,R.id.TextView25,R.id.TextView26,R.id.TextView27,R.id.TextView28,R.id.TextView29,
            R.id.TextView32,R.id.TextView33,R.id.TextView34,R.id.TextView35,R.id.TextView36,R.id.TextView37,R.id.TextView38,R.id.TextView39,
            R.id.TextView42,R.id.TextView43,R.id.TextView44,R.id.TextView45,R.id.TextView46,R.id.TextView47,R.id.TextView48,R.id.TextView49,
            R.id.TextView52,R.id.TextView53,R.id.TextView54,R.id.TextView55,R.id.TextView56,R.id.TextView57,R.id.TextView58,R.id.TextView59,
            R.id.TextView62,R.id.TextView63,R.id.TextView64,R.id.TextView65,R.id.TextView66,R.id.TextView67,R.id.TextView68,R.id.TextView69};

    TextView[] obj_tv = new TextView[48];
    //for changing color

    //Row1

    private boolean stateChanged1_12 = false;
    private boolean stateChanged1_13 = false;
    private boolean stateChanged1_14 = false;
    private boolean stateChanged1_15 = false;
    private boolean stateChanged1_16 = false;
    private boolean stateChanged1_17 = false;
    private boolean stateChanged1_18 = false;
    private boolean stateChanged1_19 = false;

    //Row2

    private boolean stateChanged1_22 = false;
    private boolean stateChanged1_23 = false;
    private boolean stateChanged1_24 = false;
    private boolean stateChanged1_25 = false;
    private boolean stateChanged1_26 = false;
    private boolean stateChanged1_27 = false;
    private boolean stateChanged1_28 = false;
    private boolean stateChanged1_29 = false;

    //Row3

    private boolean stateChanged1_32 = false;
    private boolean stateChanged1_33 = false;
    private boolean stateChanged1_34 = false;
    private boolean stateChanged1_35 = false;
    private boolean stateChanged1_36 = false;
    private boolean stateChanged1_37 = false;
    private boolean stateChanged1_38 = false;
    private boolean stateChanged1_39 = false;

    //Row4

    private boolean stateChanged1_42 = false;
    private boolean stateChanged1_43 = false;
    private boolean stateChanged1_44 = false;
    private boolean stateChanged1_45 = false;
    private boolean stateChanged1_46 = false;
    private boolean stateChanged1_47 = false;
    private boolean stateChanged1_48 = false;
    private boolean stateChanged1_49 = false;

    //Row5

    private boolean stateChanged1_52 = false;
    private boolean stateChanged1_53 = false;
    private boolean stateChanged1_54 = false;
    private boolean stateChanged1_55 = false;
    private boolean stateChanged1_56 = false;
    private boolean stateChanged1_57 = false;
    private boolean stateChanged1_58 = false;
    private boolean stateChanged1_59 = false;

    //Row6

    private boolean stateChanged1_62 = false;
    private boolean stateChanged1_63 = false;
    private boolean stateChanged1_64 = false;
    private boolean stateChanged1_65 = false;
    private boolean stateChanged1_66 = false;
    private boolean stateChanged1_67 = false;
    private boolean stateChanged1_68 = false;
    private boolean stateChanged1_69 = false;



    @Override
    protected void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        setContentView(R.layout.activity_bunk_effect);
        entry =new Database_Helper_Lectures(this);

        String weekDay;
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        weekDay = dayFormat.format(calendar.getTime());
        String Day= weekDay.toUpperCase();

        if (Day.equals("SUNDAY"))
        {
            Intent intent = new Intent(this, Bunk_Next_Week_Activity.class);
            this.startActivity (intent);
            this.finish();
        }

        for (i = 0; i < 48; i++) {
            obj_tv[i] = (TextView) findViewById(tv_id[i]);
            obj_tv[i].setOnClickListener(this);
        }

        daySelect();
        onClickNextWeek();
        importTitle();
    }

   @Override
    public void onClick(View v){
       int flag=0;
        switch(v.getId())
        {
            //Row 1
            case R.id.TextView12:
                stateChanged1_12 = !stateChanged1_12;
                v.setBackgroundResource(stateChanged1_12 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_12)
                {
                    flag=1;
                    getMiss(R.id.TextView12,flag,11);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView12,flag,11);
                }
                break;
            case R.id.TextView13:
                stateChanged1_13 = !stateChanged1_13;
                v.setBackgroundResource(stateChanged1_13 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_13)
                {
                    flag=1;
                    getMiss(R.id.TextView13,flag,11);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView13,flag,11);
                }
                break;
            case R.id.TextView14:
                stateChanged1_14 = !stateChanged1_14;
                v.setBackgroundResource(stateChanged1_14 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_14)
                {
                    flag=1;
                    getMiss(R.id.TextView14,flag,11);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView14,flag,11);
                }
                break;
            case R.id.TextView15:
                stateChanged1_15 = !stateChanged1_15;
                v.setBackgroundResource(stateChanged1_15 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_15)
                {
                    flag=1;
                    getMiss(R.id.TextView15,flag,11);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView15,flag,11);
                }
                break;
            case R.id.TextView16:
                stateChanged1_16 = !stateChanged1_16;
                v.setBackgroundResource(stateChanged1_16 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_16)
                {
                    flag=1;
                    getMiss(R.id.TextView16,flag,11);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView16,flag,11);
                }
                break;
            case R.id.TextView17:
                stateChanged1_17 = !stateChanged1_17;
                v.setBackgroundResource(stateChanged1_17 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_17)
                {
                    flag=1;
                    getMiss(R.id.TextView17,flag,11);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView17,flag,11);
                }
                break;
            case R.id.TextView18:
                stateChanged1_18 = !stateChanged1_18;
                v.setBackgroundResource(stateChanged1_18 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_18)
                {
                    flag=1;
                    getMiss(R.id.TextView18,flag,11);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView18,flag,11);
                }
                break;
            case R.id.TextView19:
                stateChanged1_19 = !stateChanged1_19;
                v.setBackgroundResource(stateChanged1_19 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_19)
                {
                    flag=1;
                    getMiss(R.id.TextView19,flag,11);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView19,flag,11);
                }
                break;

            //Row 2
            case R.id.TextView22:
                stateChanged1_22 = !stateChanged1_22;
                v.setBackgroundResource(stateChanged1_22 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_22)
                {
                    flag=1;
                    getMiss(R.id.TextView22,flag,12);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView22,flag,12);
                }
                break;
            case R.id.TextView23:
                stateChanged1_23 = !stateChanged1_23;
                v.setBackgroundResource(stateChanged1_23 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_23)
                {
                    flag=1;
                    getMiss(R.id.TextView23,flag,12);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView23,flag,12);
                }
                break;
            case R.id.TextView24:
                stateChanged1_24 = !stateChanged1_24;
                v.setBackgroundResource(stateChanged1_24 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_24)
                {
                    flag=1;
                    getMiss(R.id.TextView24,flag,12);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView24,flag,12);
                }
                break;
            case R.id.TextView25:
                stateChanged1_25 = !stateChanged1_25;
                v.setBackgroundResource(stateChanged1_25 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_25)
                {
                    flag=1;
                    getMiss(R.id.TextView25,flag,12);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView25,flag,12);
                }
                break;
            case R.id.TextView26:
                stateChanged1_26 = !stateChanged1_26;
                v.setBackgroundResource(stateChanged1_26 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_26)
                {
                    flag=1;
                    getMiss(R.id.TextView26,flag,12);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView26,flag,12);
                }
                break;
            case R.id.TextView27:
                stateChanged1_27 = !stateChanged1_27;
                v.setBackgroundResource(stateChanged1_27 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_27)
                {
                    flag=1;
                    getMiss(R.id.TextView27,flag,12);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView27,flag,12);
                }
                break;
            case R.id.TextView28:
                stateChanged1_28 = !stateChanged1_28;
                v.setBackgroundResource(stateChanged1_28 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_28)
                {
                    flag=1;
                    getMiss(R.id.TextView28,flag,12);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView28,flag,12);
                }
                break;
            case R.id.TextView29:
                stateChanged1_29 = !stateChanged1_29;
                v.setBackgroundResource(stateChanged1_29 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_29)
                {
                    flag=1;
                    getMiss(R.id.TextView29,flag,12);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView29,flag,12);
                }
                break;

            //Row 3
            case R.id.TextView32:
                stateChanged1_32 = !stateChanged1_32;
                v.setBackgroundResource(stateChanged1_32 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_32)
                {
                    flag=1;
                    getMiss(R.id.TextView32,flag,13);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView32,flag,13);
                }
                break;
            case R.id.TextView33:
                stateChanged1_33 = !stateChanged1_33;
                v.setBackgroundResource(stateChanged1_33 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_33)
                {
                    flag=1;
                    getMiss(R.id.TextView33,flag,13);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView33,flag,13);
                }
                break;
            case R.id.TextView34:
                stateChanged1_34 = !stateChanged1_34;
                v.setBackgroundResource(stateChanged1_34 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_34)
                {
                    flag=1;
                    getMiss(R.id.TextView34,flag,13);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView34,flag,13);
                }
                break;
            case R.id.TextView35:
                stateChanged1_35 = !stateChanged1_35;
                v.setBackgroundResource(stateChanged1_35 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_35)
                {
                    flag=1;
                    getMiss(R.id.TextView35,flag,13);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView35,flag,13);
                }
                break;
            case R.id.TextView36:
                stateChanged1_36 = !stateChanged1_36;
                v.setBackgroundResource(stateChanged1_36 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_36)
                {
                    flag=1;
                    getMiss(R.id.TextView36,flag,13);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView36,flag,13);
                }
                break;
            case R.id.TextView37:
                stateChanged1_37 = !stateChanged1_37;
                v.setBackgroundResource(stateChanged1_37 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_37)
                {
                    flag=1;
                    getMiss(R.id.TextView37,flag,13);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView37,flag,13);
                }
                break;
            case R.id.TextView38:
                stateChanged1_38 = !stateChanged1_38;
                v.setBackgroundResource(stateChanged1_38 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_38)
                {
                    flag=1;
                    getMiss(R.id.TextView38,flag,13);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView38,flag,13);
                }
                break;
            case R.id.TextView39:
                stateChanged1_39 = !stateChanged1_39;
                v.setBackgroundResource(stateChanged1_39 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_39)
                {
                    flag=1;
                    getMiss(R.id.TextView39,flag,13);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView39,flag,13);
                }
                break;

            //Row 4
            case R.id.TextView42:
                stateChanged1_42 = !stateChanged1_42;
                v.setBackgroundResource(stateChanged1_42 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_42)
                {
                    flag=1;
                    getMiss(R.id.TextView42,flag,14);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView42,flag,14);
                }
                break;
            case R.id.TextView43:
                stateChanged1_43 = !stateChanged1_43;
                v.setBackgroundResource(stateChanged1_43 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_43)
                {
                    flag=1;
                    getMiss(R.id.TextView43,flag,14);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView43,flag,14);
                }
                break;
            case R.id.TextView44:
                stateChanged1_44 = !stateChanged1_44;
                v.setBackgroundResource(stateChanged1_44 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_44)
                {
                    flag=1;
                    getMiss(R.id.TextView44,flag,14);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView44,flag,14);
                }
                break;
            case R.id.TextView45:
                stateChanged1_45 = !stateChanged1_45;
                v.setBackgroundResource(stateChanged1_45 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_45)
                {
                    flag=1;
                    getMiss(R.id.TextView45,flag,14);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView45,flag,14);
                }
                break;
            case R.id.TextView46:
                stateChanged1_46 = !stateChanged1_46;
                v.setBackgroundResource(stateChanged1_46 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_46)
                {
                    flag=1;
                    getMiss(R.id.TextView46,flag,14);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView46,flag,14);
                }
                break;
            case R.id.TextView47:
                stateChanged1_47 = !stateChanged1_47;
                v.setBackgroundResource(stateChanged1_47 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_47)
                {
                    flag=1;
                    getMiss(R.id.TextView47,flag,14);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView47,flag,14);
                }
                break;
            case R.id.TextView48:
                stateChanged1_48 = !stateChanged1_48;
                v.setBackgroundResource(stateChanged1_48 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_48)
                {
                    flag=1;
                    getMiss(R.id.TextView48,flag,14);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView48,flag,14);
                }
                break;
            case R.id.TextView49:
                stateChanged1_49 = !stateChanged1_49;
                v.setBackgroundResource(stateChanged1_49 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_49)
                {
                    flag=1;
                    getMiss(R.id.TextView49,flag,14);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView49,flag,14);
                }
                break;

            //Row 5
            case R.id.TextView52:
                stateChanged1_52 = !stateChanged1_52;
                v.setBackgroundResource(stateChanged1_52 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_52)
                {
                    flag=1;
                    getMiss(R.id.TextView52,flag,15);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView52,flag,15);
                }
                break;
            case R.id.TextView53:
                stateChanged1_53 = !stateChanged1_53;
                v.setBackgroundResource(stateChanged1_53 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_53)
                {
                    flag=1;
                    getMiss(R.id.TextView53,flag,15);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView53,flag,15);
                }
                break;
            case R.id.TextView54:
                stateChanged1_54 = !stateChanged1_54;
                v.setBackgroundResource(stateChanged1_54 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_54)
                {
                    flag=1;
                    getMiss(R.id.TextView54,flag,15);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView54,flag,15);
                }
                break;
            case R.id.TextView55:
                stateChanged1_55 = !stateChanged1_55;
                v.setBackgroundResource(stateChanged1_55 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_55)
                {
                    flag=1;
                    getMiss(R.id.TextView55,flag,15);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView55,flag,15);
                }
                break;
            case R.id.TextView56:
                stateChanged1_56 = !stateChanged1_56;
                v.setBackgroundResource(stateChanged1_56 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_56)
                {
                    flag=1;
                    getMiss(R.id.TextView56,flag,15);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView56,flag,15);
                }
                break;
            case R.id.TextView57:
                stateChanged1_57 = !stateChanged1_57;
                v.setBackgroundResource(stateChanged1_57 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_57)
                {
                    flag=1;
                    getMiss(R.id.TextView57,flag,15);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView57,flag,15);
                }
                break;
            case R.id.TextView58:
                stateChanged1_58 = !stateChanged1_58;
                v.setBackgroundResource(stateChanged1_58 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_58)
                {
                    flag=1;
                    getMiss(R.id.TextView58,flag,15);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView58,flag,15);
                }
                break;
            case R.id.TextView59:
                stateChanged1_59 = !stateChanged1_59;
                v.setBackgroundResource(stateChanged1_59 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_59)
                {
                    flag=1;
                    getMiss(R.id.TextView59,flag,15);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView59,flag,15);
                }
                break;

            //Row 6
            case R.id.TextView62:
                stateChanged1_62 = !stateChanged1_62;
                v.setBackgroundResource(stateChanged1_62 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_62)
                {
                    flag=1;
                    getMiss(R.id.TextView62,flag,16);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView62,flag,16);
                }
                break;
            case R.id.TextView63:
                stateChanged1_63 = !stateChanged1_63;
                v.setBackgroundResource(stateChanged1_63 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_63)
                {
                    flag=1;
                    getMiss(R.id.TextView63,flag,16);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView63,flag,16);
                }
                break;
            case R.id.TextView64:
                stateChanged1_64 = !stateChanged1_64;
                v.setBackgroundResource(stateChanged1_64 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_64)
                {
                    flag=1;
                    getMiss(R.id.TextView64,flag,16);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView64,flag,16);
                }
                break;
            case R.id.TextView65:
                stateChanged1_65 = !stateChanged1_65;
                v.setBackgroundResource(stateChanged1_65 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_65)
                {
                    flag=1;
                    getMiss(R.id.TextView65,flag,16);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView65,flag,16);
                }
                break;
            case R.id.TextView66:
                stateChanged1_66 = !stateChanged1_66;
                v.setBackgroundResource(stateChanged1_66 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_66)
                {
                    flag=1;
                    getMiss(R.id.TextView66,flag,16);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView66,flag,16);
                }
                break;
            case R.id.TextView67:
                stateChanged1_67 = !stateChanged1_67;
                v.setBackgroundResource(stateChanged1_67 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_67)
                {
                    flag=1;
                    getMiss(R.id.TextView67,flag,16);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView67,flag,16);
                }
                break;
            case R.id.TextView68:
                stateChanged1_68 = !stateChanged1_68;
                v.setBackgroundResource(stateChanged1_68 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_68)
                {
                    flag=1;
                    getMiss(R.id.TextView68,flag,16);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView68,flag,16);
                }
                break;
            case R.id.TextView69:
                stateChanged1_69 = !stateChanged1_69;
                v.setBackgroundResource(stateChanged1_69 ? R.drawable.cell_shape_onclick : R.drawable.cell_shape_white);
                if(stateChanged1_69)
                {
                    flag=1;
                    getMiss(R.id.TextView69,flag,16);
                }
                else
                {
                    flag=2;
                    getMiss(R.id.TextView69,flag,16);
                }
                break;

        }

    }

    public void daySelect()
    {
        int j,k,count=6;

        TextView tv_mon;
        TextView tv_tue;
        TextView tv_wed;
        TextView tv_thu;
        TextView tv_fri;
        TextView tv_sat;
        TextView tv_mon_scroll;
        TextView tv_tue_scroll;
        TextView tv_wed_scroll;
        TextView tv_thu_scroll;
        TextView tv_fri_scroll;
        TextView tv_sat_scroll;

        tv_mon = (TextView) findViewById(R.id.TextView11);
        tv_mon_scroll = (TextView) findViewById(R.id.TextView20);
        tv_tue = (TextView) findViewById(R.id.TextView21);
        tv_tue_scroll = (TextView) findViewById(R.id.TextView30);
        tv_wed = (TextView) findViewById(R.id.TextView31);
        tv_wed_scroll = (TextView) findViewById(R.id.TextView40);
        tv_thu = (TextView) findViewById(R.id.TextView41);
        tv_thu_scroll = (TextView) findViewById(R.id.TextView50);
        tv_fri = (TextView) findViewById(R.id.TextView51);
        tv_fri_scroll = (TextView) findViewById(R.id.TextView60);
        tv_sat = (TextView) findViewById(R.id.TextView61);
        tv_sat_scroll = (TextView) findViewById(R.id.TextView70);
        TableRow rem = (TableRow) findViewById(R.id.lectures_scroll);
        TableRow[] store_id_row = new TableRow[count];
        String[] day_value = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};
        int[] row_id = {R.id.monday,R.id.tuesday,R.id.wednesday,R.id.thursday,R.id.friday,R.id.saturday};

        for(j=0;j<count;j++)
        {
            store_id_row[j] = (TableRow) findViewById(row_id[j]);
        }

        String date = new SimpleDateFormat(",dd-MM",Locale.ENGLISH).format(new Date());//getting current date


        for(k=0;k<count;k++)
        {
            String weekDay;
            SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
            Calendar calendar = Calendar.getInstance();
            weekDay = dayFormat.format(calendar.getTime());
            String Day= weekDay.toUpperCase();
            if(Day.equals(day_value[k]))
            {

                if(k==0)
                {
                    tv_mon.setText("MON" + date);
                    tv_mon_scroll.setText("MON" + date);
                    addDate();
                    tv_tue.setText("TUE" + upDated);
                    tv_tue_scroll.setText("TUE" + upDated);
                    addDate();
                    tv_wed.setText("WED" + upDated);
                    tv_wed_scroll.setText("WED" + upDated);
                    addDate();
                    tv_thu.setText("THU" + upDated);
                    tv_thu_scroll.setText("THU" + upDated);
                    addDate();
                    tv_fri.setText("FRI" + upDated);
                    tv_fri_scroll.setText("FRI" + upDated);
                    addDate();
                    tv_sat.setText("SAT" + upDated);
                    tv_sat_scroll.setText("SAT" + upDated);
                }
                if(k==1)
                {
                    tv_tue.setText("TUE"+date);
                    tv_tue_scroll.setText("TUE"+date);
                    addDate();
                    tv_wed.setText("WED" + upDated);
                    tv_wed_scroll.setText("WED" + upDated);
                    addDate();
                    tv_thu.setText("THU" + upDated);
                    tv_thu_scroll.setText("THU" + upDated);
                    addDate();
                    tv_fri.setText("FRI" + upDated);
                    tv_fri_scroll.setText("FRI" + upDated);
                    addDate();
                    tv_sat.setText("SAT" + upDated);
                    tv_sat_scroll.setText("SAT" + upDated);
                }
                if(k==2)
                {
                    rem.setVisibility(View.GONE);
                    tv_wed.setText("WED"+date);
                    tv_wed_scroll.setText("WED"+date);
                    addDate();
                    tv_thu.setText("THU" + upDated);
                    tv_thu_scroll.setText("THU" + upDated);
                    addDate();
                    tv_fri.setText("FRI" + upDated);
                    tv_fri_scroll.setText("FRI" + upDated);
                    addDate();
                    tv_sat.setText("SAT" + upDated);
                    tv_sat_scroll.setText("SAT" + upDated);
                }
                if(k==3)
                {
                    rem.setVisibility(View.GONE);
                    tv_thu.setText("THU"+date);
                    tv_thu_scroll.setText("THU" +date);
                    addDate();
                    tv_fri.setText("FRI" + upDated);
                    tv_fri_scroll.setText("FRI" + upDated);
                    addDate();
                    tv_sat.setText("SAT" + upDated);
                    tv_sat_scroll.setText("SAT" + upDated);
                }
                if(k==4)
                {
                    rem.setVisibility(View.GONE);
                    tv_fri.setText("FRI"+date);
                    tv_fri_scroll.setText("FRI" +date);
                    addDate();
                    tv_sat.setText("SAT" + upDated);
                    tv_sat_scroll.setText("SAT" + upDated);
                }
                if(k==5)
                {
                    rem.setVisibility(View.GONE);
                    tv_sat.setText("SAT" + date);
                    tv_sat_scroll.setText("SAT" + date);
                }
                int remove=k-1;
                while(remove>=0)//for removing past days of the week
                {
                    store_id_row[remove].setVisibility(View.GONE);
                    remove--;
                }
            }
        }

    }

    public void getMiss(int id,int flag,int day)
    {
        String temp="";
        entry = new Database_Helper_Lectures(this);
        miss = new Database_Helper_Miss(this);
        Cursor set = entry.setTitle(""+id);
        if(set != null && set.moveToNext() )
        {
            temp = set.getString(0).toUpperCase();
        }
        if(temp.length()>0)
        {
            if(flag==1)
            {
                miss.insert(""+id,temp,day);
            }
            if(flag==2)
            {
                miss.deleteOne(""+id,""+day);
            }
        }
        set.close();
    }

   public void onClickNextWeek() {
       Button next_week_button=(Button)findViewById(R.id.next_week);
       next_week_button.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent i = new Intent(Bunk_Effect_Activity.this,Bunk_Next_Week_Activity.class);
                       startActivity(i);
                       finish();
                   }
               });

       Button next_week_button_scroll1=(Button)findViewById(R.id.next_week_scroll1);
       next_week_button_scroll1.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent i = new Intent(Bunk_Effect_Activity.this,Bunk_Next_Week_Activity.class);
                       startActivity(i);
                       finish();
                   }
               });

       Button next_week_button_scroll2=(Button)findViewById(R.id.next_week_scroll2);
       next_week_button_scroll2.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent i = new Intent(Bunk_Effect_Activity.this,Bunk_Next_Week_Activity.class);
                       startActivity(i);
                       finish();
                   }
               });

       Button next_week_button_scroll3=(Button)findViewById(R.id.next_week_scroll3);
       next_week_button_scroll3.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent i = new Intent(Bunk_Effect_Activity.this,Bunk_Next_Week_Activity.class);
                       startActivity(i);
                       finish();
                   }
               });
   }

    public void addDate()
    {

        c.add(Calendar.DATE, 1);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = (c.get(Calendar.MONTH)+1);

        if(month/10==0)
        {
            if(day/10==0)
            {
                upDated = ",0"+day+"-0"+month;
            }
            else
            {
                upDated = ","+day+"-0"+month;
            }

        }
        else
        {
            if(day/10==0)
            {
                upDated = ",0"+day+"-"+month;
            }
            else
            {
                upDated = ","+day+"-"+month;
            }
        }


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

    }



