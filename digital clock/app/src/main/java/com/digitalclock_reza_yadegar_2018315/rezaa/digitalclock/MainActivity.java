package com.digitalclock_reza_yadegar_2018315.rezaa.digitalclock;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public int hh ;
    public int mm ;
    public int ss ;
    public int yyyy ;
    public int MM ;
    public int DD ;
    public String AP ;
    public int WDtemp;


    public MediaPlayer one;
    public MediaPlayer oneO;
    public MediaPlayer two;
    public MediaPlayer twoO;
    public MediaPlayer three;
    public MediaPlayer threeO;
    public MediaPlayer _for;
    public MediaPlayer _forO;
    public MediaPlayer five;
    public MediaPlayer fiveO;
    public MediaPlayer six;
    public MediaPlayer sixO;
    public MediaPlayer seven;
    public MediaPlayer sevenO;
    public MediaPlayer eight;
    public MediaPlayer eightO;
    public MediaPlayer nine;
    public MediaPlayer nineO;
    public MediaPlayer ten;
    public MediaPlayer tenO;
    public MediaPlayer eleven;
    public MediaPlayer elevenO;
    public MediaPlayer twelve;
    public MediaPlayer twelveO;
    public MediaPlayer thirteen;
    public MediaPlayer forteen;
    public MediaPlayer fifteen;
    public MediaPlayer sixteen;
    public MediaPlayer seventeen;
    public MediaPlayer eighteen;
    public MediaPlayer nineteen;
    public MediaPlayer twenty;
    public MediaPlayer twentyO;
    public MediaPlayer thirty;
    public MediaPlayer thirtyO;
    public MediaPlayer forty;
    public MediaPlayer fortyO;
    public MediaPlayer fifty;
    public MediaPlayer fiftyO;
    public MediaPlayer minute_sound;
    public MediaPlayer hour_sound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView year = (TextView) findViewById(R.id.Year);
        final TextView month = (TextView)findViewById(R.id.Mounth);
        final TextView day = (TextView)findViewById(R.id.Day);
        final TextView ap = (TextView)findViewById(R.id.AP);
        final TextView hour = (TextView)findViewById(R.id.Hour);
        final TextView minute = (TextView)findViewById(R.id.Minute);
        final TextView second = (TextView)findViewById(R.id.Second);
        final TextView percent = (TextView)findViewById(R.id.Percent);
        final TextView wd1 = (TextView)findViewById(R.id.Week_Day_1);
        final TextView wd2 = (TextView)findViewById(R.id.Week_Day_2);
        final TextView wd3 = (TextView)findViewById(R.id.Week_Day_3);

        final Button sclock = (Button)findViewById(R.id.CShow);

        one = MediaPlayer.create(this ,R.raw._1);
        oneO = MediaPlayer.create(this ,R.raw._1_o);
        two = MediaPlayer.create(this ,R.raw._2);
        twoO = MediaPlayer.create(this ,R.raw._1_o);
        three = MediaPlayer.create(this ,R.raw._3);
        threeO = MediaPlayer.create(this ,R.raw._3_o);
        _for = MediaPlayer.create(this ,R.raw._4);
        _forO = MediaPlayer.create(this ,R.raw._4_o);
        five = MediaPlayer.create(this ,R.raw._5);
        fiveO = MediaPlayer.create(this ,R.raw._5_o);
        six = MediaPlayer.create(this ,R.raw._6);
        sixO = MediaPlayer.create(this ,R.raw._6_o);
        seven = MediaPlayer.create(this ,R.raw._7);
        sevenO = MediaPlayer.create(this ,R.raw._7_o);
        eight = MediaPlayer.create(this ,R.raw._8);
        eightO = MediaPlayer.create(this ,R.raw._8_o);
        nine = MediaPlayer.create(this ,R.raw._9);
        nineO = MediaPlayer.create(this ,R.raw._9_o);
        ten = MediaPlayer.create(this ,R.raw._10);
        tenO = MediaPlayer.create(this ,R.raw._10_o);
        eleven = MediaPlayer.create(this ,R.raw._11);
        elevenO = MediaPlayer.create(this ,R.raw._11_o);
        twelve = MediaPlayer.create(this ,R.raw._12);
        twelveO = MediaPlayer.create(this ,R.raw._12_o);
        thirteen = MediaPlayer.create(this ,R.raw._13);
        forteen = MediaPlayer.create(this ,R.raw._14);
        fifteen = MediaPlayer.create(this ,R.raw._15);
        sixteen = MediaPlayer.create(this ,R.raw._16);
        seventeen = MediaPlayer.create(this ,R.raw._17);
        eighteen = MediaPlayer.create(this ,R.raw._18);
        nineteen = MediaPlayer.create(this ,R.raw._19);
        twenty = MediaPlayer.create(this ,R.raw._20);
        twentyO = MediaPlayer.create(this ,R.raw._20_o);
        thirty = MediaPlayer.create(this ,R.raw._30);
        thirtyO = MediaPlayer.create(this ,R.raw._30_o);
        forty = MediaPlayer.create(this ,R.raw._40);
        fortyO = MediaPlayer.create(this ,R.raw._40_o);
        fifty = MediaPlayer.create(this ,R.raw._50);
        fiftyO = MediaPlayer.create(this ,R.raw._50_o);
        minute_sound = MediaPlayer.create(this ,R.raw.daghigheh);
        hour_sound = MediaPlayer.create(this ,R.raw.saat);

        sclock.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {

                Calendar clock = Calendar.getInstance();
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
                    else
                    {
                        hour.setText("0" + String.valueOf(hh-12));
                        AP = "PM";
                    }
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
                hour_sound.start();
                hour_function();
            }
        });


    }

    public void hour_function(){

        if(mm != 0) {
            switch (hh) {
                case 1:
                case 13: {
                    hour_say(hour_sound, oneO);
                    break;
                }
                case 2:
                case 14: {
                    hour_say(hour_sound, twoO);
                    break;
                }
                case 3:
                case 15: {
                    hour_say(hour_sound, threeO);
                    break;
                }
                case 4:
                case 16: {
                    hour_say(hour_sound, _forO);
                    break;
                }
                case 5:
                case 17: {
                    hour_say(hour_sound, fiveO);
                    break;
                }
                case 6:
                case 18: {
                    hour_say(hour_sound, sixO);
                    break;
                }
                case 7:
                case 19: {
                    hour_say(hour_sound, sevenO);
                    break;
                }
                case 8:
                case 20: {
                    hour_say(hour_sound, eightO);
                    break;
                }
                case 9:
                case 21: {
                    hour_say(hour_sound, nineO);
                    break;
                }
                case 10:
                case 22: {
                    hour_say(hour_sound, tenO);
                    break;
                }
                case 11:
                case 23: {
                    hour_say(hour_sound, elevenO);
                    break;
                }
                case 0:
                case 12:
                case 24: {
                    hour_say(hour_sound, twelveO);
                    break;
                }
            }
        }
        else if (mm == 0)
        {
            switch (hh) {
                case 1:
                case 13: {
                    hour_say(hour_sound, one);
                    break;
                }
                case 2:
                case 14: {
                    hour_say(hour_sound, two);
                    break;
                }
                case 3:
                case 15: {
                    hour_say(hour_sound, three);
                    break;
                }
                case 4:
                case 16: {
                    hour_say(hour_sound, _for);
                    break;
                }
                case 5:
                case 17: {
                    hour_say(hour_sound, five);
                    break;
                }
                case 6:
                case 18: {
                    hour_say(hour_sound, six);
                    break;
                }
                case 7:
                case 19: {
                    hour_say(hour_sound, seven);
                    break;
                }
                case 8:
                case 20: {
                    hour_say(hour_sound, eight);
                    break;
                }
                case 9:
                case 21: {
                    hour_say(hour_sound, nine);
                    break;
                }
                case 10:
                case 22: {
                    hour_say(hour_sound, ten);
                    break;
                }
                case 11:
                case 23: {
                    hour_say(hour_sound, eleven);
                    break;
                }
                case 0:
                case 12:
                case 24: {
                    hour_say(hour_sound, twelve);
                    break;
                }
            }
        }
    }

    public void hour_say(MediaPlayer sound1 , final MediaPlayer sound2)
    {
        sound1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sound2.start();
            }
        });

        minute_function(sound2);
    }

    public void minute_function(MediaPlayer sound)
    {
        switch (mm)
        {
            case 0:
                break;
            case 1:
                minute_say(sound , one , null);
                break;
            case 2:
                minute_say(sound , two , null);
                break;
            case 3:
                minute_say(sound , three , null);
                break;
            case 4:
                minute_say(sound , _for , null);
                break;
            case 5:
                minute_say(sound , five , null);
                break;
            case 6:
                minute_say(sound , six , null);
                break;
            case 7:
                minute_say(sound , seven , null);
                break;
            case 8:
                minute_say(sound , eight , null);
                break;
            case 9:
                minute_say(sound , nine , null);
                break;
            case 10:
                minute_say(sound , ten , null);
                break;
            case 11:
                minute_say(sound , eleven , null);
                break;
            case 12:
                minute_say(sound , twelve , null);
                break;
            case 13:
                minute_say(sound , thirteen , null);
                break;
            case 14:
                minute_say(sound , forteen , null);
                break;
            case 15:
                minute_say(sound , fifteen , null);
                break;
            case 16:
                minute_say(sound , sixteen , null);
                break;
            case 17:
                minute_say(sound , seventeen , null);
                break;
            case 18:
                minute_say(sound , eighteen , null);
                break;
            case 19:
                minute_say(sound , nineteen , null);
                break;
            case 20:
                minute_say(sound , twenty , null);
                break;
            case 21:
                minute_say(sound , twentyO , one);
                break;
            case 22:
                minute_say(sound , twentyO , two);
                break;
            case 23:
                minute_say(sound , twentyO , three);
                break;
            case 24:
                minute_say(sound , twentyO , _for);
                break;
            case 25:
                minute_say(sound , twentyO , five);
                break;
            case 26:
                minute_say(sound , twentyO , six);
                break;
            case 27:
                minute_say(sound , twentyO , seven);
                break;
            case 28:
                minute_say(sound , twentyO , eight);
                break;
            case 29:
                minute_say(sound , twentyO , nine);
                break;
            case 30:
                minute_say(sound , thirtyO , null);
                break;
            case 31:
                minute_say(sound , thirtyO , one);
                break;
            case 32:
                minute_say(sound , thirtyO , two);
                break;
            case 33:
                minute_say(sound , thirtyO , three);
                break;
            case 34:
                minute_say(sound , thirtyO , _for);
                break;
            case 35:
                minute_say(sound , thirtyO , five);
                break;
            case 36:
                minute_say(sound , thirtyO , six);
                break;
            case 37:
                minute_say(sound , thirtyO , seven);
                break;
            case 38:
                minute_say(sound , thirtyO , eight);
                break;
            case 39:
                minute_say(sound , thirtyO , nine);
                break;
            case 40:
                minute_say(sound , fortyO , null);
                break;
            case 41:
                minute_say(sound , fortyO , one);
                break;
            case 42:
                minute_say(sound , fortyO , two);
                break;
            case 43:
                minute_say(sound , fortyO , three);
                break;
            case 44:
                minute_say(sound , fortyO , _for);
                break;
            case 45:
                minute_say(sound , fortyO , five);
                break;
            case 46:
                minute_say(sound , fortyO , six);
                break;
            case 47:
                minute_say(sound , fortyO , seven);
                break;
            case 48:
                minute_say(sound , fortyO , eight);
                break;
            case 49:
                minute_say(sound , fortyO , nine);
                break;
            case 50:
                minute_say(sound , fiftyO , null);
                break;
            case 51:
                minute_say(sound , fiftyO , one);
                break;
            case 52:
                minute_say(sound , fiftyO , two);
                break;
            case 53:
                minute_say(sound , fiftyO , three);
                break;
            case 54:
                minute_say(sound , fiftyO , _for);
                break;
            case 55:
                minute_say(sound , fiftyO , five);
                break;
            case 56:
                minute_say(sound , fiftyO , six);
                break;
            case 57:
                minute_say(sound , fiftyO , seven);
                break;
            case 58:
                minute_say(sound , fiftyO , eight);
                break;
            case 59:
                minute_say(sound , fiftyO , nine);
                break;
        }
    }

    public void minute_say(MediaPlayer sound1 , final MediaPlayer sound2 , final MediaPlayer sound3)
    {
        sound1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sound2.start();
            }
        });

        if(sound3 != null)
        {
            sound2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    sound3.start();
                }
            });

            sound3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    minute_sound.start();
                }
            });
        }
        else
        {
            sound2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    minute_sound.start();
                }
            });
        }


    }
}
