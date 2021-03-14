package com.example.tamagoshi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecran1);
        //SharedPreferences settings2 = getSharedPreferences(PREFS_NAME, 1);

        Manager M = Manager.getInstance(this, this);
        M.Ecran1();
    }
}

