package com.example.podgotowka;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uikit.edit_text.BottomSheet.CustomBottomSheet;
import com.example.uikit.edit_text.Button.BthBig;
import com.example.uikit.edit_text.Button.BthBubbleBack;
import com.example.uikit.edit_text.Button.BthBubbleFilter;
import com.example.uikit.edit_text.Button.BthCard;
import com.example.uikit.edit_text.Button.BthChips;
import com.example.uikit.edit_text.Button.BthCustom;
import com.example.uikit.edit_text.Button.BthSmall;
import com.example.uikit.edit_text.Button.BthSocial;
import com.example.uikit.edit_text.EtDate;
import com.example.uikit.edit_text.EtPassword;
import com.example.uikit.edit_text.etDefault;
import com.example.uikit.edit_text.search.EtSearch;
import com.example.uikit.edit_text.tabbar.TabBarAdapter;
import com.example.uikit.edit_text.tabbar.TabBarCustom;

import select.CustomSelect;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /// Поиск
        EtSearch etSearch = findViewById(R.id.etSearch);
        etSearch.init(0); /// Инициализация лейаута

        /// Обычное пустое поле
        etDefault etDefault = findViewById(R.id.etDefault);
        etDefault.init("", "Введите имя", "");

        /// Предзаполненное поле
        etDefault etFilled = findViewById(R.id.etFilled);
        etFilled.init("", "Введите имя", "Иван");

        /// Поле с заголовком (Title)
        etDefault etDescription = findViewById(R.id.etDescription);
        etDescription.init("Имя", "Введите имя", "Иван");

        /// Поле с ошибкой
        etDefault etError = findViewById(R.id.etError);
        etError.init("Имя", "Имя", "");
        etError.OnError(true, "Ошибка валидации");

        /// Поле пароля
        EtPassword etPassword = findViewById(R.id.etPassword);
        etPassword.init(0); /// Инициализация лейаута
        etPassword.init("", "", "123456789");

        /// Поле даты
        EtDate etDate = findViewById(R.id.etDate);
        etDate.init(0); // Инициализация лейаута
        etDate.init("Дата рождения", "ДД.ММ.ГГГГ", "");

        /// SELECT
        String[] Items = new String[]{"Мужской", "Женский"};
        CustomSelect select = findViewById(R.id.select);
        select.init(Items, "Пол", "Выберите пол", null);

        /// BOTTOM SHEET
        Button bthSheetDialogPreview = findViewById(R.id.bthShowDialog);
        Context context = this;
        bthSheetDialogPreview.setOnClickListener(view -> {
            View view1 = LayoutInflater.from(context).inflate(com.example.uikit.R.layout.et_defualt, null);
            CustomBottomSheet.Show(context, view1, "Заголовок шторки");
        });

        /// BUTTONS

        /// 1. Big Button
        BthBig bthBig = findViewById(R.id.bthBig);
        bthBig.init(0);
        bthBig.init("Главная кнопка", BthCustom.TypeButton.PRIMAPRY);
        bthBig.setOnClickListener(v -> Toast.makeText(context, "Big Button Click", Toast.LENGTH_SHORT).show());

        /// 2. Small Button
        BthSmall bthSmall = findViewById(R.id.bthSmall);
        bthSmall.init(0);
        bthSmall.init("Small", BthCustom.TypeButton.SECONDARY);

        /// 3. Chips
        BthChips bthChips = findViewById(R.id.bthChips);
        bthChips.init(0);
        bthChips.init("Chips", BthCustom.TypeButton.ON);

        /// 4. Card Button (Кнопка с ценой)
        BthCard bthCard = findViewById(R.id.bthCard);
        bthCard.init(0);
        bthCard.init("В корзину", BthCustom.TypeButton.PRIMAPRY);
        bthCard.onCost(1250.0);

        /// 5. Social Buttons
        BthSocial bthVk = findViewById(R.id.bthVk);
        bthVk.init(BthSocial.Type.VK);

        BthSocial bthYandex = findViewById(R.id.bthYandex);
        bthYandex.init(BthSocial.Type.YANDEX);

        BthBubbleBack bthBack = findViewById(R.id.bthBack);
        bthBack.init(0);

        BthBubbleFilter bthFilter = findViewById(R.id.bthFilter);
        bthFilter.init(0);

        TabBarCustom tabBar = findViewById(R.id.tabBar);
        if (tabBar.Adapter != null) {
            tabBar.Adapter.Listner = position -> {
                Log.e("TabBar", "Clicked position: " + position);
                Toast.makeText(context, "Tab selected: " + position, Toast.LENGTH_SHORT).show();
            };
        }
    }
}