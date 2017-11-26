package com.jz.fx.streaming.service.core.config;

import com.jz.fx.streaming.service.core.pojo.Price;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Jack on 12/11/2017.
 */
@Configuration
public class PriceMapConfig {

    @Bean(name = "priceUpdateMap")
    public Map<String, Price> priceUpdateMap () { return new ConcurrentHashMap<>();}
}
