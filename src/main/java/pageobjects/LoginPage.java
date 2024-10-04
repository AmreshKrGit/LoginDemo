package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@id='flash']")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String uname) {
        logger.info("Entering username: " + uname);
        username.sendKeys(uname);
    }

    public void enterPassword(String pwd) {
        logger.info("Entering password");
        password.sendKeys(pwd);
    }

    public void clickLogin() {
        logger.info("Clicking the login button");
        loginButton.click();
    }

    public String getErrorMessage() {
        logger.info("Getting error message: " + errorMessage.getText());
        return errorMessage.getText();
    }
}
