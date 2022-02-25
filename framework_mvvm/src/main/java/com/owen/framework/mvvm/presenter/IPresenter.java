package com.owen.framework.mvvm.presenter;


import androidx.annotation.NonNull;
import androidx.annotation.UiThread;

import com.owen.framework.mvvm.view.IView;

/**
 * 根Presenter
 * 添加View,销毁View
 *
 * @author ZhengYuanle
 */
public interface IPresenter<V extends IView> {

    /**
     * 将 View 添加到当前 Presenter
     */
    @UiThread
    void attachView(@NonNull V view);

    /**
     * 将 View 从 Presenter 移除
     */
    @UiThread
    void detachView();

}
