package tests;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Login;

public class TestLogin {

    private WebDriver driver;
    private Login login;

    @Before
    public void setUp() {
        String os = System.getProperty("os.name").toLowerCase();
        if(os.indexOf("win") >= 0) {
            System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver");
        }

        driver = new ChromeDriver();
        login = new Login(driver);
    }

    @Test
    public void succeeded() {
        login.with("tomsmith", "SuperSecretPassword!");
        assertTrue("success message not present",
                login.successMessagePresent());
    }

    @Test
    public void failed() {
        login.with("tomsmith", "bad password");
        assertTrue("failure message wasn't present after providing bogus credentials",
                login.failureMessagePresent());
        assertFalse("success message was present after providing bogus credentials",
                login.successMessagePresent());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
