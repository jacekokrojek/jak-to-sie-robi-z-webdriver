package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {

    WebDriver driver;
    By title = By.cssSelector(".page-header h1");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle(){
        return driver.findElement(title).getText();
    }

}
