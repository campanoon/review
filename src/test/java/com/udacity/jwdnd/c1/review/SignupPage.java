package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SignupPage {

    @FindBy(id="inputFirstName")
    private WebElement firstName;

    @FindBy(id="inputLastName")
    private WebElement lastName;

    @FindBy(id="inputUsername")
    private WebElement userName;

    @FindBy(id="inputPassword")
    private WebElement password;

    @FindBy(id="submit-SignUp-button")
    private WebElement submitButton;

    public SignupPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void submitUser (String firstname, String lastName, String userName, String password){
        this.firstName.sendKeys(firstname);
        this.lastName.sendKeys(lastName);
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        submitButton.click();
    }
}
