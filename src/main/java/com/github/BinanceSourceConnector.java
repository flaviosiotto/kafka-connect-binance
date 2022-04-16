package com.github;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.utils.AppInfoParser;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 *
 */
public class BinanceSourceConnector extends SourceConnector {

    private BinanceSourceConnectorConfig config;
    private Map<String, String> props;

    @Override
    public String version() {
        return AppInfoParser.getVersion();
    }

    @Override
    public void start(Map<String, String> props) {
        this.props = props;
        config = new BinanceSourceConnectorConfig(props);
    }

    @Override
    public Class<? extends Task> taskClass() {
        return BinanceSourceTask.class;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
      List<Map<String, String>> taskConfigs = new ArrayList<>();
      for (int i = 0; i < maxTasks; i++) {
        Map<String, String> taskConfig = new HashMap<>(this.props);
        taskConfig.put("binance", Integer.toString(i));
        taskConfigs.add(taskConfig);
      }
      return taskConfigs;
    }

    @Override
    public void stop() {

    }

    @Override
    public ConfigDef config() {
        return config.ConfigDef();
    }

}
