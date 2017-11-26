package com.jz.fx.streaming.service.core.listeners;

import com.iggroup.webapi.samples.client.streaming.HandyTableListenerAdapter;
import org.springframework.stereotype.Component;

/**
 * Created by Jack on 11/11/2017.
 */
public interface Listener<T> {
    /**
     * Listens *
     */
    HandyTableListenerAdapter listen(T t) throws Exception;

}
