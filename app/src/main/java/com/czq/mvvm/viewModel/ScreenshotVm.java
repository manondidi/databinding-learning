package com.czq.mvvm.viewModel;

import com.czq.mvvm.model.Screenshot;

import java.util.ArrayList;
import java.util.List;

public class ScreenshotVm {


    public List<Screenshot> screenshots = new ArrayList<>();

    public ScreenshotVm(List<Screenshot> screenshots) {
        this.screenshots = screenshots;
    }
}
