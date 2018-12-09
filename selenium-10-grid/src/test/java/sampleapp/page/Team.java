package sampleapp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Team {

    WebDriver driver;

    String url = "http://jacekokrojek.github.io/jak-to-zrobic-w-js/about.html";

    By teamMemberDetailLocator = By.cssSelector("li.span4");
    By nameLocator = By.cssSelector("strong");
    By positionLocator = By.cssSelector("i");

    public Team(WebDriver driver) {
        this.driver = driver;
    }

    public void visit(){
        driver.get(url);
    }

    public boolean isLoaded(){
        return driver.getCurrentUrl() == url;
    }

    public String getMemberDetails(int idx){
        WebElement teamMemberDetail = driver.findElements(teamMemberDetailLocator).get(idx);
        String name = teamMemberDetail.findElement(nameLocator).getText();
        String position = teamMemberDetail.findElement(positionLocator).getText();
        return name + "/" + position;
    }

}
