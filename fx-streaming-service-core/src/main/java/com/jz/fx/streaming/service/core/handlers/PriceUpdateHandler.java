package com.jz.fx.streaming.service.core.handlers;

import com.jz.fx.streaming.service.core.config.PriceMapConfig;
import com.jz.fx.streaming.service.core.config.QueueConfig;
//import com.jz.fx.streaming.service.core.model.CcyPrices;
import com.jz.fx.streaming.service.core.pojo.Price;
import com.lightstreamer.ls_client.UpdateInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * Created by Jack on 12/11/2017.
 */
@Component("priceUpdateHandler")
public class PriceUpdateHandler implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(PriceUpdateHandler.class);

    @Autowired
    private QueueConfig queueConfig;

    @Autowired
    private PriceMapConfig priceMapConfig;

    /*@Autowired
    private FxPricesRepository fxPricesRepository;
*/
    @Value("${price.update.handler.enabled:false}")
    private boolean handlerEnabled;

/*    @Autowired
    private DbCallback dbCallback;*/

    public static Map<String, Price> priceUpdateMap = new ConcurrentHashMap<>();

    private static List<Price> priceList = new ArrayList<>();

    private static  ExecutorService executorService = Executors.newFixedThreadPool(4);

    public void run() {
        try{
            final BlockingQueue<UpdateInfo> queue = queueConfig.priceUpdateBlockingQueue();

           /* Callable<UpdateInfo> priceUpdateCallable = () -> {
                return queue.poll(100, TimeUnit.MILLISECONDS);
            };

            ExecutorService executorService = Executors.newFixedThreadPool(10);
            Future<UpdateInfo> result = executorService.submit(priceUpdateCallable);*/
            while(handlerEnabled) {
                UpdateInfo updateInfo = queue.take();

                handle(updateInfo);

            }
        }
        catch (InterruptedException ie){
            LOG.warn("Interupted while polling from price update queue, ignoring it.");
            Thread.currentThread().interrupt();
            return;
        }
    }

    public void handle(UpdateInfo updateInfo) {
        Objects.requireNonNull(updateInfo);
        final String itemName = updateInfo.getItemName();
        //final String itemName = updateInfo.getNewValue(0);
        final String bid = updateInfo.getNewValue(1);
        final String ask = updateInfo.getNewValue(2);

        Price newPrice = new Price();
        newPrice.setCcyName(itemName);
        newPrice.setBid(bid);
        newPrice.setAsk(ask);
        Date date = new Date(System.currentTimeMillis());
        newPrice.setTime(date.toString());
       /* CcyPrices ccyPrices = new CcyPrices();
        ccyPrices.setCcyName(itemName);
        ccyPrices.setBid(Double.parseDouble(bid));
        ccyPrices.setAsk(Double.parseDouble(ask));
       // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        ccyPrices.setTimeStamp(date);*/

      /*  DbHandler dbHandler = new DbHandler(dbCallback,ccyPrices);
        executorService.submit(dbHandler);*/
      // fxPricesRepository.save(ccyPrices);



        LOG.info("Ccy " + itemName + " has a new price: " + newPrice);
       // priceUpdateMap.put(itemName, newPrice);
        //priceList.add(newPrice);

      /*  priceList.stream()
                .filter((price) -> {
                    return Double.parseDouble(price.getBid()) < 0.76d;
                }).forEach(System.out::println);*/


    }
}
