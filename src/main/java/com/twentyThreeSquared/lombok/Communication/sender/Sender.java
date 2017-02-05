package com.twentyThreeSquared.lombok.Communication.sender;

import com.fasterxml.jackson.databind.JsonNode;

public interface Sender {

    void send(JsonNode data) throws Exception;
}
