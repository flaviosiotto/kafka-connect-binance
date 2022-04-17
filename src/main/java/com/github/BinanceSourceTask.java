package com.github;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

import com.binance.connector.client.impl.SpotClientImpl;
import com.binance.connector.client.impl.spot.Market;
import com.github.model.CombinedTrades;

import org.apache.kafka.common.errors.InterruptException;
import org.apache.kafka.common.message.ApiVersionsResponseData;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
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
    private BinanceWebSocketClient binanceClient;

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


        ArrayList<String> streams = new ArrayList<>();
        streams.add(symbol+"@trade");

        binanceClient = new BinanceWebSocketClient();
        binanceClient.combineStreams( streams );

        
    }

    @Override
    public List<SourceRecord> poll() throws InterruptException {

//        String result = market.klines(binanceConfig);
        CombinedTrades result = BinanceWebSocketClient.messageQueue.poll();

        if (result == null) {
            return null;
        }

        final List<SourceRecord> records = new ArrayList<>();


        SourceRecord record = new SourceRecord(
            Collections.singletonMap("symbol", symbol),
            Collections.singletonMap("offset", 0),
            topic,
            null,
            null,
            null,
            CombinedTrades.SCHEMA,
            result.toStruct()
        );
        records.add(record);

        return records;
    }

    @Override
    public void stop() {

    }


}
