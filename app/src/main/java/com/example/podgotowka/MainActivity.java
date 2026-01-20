package com.example.podgotowka;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uikit.edit_text.EtDefualt;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EtDefualt etDefualt = findViewById(R.id.etDefualt);
        etDefualt.init("","","Иван");

        EtDefualt etFilled = findViewById(R.id.etFilled);
        etDefualt.init("Имя","Введите Имя","Иван");

        EtDefualt etDescription = findViewById(R.id.etDescription);
        .init("","Введите Имя","Иван");

        EtDefualt etError = findViewById(R.id.etError);
        etError.init("","Введите Имя","Иван");
        etError.OnError

        EtDefualt etDefualt = findViewById(R.id.etDefualt);
        etDefualt.init("","Введите Имя","Иван");
    }
}
