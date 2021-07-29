package com.ydh.mylibrary;

import android.app.Application;
import android.content.Context;

/**
 * Description:
 * Author: YangDH
 * Date: 2021/7/20
 */
public class UIUtils {
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
