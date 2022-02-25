package com.owen.library_common.async;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * RxJavaObservable
 *
 * @author ZhengYuanle
 */
public class RxJavaObservable {

    private RxJavaObserver rxJavaObserver;
    private Observable observable;

    /*构造函数*/
    public RxJavaObservable(Observable observable, RxJavaObserver rxJavaObserver) {
        this.rxJavaObserver = rxJavaObserver;
        this.observable = observable;
    }

    /*doOnDispose*/
    private Observable doOnDispose() {
        return observable.doOnDispose(new OnAsyncDisposeAction(rxJavaObserver));
    }

    /*订阅在主线程*/
    public void subscribe() {
        doOnDispose().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(rxJavaObserver);
    }

}
