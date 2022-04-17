package com.github.model;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CombinedTrades {
    private String streams;
    private Trade data;

    public static Schema SCHEMA = SchemaBuilder.struct()
        .name("trades")
        .field("stream", Schema.STRING_SCHEMA)
        .field("data",
            Trade.SCHEMA
        );

    public CombinedTrades(String streams, Trade data) {
        this.streams = streams;
        this.data = data;
    }

    public Struct toStruct() {
        return new Struct(CombinedTrades.SCHEMA)
            .put("stream", this.streams)
            .put("data", this.data)
        ;
    }

    @JsonProperty("stream")
    public String getStreams() {
        return streams;
    }

    public void setStreams(String streams) {
        this.streams = streams;
    }


    @JsonProperty("data")
    public Trade getData() {
        return data;
    }

    public void setData(Trade data) {
        this.data = data;
    }
}
