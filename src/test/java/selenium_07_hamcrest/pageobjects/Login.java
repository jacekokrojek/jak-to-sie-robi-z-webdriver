package selenium_07_hamcrest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class Login extends Base {

    By loginFormLocator = By.id("login");
    By usernameLocator  = By.id("username");
    By passwordLocator  = By.id("password");
    By submitButton     = By.cssSelector("button");
    By successMessageLocator = By.cssSelector(".flash.success");
    By failureMessageLocator = By.cssSelector(".flash.error");

    public Login(WebDriver driver) {
        super(driver);
        visit("/login");
        assertThat(isDisplayed(loginFormLocator), equalTo(true));
    }

    public void with(String username, String password) {
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(submitButton);
    }

    public Boolean successMessagePresent() {
        isDisplayed(find(successMessageLocator), 1);
        return isDisplayed(successMessageLocator);
    }

    public Boolean failureMessagePresent() {
        isDisplayed(find(failureMessageLocator), 1);
        return isDisplayed(failureMessageLocator);
    }
}
