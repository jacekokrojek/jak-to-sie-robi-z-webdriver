package selenium_08_page_factory.tests;

import org.junit.Before;
import org.junit.Test;
import selenium_08_page_factory.pageobjects.DynamicLoading;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TestDynamicLoading extends Base {

    private DynamicLoading dynamicLoading;

    @Before
    public void setUp() {
        dynamicLoading = new DynamicLoading(driver);
    }

    @Test
    public void hiddenElementLoads() {
        dynamicLoading.loadExample("1");
        assertThat(dynamicLoading.finishTextPresent(), equalTo(true));
    }

    @Test
    public void elementAppears() {
        dynamicLoading.loadExample("2");
        assertThat(dynamicLoading.finishTextPresent(), equalTo(true));
    }

}
