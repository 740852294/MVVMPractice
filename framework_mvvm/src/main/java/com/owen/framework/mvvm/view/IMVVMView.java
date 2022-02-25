package com.owen.framework.mvvm.view;

import android.app.Activity;

import androidx.lifecycle.LifecycleOwner;

/**
 * IMVVMView
 *
 * @author ZhengYuanle
 */
public interface IMVVMView extends IView {
    /**
     * LifecycleOwner
     */
    LifecycleOwner getLifecycleOwner();

    /**
     * Activity
     */
    Activity getActivity();

}
