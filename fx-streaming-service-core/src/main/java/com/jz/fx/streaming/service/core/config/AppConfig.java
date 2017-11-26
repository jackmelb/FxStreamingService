package com.jz.fx.streaming.service.core.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Jack on 12/11/2017.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@PropertySource("classpath:/application.properties")
public class AppConfig {

 /*   @Autowired
    public AppConfig(@Value("${trading.ccys}") String tradingCcy){
        this.tradingCcys = tradingCcy;
    }*/

  /*  @Value("${trading}")
    private String tradingCcys;*/


/*    @PostConstruct
    public void print() {
        System.out.println(tradingCcys);
    }*/
   /* @Autowired
    private Environment env;*/

   /* @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }*/
}
