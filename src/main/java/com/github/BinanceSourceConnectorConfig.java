package com.github;


import java.util.Map;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Importance;
import org.apache.kafka.common.config.ConfigDef.Type;

public class BinanceSourceConnectorConfig extends AbstractConfig {


    public static final String KAFKA_TOPIC_CONF = "kafka.topic";
    private static final String KAFKA_TOPIC_DOC = "Topic to write to";
    public static final String BINANCE_MARKET_ENDPOINT_CONF = "binance.market_endpoint";
    private static final String BINANCE_MARKET_ENDPOINT_DOC = "Market Endpoint to read from";
    public static final String BINANCE_SYMBOL_CONF = "binance.symbol";
    private static final String BINANCE_SYMBOL_DOC = "symbol to read (es. BTCUSDT)";
    public static final String BINANCE_INTERVAL_CONF = "binance.interval";
    private static final String BINANCE_INTERVAL_DOC = "interval (1m, 5m, etc)";
    public static final String BINANCE_STARTTIME_CONF = "binance.start_time";
    private static final String BINANCE_STARTTIME_DOC = "Start Time";



    public static final ConfigDef CONFIG_DEF = createConfigDef();


    public BinanceSourceConnectorConfig(final Map<?, ?> originalProps) {
        super(CONFIG_DEF, originalProps);
    }


    public ConfigDef ConfigDef() {
        ConfigDef configDef = new ConfigDef()
            .define(KAFKA_TOPIC_CONF, Type.STRING, Importance.HIGH, KAFKA_TOPIC_DOC)
            .define(BINANCE_MARKET_ENDPOINT_CONF, Type.STRING, Importance.HIGH, BINANCE_MARKET_ENDPOINT_DOC)
            .define(BINANCE_SYMBOL_CONF, Type.STRING, Importance.HIGH, BINANCE_SYMBOL_DOC)
            .define(BINANCE_INTERVAL_CONF, Type.STRING, Importance.HIGH, BINANCE_INTERVAL_DOC)
            .define(BINANCE_STARTTIME_CONF, Type.LONG, Importance.HIGH, BINANCE_STARTTIME_DOC)
            ;

        return configDef;
    }

    public String getKafkaTopic() {
        return this.getString(KAFKA_TOPIC_CONF);
    }

    public String getEndpoint() {
        return this.getString(BINANCE_MARKET_ENDPOINT_CONF);
    }

    public String getSymbol() {
        return this.getString(BINANCE_SYMBOL_CONF);
    }

    public String getInterval() {
        return this.getString(BINANCE_INTERVAL_CONF);
    }

    public Long getStartTime() {
        return this.getLong(BINANCE_STARTTIME_CONF);
    }

}