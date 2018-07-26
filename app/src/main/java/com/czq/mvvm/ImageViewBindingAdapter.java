package com.czq.mvvm;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.czq.mvvm.util.DenyUtil;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class ImageViewBindingAdapter {

    @BindingAdapter({"imgUrl-corners", "corner"})
    public static void loadImageUrl(ImageView imageView, String url, int corners) {

        Glide.with(imageView.getContext()).load(url)
                .apply(RequestOptions.bitmapTransform(new MultiTransformation(
                        new CenterCrop(),
                        new RoundedCornersTransformation(DenyUtil.dip2px(imageView.getContext(), corners), 0, RoundedCornersTransformation.CornerType.ALL))))
                .into(imageView);
    }

    @BindingAdapter({"imgUrl-circle"})
    public static void loadCircleImageUrl(ImageView imageView, String url) {

        Glide.with(imageView.getContext()).load(url)
                .apply(RequestOptions.bitmapTransform(new MultiTransformation(
                        new CenterCrop(),
                        new CircleCrop())))
                .into(imageView);
    }

    @BindingAdapter({"imgUrl"})
    public static void loadImageUrl(ImageView imageView, String url) {

        Glide.with(imageView.getContext()).load(url)
                .apply(RequestOptions.bitmapTransform(new MultiTransformation(
                        new CenterCrop())))
                .into(imageView);
    }

    @BindingAdapter({"imgResId"})
    public static void setImageResId(ImageView imageView, int resId) {
        imageView.setImageResource(resId);
    }
}
