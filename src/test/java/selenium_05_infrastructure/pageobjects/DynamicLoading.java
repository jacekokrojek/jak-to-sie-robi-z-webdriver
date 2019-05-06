package selenium_05_infrastructure.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium_04_waits.pageobjects.Base;

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