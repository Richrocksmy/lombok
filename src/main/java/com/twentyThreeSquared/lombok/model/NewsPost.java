package com.twentyThreeSquared.lombok.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;
import java.util.UUID;

@JsonDeserialize(builder=NewsPost.Builder.class)
public class NewsPost {

    private final UUID creatorId;
    private final List<UUID> recipientIds;
    private final String text;

    private NewsPost(UUID creatorId, List<UUID> recipientIds, String text) {
        this.creatorId = creatorId;
        this.recipientIds = recipientIds;
        this.text = text;
    }

    public UUID getCreatorId() {
        return creatorId;
    }

    public List<UUID> getRecipientIds() {
        return recipientIds;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("creatorId", creatorId)
                .append("recipientIds", recipientIds)
                .append("text", text)
                .toString();
    }

    public static class Builder {

        private UUID creatorId;
        private List<UUID> recipientIds;
        private String text;

        public Builder() {}

        public Builder(UUID creatorId, List<UUID> recipientIds, String text) {
            this.creatorId = creatorId;
            this.recipientIds = recipientIds;
            this.text = text;
        }

        public Builder withCreatorId(UUID creatorId) {
            this.creatorId = creatorId;
            return this;
        }

        public Builder withRecipientIds(List<UUID> recipientIds) {
            this.recipientIds = recipientIds;
            return this;
        }

        public Builder withText(String text) {
            this.text = text;
            return this;
        }

        public NewsPost build() {
            return new NewsPost(creatorId, recipientIds, text);
        }
    }
}
