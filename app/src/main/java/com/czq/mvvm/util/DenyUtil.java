package com.czq.mvvm.util;

import android.content.Context;

public class DenyUtil {
    public static int dip2px(Context paramContext, int paramInt) {
        float f = paramContext.getResources().getDisplayMetrics().density;
        return (int) (paramInt * f + 0.5D);
    }

    public static int px2dip(Context paramContext, int paramInt) {
        float f = paramContext.getResources().getDisplayMetrics().density;
        return (int) (paramInt / f + 0.5F);
    }
}
