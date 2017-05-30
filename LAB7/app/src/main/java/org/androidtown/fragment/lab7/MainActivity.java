package org.androidtown.fragment.lab7;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout back1;
    LinearLayout back2;

    MediaPlayer mplayer;
    MediaPlayer mplayer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        back1=(LinearLayout)findViewById(R.id.audio1);     //Get the ID=audio1 and inflation
        back2=(LinearLayout)findViewById(R.id.audio2);     //Get the ID=audio2 and inflation


        mplayer= MediaPlayer.create(getApplicationContext(),R.raw.music1);     //Get the raw=music1
        mplayer1= MediaPlayer.create(getApplicationContext(),R.raw.music2);    //Get the raw=music2

    }
    public void play1(View v)
    {
        if(mplayer1.isPlaying())    //If music 1 is running, stop it and play music 2
        {
            mplayer1.pause();
        }
        mplayer.start();

        Toast.makeText(getApplicationContext(),"음원2이 재생되었습니다",Toast.LENGTH_LONG).show();

        back1.setBackgroundColor(Color.DKGRAY);
        back2.setBackgroundColor(Color.WHITE);

        //Change the color of background 1 to gray
        //Change the color of background 2 to white


    }
    public void play2(View v)
    {
        if(mplayer.isPlaying())   //If music 2 is running, stop it and play music 1
        {
            mplayer.pause();
        }
        mplayer1.start();

        Toast.makeText(getApplicationContext(),"음원1이 재생되었습니다",Toast.LENGTH_LONG).show();
        back2.setBackgroundColor(Color.DKGRAY);
        back1.setBackgroundColor(Color.WHITE);

        //Change the color of background 2 to gray
        //Change the color of background 1 to white




    }

}
