package com.czq.mvvm.converter;

import com.czq.mvvm.model.GameInfo;
import com.czq.mvvm.viewModel.GameDetailVm;
import com.czq.mvvm.viewModel.PlayStatusItemVm;
import com.czq.mvvm.viewModel.TwoWayResultVm;

public class GameDetailConverter {
    public static GameDetailVm converGameDetailVm(GameInfo gameInfo, TwoWayResultVm twoWayResultVm, GameDetailVm gameDetailVm) {
        gameDetailVm.gameInfoVm = GameInfoConverter.converGameInfo(gameInfo);
        PlayStatusItemVm playStatusItemVm = PlayStatusConverter.converPlayStatus(gameInfo);
        for (int i = 0; i < gameDetailVm.datasource.size(); i++) {
            if (gameDetailVm.datasource.get(i) instanceof PlayStatusItemVm) {
                gameDetailVm.datasource.remove(i);
                gameDetailVm.datasource.add(i, playStatusItemVm);
                break;
            }
        }

        return gameDetailVm;
    }
}
