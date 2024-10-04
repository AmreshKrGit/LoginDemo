package steps;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageobjects.HomePage;
import pageobjects.LoginPage;

import static org.testng.Assert.assertEquals;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    Logger logger = LoggerFactory.getLogger(LoginSteps.class);

    @Given("The user is on the login page")
    public void user_is_on_login_page() {
        logger.info("Launching the browser and navigating to the login page");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }

    @When("The user enters valid credentials")
    public void user_enters_valid_credentials() {
        logger.info("Entering valid credentials");
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();
    }

    @When("The user enters invalid credentials")
    public void user_enters_invalid_credentials() {
        logger.info("Entering invalid credentials");
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("invalidPass");
        loginPage.clickLogin();
    }

    @When("The user leaves the username field empty")
    public void user_leaves_username_field_empty() {
        logger.info("Leaving the username field empty");
        loginPage.enterUsername("");
    }

    @And("The user enters a valid password")
    public void user_enters_valid_password() {
        logger.info("Entering a valid password");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();
    }

    @Then("The user should be navigated to the home page")
    public void user_should_be_navigated_to_home_page() {
    	String homePageLoginMessageString = "Welcome to the Secure Area. When you are done click logout below.";
        logger.info("Verifying the navigation to the home page");
        homePage = new HomePage(driver);
        String welcomeMessage = homePage.getWelcomeMessage();
        logger.info("Welcome message displayed: " + welcomeMessage);
        assertEquals(welcomeMessage, homePageLoginMessageString, "Home page validation failed!");
        logger.info("Successfully navigated to the home page");
        driver.quit();
    }

    @Then("An error message should be displayed")
    public void error_message_should_be_displayed() {
    	String invalidLoginErrorMessage = "Your username is invalid!";
        logger.info("Verifying the error message");
        String errorMessage = loginPage.getErrorMessage().substring(0, 25);
        logger.info("Error message displayed: " + errorMessage);
        assertEquals(errorMessage, invalidLoginErrorMessage, "Error message validation failed!");
        logger.info("Error message validation successful");
        driver.quit();
    }
}
