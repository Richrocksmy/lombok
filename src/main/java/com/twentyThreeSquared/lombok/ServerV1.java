package com.twentyThreeSquared.lombok;

import com.fasterxml.jackson.databind.JsonNode;
import com.twentyThreeSquared.lombok.Communication.Server;

public class ServerV1 implements Server {

    private JsonNode data;

    public JsonNode get() {
        return data;
    }

    public void post(JsonNode data) {
        this.data = data;
    }
}
