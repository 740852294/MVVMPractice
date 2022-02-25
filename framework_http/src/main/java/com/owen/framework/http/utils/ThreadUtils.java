package com.owen.framework.http.utils;

import android.os.Looper;

/**
 * 线程工具类
 *
 * @author ZhengYuanle
 */
public class ThreadUtils {
    /**
     * 是否主线程
     *
     * @return
     */
    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }
}
