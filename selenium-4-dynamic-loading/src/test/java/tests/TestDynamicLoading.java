package tests;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.DynamicLoading;

public class TestDynamicLoading {

    private WebDriver driver;
    private DynamicLoading dynamicLoading;

    @Before
    public void setUp() {
        String os = System.getProperty("os.name").toLowerCase();
        if(os.indexOf("win") >= 0) {
            System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver");
        }

        driver = new ChromeDriver();
        dynamicLoading = new DynamicLoading(driver);
    }

    @Test
    public void hiddenElementLoads() {
        dynamicLoading.loadExample("1");
        assertTrue("finish text didn't display after loading",
                dynamicLoading.finishTextPresent());
    }

    @Test
    public void elementAppears() {
        dynamicLoading.loadExample("2");
        assertTrue("finish text didn't render after loading",
                dynamicLoading.finishTextPresent());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
