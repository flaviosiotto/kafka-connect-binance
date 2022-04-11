package com.github;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Collections;

import com.binance.connector.client.impl.SpotClientImpl;
import com.binance.connector.client.impl.spot.Market;

import org.apache.kafka.common.errors.InterruptException;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * BinanceSourceTask reads from Binance API.
 */
public class BinanceSourceTask extends SourceTask {
    private static final Logger log = LoggerFactory.getLogger(BinanceSourceTask.class);

    private String topic;
    private String symbol;
    private BinanceSourceConnectorConfig config;

    private LinkedHashMap<String,Object> binanceConfig;
    private Market market;

    @Override
    public String version() {
        return new BinanceSourceConnector().version();
    }

    @Override
    public void start(Map<String, String> props) {
        config = new BinanceSourceConnectorConfig(props);
        topic = config.getKafkaTopic();
//        String endpoint = config.getEndpoint();
        symbol = config.getSymbol();
        String interval = config.getInterval();
//        Long starttime = config.getStartTime();

        binanceConfig = new LinkedHashMap<>();

        binanceConfig.put("symbol",symbol);
        binanceConfig.put("interval", interval);
//        binanceConfig.put("startTime", starttime);


        market = new SpotClientImpl().createMarket();

    }

    @Override
    public List<SourceRecord> poll() throws InterruptException {

        String result = market.klines(binanceConfig);

        final List<SourceRecord> records = new ArrayList<>();


        SourceRecord record = new SourceRecord(
            Collections.singletonMap("symbol", symbol),
            Collections.singletonMap("offset", 0),
            topic,
            null,
            null,
            null,
            Schema.BYTES_SCHEMA,
            result.getBytes()
        );
        records.add(record);

        return records;
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