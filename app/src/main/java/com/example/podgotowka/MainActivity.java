package com.example.podgotowka;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uikit.edit_text.BottomSheet.CustomBottomSheet;
import com.example.uikit.edit_text.Button.BthBig;
import com.example.uikit.edit_text.Button.BthCustom;
import com.example.uikit.edit_text.EtDate;
import com.example.uikit.edit_text.etDefault;
import com.example.uikit.edit_text.EtPassword;
import com.google.android.material.bottomsheet.BottomSheetDialog;

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

        Button bthSheetDialogPreview = findViewById(R.id.bthShowDialog);
        Context context = this;
        bthSheetDialogPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1 = LayoutInflater.from(context).inflate(com.example.uikit.R.layout.et_defualt,null);

                CustomBottomSheet.Show(context, view,"");
            }
        });

        BthBig bthBig = findViewById(R.id.bthBig);
        bthBig.init("Нажми на меня", BthCustom.TypeButton.TETRIARY);
    }
}