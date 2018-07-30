package com.czq.mvvm.converter;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import com.czq.mvvm.model.GameInfo;
import com.czq.mvvm.viewModel.PlayStatusItemVm;

public class PlayStatusConverter {
    public static PlayStatusItemVm converPlayStatus(GameInfo gameInfo) {
        if (gameInfo == null) {
            return null;
        }
        PlayStatusItemVm playStatusItemVm = new PlayStatusItemVm();
        playStatusItemVm.playStatus.set(gameInfo.playStatus);
        playStatusItemVm.content.set(new SpannableString(gameInfo.reviewContent));

        if (gameInfo.deserve == null) {
            playStatusItemVm.content.set(new SpannableString(gameInfo.reviewContent));
        } else {
            String deserveStr = gameInfo.deserve == 1 ? "值得玩  |  " : "不值得玩 |   ";
            ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor(gameInfo.deserve == 1 ? "#f39a00" : "#aaaaaa"));
            SpannableString spannableString = new SpannableString(deserveStr + gameInfo.reviewContent);
            spannableString.setSpan(colorSpan, 0, deserveStr.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            playStatusItemVm.content.set(spannableString);

        }
        return playStatusItemVm;
    }
}
