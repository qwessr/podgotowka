package com.example.podgotowka;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uikit.edit_text.EtDate;
import com.example.uikit.edit_text.etDefault;
import com.example.uikit.edit_text.EtPassword;

import select.CustomSelect;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Обычное пустое поле
        etDefault etDefault = findViewById(R.id.etDefault);
        etDefault.init("", "Введите имя", "");

        // Предзаполненное поле
        etDefault etFilled = findViewById(R.id.etFilled);
        etFilled.init("", "Введите имя", "Иван");

        // Поле с заголовком (Title)
        etDefault etDescription = findViewById(R.id.etDescription);
        etDescription.init("Имя", "Введите имя", "Иван");

        // Поле с ошибкой
        etDefault etError = findViewById(R.id.etError);
        etError.init("Имя", "Имя", "");
        etError.OnError(true, "Введите имя");

        // Поле пароля
        EtPassword etPassword = findViewById(R.id.etPassword);
        etPassword.init("", "", "123456789");

        String[] Items = new String[]{"Мужсуой","Женский"};
        CustomSelect Select=findViewById(R.id.select);
        Select.init(Items,"Пол","Пол",null);
    }
}