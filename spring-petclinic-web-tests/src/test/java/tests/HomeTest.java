package tests;

import pageobjects.Home;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class HomeTest extends Base {

    private Home home;

    @Before
    public void setUp() {
        home = new Home(driver);
    }

    @Test
    public void whenVisited_thenShouldHaveCorrectTitle() throws IOException {
        assertTrue(imagesEqual(takeScreenshot(),"./images/homepage.png"));
    }

}
