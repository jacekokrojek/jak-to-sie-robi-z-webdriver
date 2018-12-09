package tests;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--no-sandbox");
        driver = new RemoteWebDriver(new URL("http://192.168.30.1:4444/wd/hub"), options);
    }

    @Test
    public void whenLoggedInWithCorrectCredentials_thenSuccessVisible() {
        driver.get("http://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button")).click();
        WebElement message = driver.findElement(By.cssSelector(".flash.success"));
        assertTrue( message.isDisplayed() );
        assertTrue( message.getText().contains("You logged into a secure area!") );
    }

    /**
     * Fill the content of the test below
     */
    @Test
    public void whenLoggedInWithIncorrectCredentials_thenInvalidPasswordVisible() {
    }

    /**
     * Additional tasks and questions
     *  - How this code could be optimized
     *  - Closing driver after each test
     */

    @After
    public void tearDown() {
        driver.quit();
    }
}