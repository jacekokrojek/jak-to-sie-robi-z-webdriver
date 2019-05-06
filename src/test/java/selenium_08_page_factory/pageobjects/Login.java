package selenium_08_page_factory.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class Login extends Base {

    @FindBy(id = "login")
    private WebElement loginFormLocator;

    @FindBy(id = "username")
    private WebElement usernameLocator;

    @FindBy(id = "password")
    private WebElement passwordLocator;

    @FindBy(css = "button")
    private WebElement submitButton;

    @FindBy(css = ".flash.success")
    private WebElement successMessageLocator;

    @FindBy(css = ".flash.error")
    private WebElement failureMessageLocator;

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
        isDisplayed(successMessageLocator, 1);
        return isDisplayed(successMessageLocator);
    }

    public Boolean failureMessagePresent() {
        isDisplayed(failureMessageLocator, 1);
        return isDisplayed(failureMessageLocator);
    }
}
