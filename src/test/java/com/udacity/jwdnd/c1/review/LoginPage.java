package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginPage {

    @FindBy(id="inputUsername")
    private WebElement userName;

    @FindBy(id="inputPassword")
    private WebElement password;

    @FindBy(id="submit-login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void loginUser(String username, String password){
        userName.sendKeys(username);
        userName.sendKeys(password);
        loginButton.click();
    }
}
