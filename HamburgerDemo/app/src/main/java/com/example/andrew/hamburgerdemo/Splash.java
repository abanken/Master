package com.example.andrew.hamburgerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Andrew on 2/11/2017.
 */

public class Splash extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the contentview to splash screen
        setContentView(R.layout.activity_splash);
        //creates the timer
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(Splash.this, MainActivity.class));
            }
        };
        //sets timer for 4 seconds on splash page
        Timer opening = new Timer();
        opening.schedule(task, 4000);
    }
}

