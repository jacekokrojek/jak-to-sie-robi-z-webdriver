package sampleapp.test;

import org.junit.*;
import sampleapp.page.Home;
import sampleapp.page.SignUp;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomeTest extends Base{

    private Home home;
    private SignUp signUp;

    @Before
    public void setUp() {
        home = new Home(driver);
        signUp = new SignUp(driver);
    }

    @Test
    public void whenVisited_thenShouldHaveCorrectTitle() {
        home.getTitle();
        assertEquals("Protractor workshop | Home", home.getTitle());
    }

    @Test
    public void whenVisited_thenShouldHaveCorrectHeader() {
        assertEquals( "Example Headline 1", home.getHeader());
    }

    @Test
    public void whenVisited_thenShouldHaveCorrectFeatureSections() {
        List<String> expectedFeatures = Arrays.asList("Feature A", "Feature B", "Feature C");
        assertEquals( expectedFeatures, home.getFeatures() );
    }

    @Test
    public void whenVisited_thenShouldHaveSignUpLink() {
        home.signUp();
        assertTrue( signUp.isLoaded());
    }

}