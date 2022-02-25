package com.owen.framework.mvvm;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import com.owen.framework.mvvm.delegate.IMVVMDelegate;
import com.owen.framework.mvvm.presenter.IPresenter;
import com.owen.framework.mvvm.view.IView;

/**
 * MVVMLifecycle MVPVM 生命周期
 *
 * @author ZhengYuanle
 */
public class MVVMLifecycle<V extends IView, P extends IPresenter<V>> implements LifecycleObserver {

    private IMVVMDelegate<V, P> mMVVMDelegate;
    private P mPresenter;

    public MVVMLifecycle(LifecycleOwner lifecycleOwner, IMVVMDelegate<V, P> mvvmDelegate) {
        this.mMVVMDelegate = mvvmDelegate;
        bindLifecycleOwner(lifecycleOwner);
        onCreate();
    }

    /**
     * 创建回调，添加绑定
     * 备注：Lifecycle.Event.ON_CREATE 在 onCreate 函数之后，导致 onCreate 中无法正常使用
     */
    //@OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        if (mMVVMDelegate == null) return;
        /**
         * 调用创建 Presenter 函数
         */
        mPresenter = mMVVMDelegate.makePresenter();

        /**
         * 获取 View
         */
        V view = mMVVMDelegate.getMVVMView();

        if (mPresenter != null && view != null) {
            //关联view
            mPresenter.attachView(view);
        }
    }

    /**
     * 销毁回调，解除View绑定
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        if (mPresenter != null) mPresenter.detachView();//清空View对象
        mMVVMDelegate = null;//清空'代理'对象
        mPresenter = null;//清空Presenter对象
    }

    /**
     * 获取 Presenter
     *
     * @return
     */
    public P getPresenter() {
        return mPresenter;
    }

    /**
     * 绑定生命周期
     */
    private void bindLifecycleOwner(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == null) return;
        lifecycleOwner.getLifecycle().addObserver(this);
    }

}
