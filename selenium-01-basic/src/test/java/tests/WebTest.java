package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WebTest {
    private WebDriver driver;
    HomePage homePage;
    ServicesPage servicesPage;
    BlogPage blogPage;
    ContactPage contactPage;
    SignUpPage signUpPage;

    @Before
    public void setUp() {

        String os = System.getProperty("os.name").toLowerCase();
        if(os.indexOf("win") >= 0) {
            System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver");
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        servicesPage = new ServicesPage(driver);
        blogPage = new BlogPage(driver);
        contactPage = new ContactPage(driver);
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void shouldHaveCorrectBannerHeader(){
        assertEquals( "Example Headline 1", homePage.getActiveBannerHeader() );
    }

//    @Test
//    public void shouldHaveCorrectBannerHeader(){
//        driver.get("http://jacekokrojek.github.io/jak-to-zrobic-w-js/index.html");
//        // WebElement bannerHeader = driver.findElement(By.cssSelector("div.active.item h1"));
//        WebElement banner = driver.findElement(By.cssSelector("div.active.item"));
//        WebElement bannerHeader = banner.findElement(By.cssSelector("h1"));
//        assertEquals( "Example Headline 1", bannerHeader.getText() );
//    }

    @Test
    public void shouldHaveCorrectFeatureHeaders(){
        driver.get("http://jacekokrojek.github.io/jak-to-zrobic-w-js/index.html");
        List<WebElement> featureHeaders = driver.findElements(By.cssSelector("h2"));
        WebElement el = featureHeaders.get(0);
        assertEquals("Feature A", el.getText() );
        //assertEquals("Feature A", featureHeaders.get(0).getText() );
        assertEquals("Feature B", featureHeaders.get(1).getText() );
        assertEquals("Feature C", featureHeaders.get(2).getText() );
    }

    @Test
    public void shouldNavigateToServices(){
        homePage.goToServices();
        assertTrue(servicesPage.getTitle().contains("Services"));
    }

    @Test
    public void shouldNavigateToBlog(){
        homePage.goToBlog();
        assertTrue(blogPage.getTitle().contains("Blog"));
    }

    @Test
    public void shouldNavigateToContact(){
        homePage.goToContact();
        assertTrue(contactPage.getTitle().contains("Contact"));
    }

    @Test
    public void shouldRegister(){
        signUpPage.complete("Jacek", "jacek@mail.com", "1234", "1234");
        assertEquals("Thank you for registration", driver.findElement(By.cssSelector("h2")).getText());
    }
//    @Test
//    public void shouldRegister(){
//
//        driver.get("http://jacekokrojek.github.io/jak-to-zrobic-w-js/signup.html");
//        driver.findElement(By.id("usernamesignup")).sendKeys("Jacek");
//        driver.findElement(By.id("emailsignup")).sendKeys("jacek@mail.com");
//        driver.findElement(By.id("passwordsignup")).sendKeys("Jacek");
//        driver.findElement(By.id("passwordsignup_confirm")).sendKeys("Jacek");
//        driver.findElement(By.cssSelector(".signin a.btn")).click();
//        assertEquals("Thank you for registration", driver.findElement(By.cssSelector("h2")).getText());
//    }



    @After
    public void tearDown() {
        driver.quit();
    }

}