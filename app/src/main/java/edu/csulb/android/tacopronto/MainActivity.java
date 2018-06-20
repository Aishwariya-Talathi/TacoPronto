package edu.csulb.android.tacopronto;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.*;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1;
    static String s;
    private RadioButton sizelarge,sizemedium,tortillacorn,tortillaflour;
    private CheckBox fbeef,fchicken,fwhitefish,fcheese,fseafood,frice,fpico,fbeans,fguacamole,flbt;
    private CheckBox bsoda,bcerveza,bmargarita,btaquila;
    double cost=0;
    private static final int PERMISSION_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    private void init() {
        button1 = (Button) findViewById(R.id.button);
        sizelarge=(RadioButton) findViewById(R.id.radioButton2);
        sizemedium=(RadioButton) findViewById(R.id.radioButton);
        tortillacorn=(RadioButton) findViewById(R.id.radioButton9);
        tortillaflour=(RadioButton) findViewById(R.id.radioButton10);
        fbeef=(CheckBox) findViewById(R.id.checkBox);
        fchicken=(CheckBox) findViewById(R.id.checkBox2);
        fwhitefish=(CheckBox) findViewById(R.id.checkBox5);
        fcheese=(CheckBox) findViewById(R.id.checkBox4);
        fseafood=(CheckBox) findViewById(R.id.checkBox3);
        frice=(CheckBox) findViewById(R.id.checkBox9);
        fpico=(CheckBox) findViewById(R.id.checkBox10);
        fbeans=(CheckBox) findViewById(R.id.checkBox11);
        fguacamole=(CheckBox) findViewById(R.id.checkBox8);
        flbt=(CheckBox) findViewById(R.id.checkBox7);
        bsoda=(CheckBox) findViewById(R.id.checkBox18);
        bcerveza=(CheckBox) findViewById(R.id.checkBox16);
        bmargarita=(CheckBox) findViewById(R.id.checkBox19);
        btaquila=(CheckBox) findViewById(R.id.checkBox17);
        button1.setOnClickListener(this);
    }
    private void sizeradiocheck() {
        if(sizelarge.isChecked())
        {
            cost+=6;
            s+=" ## Pizza Size:Large ";
        }

        else if(sizemedium.isChecked()) {
            cost += 4;
            s+=" ## Pizza Size:Medium ";
        }
    }
    private void tortillaradiocheck() {
        if(tortillaflour.isChecked()) {
            cost += 0.50;
            s+=" ## Tortilla : Flour ";
        }
        else if(tortillacorn.isChecked()) {
            cost += 0.70;
            s+=" ## Tortilla : Corn ";
        }
    }
    private void fillingscheck() {
        s+=" ## Fillings :: ";
        if(fbeef.isChecked())
        {
            cost+=0.50;
            s+=" Beef ";
        }


        if(fchicken.isChecked()) {
            cost += 0.45;
            s+=" Chicken ";
        }
        if(fwhitefish.isChecked()) {
            cost += 0.70;
            s+=" White Fish ";

        }
        if(fcheese.isChecked()) {
            cost += 0.45;
            s+=" Cheese ";
        }
        if(fseafood.isChecked()) {
            cost += 0.90;
            s+=" Sea Food ";
        }
        if(frice.isChecked()) {
            cost += 1.00;
            s+=" Rice ";
        }
        if(fpico.isChecked()) {
            cost += 0.30;
            s+=" Pico de Gallo ";

        }
        if(fbeans.isChecked()) {
            cost += 0.30;
            s+=" Beans ";
        }
        if(fguacamole.isChecked()) {
            cost += 0.50;
            s+=" Guacamole ";
        }
        if(flbt.isChecked()) {
            cost += 0.40;
            s+=" LBT ";
        }
    }
    private void beveragecheck() {
        s+=" ## beverage :: ";
        if(bsoda.isChecked()) {
            cost += 1.20;
            s+=" Soda ";

        }
        if(bcerveza.isChecked()) {
            cost += 1.45;
            s+=" Cerveza ";
        }
        if(bmargarita.isChecked()) {
            cost += 2.20;
            s+=" Margarita ";
        }
        if(btaquila.isChecked()) {
            cost += 3;
            s+=" Taquila ";
        }
    }

    @Override
    public void onClick(View view) {
        sizeradiocheck();
        tortillaradiocheck();
        fillingscheck();
        beveragecheck();
        String cst=Double.toString(cost);
        s+=" ## Total cost : ";
        s+=cst;
        String tel_no="+15623148717";
        if(android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.M)
        {

            if(checkSelfPermission(Manifest.permission.SEND_SMS)==PackageManager.PERMISSION_DENIED)
            {

                Log.d("permission","permission to SEND_SMS denied,permission being requested");
                String[] permission = {Manifest.permission.SEND_SMS};

                requestPermissions(permission, PERMISSION_REQUEST);

            }
        SmsManager sms=SmsManager.getDefault();
       sms.sendTextMessage(tel_no,null,s,null,null);

    }
        cost=0;
        s= "" ;
}
    }
