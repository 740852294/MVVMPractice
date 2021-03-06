package com.owen.library_common.async;


import android.text.TextUtils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;


/**
 * RxJavaObserver
 *
 * @author ZhengYuanle
 */
public class RxJavaObserver<T> implements Observer<T>, IAsyncCancel, LifecycleObserver {

    /*请求标识*/
    private String mDisposableTag;

    public RxJavaObserver(LifecycleOwner lifecycleOwner) {
        this("", lifecycleOwner);
    }

    public RxJavaObserver(String disposableTag, LifecycleOwner lifecycleOwner) {
        setDisposableTag(disposableTag);
        bindLifecycleOwner(lifecycleOwner);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        AsyncManager.get().removeDisposable(mDisposableTag);
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onNext(@NonNull T value) {
        AsyncManager.get().removeDisposable(mDisposableTag);
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        AsyncManager.get().addDisposable(mDisposableTag, d);
    }


    /**
     * 手动取消请求/在组件生命周期销毁时自动取消(只有绑定了LifecycleOwner才会自动回调)
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    @Override
    public void cancel() {
        AsyncManager.get().removeDisposable(mDisposableTag);
    }

    /**
     * 绑定生命周期
     */
    protected void bindLifecycleOwner(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null)
            lifecycleOwner.getLifecycle().addObserver(this);
    }

    /**
     * 设置请求唯一标识
     */
    protected void setDisposableTag(String disposableTag) {
        this.mDisposableTag = TextUtils.isEmpty(disposableTag) ? String.valueOf(System.currentTimeMillis()) : disposableTag;
    }

}
