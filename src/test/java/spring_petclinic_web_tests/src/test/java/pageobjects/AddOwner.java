package spring_petclinic_web_tests.src.test.java.pageobjects;

import org.openqa.selenium.WebDriver;

public class AddOwner extends Base {

//    By firstNameInput = By.id("firstName");
//    By lastNameInput = By.id("lastName");
//    By addressInput = By.id("address");
//    By cityInput = By.id("city");
//    By telephoneInput = By.id("telephone");
//    By addOwnerButton = By.cssSelector("button.btn");

    public AddOwner(WebDriver driver) {
        super(driver);
        pageUrl = "/owners/new";
    }

//    public void details(String firstName, String lastName, String address, String city, String telephone) {
//        type(firstName, firstNameInput);
//        type(lastName, lastNameInput);
//        type(address, addressInput);
//        type(city, cityInput);
//        type(telephone, telephoneInput);
//        click(addOwnerButton);
//    }

}
