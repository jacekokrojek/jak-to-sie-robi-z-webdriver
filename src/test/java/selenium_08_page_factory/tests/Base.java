package selenium_08_page_factory.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

    protected WebDriver driver;

    @Rule
    public ExternalResource resource = new ExternalResource() {

        @Override
        protected void before() throws Throwable {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        @Override
        protected void after() {
            driver.quit();
        }

    };

}
