package com.owen.library_common.utils;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 路由工具类
 *
 * @author ZhengYuanle
 */
public class RouterUtils {

    public static void inject(Object obj) {
        ARouter.getInstance().inject(obj);
    }

    public static void navigation(String path) {
        ARouter.getInstance().build(path).navigation();
    }

    public static <T> T build(String path) {
        return (T) ARouter.getInstance().build(path).navigation();
    }

}