package com.owen.framework.http.function;

import com.owen.framework.http.exception.ExceptionEngine;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.annotations.NonNull;

/**
 * http结果处理函数
 *
 * @author ZhengYuanle
 */
public class HttpResultFunction<T> implements Function<Throwable, Observable<T>> {
    @Override
    public Observable<T> apply(@NonNull Throwable throwable) throws Exception {
        return Observable.error(ExceptionEngine.handleException(throwable));
    }
}
