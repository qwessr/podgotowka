package com.example.uikit.edit_text;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.uikit.R;

/// КОМПОНЕНТ input (ввод данных)
public class etDefault extends ConstraintLayout {

    /// Название поля
    EditText editText;
    /// Текстовое поле
    TextView textView;
    /// флаг для ошибок
    private boolean onError = false;

    public etDefault(@NonNull Context context) {
        super(context);
        init();
    }

    public etDefault(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public etDefault(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /// Инициализация компонента
    void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.et_defualt, this, true);
        editText = findViewById(R.id.et_edit_text);
        textView = findViewById(R.id.tvTextView);

        editText.setOnFocusChangeListener(FocusListener);
    }

    /// Инициализация компонента, назначение названия поля и hint
    public void init(String title, String hint) {
        LayoutInflater.from(getContext()).inflate(R.layout.et_defualt,this, true);
    }

    /// Изменение состояния в зависимости от того что находится в текстовом поле
    private OnFocusChangeListener FocusListener = new OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            setState();
        }
    };

    public void OnError(boolean state) {
        setState();
        onError = state;
    }

    private void setState() {
        if(onError)
            editText.setBackgroundResource(R.drawable.et_state_error);
        else {
            if(String.valueOf(editText.getText()).isEmpty())
                editText.setBackgroundResource(R.drawable.et_stste_defualt);
            else
                editText.setBackgroundResource(R.drawable.et_state_filled);
        }
    }


}


