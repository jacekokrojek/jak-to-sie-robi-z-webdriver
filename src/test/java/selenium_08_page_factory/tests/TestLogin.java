package selenium_08_page_factory.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import selenium_08_page_factory.pageobjects.Login;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TestLogin extends Base {

    private Login login;

    @Before
    public void setUp() {
        login = new Login(driver);
    }

    @Test
    public void succeeded() {
        login.with("tomsmith", "SuperSecretPassword!");
        assertThat(login.successMessagePresent(), equalTo(true));
    }

    @Test @Ignore
    public void failed() {
        login.with("tomsmith", "bad password");
        assertThat(login.failureMessagePresent(), equalTo(true));
        assertThat(login.successMessagePresent(), equalTo(false));
    }

}
