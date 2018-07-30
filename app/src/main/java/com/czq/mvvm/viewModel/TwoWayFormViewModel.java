package com.czq.mvvm.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.czq.mvvm.BR;
import com.czq.mvvm.R;
import com.czq.mvvm.util.DenyUtil;
import com.google.android.flexbox.FlexboxLayout;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 双向绑定表单
 */
public class TwoWayFormViewModel extends BaseObservable {
    private PlayStatusItemVm playStatus;
    private String content;
    private Integer deserve;//可以为null
    private List<String> platformList;
    private Set<String> playPlayformSet;//选中的
    private static InverseBindingListener mRadioInverseBindingListener;
    private static InverseBindingListener mCheckboxInverseBindingListener;

    @Bindable
    public PlayStatusItemVm getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(PlayStatusItemVm playStatus) {
        this.playStatus = playStatus;
        notifyPropertyChanged(BR.playStatus);
    }

    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }

    @Bindable
    public Integer getDeserve() {
        return deserve;
    }

    public void setDeserve(Integer deserve) {
        this.deserve = deserve;
        notifyPropertyChanged(BR.deserve);
    }

    @Bindable
    public List<String> getPlatformList() {
        return platformList;
    }

    public void setPlatformList(List<String> platformList) {
        this.platformList = platformList;
        notifyPropertyChanged(BR.platformList);
    }

    @Bindable
    public Set<String> getPlayPlayformSet() {
        return playPlayformSet;
    }

    public void setPlayPlayformSet(Set<String> playPlayformSet) {
        this.playPlayformSet = playPlayformSet;
        notifyPropertyChanged(BR.playPlayformSet);
    }


    @BindingAdapter({"fillIntoPlatform", "checkedPlatform"})
    public static void generatePlatform(ViewGroup viewGroup, List<String> platformList, Set<String> playingPlatformSet) {
        if (platformList == null) {
            return;
        }
        viewGroup.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        for (String platform : platformList) {
            CheckBox cb = (CheckBox) inflater.inflate(R.layout.view_platform_checkbox, null);
            FlexboxLayout.LayoutParams lp = new FlexboxLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, DenyUtil.dip2px(viewGroup.getContext(), 30)));
            lp.bottomMargin = DenyUtil.dip2px(viewGroup.getContext(), 4);
            lp.rightMargin = DenyUtil.dip2px(viewGroup.getContext(), 4);
            cb.setLayoutParams(lp);
            cb.setChecked(playingPlatformSet.contains(platform));
            cb.setText(platform);
            cb.setOnCheckedChangeListener(mOnCheckboxCheckedChangeListener);
            viewGroup.addView(cb);
        }


    }

    @InverseBindingAdapter(attribute = "checkedPlatform", event = "childCheckboxChange")
    public static Set<String> inverseChildCheckboxChange(ViewGroup viewGroup) {

        Set<String> playingSet = new HashSet<>();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            CheckBox cb = (CheckBox) viewGroup.getChildAt(i);
            if (cb.isChecked()) {
                playingSet.add(cb.getText().toString());
            }
        }
        return playingSet;
    }


    @BindingAdapter(value = {"childCheckboxChange"}, requireAll = false)
    public static void childCheckboxChange(ViewGroup viewGroup, final InverseBindingListener inverseBindingListener) {


        if (mCheckboxInverseBindingListener == null) {
            mCheckboxInverseBindingListener = inverseBindingListener;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            CheckBox cb = (CheckBox) viewGroup.getChildAt(i);
            cb.setOnCheckedChangeListener(mOnCheckboxCheckedChangeListener);
        }


    }

    @BindingAdapter({"deserveRaido"})
    public static void setCheckedRaido(RadioGroup radioGroup, Integer deserve) {

        if (deserve == null) {
            radioGroup.check(R.id.radioDeserve);
        } else if (deserve == 1) {
            radioGroup.check(R.id.radioDeserve);
        } else if (deserve == 0) {
            radioGroup.check(R.id.radioUndeserve);
        }
    }

    @InverseBindingAdapter(attribute = "deserveRaido", event = "deserveRaidoChange")
    public static Integer inverseRaidoChecked(RadioGroup radioGroup) {
        if (R.id.radioDeserve == radioGroup.getCheckedRadioButtonId()) {
            return 1;
        } else if (R.id.radioUndeserve == radioGroup.getCheckedRadioButtonId()) {
            return 0;
        } else {
            return 0;
        }

    }

    @BindingAdapter(value = {"deserveRaidoChange"}, requireAll = false)
    public static void deserveRaidoChange(RadioGroup radioGroup, final InverseBindingListener inverseBindingListener) {

        if (mRadioInverseBindingListener == null) {
            mRadioInverseBindingListener = inverseBindingListener;

        }
        radioGroup.setOnCheckedChangeListener(mOnRadioCheckedChangeListener);
    }

    private static RadioGroup.OnCheckedChangeListener mOnRadioCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            mRadioInverseBindingListener.onChange();
        }
    };
    private static CompoundButton.OnCheckedChangeListener mOnCheckboxCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            mCheckboxInverseBindingListener.onChange();
        }
    };
}
