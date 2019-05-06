package selenium_10_image_comparison.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkboxes extends Base {
    public Checkboxes(WebDriver driver) {
        super(driver);
        visit("/checkboxes");
    }

    @FindBy(css = "input[type=\"checkbox\"]:nth-of-type(1)")
    private WebElement firstCheckBox;

    @FindBy(css = "input[type=\"checkbox\"]:nth-of-type(2)")
    private WebElement secondCheckbox;

    public void clickFirstCheckbox() {
        click(firstCheckBox);
    }

    public void clickSecondCheckbox() {
        click(secondCheckbox);
    }
}
