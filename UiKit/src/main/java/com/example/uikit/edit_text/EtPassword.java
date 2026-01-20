package com.example.uikit.edit_text;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.uikit.R;

public class EtPassword  extends etDefault{
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
    public void init(){
    super.init();
        LayoutInflater.from(getContext()).inflate(R.layout.et_password,this,true);
    }
}
