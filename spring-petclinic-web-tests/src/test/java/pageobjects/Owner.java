package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Owner extends Base {

    By ownerName = null;
    By addVisitLink = null;
    By topDescription = null;

    public Owner(WebDriver driver) {
        super(driver);
    }

    public String getOwnerName () {
        return find(ownerName).getText();
    }

    public void addVisit(){
        click(addVisitLink);
    }

    public String getTopDescription(){
        return find(topDescription).getText();
    }

}
