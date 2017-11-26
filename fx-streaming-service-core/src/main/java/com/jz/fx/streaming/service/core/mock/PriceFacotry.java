package com.jz.fx.streaming.service.core.mock;

import com.jz.fx.streaming.service.core.pojo.Price;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * Created by Jack on 17/11/2017.
 */
@Component
public class PriceFacotry {

    Random r = new Random();

    Supplier<Price> supplier = () -> {
        Price p = new Price();
        double randombid = 0.001d + (0.888d - 0.001d) * r.nextDouble();
        double randomask = 0.001d + (0.888d - 0.001d) * r.nextDouble();
        p.setCcyName("AUDUSD");
        p.setBid(Double.toString(78d + randombid));
        p.setAsk(Double.toString(79d + randomask));
        return p;
    };


    Callable<Price> c = () -> {
            return supplier.get();
    };

    public Price producePrice() throws Exception{
        return c.call();
    }
}
