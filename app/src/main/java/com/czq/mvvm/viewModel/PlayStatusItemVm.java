package com.czq.mvvm.viewModel;

import android.databinding.BindingAdapter;
import android.text.SpannableString;
import android.widget.Button;

public class PlayStatusItemVm {
    public String playStatus;
    public SpannableString content;

    @BindingAdapter({"selectPlayStatus"})
    public static void selectPlayStatusBtn(Button btn, boolean isSelected) {
        btn.setSelected(isSelected);
    }
}
