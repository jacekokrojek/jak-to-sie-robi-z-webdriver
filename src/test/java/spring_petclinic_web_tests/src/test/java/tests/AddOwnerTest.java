package spring_petclinic_web_tests.src.test.java.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import spring_petclinic_web_tests.src.test.java.pageobjects.*;

public class AddOwnerTest extends Base {

    private FindOwners findOwners;
    private Owners owners;
    private Owner owner;
    private AddOwner addOwner;
    private AddVisit addVisit;

    @Before
    public void setUp() {
        findOwners = new FindOwners(driver);
        addOwner = new AddOwner(driver);
        findOwners.navigateTo();
    }

    @Ignore
    @Test
    public void whenAddOwner_thenShouldBeVisible() throws InterruptedException {
    }

}
