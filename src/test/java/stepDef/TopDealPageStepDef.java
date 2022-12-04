package stepDef;

import java.util.List;

import org.testng.Assert;

import com.automation.pageObjects.TopDealpage;
import com.automation.utils.TestContext;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TopDealPageStepDef {

	TestContext testContext;
	List<String> expectedPageSizeValues;
	List<String> actualPageSizeValues;
	TopDealpage topDealpage;

	public TopDealPageStepDef(TestContext testContext) {
		this.testContext = testContext;
		topDealpage = testContext.objectManager.getTopDealpage();
	}

	@When("user clicks on Page size dropdown")
	public void user_clicks_on_page_size_dropdown() {
		actualPageSizeValues = topDealpage.getPageSizeDropdownValues();
	}

	@Then("he is able to see options")
	public void he_is_able_to_see_options(io.cucumber.datatable.DataTable dataTable) {
		expectedPageSizeValues = dataTable.asList();
		Assert.assertEquals(actualPageSizeValues, expectedPageSizeValues);
	}

	@When("user selects {string} from dropdown")
	public void user_selects_from_dropdown(String pageSize) {
		topDealpage.selectPageSizeFromDropdown(pageSize);
	}

	@Then("verify user is able to see equal to or less than {string} products in the table")
	public void verify_user_is_able_to_see_equal_to_or_less_than_products_in_the_table(String pageSize) {
		int actualCount = topDealpage.giveCountOfProductsPresentInTable();
		int expectedCount = Integer.parseInt(pageSize);
		Assert.assertTrue(actualCount <= expectedCount);
	}
}
