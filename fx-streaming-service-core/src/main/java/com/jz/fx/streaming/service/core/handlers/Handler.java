package com.jz.fx.streaming.service.core.handlers;

/**
 * Created by Jack on 12/11/2017.
 */
public interface Handler<T> {

    void handle();

    void handle(T t);
}
