package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TablesTest {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.indexOf("win") >= 0) {
			System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver");
		}

		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void withoutHelpfulMarkupDuesAscending() {
		driver.get("http://the-internet.herokuapp.com/tables");
		driver.findElement(By.cssSelector("#table1 thead tr th:nth-of-type(4)")).click();
		List<WebElement> dues = driver.findElements(By.cssSelector("#table1 tbody tr td:nth-of-type(4)"));
		List<Double> dueValues = new LinkedList<Double>();
		for (WebElement element : dues) {
			dueValues.add(Double.parseDouble(element.getText().replace("$", "")));
		}
		for (int counter = 0; counter < dueValues.size() - 1; counter++) {
			assertTrue(dueValues.get(counter) <= dueValues.get(counter + 1));
		}
	}

	@Test
	public void withoutHelpfulMarkupDuesDescending() {
		driver.get("http://the-internet.herokuapp.com/tables");
		driver.findElement(By.cssSelector("#table1 thead tr th:nth-of-type(4)")).click();
		driver.findElement(By.cssSelector("#table1 thead tr th:nth-of-type(4)")).click();
		List<WebElement> dues = driver.findElements(By.cssSelector("#table1 tbody tr td:nth-of-type(4)"));
		List<Double> dueValues = new LinkedList<Double>();
		for (WebElement element : dues) {
			dueValues.add(Double.parseDouble(element.getText().replace("$", "")));
		}
		for (int counter = 0; counter < dueValues.size() - 1; counter++) {
			assertTrue(dueValues.get(counter) >= dueValues.get(counter + 1));
		}
	}

	@Test
	public void withoutHelpfulMarkupEmailAscending() {
		driver.get("http://the-internet.herokuapp.com/tables");
		driver.findElement(By.cssSelector("#table1 thead tr th:nth-of-type(3)")).click();
		List<WebElement> emails = driver.findElements(By.cssSelector("#table1 tbody tr td:nth-of-type(3)"));
		for (int counter = 0; counter < emails.size() - 1; counter++) {
			assertTrue(emails.get(counter).getText().compareTo(emails.get(counter + 1).getText()) < 0);
		}
	}

	@Test
	public void withHelpfulMarkup() {
		driver.get("http://the-internet.herokuapp.com/tables");
		driver.findElement(By.cssSelector("#table2 thead .dues")).click();
		List<WebElement> dues = driver.findElements(By.cssSelector("#table2 tbody .dues"));
		List<Double> dueValues = new LinkedList<Double>();
		for (WebElement element : dues) {
			dueValues.add(Double.parseDouble(element.getText().replace("$", "")));
		}
		for (int counter = 0; counter < dueValues.size() - 1; counter++) {
			assertTrue(dueValues.get(counter) <= dueValues.get(counter + 1));
		}
	}
}