package com.slothmock.pointlessbuttonapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "myPrefsFile";

    private TextView tapCounter;
    private String savedTapCount;
    private static int counter;
    private String stringVal;


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        savedTapCount = settings.getString("savedTapCount", savedTapCount);

        Button increaseButton1 = (Button) findViewById(R.id.button1);
        Button increaseButton2 = (Button) findViewById(R.id.button2);
        Button increaseButton3 = (Button) findViewById(R.id.button3);
        Button resetButton = (Button) findViewById(R.id.resetButton);

        tapCounter = (TextView) findViewById(R.id.tapCounter);
        tapCounter.setText(savedTapCount);
        counter = Integer.parseInt(savedTapCount);


        increaseButton1.setOnClickListener(v -> {
            Log.d("src", "Increasing button tap count...");
            counter++;
            stringVal = Integer.toString(counter);
            tapCounter.setText(stringVal);

            saveTapCount(stringVal);
            makeABeep();
        });

        increaseButton2.setOnClickListener(v -> {
            Log.d("src", "Increasing button tap count...");
            counter++;
            stringVal = Integer.toString(counter);
            tapCounter.setText(stringVal);

            saveTapCount(stringVal);
            makeABeep();
        });

        increaseButton3.setOnClickListener(v -> {
            Log.d("src", "Increasing button tap count...");
            counter++;
            stringVal = Integer.toString(counter);
            tapCounter.setText(stringVal);

            saveTapCount(stringVal);
            makeABeep();
        });

        resetButton.setOnClickListener(v -> {

            Log.d("src", "Tap count reset...");
            resetTapCount();

        });
    }

    private void makeABeep() {
        ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 50);
        toneG.startTone(ToneGenerator.TONE_CDMA_ANSWER, 300);
    }

    private void saveTapCount(String savedTapCount) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("savedTapCount", savedTapCount);
        editor.apply();
    }

    private void resetTapCount() {
        tapCounter = (TextView) findViewById(R.id.tapCounter);
        tapCounter.setText("0");
        counter = 0;
        saveTapCount("0");
    }
}
