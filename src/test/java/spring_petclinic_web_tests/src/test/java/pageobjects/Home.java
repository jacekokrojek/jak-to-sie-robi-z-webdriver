package spring_petclinic_web_tests.src.test.java.pageobjects;

import org.openqa.selenium.WebDriver;


public class Home extends Base {

    public Home(WebDriver driver) {
        super(driver);
        visit("/");
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
