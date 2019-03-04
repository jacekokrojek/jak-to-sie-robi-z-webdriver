package selenium_07_hamcrest.tests;

import org.junit.Before;
import org.junit.Test;
import selenium_07_hamcrest.pageobjects.Tables;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

public class TestTables extends Base {
    private Tables tables;

    @Before
    public void setUp() {
        tables = new Tables(driver);
    }

    @Test
    public void withoutHelpfulMarkupDuesAscending() {
        tables.sortDuesAscending();
        List<Double> duesValues = tables.getDuesValues();
        for (int counter = 0; counter < duesValues.size() - 1; counter++) {
            assertThat(duesValues.get(counter), is(lessThanOrEqualTo(duesValues.get(counter + 1))));
        }
    }

    @Test
    public void withoutHelpfulMarkupDuesDescending() {
        tables.sortDuesDescending();
        List<Double> duesValues = tables.getDuesValues();
        for (int counter = 0; counter < duesValues.size() - 1; counter++) {
            assertThat(duesValues.get(counter), is(greaterThanOrEqualTo(duesValues.get(counter + 1))));
        }
    }
}
