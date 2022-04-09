package com.github;

import java.util.List;
import java.util.Map;

import org.apache.kafka.common.errors.InterruptException;
import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * BinanceSourceTask reads from Binance API.
 */
public class BinanceSourceTask extends SourceTask {
    private static final Logger log = LoggerFactory.getLogger(BinanceSourceTask.class);

    @Override
    public String version() {
        return new BinanceSourceConnector().version();
    }

    @Override
    public void start(Map<String, String> props) {

    }

    @Override
    public List<SourceRecord> poll() throws InterruptException {
        return null;
    }

    @Override
    public void stop() {

    }


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