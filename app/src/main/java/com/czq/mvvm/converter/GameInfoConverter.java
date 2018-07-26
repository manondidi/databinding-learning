package com.czq.mvvm.converter;

import android.text.TextUtils;

import com.czq.mvvm.model.GameInfo;
import com.czq.mvvm.viewModel.GameInfoVm;

public class GameInfoConverter {
    public static GameInfoVm converGameInfo(GameInfo gameInfo) {

        GameInfoVm gameInfoVm = new GameInfoVm();
        gameInfoVm.id = "" + gameInfo.id;
        gameInfoVm.desc = gameInfo.desc;
        gameInfoVm.cover = gameInfo.cover;
        gameInfoVm.deservePercent = "" + (int) (gameInfo.deservePercent * 100);
        gameInfoVm.type = gameInfo.type;
        gameInfoVm.features = TextUtils.join("、", gameInfo.features);
        gameInfoVm.languages = TextUtils.join("、", gameInfo.languages);
        gameInfoVm.platforms = TextUtils.join("、", gameInfo.platforms);
        gameInfoVm.company = gameInfo.company;
        gameInfoVm.platformList=gameInfo.platforms;
        gameInfoVm.title = gameInfo.title;
        return gameInfoVm;
    }
}