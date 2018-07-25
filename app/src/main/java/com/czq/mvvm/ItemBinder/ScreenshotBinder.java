package com.czq.mvvm.ItemBinder;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.czq.mvvm.R;
import com.czq.mvvm.databinding.ItemScreenshotBinding;
import com.czq.mvvm.model.Screenshot;
import com.czq.mvvm.viewModel.ScreenshotVm;

import jp.wasabeef.glide.transformations.BlurTransformation;
import me.drakeet.multitype.ItemViewBinder;

public class ScreenshotBinder
        extends ItemViewBinder<Screenshot, ScreenshotBinder.ViewHolder> {
    protected void onBindViewHolder(@NonNull ViewHolder paramViewHolder, @NonNull Screenshot paramScreenshotVm) {
//        Glide.with(paramViewHolder.itemView.getContext()).load(R.mipmap.default_screenshot).apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 3))).into(binding.ivToolbar);

    }

    @NonNull
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater paramLayoutInflater, @NonNull ViewGroup paramViewGroup) {
        return new ViewHolder(DataBindingUtil.inflate(paramLayoutInflater, R.layout.item_screenshot, paramViewGroup, false));
    }

    static class ViewHolder
            extends RecyclerView.ViewHolder {
        ItemScreenshotBinding binding;

        ViewHolder(@NonNull ItemScreenshotBinding b) {
            super(b.getRoot());
            binding = b;
        }
    }
}
