package com.jz.fx.streaming.service.core.callbacks;

/**
 * Created by Jack on 17/11/2017.
 */

/**
 *
 * @param <T>
 */
public interface Callback<T> {
    void call(T t);
}
