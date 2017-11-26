package com.jz.fx.streaming.service.core.exception;

/**
 * Created by Jack on 12/11/2017.
 */
public class SubscribeException extends RuntimeException {

    private Exception e;

    public SubscribeException(Exception e) {
        this.e = e;
    }
}
