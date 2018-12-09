package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class JavaScriptAlertTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "etc/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void JavaScriptAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector(".example li:nth-child(2) button")).click();
        Alert popup = driver.switchTo().alert();
        popup.accept();
        String result = driver.findElement(By.id("result")).getText();
        assertThat(result, is(equalTo("You clicked: Ok")));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}