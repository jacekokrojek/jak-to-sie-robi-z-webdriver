package selenium_08_page_factory.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

public class Tables extends Base {

    @FindBy(css = "#table1 thead tr th:nth-of-type(4)")
    private WebElement duesHeader;

    @FindBy(css = "#table1 tbody tr td:nth-of-type(4)")
    private List<WebElement> dues;

    public Tables(WebDriver driver) {
        super(driver);
        visit("/tables");
    }

    public void sortDuesAscending() {
        click(duesHeader);
    }

    public void sortDuesDescending() {
        click(duesHeader);
        click(duesHeader);
    }

    public List<Double> getDuesValues() {
        List<Double> duesValues = new LinkedList<>();
        for (WebElement due : dues) {
            duesValues.add(Double.parseDouble(due.getText().replace("$", "")));
        }
        return duesValues;
    }
}
