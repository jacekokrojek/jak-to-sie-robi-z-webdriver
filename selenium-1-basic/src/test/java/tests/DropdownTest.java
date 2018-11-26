package tests;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DropdownTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        String os = System.getProperty("os.name").toLowerCase();
        if(os.indexOf("win") >= 0) {
            System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver");
        }

        driver = new ChromeDriver();
    }

    @Test
    public void dropdownTest() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdownList = driver.findElement(By.id("dropdown"));
        List<WebElement> options = dropdownList.findElements(By.tagName("option"));
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equals("Option 1")) {
                options.get(i).click();
            }
        }
        String selectedOption = "";
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).isSelected()) {
                selectedOption = options.get(i).getText();
            }
        }
        assertThat(selectedOption, is("Option 1"));
    }

    @Test
    public void dropdownTestRedux() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select selectList = new Select(driver.findElement(By.id("dropdown")));
        selectList.selectByVisibleText("Option 1");
        assertThat(selectList.getFirstSelectedOption().getText(), is(equalTo("Option 1"
        )));
    }

    @Test
    public void test() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        assertThat(dropdown.getOptions().get(0).isEnabled(), is(false));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}