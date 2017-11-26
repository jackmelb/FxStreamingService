package com.jz.fx.streaming.service.core.config;

import com.lightstreamer.ls_client.UpdateInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Jack on 12/11/2017.
 */
@Configuration
public class QueueConfig {

    @Bean(name = "priceUpdateQueue")
    public BlockingQueue<UpdateInfo> priceUpdateBlockingQueue() {
        return new ArrayBlockingQueue<UpdateInfo>(510);
    }
}
