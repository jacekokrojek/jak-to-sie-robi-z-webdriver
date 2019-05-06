package spring_petclinic_web_tests.src.test.java.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindOwners extends Base {

    By lastNameInput = null;
    By findOwnerButton = null;
    By addOwnerLink = null;

    public FindOwners(WebDriver driver) {
        super(driver);
        pageUrl = "/owners/find";
    }

    public void byLastName(String lastName) {
        type(lastName, lastNameInput);
        click(findOwnerButton);
    }

    public void addOwner() {
        click(addOwnerLink);
    }
}
