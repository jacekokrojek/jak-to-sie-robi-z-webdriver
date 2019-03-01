package selenium_01_basics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class HoverTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        String os = System.getProperty("os.name").toLowerCase();
        if(os.indexOf("win") >= 0) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        }

        driver = new ChromeDriver();
    }

    @Test
    public void hoversTest() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        WebElement avatar = driver.findElement(By.className("figure"));
        Actions builder = new Actions(driver);
        builder.moveToElement(avatar).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(
                "figcaption")));
        assertEquals(
                Boolean.TRUE,
                driver.findElement(By.className("figcaption")).isDisplayed()
        );
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
