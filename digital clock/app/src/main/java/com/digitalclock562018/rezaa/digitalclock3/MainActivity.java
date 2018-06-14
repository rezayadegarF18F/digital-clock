package com.digitalclock562018.rezaa.digitalclock3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements MainActivityInterface {


    public int hh;
    public int mm;
    public int ss;
    public int yyyy;
    public int MM;
    public int DD;
    public String AP;
    public int WDtemp;

    public MediaPlayer minute_sound , hour_sound , man_minute_sound , man_hour_sound , woman_minute_sound , woman_hour_sound;
    public MediaPlayer sounds[][][];
    public MediaPlayer hour1_temp, hour2_temp;
    public MediaPlayer minute1_temp, minute2_temp;

    public TextView year;
    public TextView month;
    public TextView day;
    public TextView ap;
    public TextView hour;
    public TextView minute;
    public TextView second;
    public TextView wd1;
    public TextView wd2;
    public TextView wd3;

    public Calendar clock;

    public Intent setting_intent;

    public boolean form_flag;

    public SharedPreferences preferences1;
    public SharedPreferences.Editor editor;
    public SharedPreferences preferences2;
    public SharedPreferences.Editor editor2;


    public int voice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        year = findViewById(R.id.Year);
        month = findViewById(R.id.Mounth);
        day = findViewById(R.id.Day);
        ap = findViewById(R.id.AP);
        hour = findViewById(R.id.Hour);
        minute = findViewById(R.id.Minute);
        second = findViewById(R.id.Second);
        wd1 = findViewById(R.id.Week_Day_1);
        wd2 = findViewById(R.id.Week_Day_2);
        wd3 = findViewById(R.id.Week_Day_3);

        sounds = new MediaPlayer[2][2][60];
        for(int i=0 ; i<60 ; i++)
        {
            sounds[0][0][i] = null;
            sounds[0][1][i] = null;
        }

        sounds[0][0][1] = MediaPlayer.create(this ,R.raw._1);
        sounds[0][1][1] = MediaPlayer.create(this ,R.raw._1_o);
        sounds[0][0][2] = MediaPlayer.create(this ,R.raw._2);
        sounds[0][1][2] = MediaPlayer.create(this ,R.raw._2_o);
        sounds[0][0][3] = MediaPlayer.create(this ,R.raw._3);
        sounds[0][1][3] = MediaPlayer.create(this ,R.raw._3_o);
        sounds[0][0][4] = MediaPlayer.create(this ,R.raw._4);
        sounds[0][1][4] = MediaPlayer.create(this ,R.raw._4_o);
        sounds[0][0][5] = MediaPlayer.create(this ,R.raw._5);
        sounds[0][1][5] = MediaPlayer.create(this ,R.raw._5_o);
        sounds[0][0][6] = MediaPlayer.create(this ,R.raw._6);
        sounds[0][1][6] = MediaPlayer.create(this ,R.raw._6_o);
        sounds[0][0][7] = MediaPlayer.create(this ,R.raw._7);
        sounds[0][1][7] = MediaPlayer.create(this ,R.raw._7_o);
        sounds[0][0][8] = MediaPlayer.create(this ,R.raw._8);
        sounds[0][1][8] = MediaPlayer.create(this ,R.raw._8_o);
        sounds[0][0][9] = MediaPlayer.create(this ,R.raw._9);
        sounds[0][1][9] = MediaPlayer.create(this ,R.raw._9_o);
        sounds[0][0][10] = MediaPlayer.create(this ,R.raw._10);
        sounds[0][1][10] = MediaPlayer.create(this ,R.raw._10_o);
        sounds[0][0][11] = MediaPlayer.create(this ,R.raw._11);
        sounds[0][1][11] = MediaPlayer.create(this ,R.raw._11_o);
        sounds[0][0][12] = MediaPlayer.create(this ,R.raw._12);
        sounds[0][1][12] = MediaPlayer.create(this ,R.raw._12_o);
        sounds[0][0][13] = MediaPlayer.create(this ,R.raw._13);
        sounds[0][1][13] = MediaPlayer.create(this ,R.raw._13_o);
        sounds[0][0][14] = MediaPlayer.create(this ,R.raw._14);
        sounds[0][1][14] = MediaPlayer.create(this ,R.raw._14_o);
        sounds[0][0][15] = MediaPlayer.create(this ,R.raw._15);
        sounds[0][1][15] = MediaPlayer.create(this ,R.raw._15_o);
        sounds[0][0][16] = MediaPlayer.create(this ,R.raw._16);
        sounds[0][1][16] = MediaPlayer.create(this ,R.raw._16_o);
        sounds[0][0][17] = MediaPlayer.create(this ,R.raw._17);
        sounds[0][1][17] = MediaPlayer.create(this ,R.raw._17_o);
        sounds[0][0][18] = MediaPlayer.create(this ,R.raw._18);
        sounds[0][1][18] = MediaPlayer.create(this ,R.raw._18_o);
        sounds[0][0][19] = MediaPlayer.create(this ,R.raw._19);
        sounds[0][1][19] = MediaPlayer.create(this ,R.raw._19_o);
        sounds[0][0][20] = MediaPlayer.create(this ,R.raw._20);
        sounds[0][1][20] = MediaPlayer.create(this ,R.raw._20_o);
        sounds[0][0][30] = MediaPlayer.create(this ,R.raw._30);
        sounds[0][1][30] = MediaPlayer.create(this ,R.raw._30_o);
        sounds[0][0][40] = MediaPlayer.create(this ,R.raw._40);
        sounds[0][1][40] = MediaPlayer.create(this ,R.raw._40_o);
        sounds[0][0][50] = MediaPlayer.create(this ,R.raw._50);
        sounds[0][1][50] = MediaPlayer.create(this ,R.raw._50_o);

        sounds[1][0][1] = MediaPlayer.create(this ,R.raw.man_1);
        sounds[1][1][1] = MediaPlayer.create(this ,R.raw.man_1_o);
        sounds[1][0][2] = MediaPlayer.create(this ,R.raw.man_2);
        sounds[1][1][2] = MediaPlayer.create(this ,R.raw.man_2_o);
        sounds[1][0][3] = MediaPlayer.create(this ,R.raw.man_3);
        sounds[1][1][3] = MediaPlayer.create(this ,R.raw.man_3_o);
        sounds[1][0][4] = MediaPlayer.create(this ,R.raw.man_4);
        sounds[1][1][4] = MediaPlayer.create(this ,R.raw.man_4_o);
        sounds[1][0][5] = MediaPlayer.create(this ,R.raw.man_5);
        sounds[1][1][5] = MediaPlayer.create(this ,R.raw.man_5_o);
        sounds[1][0][6] = MediaPlayer.create(this ,R.raw.man_6);
        sounds[1][1][6] = MediaPlayer.create(this ,R.raw.man_6_o);
        sounds[1][0][7] = MediaPlayer.create(this ,R.raw.man_7);
        sounds[1][1][7] = MediaPlayer.create(this ,R.raw.man_7_o);
        sounds[1][0][8] = MediaPlayer.create(this ,R.raw.man_8);
        sounds[1][1][8] = MediaPlayer.create(this ,R.raw.man_8_o);
        sounds[1][0][9] = MediaPlayer.create(this ,R.raw.man_9);
        sounds[1][1][9] = MediaPlayer.create(this ,R.raw.man_9_o);
        sounds[1][0][10] = MediaPlayer.create(this ,R.raw.man_10);
        sounds[1][1][10] = MediaPlayer.create(this ,R.raw.man_10_o);
        sounds[1][0][11] = MediaPlayer.create(this ,R.raw.man_11);
        sounds[1][1][11] = MediaPlayer.create(this ,R.raw.man_11_o);
        sounds[1][0][12] = MediaPlayer.create(this ,R.raw.man_12);
        sounds[1][1][12] = MediaPlayer.create(this ,R.raw.man_12_o);
        sounds[1][0][13] = MediaPlayer.create(this ,R.raw.man_13);
        sounds[1][1][13] = MediaPlayer.create(this ,R.raw.man_13_o);
        sounds[1][0][14] = MediaPlayer.create(this ,R.raw.man_14);
        sounds[1][1][14] = MediaPlayer.create(this ,R.raw.man_14_o);
        sounds[1][0][15] = MediaPlayer.create(this ,R.raw.man_15);
        sounds[1][1][15] = MediaPlayer.create(this ,R.raw.man_15_o);
        sounds[1][0][16] = MediaPlayer.create(this ,R.raw.man_16);
        sounds[1][1][16] = MediaPlayer.create(this ,R.raw.man_16_o);
        sounds[1][0][17] = MediaPlayer.create(this ,R.raw.man_17);
        sounds[1][1][17] = MediaPlayer.create(this ,R.raw.man_17_o);
        sounds[1][0][18] = MediaPlayer.create(this ,R.raw.man_18);
        sounds[1][1][18] = MediaPlayer.create(this ,R.raw.man_18_o);
        sounds[1][0][19] = MediaPlayer.create(this ,R.raw.man_19);
        sounds[1][1][19] = MediaPlayer.create(this ,R.raw.man_19_o);
        sounds[1][0][20] = MediaPlayer.create(this ,R.raw.man_20);
        sounds[1][1][20] = MediaPlayer.create(this ,R.raw.man_20_o);
        sounds[1][0][30] = MediaPlayer.create(this ,R.raw.man_30);
        sounds[1][1][30] = MediaPlayer.create(this ,R.raw.man_30_o);
        sounds[1][0][40] = MediaPlayer.create(this ,R.raw.man_40);
        sounds[1][1][40] = MediaPlayer.create(this ,R.raw.man_40_o);
        sounds[1][0][50] = MediaPlayer.create(this ,R.raw.man_50);
        sounds[1][1][50] = MediaPlayer.create(this ,R.raw.man_50_o);

        woman_minute_sound = MediaPlayer.create(this ,R.raw.daghigheh);
        woman_hour_sound = MediaPlayer.create(this ,R.raw.saat);

        man_minute_sound = MediaPlayer.create(this , R.raw.man_daghighe);
        man_hour_sound = MediaPlayer.create(this , R.raw.man_hour);

        voice = 0;

        setting_intent = new Intent(this , Setting.class);

        final Button setting_temp = findViewById(R.id.Setting_EX);
        setting_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(setting_intent);
            }
        });

        preferences1 = getApplicationContext().getSharedPreferences("preferences_file" , MODE_PRIVATE);
        editor = preferences1.edit();

        form_flag = preferences1.getBoolean("clock_form_flag" , Boolean.parseBoolean(null));


        preferences2 = getApplicationContext().getSharedPreferences("preferences_file2" , MODE_PRIVATE);
        editor2 = preferences2.edit();

        voice = preferences2.getInt("VOICE" , 0);
        if(voice == 0)
        {
            minute_sound = woman_minute_sound;
            hour_sound = woman_hour_sound;
        }
        else if (voice == 1)
        {
            minute_sound = man_minute_sound;
            hour_sound = man_hour_sound;
        }

        hour_calc();

        final Button sclock = findViewById(R.id.CShow);
        sclock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hour1_temp = null;
                hour2_temp = null;
                minute1_temp = null;
                minute2_temp = null;

                hour_calc();
                hour_sound_play2();
            }
        });



    }



    @Override
    public void onResume(){
        super.onResume();
        form_flag = preferences1.getBoolean("clock_form_flag" , Boolean.parseBoolean(null));
        voice = preferences2.getInt("VOICE" , 0);
        if(voice == 0)
        {
            minute_sound = woman_minute_sound;
            hour_sound = woman_hour_sound;
        }
        else if (voice == 1)
        {
            minute_sound = man_minute_sound;
            hour_sound = man_hour_sound;
        }
        hour_calc();
    }

    @Override
    public boolean onCreateOptionMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu , menu);
        return true;
    }

    @Override
    public boolean onOptionItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.Setting:
                Toast.makeText(this, "Refresh selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }
        return true;
    }

    @SuppressLint({"WrongConstant", "SetTextI18n"})
    public void hour_calc()
    {
        clock = Calendar.getInstance();
        ss = clock.get(Calendar.SECOND);
        mm = clock.get(Calendar.MINUTE);
        hh = clock.get(Calendar.HOUR_OF_DAY);
        DD = clock.get(Calendar.DAY_OF_MONTH);
        MM = clock.get(Calendar.MONTH);
        yyyy = clock.get(Calendar.YEAR);

        if (ss < 10)
            second.setText("0" + String.valueOf(ss));
        else
            second.setText(String.valueOf(ss));

        if (mm < 10)
            minute.setText("0" + String.valueOf(mm));
        else
            minute.setText(String.valueOf(mm));

        if (form_flag)
        {
            if (hh < 10)
            {
                hour.setText("0" + String.valueOf(hh));
                AP = "AM";
            }
            else
            {
                if (hh < 12)
                {
                    hour.setText(String.valueOf(hh));
                    AP = "AM";
                }
                else if (hh == 12)
                {
                    hour.setText("12");
                    AP = "PM";
                }
                else if (hh < 22)
                {
                    hh -= 12;
                    hour.setText("0" + String.valueOf(hh));
                    AP = "PM";
                }
                else if(hh == 24 | hh == 0)
                {
                    hh = 0;
                    hour.setText("00");
                    AP = "AM";
                }
                else
                {
                    hh -= 12;
                    hour.setText(String.valueOf(hh));
                    AP = "PM";
                }
            }
        }
        else
        {
            if (hh < 10)
                hour.setText("0" + String.valueOf(hh));
            else
                hour.setText(String.valueOf(hh));
            AP = "--";
        }

        ap.setText(AP);

        if(DD < 10)
            day.setText("0" + String.valueOf(DD));
        else
            day.setText(String.valueOf(DD));

        if(MM < 10)
            month.setText("0" + String.valueOf(MM));
        else
            month.setText(String.valueOf(MM));

        if(yyyy < 10)
            year.setText("000" + String.valueOf(yyyy));
        else if(yyyy < 100)
            year.setText("00" + String.valueOf(yyyy));
        else if(yyyy < 1000)
            year.setText("0" + String.valueOf(yyyy));
        else
            year.setText(String.valueOf(yyyy));

        WDtemp = clock.get(Calendar.DAY_OF_WEEK);

        if (clock.get(Calendar.MONDAY) == WDtemp)
        {
            wd1.setText("M");
            wd2.setText("O");
            wd3.setText("N");
        }
        else if (clock.get(Calendar.TUESDAY) == WDtemp)
        {
            wd1.setText("T");
            wd2.setText("U");
            wd3.setText("E");
        }
        else if (clock.get(Calendar.WEDNESDAY) == WDtemp)
        {
            wd1.setText("W");
            wd2.setText("E");
            wd3.setText("D");
        }
        else if (clock.get(Calendar.THURSDAY) == WDtemp)
        {
            wd1.setText("T");
            wd2.setText("H");
            wd3.setText("U");
        }
        else if (clock.get(Calendar.FRIDAY) == WDtemp)
        {
            wd1.setText("F");
            wd2.setText("R");
            wd3.setText("I");
        }
        else if (clock.get(Calendar.SATURDAY) == WDtemp)
        {
            wd1.setText("S");
            wd2.setText("A");
            wd3.setText("T");
        }
        else if (clock.get(Calendar.SUNDAY) == WDtemp)
        {
            wd1.setText("S");
            wd2.setText("U");
            wd3.setText("N");
        }
    }

    public void hour_sound_play2()
    {
        if(mm != 0)
        {
            hour1_temp = sounds[voice][1][hh];
            if (hh > 20)
            {
                hour1_temp = sounds[voice][1][20];
                hour2_temp = sounds[voice][1][hh-20];
            }
        }
        else
        {
            hour1_temp = sounds[voice][0][hh];
            if (hh > 20)
            {
                hour1_temp = sounds[voice][1][20];
                hour2_temp = sounds[voice][0][hh-20];
            }
        }

        if(mm != 0)
        {
            if (sounds[voice][0][mm] != null)
            {
                minute1_temp = sounds[voice][0][mm];
            }
            else
            {
                minute1_temp = sounds[voice][1][(mm/10)*10];
                minute2_temp = sounds[voice][0][mm%10];
            }
        }
        play_sound2();
    }

    public void play_sound2()
    {
        hour_sound.start();
        play(hour_sound , hour1_temp);

        if(hour2_temp == null && mm !=0)
        {
            play(hour1_temp,minute1_temp);
        }
        else if(hour2_temp != null && mm == 0)
        {
            play(hour1_temp,hour2_temp);
        }
        else if(hour2_temp != null && mm !=0)
        {
            play(hour1_temp,hour2_temp);
            play(hour2_temp,minute1_temp);
        }

        if(minute1_temp != null)
        {
            if(minute2_temp == null)
            {
                play(minute1_temp , minute_sound);
            }
            else
            {
                play(minute1_temp , minute2_temp);
                play(minute2_temp , minute_sound);
            }
        }
    }

    public void play(MediaPlayer sound1 , final MediaPlayer sound2)
    {
        sound1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sound2.start();
            }
        });
    }




}
