package com.owen.framework.mvvm.delegate;

import com.owen.framework.mvvm.presenter.IPresenter;
import com.owen.framework.mvvm.view.IView;

/**
 * IMVVMDelegate
 *
 * @author ZhengYuanle
 */
public interface IMVVMDelegate<V extends IView, P extends IPresenter<V>> {
    /**
     * 创建 Presenter
     *
     * @return
     */
    public P makePresenter();

    /**
     * 获取 View
     * 将用来绑定到 P
     *
     * @return
     */
    public V getMVVMView();

    /**
     * 获取 Presenter
     *
     * @return
     */
    public P getMVVMPresenter();
}
