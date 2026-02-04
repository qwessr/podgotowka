package com.example.uikit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.test.annotation.UiThreadTest;
import androidx.test.core.app.ApplicationProvider; // Самый надежный способ получить контекст
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.uikit.R;
import com.example.uikit.edit_text.Button.BthChips;
import com.example.uikit.edit_text.Button.BthCustom;
import com.example.uikit.edit_text.etDefault;
import com.example.uikit.edit_text.card.CardPrimary;
import com.example.uikit.edit_text.common.Item;
import com.example.uikit.edit_text.tabbar.TabBarCustom;
import select.CustomSelect;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private Context context;

    @Before
    public void setUp() {
        // 1. Берем контекст всего приложения (чтобы видеть все ресурсы)
        context = ApplicationProvider.getApplicationContext();
        // 2. Ставим тему, чтобы AppCompat элементы не падали
        context.setTheme(androidx.appcompat.R.style.Theme_AppCompat_Light_NoActionBar);
    }

    // Тест A: Инпут ошибки
    @Test
    @UiThreadTest
    public void testA_InputErrorState() {
        etDefault editText = new etDefault(context, null);

        // Гарантируем загрузку макета
        if (editText.getChildCount() == 0) {
            LayoutInflater.from(context).inflate(R.layout.et_defualt, editText, true);
        }

        editText.init("Заголовок", "Подсказка", "");
        editText.OnError(true, "Текст ошибки");

        TextView tvError = editText.findViewById(R.id.tvViewError); // Или R.id.tvError, проверь в XML
        if (tvError == null) tvError = editText.findViewById(R.id.tvViewError);

        assertNotNull("Не найден TextView ошибки", tvError);
        assertEquals("Текст ошибки", tvError.getText().toString());
        assertEquals(View.VISIBLE, tvError.getVisibility());

        // Проверка цвета (красный)
        assertEquals(context.getResources().getColor(R.color.error, null), tvError.getCurrentTextColor());
    }

    // Тест B: Селект
    @Test
    @UiThreadTest
    public void testB_SelectState() {
        CustomSelect select = new CustomSelect(context, null);
        if (select.getChildCount() == 0) {
            LayoutInflater.from(context).inflate(R.layout.select_defualt, select, true);
        }

        select.init(new String[]{"1", "2"}, "Заголовок", "Выберите", null);
        assertTrue("Select должен нажиматься", select.hasOnClickListeners());
    }

    // Тест C: Chips
    @Test
    @UiThreadTest
    public void testC_ChipsState() {
        BthChips chips = new BthChips(context, null);
        chips.init(0); // Загрузка макета

        chips.setStatus(BthChips.Status.ON);
        assertNotNull("Фон ON не должен быть null", chips.getBackground());

        chips.setStatus(BthChips.Status.OFF);
        assertNotNull("Фон OFF не должен быть null", chips.getBackground());
    }

    // Тест D: Card Primary
    @Test
    @UiThreadTest
    public void testD_CardPrimaryState() {
        CardPrimary card = new CardPrimary(context, null);
        // Теперь init не упадет, так как мы исправили <merge>
        card.init(new Item("Товар", "Кат", 1000));

        // Проверяем статус ADD
        card.setStatus(CardPrimary.Status.ADD);
        TextView btn = findButton(card);
        assertNotNull("Кнопка внутри карточки не найдена", btn);
        assertEquals("Добавить", btn.getText().toString());

        // Проверяем статус DELETE
        card.setStatus(CardPrimary.Status.DELETE);
        assertEquals("Убрать", btn.getText().toString());
    }

    // Тест E: TabBar
    @Test
    @UiThreadTest
    public void testE_TabbarState() {
        TabBarCustom tabBar = new TabBarCustom(context, null);
        assertNotNull("Адаптер должен создаться", tabBar.Adapter);
        assertEquals("Должно быть 4 таба", 4, tabBar.Adapter.getItemCount());
        tabBar.setActiveTab(1);
    }

    // Помощник для поиска кнопки (так как она может быть внутри BthSmall)
    private TextView findButton(View root) {
        // 1. Попробуем найти по стандартному ID кнопки
        View v = root.findViewById(R.id.bth);
        if (v instanceof TextView) return (TextView) v;

        // 2. Если не нашли, ищем внутри BthSmall
        View small = root.findViewById(R.id.bthSmall);
        if (small != null) {
            v = small.findViewById(R.id.bth);
            if (v instanceof TextView) return (TextView) v;
        }
        return null;
    }
}