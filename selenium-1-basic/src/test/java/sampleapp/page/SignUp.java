package sampleapp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SignUp {

    WebDriver driver;

    public SignUp(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded(){
        return driver.getCurrentUrl() == "http://jacekokrojek.github.io/jak-to-zrobic-w-js/signup.html";
    }

}
