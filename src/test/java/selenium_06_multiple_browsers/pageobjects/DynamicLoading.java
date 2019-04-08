package selenium_06_multiple_browsers.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoading extends Base {

    By startButton = By.cssSelector("#start button");
    By finishText  = By.id("finish");

    public DynamicLoading(WebDriver driver) {
        super(driver);
    }

    public void loadExample(String exampleNumber) {
        visit("http://the-internet.herokuapp.com/dynamic_loading/" + exampleNumber);
        click(startButton);
    }

    public Boolean isFinishTextDisplayed() {
        return isDisplayed(find(finishText), 10);
    }

    public Boolean isFinishTextTextPresent() {
        return isPresent(finishText, 10);
    }

}