package com.czq.mvvm;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.czq.mvvm.converter.TwoWayFormConverter;
import com.czq.mvvm.databinding.ActivityTwoWayBinding;
import com.czq.mvvm.enums.PlayStatusEnum;
import com.czq.mvvm.model.GameInfo;
import com.czq.mvvm.util.KeyboardUtil;
import com.czq.mvvm.util.StatusBarUtil;
import com.czq.mvvm.viewModel.TwoWayFormViewModel;
import com.czq.mvvm.viewModel.TwoWayResultVm;

import java.util.ArrayList;

public class TwoWayActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityTwoWayBinding binding;
    GameInfo mGameInfo;
    TwoWayFormViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ((ActivityTwoWayBinding) DataBindingUtil.setContentView(this, R.layout.activity_two_way));
        StatusBarUtil.setWindowStatusBarColor(this, R.color.navBarColor);
        mGameInfo = (GameInfo) getIntent().getSerializableExtra("gameInfo");
        mViewModel = TwoWayFormConverter.converViewModel(mGameInfo);
        binding.setViewModel(mViewModel);
        binding.subLayoutPlayStatus.btnWish.setOnClickListener(this);
        binding.subLayoutPlayStatus.btnPlusOne.setOnClickListener(this);
        binding.subLayoutPlayStatus.btnPlaying.setOnClickListener(this);
        binding.subLayoutPlayStatus.btnPlayed.setOnClickListener(this);

        binding.ivBack.setOnClickListener(v -> {
            KeyboardUtil.hideSoftInputFromWindow(TwoWayActivity.this);
            finish();
        });
        binding.tvSubmit.setOnClickListener(v -> {
            KeyboardUtil.hideSoftInputFromWindow(TwoWayActivity.this);

            TwoWayResultVm twoWayResultVm = new TwoWayResultVm();
            twoWayResultVm.content = mViewModel.getContent();
            twoWayResultVm.playStatus = mViewModel.getPlayStatus().playStatus.get();
            if (twoWayResultVm.playStatus.equals(PlayStatusEnum.PLAYED) || twoWayResultVm.playStatus.equals(PlayStatusEnum.PLAYING)) {
                twoWayResultVm.deserve = mViewModel.getDeserve();
            } else {
                twoWayResultVm.deserve = null;
            }
            twoWayResultVm.playingPlatformList = new ArrayList<>(mViewModel.getPlayPlayformSet());

            Intent i = new Intent();
            i.putExtra("twoWayResultVm", twoWayResultVm);
            setResult(1234, i);
            finish();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        final String text = (String) btn.getText();
        switch (text) {
            case "想玩":
                mViewModel.getPlayStatus().playStatus.set(PlayStatusEnum.WISH);
                break;
            case "喜+1":
                mViewModel.getPlayStatus().playStatus.set(PlayStatusEnum.PLUS_ONE);
                break;
            case "在玩":
                mViewModel.getPlayStatus().playStatus.set(PlayStatusEnum.PLAYING);
                break;
            case "玩过":
                mViewModel.getPlayStatus().playStatus.set(PlayStatusEnum.PLAYED);
                break;
        }

    }
}
