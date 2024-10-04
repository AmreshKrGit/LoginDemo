package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage {
    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(HomePage.class);

    @FindBy(xpath = "//h4[contains(text(),'Welcome to the Secure Area. When you are done click logout below.')]")
    WebElement welcomeMessage;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getWelcomeMessage() {
        logger.info("Getting welcome message: " + welcomeMessage.getText());
        return welcomeMessage.getText();
    }
}
