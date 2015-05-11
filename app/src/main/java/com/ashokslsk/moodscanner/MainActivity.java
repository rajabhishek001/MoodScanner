package com.ashokslsk.moodscanner;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private ImageView thumbPrint;
    private TextView result;
    private AnimationDrawable thumbAnimation;
    private Runnable mRunnable;
    private String[] moodResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thumbPrint = (ImageView) findViewById(R.id.thumbprint);
        result = (TextView) findViewById(R.id.result);
        moodResults = new String[]{
          "Something wonderful is about to happen","Believe you can do this","You are the master of your soul",
          "Move on something wonderful is waiting for you", "Next oppurtunity will bring you happiness"," Work hard you are about to win",
          "You can get everything when you believe YOU","You look smart today!","You are wonderful","Feel the glipmse of happiness","Whats happening is thrust for your happiness tomorrow.",
          "Go ahead you can win this"
        };

        thumbPrint.setBackgroundResource(R.drawable.thumb_animation);
        thumbAnimation = (AnimationDrawable)thumbPrint.getBackground();

        thumbPrint.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //starting animation
                thumbAnimation.start();
                showresult();
                return true;
            }
        });

    }

    public void showresult(){
        mRunnable = new Runnable() {
            @Override
            public void run() {
                 int random = (int) (Math.random()*moodResults.length);
                result.setText(moodResults[random]);
                //Stopping animation
                thumbAnimation.stop();
            }
        };

        Handler mHandler = new Handler();
        mHandler.postDelayed(mRunnable,5000);
    }

  }
