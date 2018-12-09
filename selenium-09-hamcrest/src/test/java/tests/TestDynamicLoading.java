package tests;

import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import pageobjects.DynamicLoading;

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
