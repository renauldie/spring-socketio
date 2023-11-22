package com.reynn.socketio.model;

import lombok.Data;

/**
 * @author Renauldi Albarqawy
 * @Date 22/11/2023
 */
@Data
public class Message {
    private MessageType type;
    private String message;
    private String room;

    public Message() {
    }

    public Message(MessageType type, String message) {
        this.type = type;
        this.message = message;
    }
}
