package com.github.model;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Trade {
    private String eventType;
    private Long eventTime;
    private String symbol;
    private Long tradeID;
    private Float price;
    private Float quantity;
    private Long buyerID;
    private Long sellerID;
    private Long tradeTime;
    private Boolean marketMaker;

    public static Schema KEY_SCHEMA = SchemaBuilder.struct()
        .field("symbol", Schema.STRING_SCHEMA)
        .field("id_trade", Schema.INT64_SCHEMA)
    .build();

    public static Schema SCHEMA = SchemaBuilder.struct()
        .field("event_type", Schema.STRING_SCHEMA)
        .field("event_time", Schema.INT64_SCHEMA)
        .field("symbol", Schema.STRING_SCHEMA)
        .field("id_trade", Schema.INT64_SCHEMA)
        .field("price", Schema.FLOAT32_SCHEMA)
        .field("quantity", Schema.FLOAT32_SCHEMA)
        .field("id_buyer_order", Schema.INT64_SCHEMA)
        .field("id_seller_order", Schema.INT64_SCHEMA)
        .field("trade_time", Schema.INT64_SCHEMA)
        .field("market_maker", Schema.BOOLEAN_SCHEMA)
    .build();

    public Trade() {
        super();
    }

    public Trade(String eventType, Long eventTime, String symbol, Long tradeID, Float price, Float quantity,
            Long buyerID, Long sellerID, Long tradeTime, Boolean marketMaker) {
        this.eventType = eventType;
        this.eventTime = eventTime;
        this.symbol = symbol;
        this.tradeID = tradeID;
        this.price = price;
        this.quantity = quantity;
        this.buyerID = buyerID;
        this.sellerID = sellerID;
        this.tradeTime = tradeTime;
        this.marketMaker = marketMaker;
    }


    public Struct toStruct() {
        return new Struct(SCHEMA)
            .put("event_type", eventType)
            .put("event_time", eventTime)
            .put("symbol", symbol)
            .put("id_trade", tradeID)
            .put("price", price)
            .put("quantity", quantity)
            .put("id_buyer", buyerID)
            .put("id_seller", sellerID)
            .put("trade_time", tradeTime)
            .put("market_maker", marketMaker)
            ;
    }

    public Struct toKeyStruct() {
        return new Struct(SCHEMA)
            .put("symbol", symbol)
            .put("id_trade", tradeID)
         ;
    }

    @JsonProperty("e")
    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @JsonProperty("E")
    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }

    @JsonProperty("s")
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("t")
    public Long getTradeID() {
        return tradeID;
    }

    public void setTradeID(Long tradeID) {
        this.tradeID = tradeID;
    }

    @JsonProperty("p")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @JsonProperty("q")
    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("b")
    public Long getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(Long buyerID) {
        this.buyerID = buyerID;
    }

    @JsonProperty("a")
    public Long getSellerID() {
        return sellerID;
    }

    public void setSellerID(Long sellerID) {
        this.sellerID = sellerID;
    }

    @JsonProperty("T")
    public Long getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Long tradeTime) {
        this.tradeTime = tradeTime;
    }

    @JsonProperty("m")
    public Boolean getMarketMaker() {
        return marketMaker;
    }

    public void setMarketMaker(Boolean marketMaker) {
        this.marketMaker = marketMaker;
    }


}
