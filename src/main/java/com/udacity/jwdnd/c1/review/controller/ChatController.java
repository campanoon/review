package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {

    MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping()
    public String getMessages(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        model.addAttribute("messages",messageService.getMessageList().toString());
        return "chat";
    }

    @PostMapping()
    public String postMessage(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        messageService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("messages",messageService.getMessageList().toString());
        return "chat";
    }

    @ModelAttribute("allTypes")
    public String[] populateTypes(){
        return new String[] {"Say","Shout", "Whisper"};
    }
}
