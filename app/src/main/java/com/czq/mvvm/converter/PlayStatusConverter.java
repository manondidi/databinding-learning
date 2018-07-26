package com.czq.mvvm.converter;

import android.text.SpannableString;

import com.czq.mvvm.model.GameInfo;
import com.czq.mvvm.viewModel.PlayStatusItemVm;

public class PlayStatusConverter {
    public static  PlayStatusItemVm  converPlayStatus(GameInfo  gameInfo){
        PlayStatusItemVm playStatusItemVm=new PlayStatusItemVm();
        playStatusItemVm.playStatus=gameInfo.playStatus;
        playStatusItemVm.content=new SpannableString(gameInfo.reviewContent);
        return playStatusItemVm;
    }
}
