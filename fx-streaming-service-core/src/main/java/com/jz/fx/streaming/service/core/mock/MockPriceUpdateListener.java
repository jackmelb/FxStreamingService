package com.jz.fx.streaming.service.core.mock;

import com.iggroup.webapi.samples.client.streaming.HandyTableListenerAdapter;
import com.jz.fx.streaming.service.core.config.QueueConfig;
import com.jz.fx.streaming.service.core.listeners.Listener;
import com.jz.fx.streaming.service.core.pojo.Price;
import com.lightstreamer.ls_client.UpdateInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Jack on 17/11/2017.
 */
@Component
public class MockPriceUpdateListener implements Listener<String> {

    private static final Logger LOG = LoggerFactory.getLogger(MockPriceUpdateListener.class);

    @Autowired
    PriceFacotry priceFacotry;

    @Autowired
    private QueueConfig queueConfig;

    public HandyTableListenerAdapter listen(String s) throws Exception {
        for (int i =0; i < 1000; i++) {
            final Price price = priceFacotry.producePrice();
            MockUpdateInfo mockUpdateInfo = new MockUpdateInfo(price);
            LOG.info("MockPriceUpdateListener, Market i {} s {} data {}", i, s, mockUpdateInfo);
            queueConfig.priceUpdateBlockingQueue().put(mockUpdateInfo);
        }
        return new HandyTableListenerAdapter();
    }
}
