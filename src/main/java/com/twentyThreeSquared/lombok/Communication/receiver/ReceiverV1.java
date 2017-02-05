package com.twentyThreeSquared.lombok.Communication.receiver;

import com.fasterxml.jackson.databind.JsonNode;
import com.twentyThreeSquared.lombok.Communication.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReceiverV1 implements Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverV1.class);

    private Server server;

    public ReceiverV1(Server server) {
        this.server = server;
    }

    public JsonNode receive() throws Exception {
        JsonNode data = server.get();
        LOGGER.info("Received new data: {}", data.toString());
        return data;
    }
}
