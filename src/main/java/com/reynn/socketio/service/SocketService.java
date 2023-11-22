package com.reynn.socketio.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.reynn.socketio.model.Message;
import com.reynn.socketio.model.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Renauldi Albarqawy
 * @Date 22/11/2023
 */
@Service
@Slf4j
public class SocketService {

    public void sendMessage(String room, String eventName, SocketIOClient senderClient, String message) {
        for (SocketIOClient client : senderClient.getNamespace().getRoomOperations(room).getClients()) {
            if (!client.getSessionId().equals(senderClient.getSessionId())) {
                client.sendEvent(eventName,new Message(MessageType.SERVER, message));
            }
        }
    }

}
