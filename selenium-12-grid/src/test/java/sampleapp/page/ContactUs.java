package sampleapp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUs extends Base{

    WebDriver driver;

    By nameInput = By.id("name");
    By emailInput = By.id("email");
    By contentInput = By.id("content");
    By submitButton = By.cssSelector("button.btn");
    By confirmationMessage = By.cssSelector("span.message > h3");

    public ContactUs(WebDriver driver) {
        super(driver);
        visit("http://jacekokrojek.github.io/jak-to-zrobic-w-js/contact.html");
    }

    public String getConfirmation() {
        isDisplayed(confirmationMessage, 10000);
        return find(confirmationMessage).getText();
    }

    public void sendMessage(String name, String email, String content) {
        type(name, nameInput);
        type(email, emailInput);
        type(content, contentInput);
        click(submitButton);
    }

}
