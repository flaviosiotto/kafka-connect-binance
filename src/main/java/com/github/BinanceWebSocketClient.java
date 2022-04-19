package com.github;

import com.binance.connector.client.impl.WebsocketClientImpl;
import com.binance.connector.client.utils.WebSocketCallback;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.github.model.CombinedTrades;

public class BinanceWebSocketClient extends WebsocketClientImpl{

    private static WebSocketCallback onMessageCallback;

    public static ConcurrentLinkedQueue<CombinedTrades> messageQueue = new ConcurrentLinkedQueue<CombinedTrades>();

    ObjectMapper mapper = new ObjectMapper();
    private CombinedTrades trade;

    public BinanceWebSocketClient() {
        super();

        onMessageCallback = (message) -> {
            try {
                trade = mapper.readValue(message, CombinedTrades.class);
            } catch (JsonProcessingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            messageQueue.add(trade);
        };

    }


    public void combineStreams(ArrayList<String> streams) {
        this.combineStreams(streams, onMessageCallback);
    }


    /*
    private static volatile boolean isTradeStreamUp = false;
    private static WebSocketCallback onOpenCallback;
    private static WebSocketCallback onMessageCallback;
    private static WebSocketCallback onClosingCallback;
    private static WebSocketCallback onFailureCallback;

    public static void main(String[] args) {
        WebsocketClientImpl client = new WebsocketClientImpl();

        onOpenCallback = openEvent -> {
            isTradeStreamUp = true;
        };
        onMessageCallback = (message) -> {
            System.out.println(message);
            client.closeAllConnections();
        };
        onClosingCallback = closingEvent -> {
            isTradeStreamUp = false;
        };
        onFailureCallback = failureEvent -> {
            isTradeStreamUp = false;
            connectToTradeStream(client, onOpenCallback, onMessageCallback, onClosingCallback, onClosingCallback);
        };
        connectToTradeStream(client, onOpenCallback, onMessageCallback, onClosingCallback, onFailureCallback);
    }

    private static void connectToTradeStream(
            WebsocketClientImpl client,
            WebSocketCallback onOpenCallback,
            WebSocketCallback onMessageCallback,
            WebSocketCallback onClosingCallback,
            WebSocketCallback onFailureCallback) {
        client.tradeStream("btcusdt", onOpenCallback, onMessageCallback, onClosingCallback, onFailureCallback);
    }
    */
}
