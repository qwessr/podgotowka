package com.example.podgotowka;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.uikit.edit_text.etDefault;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etDefault btnDefault = findViewById(R.id.etDefault);
        btnDefault.init("", "Введите e-mail");




    }
}