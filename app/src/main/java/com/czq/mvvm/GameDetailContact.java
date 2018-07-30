package com.czq.mvvm;

import com.czq.mvvm.model.GameInfo;
import com.czq.mvvm.viewModel.GameDetailVm;

public interface GameDetailContact {
    interface IGameDetailView{

        void setGameDetailVm(GameDetailVm gameDetailVm);

        void setGameInfo(GameInfo gameInfo);
    }
    interface IGameDetailPresenter{

        void getGameDetail(String gameId);

        void start();
    }
}
