package com.twentyThreeSquared.lombok;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twentyThreeSquared.lombok.Communication.receiver.Receiver;
import com.twentyThreeSquared.lombok.Communication.sender.Sender;
import com.twentyThreeSquared.lombok.model.NewsPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.UUID;

public class TranmissionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TranmissionService.class);

    private final Sender sender;
    private final Receiver receiver;
    private final ObjectMapper mapper;

    public TranmissionService(Sender sender, Receiver receiver, ObjectMapper mapper) {
        this.sender = sender;
        this.receiver = receiver;
        this.mapper = mapper;
    }

    public void run() throws Exception {
        LOGGER.info("Starting {}", TranmissionService.class);

        NewsPost newsPost = new NewsPost.Builder()
                .withCreatorId(UUID.randomUUID())
                .withRecipientIds(Collections.singletonList(UUID.randomUUID()))
                .withText("This is an exciting news post!")
                .build();

        sender.send(serialize(newsPost));

        NewsPost receivedNewsPost = deserialize(receiver.receive());

        LOGGER.info(receivedNewsPost.toString());
        LOGGER.info("Creator Id: {}", receivedNewsPost.getCreatorId());
        LOGGER.info("Text: {}", receivedNewsPost.getText());
    }

    private JsonNode serialize(NewsPost newsPost) {
        return mapper.valueToTree(newsPost);
    }

    private NewsPost deserialize(JsonNode jsonNode) throws JsonProcessingException {
        return mapper.treeToValue(jsonNode, NewsPost.class);
    }
}
