package com.digitalclock_reza_yadegar_2018315.rezaa.digitalclock;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Setting extends AppCompatActivity {

    public RadioGroup clock_form;
    public RadioButton form_in_12_1;
    public RadioButton form_in_24_1;

    public SharedPreferences preferences1;
    public SharedPreferences.Editor editor;

    public boolean form_flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

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

        Intent intent = new Intent(getBaseContext(), Setting.class);
        intent.putExtra("form_flag", true);
        setResult(RESULT_OK, intent);
    }
}
