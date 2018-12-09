package sampleapp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Menu extends Base {

    public Menu(WebDriver driver) {
        super(driver);
    }

    public void select(String text) {
        click(By.linkText(text));
    }

}
