package com.example.podgotowka;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uikit.edit_text.etDefault;

import select.CustomSelect;

public class RegistrationProfile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        etDefault etDefault1 = findViewById(R.id.etDefault1);
            if (etDefault1 != null) {
                etDefault1.init("", "Имя", "");
        }

        etDefault etDefault2 = findViewById(R.id.etDefault2);
        if (etDefault2 != null) {
            etDefault2.init("", "Отчество", "");
        }

        etDefault etDefault3 = findViewById(R.id.etDefault3);
        if (etDefault3 != null) {
            etDefault3.init("", "Фамилия", "");
        }
        etDefault etDate = findViewById(R.id.etDate);
        if (etDate != null) {
            etDate.init("", "Дата рождения", "");
        }

        /// SELECT
        String[] Items = new String[]{"Мужской", "Женский"};
        CustomSelect select = findViewById(R.id.select);
        if (select != null) {
            select.init(Items, "", "Пол", null);
        }

        etDefault etDefault4 = findViewById(R.id.etDefault4);
        if (etDefault4 != null) {
            etDefault4.init("", "Почта", "");
        }
    }
}
