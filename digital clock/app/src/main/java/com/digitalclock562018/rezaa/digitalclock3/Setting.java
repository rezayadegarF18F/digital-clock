package com.digitalclock562018.rezaa.digitalclock3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Setting extends AppCompatActivity{


    public RadioGroup clock_form;
    public RadioButton form_in_12_1;
    public RadioButton form_in_24_1;

    public RadioGroup voice_Select;
    public RadioButton man_voice;
    public RadioButton woman_voice;

    public SharedPreferences preferences1;
    public SharedPreferences.Editor editor;
    public SharedPreferences preferences2;
    public SharedPreferences.Editor editor2;

    public boolean form_flag;
    public int voice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);


        preferences1 = getApplicationContext().getSharedPreferences("preferences_file" , MODE_PRIVATE);
        editor = preferences1.edit();

        form_flag = Boolean.parseBoolean(null);
        form_flag = preferences1.getBoolean("clock_form_flag" , Boolean.parseBoolean(null));

        form_in_12_1 = findViewById(R.id._12Hour);
        form_in_24_1 = findViewById(R.id._24Hour);

        if(form_flag)
        {
            form_in_12_1.setChecked(true);
        }
        else
        {
            form_in_24_1.setChecked(true);
            //in the first run of the app , this code will be executed ,
            // because the form_flag isn't set
            // and with initial definition of this variable , the value of false is stored in it
            //and the clock is in 24 Hour form
        }

        clock_form = findViewById(R.id.Clock_Frame);
        clock_form.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id._24Hour : {
                        form_flag = false;
                        editor.putBoolean("clock_form_flag" , false);
                        editor.apply();
                        break;
                    }
                    case R.id._12Hour : {
                        form_flag = true;
                        editor.putBoolean("clock_form_flag" , true);
                        editor.apply();
                        break;
                    }
                }
            }
        });




        preferences2 = getApplicationContext().getSharedPreferences("preferences_file2" , MODE_PRIVATE);
        editor2 = preferences2.edit();

        voice = 0;
        voice = preferences2.getInt("VOICE" , 0);

        man_voice = findViewById(R.id.man);
        woman_voice = findViewById(R.id.woman);




        if(voice == 1)
        {
            man_voice.setChecked(true);
        }
        else if(voice == 0)
        {
            woman_voice.setChecked(true);
            //in the first run of the app , this code will be executed ,
            // because the form_flag isn't set
            // and with initial definition of this variable , the value of false is stored in it
            //and the clock is in 24 Hour form
        }
        else
        {
            //man_voice.setChecked(true);
        }

        voice_Select = findViewById(R.id.voice_select);
        voice_Select.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.man : {
                        voice = 1;
                        editor2.putInt("VOICE" , 1);
                        editor2.apply();
                        break;
                    }
                    case R.id.woman : {
                        voice = 0;
                        editor2.putInt("VOICE" , 0);
                        editor2.apply();
                        break;
                    }
                }
            }
        });


        ViewCompat.setLayoutDirection (voice_Select , ViewCompat.LAYOUT_DIRECTION_RTL);
        ViewCompat.setLayoutDirection (man_voice, ViewCompat.LAYOUT_DIRECTION_RTL);
        ViewCompat.setLayoutDirection (woman_voice , ViewCompat.LAYOUT_DIRECTION_RTL);

        ViewCompat.setLayoutDirection (clock_form , ViewCompat.LAYOUT_DIRECTION_RTL);
        ViewCompat.setLayoutDirection (form_in_12_1, ViewCompat.LAYOUT_DIRECTION_RTL);
        ViewCompat.setLayoutDirection (form_in_24_1 , ViewCompat.LAYOUT_DIRECTION_RTL);

    }


}
