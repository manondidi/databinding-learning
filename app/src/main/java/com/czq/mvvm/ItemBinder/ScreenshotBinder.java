package com.czq.mvvm.ItemBinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.czq.mvvm.R;
import com.czq.mvvm.viewModel.ScreenshotVm;

import me.drakeet.multitype.ItemViewBinder;

public class ScreenshotBinder
        extends ItemViewBinder<ScreenshotVm, ScreenshotBinder.ViewHolder>
{
    protected void onBindViewHolder(@NonNull ViewHolder paramViewHolder, @NonNull ScreenshotVm paramScreenshotVm) {}

    @NonNull
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater paramLayoutInflater, @NonNull ViewGroup paramViewGroup)
    {
        return new ViewHolder(paramLayoutInflater.inflate(R.layout.item_screenshot, paramViewGroup, false));
    }

    static class ViewHolder
            extends RecyclerView.ViewHolder
    {
        ViewHolder(@NonNull View paramView)
        {
            super(paramView);
        }
    }
}
