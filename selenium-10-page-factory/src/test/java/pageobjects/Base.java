package pageobjects;

import java.util.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbtqa.tag.pagefactory.PageFactory;

import static tests.Config.*;

public class Base {

    private WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visit(String url) {
       if (url.contains("http"))  {
           driver.get(url);
       } else {
           driver.get(baseUrl + url);
       }
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(String inputText, WebElement element) {
        element.sendKeys(inputText);
    }

    public Boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public Boolean isDisplayed(WebElement element, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException exception) {
            return false;
        }
        return true;
    }

}
