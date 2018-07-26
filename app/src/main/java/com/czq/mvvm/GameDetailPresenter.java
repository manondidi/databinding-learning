package com.czq.mvvm;

import com.czq.mvvm.converter.CommentConverter;
import com.czq.mvvm.converter.EntryItemVmConverter;
import com.czq.mvvm.converter.GameInfoConverter;
import com.czq.mvvm.converter.PlayStatusConverter;
import com.czq.mvvm.viewModel.GameDetailVm;
import com.czq.mvvm.viewModel.EmptyTransparentItemVm;
import com.czq.mvvm.viewModel.PlayStatusItemVm;
import com.czq.mvvm.viewModel.RecordTotalItemVm;
import com.czq.mvvm.viewModel.ScreenshotVm;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GameDetailPresenter implements GameDetailContact.IGameDetailPresenter {

    private GameDetailContact.IGameDetailView mView;

    private MockService mockService;

    public GameDetailPresenter(GameDetailContact.IGameDetailView view, MockService mockService) {
        this.mockService = mockService;
        this.mView = view;
    }

    @Override
    public void start() {
        getGameDetail("");
    }

    @Override
    public void getGameDetail(String gameId) {
        Observable.zip(
                mockService.getGameCard(gameId),
                mockService.getGameInfo(gameId),
                mockService.getScreenshotList(gameId),
                mockService.getCommentList(gameId),
                (gameCard, gameInfo, screenshots, comments) -> {

                    GameDetailVm gameDetailVm = new GameDetailVm();
                    gameDetailVm.datasource = new ArrayList();
                    gameDetailVm.datasource.add(new EmptyTransparentItemVm());
                    gameDetailVm.datasource.add(PlayStatusConverter.converPlayStatus(gameInfo));
                    gameDetailVm.datasource.add(EntryItemVmConverter.convertEntryItemVm(gameCard));
                    gameDetailVm.datasource.add(new RecordTotalItemVm(comments.size()));
                    gameDetailVm.datasource.addAll(CommentConverter.convertCommentItemVmList(comments));

                    gameDetailVm.gameInfoVm = GameInfoConverter.converGameInfo(gameInfo);
                    gameDetailVm.screenshotVm = new ScreenshotVm(screenshots);
                    return gameDetailVm;

                }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(gameDetailVm -> {
                    mView.setGameDetailVm(gameDetailVm);
                });
    }

}

