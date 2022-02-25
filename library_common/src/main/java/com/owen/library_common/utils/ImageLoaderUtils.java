package com.owen.library_common.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.owen.library_common.R;


/**
 * ImageLoaderUtils
 *
 * @author ZhengYuanle
 */
public class ImageLoaderUtils {

    public static void load(Context context, ImageView imageView, Object obj) {
        load(context, imageView, obj, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
    }


    public static void load(Context context, ImageView imageView, Object obj, int placeholderId, int errorRes) {
        RequestBuilder<Drawable> drawableTypeRequest = Glide.with(context).load(obj);
        drawableTypeRequest.placeholder(placeholderId).dontAnimate().error(errorRes).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageView);
    }

}
