package com.freelance.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "chats")
public class ChatModel {

    public String _id;
    public List<String> messages;

    public ChatModel(){

    }

    public String get_id() {
        return _id;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    
    
}
