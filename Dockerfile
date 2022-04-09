ARG CP_VERSION=7.1.0
ARG BASE_PREFIX=confluentinc 
ARG CONNECT_IMAGE=cp-kafka-connect

FROM $BASE_PREFIX/$CONNECT_IMAGE:$CP_VERSION

ENV CONNECT_PLUGIN_PATH="/usr/share/java,/usr/share/confluent-hub-components"

ARG KAFKA_CONNECT_BINANCE_VERSION

COPY target/components/packages/confluentinc-kafka-connect-datagen-${KAFKA_CONNECT_BINANCE_VERSION}.zip /tmp/confluentinc-kafka-connect-datagen-${KAFKA_CONNECT_BINANCE_VERSION}.zip

RUN confluent-hub install --no-prompt /tmp/confluentinc-kafka-connect-datagen-${KAFKA_CONNECT_BINANCE_VERSION}.zip