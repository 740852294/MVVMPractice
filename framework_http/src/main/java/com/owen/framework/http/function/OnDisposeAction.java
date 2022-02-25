package com.owen.framework.http.function;

import com.owen.framework.http.disposable.IDisposableCancel;

import io.reactivex.rxjava3.functions.Action;

/**
 * OnDisposableCancel
 *
 * @author ZhengYuanle
 */
public class OnDisposeAction implements Action {

    private IDisposableCancel disposableCancel;

    public OnDisposeAction(IDisposableCancel disposableCancel) {
        this.disposableCancel = disposableCancel;
    }

    @Override
    public void run() throws Exception {
        //Dispose
        if (disposableCancel != null) disposableCancel.cancel();
    }
}