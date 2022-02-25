package com.owen.framework.http.function;

import androidx.annotation.NonNull;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import io.reactivex.rxjava3.functions.Function;

/**
 * 服务器结果处理函数
 *
 * @author ZhengYuanle
 */
public class ServerResultFunction implements Function<JsonElement, String> {
    @Override
    public String apply(@NonNull JsonElement response) throws Exception {
        /*避免html文本被格式化*/
        return new GsonBuilder().disableHtmlEscaping().create().toJson(response);
    }
}