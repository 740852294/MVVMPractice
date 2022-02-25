package com.owen.library_common.async;

import io.reactivex.rxjava3.functions.Action;

/**
 * OnAsyncDisposeAction
 *
 * @author ZhengYuanle
 */
public class OnAsyncDisposeAction implements Action {

    private IAsyncCancel asyncCancel;

    public OnAsyncDisposeAction(IAsyncCancel asyncCancel) {
        this.asyncCancel = asyncCancel;
    }

    @Override
    public void run() throws Exception {
        //Dispose
        if (asyncCancel != null) asyncCancel.cancel();
    }
}