package com.twentyThreeSquared.lombok.Communication.sender;

import com.fasterxml.jackson.databind.JsonNode;
import com.twentyThreeSquared.lombok.Communication.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SenderV1 implements Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(SenderV1.class);

    private Server server;

    public SenderV1(Server server) {
        this.server = server;
    }

    public void send(JsonNode data) throws Exception {
        LOGGER.info("Sending new data: {}", data.toString());
        server.post(data);
    }
}
