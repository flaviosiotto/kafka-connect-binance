ARG CP_VERSION=7.1.0
ARG BASE_PREFIX=confluentinc 
ARG CONNECT_IMAGE=cp-server-connect

FROM $BASE_PREFIX/$CONNECT_IMAGE:$CP_VERSION

ENV CONNECT_PLUGIN_PATH="/usr/share/java,/usr/share/confluent-hub-components"

ARG KAFKA_CONNECT_BINANCE_VERSION=1.0-SNAPSHOT

# Build Live Plugin

COPY target/components/packages/flaviosiotto-kafka-connect-binance-${KAFKA_CONNECT_BINANCE_VERSION}.zip /tmp/kafka-connect-binance-${KAFKA_CONNECT_BINANCE_VERSION}.zip

RUN confluent-hub install --no-prompt /tmp/kafka-connect-binance-${KAFKA_CONNECT_BINANCE_VERSION}.zip