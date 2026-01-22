package com.example.uikit.edit_text.BottomSheet;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uikit.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class CustomBottomSheet {

    public static BottomSheetDialog Show(Context context, View custom_view, String tittle )
    {
        BottomSheetDialog Dialog = new BottomSheetDialog(context);
        View view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_default, null);

        TextView tvTitle = view.findViewById(R.id.tvTitle);
        ImageView   bthClose = view.findViewById(R.id.bthClose);
        FrameLayout frame = view.findViewById(R.id.frame);

        bthClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog.dismiss();
            }
        });

        if (tittle.isEmpty())
        {
            tvTitle.setVisibility(View.GONE);
            bthClose.setVisibility(View.GONE);
        }
        else {
            tvTitle.setText(tittle);
            tvTitle.setVisibility(View.VISIBLE);
            bthClose.setVisibility(View.VISIBLE);
        }



        frame.addView(custom_view);

        Dialog.setContentView(view);
        Dialog.show();

        return Dialog;
    }
}
