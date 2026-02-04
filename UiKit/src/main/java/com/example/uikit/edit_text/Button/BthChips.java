package com.example.uikit.edit_text.Button;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.uikit.R;

public class BthChips extends BthCustom{

    public enum Status {
        ON, OFF
    }

    public void setStatus(Status status) {
        if (status == Status.ON) {
            this.init("Chips ON", TypeButton.ON);
        } else {
            this.init("Chips OFF", TypeButton.SECONDARY);
        }
    }

    public BthChips(@NonNull Context context) {
        super(context);
    }

    public BthChips(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BthChips(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void init(Integer idLayot)
    {
        super.init(R.layout.bth_chips);
    }
}
