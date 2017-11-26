package com.jz.fx.streaming.service.core.controller;

import com.jz.fx.streaming.service.core.config.PriceMapConfig;
import com.jz.fx.streaming.service.core.handlers.PriceUpdateHandler;
import com.jz.fx.streaming.service.core.pojo.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jack on 15/11/2017.
 */
@RestController
@RequestMapping("home/")
public class HomeController {

    @Autowired
    PriceMapConfig priceMapConfig;

    @Autowired
    PriceUpdateHandler priceUpdateHandler;

    @RequestMapping("/")
    public String home(){
        return "hello";
    }

    @RequestMapping(value = "fxprice", method = RequestMethod.GET)
    public Price getFxPrice(){
        /*Price newPrice = new Price();
        newPrice.setCcyName("AUDUSD");
        newPrice.setBid("78.51");
        newPrice.setAsk("80.21");
        return  newPrice;*/
        return priceUpdateHandler.priceUpdateMap.get("MARKET:CS.D.AUDUSD.MINI.IP");


    }
}
