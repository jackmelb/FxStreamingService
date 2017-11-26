/*
package com.jz.fx.streaming.service.core.controller;

import com.iggroup.webapi.samples.handlers.PriceUpdateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.websocket.EncodeException;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Objects;

*/
/**
 * Created by Jack on 16/11/2017.
 *//*

@ServerEndpoint(value = "/channel/fxprice")
public class PriceWebSocketHandler implements WebSocketHandler{

    @Autowired
    PriceUpdateHandler priceUpdateHandler;

    @OnOpen
    public void onOpen(Session session) throws IOException, EncodeException{
            session.getBasicRemote().sendObject(priceUpdateHandler.priceUpdateMap.get("MARKET:CS.D.AUDUSD.MINI.IP"));
    }

    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {

    }

    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {

    }

    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {

    }

    public boolean supportsPartialMessages() {
        return false;
    }
}
*/
