package spring_petclinic_web_tests.src.test.java.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import spring_petclinic_web_tests.src.test.java.pageobjects.Home;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class HomeTest extends Base {

    private Home home;

    @Before
    public void setUp() {
        home = new Home(driver);
    }

    @Ignore
    @Test
    public void whenVisited_thenShouldHaveCorrectTitle() throws IOException {
        assertTrue(imagesEqual(takeScreenshot(),"./images/homepage.png"));
    }

}
