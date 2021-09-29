package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    List<ChatMessage> messageList;

    @PostConstruct
    public void messageService(){
        System.out.println("Creating MessageService bean");
        messageList=new ArrayList<>();
    }

    public void addMessage(ChatForm chatForm){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()){
            case "Say":
                chatMessage.setMessageText(chatForm.getMessageText());
                break;
            case "Shout":
                chatMessage.setMessageText(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                chatMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
        }
        messageList.add(chatMessage);
    }

    public List<ChatMessage> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<ChatMessage> messageList) {
        this.messageList = messageList;
    }

    /*
    String message;

    public MessageService(String message) {
        this.message = message;
    }



    public String uppercaseMessage(){
        System.out.println("uppercaseMessage() in Service");
        return message.toUpperCase();
    }

    public String lowercaseMessage(){
        System.out.println("lowercaseMessage() in Service");
        return message.toLowerCase();
    }
    */



}
