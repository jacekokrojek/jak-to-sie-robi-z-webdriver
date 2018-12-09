package sampleapp.test;

import org.junit.Before;
import org.junit.Test;
import sampleapp.page.ContactUs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContactUsTest extends Base{

    private ContactUs contactUs;

    @Before
    public void setUp() {
        contactUs = new ContactUs(driver);
    }

    @Test
    public void whenMessageSend_thenConfirmationVisible() {
        contactUs.sendMessage("Jacek", "jacek@gmail.com", "Content");
        assertEquals("Your message has been sent.", contactUs.getConfirmation());
    }

}