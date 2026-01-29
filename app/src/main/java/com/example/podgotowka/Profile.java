package com.example.podgotowka;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import toggle.Toggle;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        Toggle toggle = findViewById(R.id.toggle);
        toggle.setChecked(true);

        Log.d("TOGGLE", "State: " + toggle.isChecked());
    }
    }
