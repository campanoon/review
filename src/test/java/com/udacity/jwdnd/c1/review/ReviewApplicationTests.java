package com.udacity.jwdnd.c1.review;

import static org.junit.Assert.*;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {

	@LocalServerPort
	public int port;

	public static WebDriver driver;

	public String baseURL;

	@BeforeAll
	public static void beforeAll(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll(){
		driver.quit();
		driver = null;
	}

	@BeforeEach
	public void beforeEach(){
		baseURL = baseURL = "http://localhost:" + port;
	}

	@Test
	void testUserSignupLoginAndSubmitMessage() {
		String username ="chatina";
		String password ="chatina2";
		String message = "A comeeeeeeeeeeeeeeeeeeel!";

		driver.get(baseURL + "/signup");
		SignupPage signupPage = new SignupPage(driver);
		signupPage.submitUser("Belenchu","Lancharro",username, password);

		driver.get(baseURL + "/login");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginUser(username, password);

		ChatPage chatPage = new ChatPage(driver);
		chatPage.submitMessage(message);

		ChatMessage chatMessage = chatPage.getChatMessage();

		assertEquals(chatMessage.getMessageText(),message);

	}

}
