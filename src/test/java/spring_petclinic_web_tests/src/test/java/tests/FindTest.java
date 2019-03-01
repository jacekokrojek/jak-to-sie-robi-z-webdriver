package spring_petclinic_web_tests.src.test.java.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import spring_petclinic_web_tests.src.test.java.providers.OwnerProvider;
import spring_petclinic_web_tests.src.test.java.pageobjects.*;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FindTest extends Base {

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
        findOwners.navigateTo();
    }

    @Ignore
    @Test
    public void whenSearchWithEmptyCriteria_thenAllOwnersShouldBeVisible() throws InterruptedException {
        findOwners.byLastName("");
        assertEquals("Incorrect number of owners",
                10, owners.listOfNames().size());
    }

    @Ignore
    @Test
    public void whenSearchWithExistingLastnames_thenMatchingOwnersShouldBeVisible() throws InterruptedException, IOException {
        OwnerProvider.prepareForTest();
        String phrase = "Dav";
        findOwners.byLastName(phrase);
        List<String> ownerNames = owners.listOfNames();
        assertEquals("Incorrect number of owners",
                2, ownerNames.size());
        for (int i = 0; i < ownerNames.size(); i++) {
            assertTrue(ownerNames.get(i).contains(phrase));
        }
    }

    @Ignore
    @Test
    public void whenSearchWithExistingLastname_thenMatchingOwnerDetailsShouldBeVisible() throws InterruptedException {
        String phrase = "Franklin";
        findOwners.byLastName(phrase);
        assertTrue(owner.getOwnerName().contains(phrase));
    }

}
