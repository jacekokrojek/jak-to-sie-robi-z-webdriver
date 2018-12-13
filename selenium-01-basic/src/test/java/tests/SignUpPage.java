package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;
    By usernameInput = By.id("usernamesignup");
    By emailInput = By.id("emailsignup");
    By passwordInput = By.id("passwordsignup");
    By passwordConfirmInput = By.id("passwordsignup_confirm");
    By sumitButton = By.cssSelector(".signin a.btn");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void complete(String username, String email, String password, String passwordConfirm) {
        driver.get("http://jacekokrojek.github.io/jak-to-zrobic-w-js/signup.html");
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(passwordConfirmInput).sendKeys(passwordConfirm);
        driver.findElement(sumitButton).click();
    }

//        driver.get("http://jacekokrojek.github.io/jak-to-zrobic-w-js/signup.html");
//        driver.findElement(By.id("usernamesignup")).sendKeys("Jacek");
//        driver.findElement(By.id("emailsignup")).sendKeys("jacek@mail.com");
//        driver.findElement(By.id("passwordsignup")).sendKeys("Jacek");
//        driver.findElement(By.id("passwordsignup_confirm")).sendKeys("Jacek");
//        driver.findElement(By.cssSelector(".signin a.btn")).click();

}
