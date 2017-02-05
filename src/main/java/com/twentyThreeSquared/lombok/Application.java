package com.twentyThreeSquared.lombok;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twentyThreeSquared.lombok.Communication.Server;
import com.twentyThreeSquared.lombok.Communication.receiver.Receiver;
import com.twentyThreeSquared.lombok.Communication.receiver.ReceiverV1;
import com.twentyThreeSquared.lombok.Communication.sender.Sender;
import com.twentyThreeSquared.lombok.Communication.sender.SenderV1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        Server server = new ServerV1();
        Sender sender = new SenderV1(server);
        Receiver receiver = new ReceiverV1(server);
        ObjectMapper mapper = new ObjectMapper();

        try {
            new TranmissionService(sender, receiver, mapper).run();
        } catch (Exception e) {
            LOGGER.error("Catastrophic failure at runtime in TransmissionService!");
        }
    }
}
