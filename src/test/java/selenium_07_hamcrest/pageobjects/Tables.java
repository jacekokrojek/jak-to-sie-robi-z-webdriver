package selenium_07_hamcrest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class Tables extends Base {

    By duesHeaderLocator = By.cssSelector("#table1 thead tr th:nth-of-type(4)");
    By duesValuesLocator = By.cssSelector("#table1 tbody tr td:nth-of-type(4)");

    public Tables(WebDriver driver) {
        super(driver);
        visit("/tables");
    }

    public void sortDuesAscending() {
        click(duesHeaderLocator);
    }

    public void sortDuesDescending() {
        click(duesHeaderLocator);
        click(duesHeaderLocator);
    }

    public List<Double> getDuesValues() {
        List<WebElement> dues = findAll(duesValuesLocator);
        List<Double> duesValues = new LinkedList<>();
        for (WebElement due : dues) {
            duesValues.add(Double.parseDouble(due.getText().replace("$", "")));
        }
        return duesValues;
    }
}
