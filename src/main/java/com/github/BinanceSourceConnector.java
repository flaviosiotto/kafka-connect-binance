package com.github;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.utils.AppInfoParser;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class BinanceSourceConnector extends SourceConnector {

    private static final ConfigDef CONFIG_DEF = new ConfigDef();

    @Override
    public String version() {
        return AppInfoParser.getVersion();
    }

    @Override
    public void start(Map<String, String> props) {
        
    }

    @Override
    public Class<? extends Task> taskClass() {
        return BinanceSourceTask.class;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        ArrayList<Map<String, String>> configs = new ArrayList<>();
        return configs;
    }

    @Override
    public void stop() {

    }

    @Override
    public ConfigDef config() {
        return CONFIG_DEF;
    }

}
