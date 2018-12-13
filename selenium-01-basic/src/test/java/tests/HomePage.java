package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    By bannerHeader = By.cssSelector("div.active.item h1");
    By servicesLink = By.linkText("Services");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://jacekokrojek.github.io/jak-to-zrobic-w-js/index.html");
    }

    public String getActiveBannerHeader(){
        return driver.findElement(bannerHeader).getText();
    }

    public void goToServices(){
        driver.findElement(servicesLink).click();
    }
}
