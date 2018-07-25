package com.czq.mvvm;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.czq.mvvm.model.Comment;
import com.czq.mvvm.model.GameCard;
import com.czq.mvvm.model.GameInfo;
import com.czq.mvvm.model.Screenshot;
import com.czq.mvvm.util.AssetUtil;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class MockService {

    private Context mContext;

    public MockService(Context context) {
        mContext = context;
    }

    public Observable<List<Screenshot>> getScreenshotList(String gameId) {
        return Observable.just("screenshot.json")
                .delay(1, TimeUnit.SECONDS)
                .map(file -> AssetUtil.getStringFromFile(mContext, file))
                .map(data -> JSON.parseArray(data, Screenshot.class));
    }

    public Observable<GameInfo> getGameInfo(String gameId) {
        return Observable.just("gameInfo.json")
                .delay(1, TimeUnit.SECONDS)
                .map(file -> AssetUtil.getStringFromFile(mContext, file))
                .map(data -> JSON.parseObject(data, GameInfo.class));
    }

    public Observable<List<Comment>> getCommentList(String gameId) {
        return Observable.just("comment.json")
                .delay(1, TimeUnit.SECONDS)
                .map(file -> AssetUtil.getStringFromFile(mContext, file))
                .map(data -> JSON.parseArray(data, Comment.class));
    }


    public Observable<GameCard> getGameCard(String gameId) {
        return Observable.just("gameCard.json")
                .delay(1, TimeUnit.SECONDS)
                .map(file -> AssetUtil.getStringFromFile(mContext, file))
                .map(data -> JSON.parseObject(data, GameCard.class));
    }

}
