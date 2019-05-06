package spring_petclinic_web_tests.src.test.java.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Owners extends Base {

    By ownerName = null;

    public Owners(WebDriver driver) {
        super(driver);
    }

    public List<String> listOfNames() throws InterruptedException {
        List<WebElement> owners = driver.findElements(ownerName);
        List<String> ownerNames = new ArrayList<>();
        for (WebElement owner : owners) {
            ownerNames.add(owner.getText());
            //ownerNames.add(getText(owner));
        }
        return ownerNames;
    }

    public void selectOwner(int index){
        List<WebElement> owners = driver.findElements(ownerName);
        owners.get(index).click();
    }

}
