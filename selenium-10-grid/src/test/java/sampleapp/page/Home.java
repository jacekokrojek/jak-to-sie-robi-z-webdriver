package sampleapp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Home extends Base{

    By headerLocator = By.xpath("(//h1)[1]");
    By featuresLocator = By.xpath("//h2");
    By signUpButtonLocator = By.linkText("Sign up today");

    public Home(WebDriver driver) {
        super(driver);
        visit("http://jacekokrojek.github.io/jak-to-zrobic-w-js/index.html");
    }

    public String getTitle(){
        String title = driver.getTitle();
        return driver.getTitle();
    }

    public String getHeader() {
        return find(headerLocator).getText();
    }

    public List<String> getFeatures() {
        List<WebElement> features = driver.findElements(featuresLocator);
        List<String> currentFeatureText = new ArrayList<>();
        for (WebElement el : features) {
            currentFeatureText.add(el.getText());
        }
        return currentFeatureText;
    }

    public void signUp(){
        click(signUpButtonLocator);
    }

}
