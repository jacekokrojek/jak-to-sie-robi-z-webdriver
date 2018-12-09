package tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import pageobjects.Tables;

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
