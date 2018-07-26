package com.czq.mvvm;

import com.czq.mvvm.viewModel.GameDetailVm;

public interface GameDetailContact {
    interface IGameDetailView{

        void setGameDetailVm(GameDetailVm gameDetailVm);
    }
    interface IGameDetailPresenter{

        void getGameDetail(String gameId);

        void start();
    }
}
