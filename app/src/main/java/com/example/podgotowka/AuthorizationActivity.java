package com.example.podgotowka;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uikit.edit_text.Button.BthBig;
import com.example.uikit.edit_text.Button.BthCustom;
import com.example.uikit.edit_text.Button.BthSocial;
import com.example.uikit.edit_text.EtPassword;
import com.example.uikit.edit_text.etDefault;

public class AuthorizationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);





        /// 1. Поле Email
        etDefault etDefault1 = findViewById(R.id.etDefault1);
        if (etDefault1 != null) {
            etDefault1.init("Вход по email", "example@mail.com", "");
        }

        /// 2. Поле Пароля
        EtPassword etPassword = findViewById(R.id.etPassword);
        if (etPassword != null) {
            etPassword.init("Пароль", "Введите пароль", "");
        }


        /// 3. Главная кнопка
        BthBig bthBig = findViewById(R.id.etNext);

        if (bthBig != null) {
            bthBig.init(com.example.uikit.R.layout.bth_big);
            bthBig.init("Далее", BthCustom.TypeButton.PRIMAPRY);

            if (bthBig.Bth != null) {
                bthBig.Bth.setOnClickListener(v -> {
                    Log.d("BUTTON_CLICK", "Кнопка нажата!");
                    Toast.makeText(this, "Нажата кнопка", Toast.LENGTH_SHORT).show();
                });
            }
        }

        /// 4. Соцсети
        BthSocial bthVk = findViewById(R.id.bthVk);
        if (bthVk != null) {
            bthVk.init(BthSocial.Type.VK);
        }

        BthSocial bthYandex = findViewById(R.id.bthYandex);
        if (bthYandex != null) {
            bthYandex.init(BthSocial.Type.YANDEX);
        }



    }
}