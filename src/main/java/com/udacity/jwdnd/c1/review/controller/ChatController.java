package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.User;
import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/chat")
public class ChatController {
    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChatPage(Authentication authentication, @ModelAttribute("chatForm") ChatForm chatForm, Model model) {
        model.addAttribute("chatMessages", this.messageService.getMessageList());
        return "chat";
    }

    @PostMapping
    public String postChatMessage(Authentication authentication, @ModelAttribute("chatForm") ChatForm chatForm, Model model) {
            chatForm.setUsername(authentication.getName());
            this.messageService.addMessage(chatForm);
            chatForm.setMessageText("");
            model.addAttribute("chatMessages", this.messageService.getMessageList());
            return "chat";
    }

    @ModelAttribute("allTypes")
    public String[] allTypes() {
        return new String[]{"Say", "Shout", "Whisper"};
    }
}
