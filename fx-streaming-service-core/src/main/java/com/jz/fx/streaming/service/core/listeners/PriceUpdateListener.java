package com.jz.fx.streaming.service.core.listeners;

import com.iggroup.webapi.samples.client.StreamingAPI;
import com.iggroup.webapi.samples.client.streaming.HandyTableListenerAdapter;
import com.jz.fx.streaming.service.core.config.QueueConfig;
import com.lightstreamer.ls_client.UpdateInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by Jack on 11/11/2017.
 */
@Component("priceUpdateListener")
public class PriceUpdateListener implements Listener<String> {

    private static final Logger LOG = LoggerFactory.getLogger(PriceUpdateListener.class);

    @Autowired
    private StreamingAPI streamingAPI;

    @Autowired
    private QueueConfig queueConfig;

    public HandyTableListenerAdapter listen(String ccy) throws Exception{

        final HandyTableListenerAdapter handyTableListenerAdapter = streamingAPI.subscribeForMarket(ccy, new HandyTableListenerAdapter() {
            @Override
            public void onUpdate(int i, String s, UpdateInfo updateInfo) {
                try {
                    queueConfig.priceUpdateBlockingQueue().put(updateInfo);
                    LOG.info("Market i {} s {} data {}", i, s, updateInfo);
                }
                catch (InterruptedException ie){
                    LOG.warn(PriceUpdateListener.class.getName() + "thrown a InterruptedException, ignoring it.");
                }
            }
        });
        return handyTableListenerAdapter;
    }
}
