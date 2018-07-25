package com.czq.mvvm.util;

import android.content.Context;

public class DenyUtil {
    public static int dip2px(Context context, int dp) {
        float f = context.getResources().getDisplayMetrics().density;
        return (int) (dp * f + 0.5D);
    }

    public static int px2dip(Context context, int px) {
        float f = context.getResources().getDisplayMetrics().density;
        return (int) (px / f + 0.5F);
    }
}
