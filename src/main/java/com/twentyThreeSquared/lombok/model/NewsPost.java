package com.twentyThreeSquared.lombok.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Builder
@JsonDeserialize(builder=NewsPost.NewsPostBuilder.class)
public @Data class NewsPost {

    private final UUID creatorId;
    private final List<UUID> recipientIds;
    private final String text;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class NewsPostBuilder {}
}
