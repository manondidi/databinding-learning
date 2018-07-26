package com.czq.mvvm.bindingAdapter;

import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.czq.mvvm.R;
import com.czq.mvvm.util.DenyUtil;

import java.util.ArrayList;
import java.util.List;

public class GamePlatformBindingAdapter {

    @BindingAdapter({"platformIcon"})
    public static void loadPlatformIcon(LinearLayout linearLayout, List<String> platforms) {
        if (platforms==null){
            return;
        }
        linearLayout.removeAllViews();
        for (String platform : platforms) {
            ImageView ivIcon = new ImageView(linearLayout.getContext());
            ivIcon.setImageResource(R.mipmap.platform_ns);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DenyUtil.dip2px(linearLayout.getContext(), 16), DenyUtil.dip2px(linearLayout.getContext(), 16));
            layoutParams.rightMargin = DenyUtil.dip2px(linearLayout.getContext(), 6);
            ivIcon.setLayoutParams(layoutParams);
            linearLayout.addView(ivIcon);
           ivIcon.setImageResource(getPlatformIconResId(platform));
        }

    }


    public static int getPlatformIconResId(String platform) {
        switch (platform.toLowerCase()) {

            case "android":
                return R.mipmap.platform_android;

            case "ios":
                return R.mipmap.platform_ios;

            case "web":
                return R.mipmap.platform_ie;

            case "nds":
                return R.mipmap.platform_nds;

            case "wii":
                return R.mipmap.platform_will;

            case "ngc":
                return R.mipmap.platform_ngc;

            case "gba":
                return R.mipmap.platform_gba;

            case "ps2":
                return R.mipmap.platform_ps2;

            case "xbox":
                return R.mipmap.platform_xbox_balck;

            case "psp":
                return R.mipmap.platform_psp;

            case "xbox360":
                return R.mipmap.platform_xbox360;

            case "ps3":
                return R.mipmap.platform_ps3;

            case "arc":
                return R.mipmap.platform_arc;

            case "ps4":
                return R.mipmap.platform_ps4;

            case "xboxone":
                return R.mipmap.platform_xboxone;

            case "wp":
                return R.mipmap.platform_wp;

            case "3ds":
                return R.mipmap.platform_3ds;

            case "wiiu":
                return R.mipmap.platform_willu;

            case "mac":
                return R.mipmap.platform_mac;

            case "linux":
                return R.mipmap.platform_linux;

            case "ns":
                return R.mipmap.platform_ns;
            case "pc":
            default:
                return R.mipmap.platform_pc;
        }
    }
}
