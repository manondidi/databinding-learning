package com.czq.mvvm.ItemBinder;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.czq.mvvm.R;
import com.czq.mvvm.databinding.ItemScreenshotBinding;
import com.czq.mvvm.model.Screenshot;
import com.czq.mvvm.util.DenyUtil;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import me.drakeet.multitype.ItemViewBinder;

public class ScreenshotBinder
        extends ItemViewBinder<Screenshot, ScreenshotBinder.ViewHolder> {

    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Screenshot screenshot) {

        holder.binding.setScreenshot(screenshot);
        holder.binding.executePendingBindings();

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
