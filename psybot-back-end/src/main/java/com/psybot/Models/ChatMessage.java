package com.psybot.Models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="messages")
public class ChatMessage {
    private String inputMessage;
    private String outputMessage;

    public String getInputMessage() {
        return inputMessage;
    }

    public void setInputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }

    public void setOutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }
}
