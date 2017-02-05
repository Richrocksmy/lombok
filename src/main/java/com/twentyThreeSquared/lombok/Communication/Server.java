package com.twentyThreeSquared.lombok.Communication;

import com.fasterxml.jackson.databind.JsonNode;

public interface Server {

    JsonNode get();

    void post(JsonNode data);
}
