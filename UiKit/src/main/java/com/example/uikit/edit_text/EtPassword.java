package com.example.uikit.edit_text;

import android.content.Context;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.uikit.R;

public class EtPassword extends CustomEditText {

    ImageView bthPassword;

    public EtPassword(@NonNull Context context) {
        super(context);
    }

    public EtPassword(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EtPassword(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void init(Integer idLayout) {
        super.init(R.layout.et_password);

        bthPassword = findViewById(R.id.bthPassword);
        bthPassword.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getTransformationMethod() == null) {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    bthPassword.setImageResource(R.drawable.ic_password_hide);
                } else {
                    editText.setTransformationMethod(null);
                    bthPassword.setImageResource(R.drawable.ic_password_show);
                }
            }
        });
    }
}