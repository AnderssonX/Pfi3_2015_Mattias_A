package com.example.mattias.assignment_1;

//
// Yoda Says....
// By Mattias Andersson
// IDK14, Malmo Hogskola, 2015
//

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity {
// various variables for checking previous quote
    int lastQuote;
int prevQuote=6;
    // create a mediaplayer
MediaPlayer mySound;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Destroy", "Program forced shut down");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Stop", "Program stopped");
    }

    @Override
    protected void onPause() {
        super.onPause();
    Log.i("Pause", "Program paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
    Log.i("Resume", "Program resumed");
    }


    @Override
    protected void onStart() {
        super.onStart();
    Log.i("Start", "Program started, yay!");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySound = MediaPlayer.create(this, R.raw.lightsaber);
        mySound.start();
        Log.i("Create", "Program created");
    }


    @Override
     public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getQuote(View view) {
        if (mySound != null) {
            if (mySound.isPlaying()) {
                mySound.stop();
            }
            mySound.release();
            mySound = null;
        }

        prevQuote=lastQuote;
        TextView quoteView = (TextView)findViewById(R.id.quoteMessage);
        String[] randomQuotes = getResources().getStringArray(R.array.quotes);
        Random random = new Random();
        int randomNo = random.nextInt(6);
        lastQuote=randomNo;

    quoteView.setText(randomQuotes[randomNo]);
        // quoteView.animate();
    quoteView.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_in_left));
// check value of random number and play appropriate sound file to fit current quote!
if(randomNo==0){
mySound = MediaPlayer.create(this, R.raw.years);
mySound.start();
}
        if(randomNo==1){
            mySound = MediaPlayer.create(this, R.raw.truly);
            mySound.start();
        }
        if(randomNo==2){
            mySound = MediaPlayer.create(this, R.raw.darkside);
            mySound.start();
        }
        if(randomNo==3){
            mySound = MediaPlayer.create(this, R.raw.doordonot);
            mySound.start();
        }
        if(randomNo==4){
            mySound = MediaPlayer.create(this, R.raw.clouds);
            mySound.start();
        }
        if(randomNo==5){
            mySound = MediaPlayer.create(this, R.raw.beware);
            mySound.start();
        }
        Log.i("Button pressed", "fetching new random quote");
Log.isLoggable("Random No is equal to", randomNo);
    }
public void lastQuote(View view) {
    // Check if MediaPlayer is currently playing and stop it if it does.
    if (mySound != null) {
        if (mySound.isPlaying()) {
            mySound.stop();
        }
        mySound.release();
        mySound = null;
    }

    TextView quoteView = (TextView)findViewById(R.id.quoteMessage);
            String[] randomQuotes = getResources().getStringArray(R.array.quotes);
    // If prevQuote is seperated from 5, display it in textview.
    if(prevQuote!=6){
    quoteView.setText(randomQuotes [prevQuote]);
    quoteView.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_in_left));
// play approriate sound file to fit previous quote

        if(prevQuote==0){
            mySound = MediaPlayer.create(this, R.raw.years);
            mySound.start();
        }
        if(prevQuote==1){
            mySound = MediaPlayer.create(this, R.raw.truly);
            mySound.start();
        }
        if(prevQuote==2){
            mySound = MediaPlayer.create(this, R.raw.darkside);
            mySound.start();
        }
        if(prevQuote==3){
            mySound = MediaPlayer.create(this, R.raw.doordonot);
            mySound.start();
        }
        if(prevQuote==4){
            mySound = MediaPlayer.create(this, R.raw.clouds);
            mySound.start();
        }
        if(prevQuote==5){
            mySound = MediaPlayer.create(this, R.raw.beware);
            mySound.start();
        }

        // logcat stuff
        Log.i("Button pressed", "grabbing previous displayed quote");}
    else{
        Log.i("Button pressed", "But can't find a previous quote");}
    }
}


