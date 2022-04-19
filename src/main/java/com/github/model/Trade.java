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

    public static Schema SCHEMA = SchemaBuilder.struct()
            .field("e", Schema.STRING_SCHEMA)
            .field("E", Schema.INT32_SCHEMA)
            .field("s", Schema.STRING_SCHEMA)
            .field("t", Schema.INT32_SCHEMA)
            .field("p", Schema.FLOAT32_SCHEMA)
            .field("q", Schema.FLOAT32_SCHEMA)
            .field("b", Schema.INT32_SCHEMA)
            .field("a", Schema.INT32_SCHEMA)
            .field("T", Schema.INT32_SCHEMA)
            .field("m", Schema.BOOLEAN_SCHEMA)
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
            .put("e", eventType)
            .put("E", eventTime)
            .put("s", symbol)
            .put("t", tradeID)
            .put("p", price)
            .put("q", quantity)
            .put("b", buyerID)
            .put("a", sellerID)
            .put("T", tradeTime)
            .put("m", marketMaker)
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
