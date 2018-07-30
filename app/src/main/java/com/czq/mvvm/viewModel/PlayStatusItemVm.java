package com.czq.mvvm.viewModel;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.text.SpannableString;
import android.widget.Button;

public class PlayStatusItemVm {
    public ObservableField<String> playStatus;
    public ObservableField<SpannableString> content;

    public PlayStatusItemVm() {
        playStatus=new ObservableField<>();
        content=new ObservableField<>();
    }

    @BindingAdapter({"selectPlayStatus"})
    public static void selectPlayStatusBtn(Button btn, boolean isSelected) {
        btn.setSelected(isSelected);
    }
}
