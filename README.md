# MoodScanner
Simple Application that display random texts with frame animation.

**Mood Scanner**  
This code may definitely not scan your mood instead an example for frame animation and random text picker.

![Screen](https://github.com/ashokslsk/MoodScanner/blob/master/screens/1.png)
![Screen](https://github.com/ashokslsk/MoodScanner/blob/master/screens/2.png)

**STEPS**

- Create your custom backgrounds for entire screen and imageview

```sh
// Screen Background imag_bg.xml
<shape xmlns:android="http://schemas.android.com/apk/res/android" android:shape="rectangle" >
    <gradient
        android:type="linear"
        android:centerX="49%"
        android:startColor="#FF000000"
        android:centerColor="#FF803100"
        android:endColor="#FF000000"
        android:angle="45"/>
</shape>

//ImageView Background finger_bg.xml
<shape xmlns:android="http://schemas.android.com/apk/res/android" android:shape="rectangle" >
    <gradient
        android:type="linear"
        android:centerX="49%"
        android:startColor="#FF000000"
        android:centerColor="#FF803100"
        android:endColor="#FF000000"
        android:angle="45"/>
</shape>
```

- Define two imageview's for displaying the image
```sh
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:background="@drawable/imag_bg"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/titleText"
        android:textSize="34sp"
        android:textStyle="bold"
        android:padding="20dp"
        android:text="Mood Scanner"
        android:textColor="#fabfab"
        android:layout_centerHorizontal="true"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />


    <TextView
        android:id="@+id/textExplain"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="15sp"
        android:textStyle="normal"
        android:layout_below="@+id/titleText"
        android:layout_centerHorizontal="true"
        android:text="Press and hold for reveal your mood "
        android:textColor="#fff"/>
    
    <ImageView
        android:layout_width="200dp"
        android:layout_height="304dp"
        android:layout_centerHorizontal="true"
        android:layout_below="@+id/textExplain"
        android:layout_marginTop="5dp"
        android:src="@drawable/finger_bg"
        android:id="@+id/backgroundScanner"/>

    <ImageView
        android:layout_width="200dp"
        android:layout_height="304dp"
        android:src="@drawable/thumb_finger_prints"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="5dp"
        android:layout_below="@+id/textExplain"
        android:id="@+id/thumbprint"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/resulttitle"
        android:layout_below="@id/thumbprint"
        android:layout_marginTop="10dp"
        android:textSize="18sp"
        android:textStyle="bold"
        android:layout_centerHorizontal="true"
        android:textColor="#beff"
        android:text="Your mood"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/result"
        android:padding="10dp"
        android:textColor="#bbff1521"
        android:textSize="20sp"
        android:textStyle="italic"
        android:text="Hello"
        android:layout_centerHorizontal="true"
        android:layout_below="@id/resulttitle"/>

</RelativeLayout>
```
- Create animation xml

```sh
<?xml version="1.0" encoding="utf-8"?>
<animation-list xmlns:android="http://schemas.android.com/apk/res/android"
    android:oneshot="false">

    <item
        android:drawable="@drawable/thumb_finger_prints"
        android:duration="100"/>

    <item
        android:drawable="@drawable/anim_one"
        android:duration="100"/>

    <item
        android:drawable="@drawable/anim_two"
        android:duration="100"/>

    <item
        android:drawable="@drawable/anim_three"
        android:duration="100"/>

</animation-list>
```

- Now connecting the xml defined attributes in java as shown below
```sh

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
```

- Execute it as simple as it is 

* [For more codes, funs and for queries be in touch with @ashokslsk ](https://github.com/ashokslsk)

