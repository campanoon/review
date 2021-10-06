package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {

    @FindBy(id="messageText")
    private WebElement textField;

    @FindBy(id="submitMessage")
    private WebElement submitButton;

    @FindBy(id="messageType")
    private WebElement messageType;

    @FindBy(className = "chatMessageText")
    private WebElement firstMessageText;

    public ChatPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public ChatMessage getChatMessage(){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setMessageText(firstMessageText.getText());
        return chatMessage;
    }


    public void submitMessage(String message){
        this.textField.sendKeys(message);
        this.submitButton.click();
    }

}
