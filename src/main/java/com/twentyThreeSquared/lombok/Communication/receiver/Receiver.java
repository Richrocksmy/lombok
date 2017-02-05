package com.twentyThreeSquared.lombok.Communication.receiver;

import com.fasterxml.jackson.databind.JsonNode;

public interface Receiver {

    JsonNode receive() throws Exception;
}
