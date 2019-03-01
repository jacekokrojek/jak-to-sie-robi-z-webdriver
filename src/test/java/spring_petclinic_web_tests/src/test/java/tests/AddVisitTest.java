package spring_petclinic_web_tests.src.test.java.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import spring_petclinic_web_tests.src.test.java.pageobjects.*;

public class AddVisitTest extends Base {

    private FindOwners findOwners;
    private Owners owners;
    private Owner owner;
    private AddOwner addOwner;
    private AddVisit addVisit;

    @Before
    public void setUp() {
        findOwners = new FindOwners(driver);
        owners = new Owners(driver);
        owner = new Owner(driver);
        addOwner = new AddOwner(driver);
        addVisit = new AddVisit(driver);
        findOwners.navigateTo();
    }

    @Ignore
    @Test
    public void whenAddVisit_thenShouldBeVisible() throws InterruptedException {
    }

}
