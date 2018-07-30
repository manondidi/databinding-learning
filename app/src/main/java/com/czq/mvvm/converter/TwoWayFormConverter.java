package com.czq.mvvm.converter;

import com.czq.mvvm.model.GameInfo;
import com.czq.mvvm.viewModel.TwoWayFormViewModel;

import java.util.HashSet;

public class TwoWayFormConverter {

    public static TwoWayFormViewModel converViewModel(GameInfo gameInfo) {
        TwoWayFormViewModel viewModel = new TwoWayFormViewModel();
        viewModel.setPlayStatus(PlayStatusConverter.converPlayStatus(gameInfo));
        viewModel.setContent(gameInfo.reviewContent);
        viewModel.setDeserve(gameInfo.deserve);
        viewModel.setPlatformList(gameInfo.platforms);
        viewModel.setPlayPlayformSet(new HashSet<>(gameInfo.playPlatforms));
        return viewModel;

    }
}
