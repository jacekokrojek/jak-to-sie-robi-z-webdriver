package selenium_09_grid.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

@Ignore
public class LoginTest {
    private WebDriver driver;

    /**
     * Before running the test, set up the Selenium Grid.
     * 1. Download Selenium Standalone Server from: https://www.seleniumhq.org/download/
     * 2. Follow the instructions provided here: https://github.com/SeleniumHQ/selenium/wiki/Grid2
     * 3. IMPORTANT: When setting up the node, you need to set the driver path in the CMD line:
     * java -Dwebdriver.chrome.driver="<FULL_path_to_your_driver>" -jar selenium-server-standalone-<your_version>.jar -role node -hub http://<ip_of_host_machine>:4444/grid/register
     * @throws MalformedURLException
     */

    @Before
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--no-sandbox");
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
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