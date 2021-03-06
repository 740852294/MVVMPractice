package com.owen.framework.mvvm.component;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;

import com.owen.framework.mvvm.MVVMLifecycle;
import com.owen.framework.mvvm.delegate.IMVVMDelegate;
import com.owen.framework.mvvm.presenter.IPresenter;
import com.owen.framework.mvvm.view.IMVVMView;

/**
 * MVVMAppCompatActivity
 * 基础 AppCompatActivity（开发者如果不想继承此类可以参考此类，自行实现）
 *
 * @author ZhengYuanle
 */
public class MVVMFragment<V extends IMVVMView, P extends IPresenter<V>> extends Fragment implements IMVVMView, IMVVMDelegate<V, P> {

    private MVVMLifecycle<V, P> mMVVMLifecycle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMVVMLifecycle = new MVVMLifecycle<V, P>(this, this);//绑定生命周期
    }

    @Override
    public P makePresenter() {
        return null;//具体业务Activity中根据需要重写
    }

    @Override
    public V getMVVMView() {
        return (V) this;//返回当前View
    }

    @Override
    public P getMVVMPresenter() {
        return mMVVMLifecycle.getPresenter();
    }

    @Override
    public LifecycleOwner getLifecycleOwner() {
        return this;//获取生命周期所有者
    }

    /*@Override
    public Activity getActivity() {
        return this;//获取Activity
    }*/
}
