package stepDef;

import java.util.List;

import org.testng.Assert;

import com.automation.pageObjects.LandingPage;
import com.automation.utils.TestContext;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LandingPageStepDef {

	TestContext testContext;
	LandingPage landingPage;

	public LandingPageStepDef(TestContext testContext) {
		this.testContext = testContext;
	}

	@Given("user is on Greenkart landing page")
	public void user_is_on_greenkart_landing_page() {
		Assert.assertEquals(testContext.objectManager.getLandingPage().getLandingPageTitle(),
				"GreenKart - veg and fruits kart");
	}

	@Given("Navigated to Top deals page")
	public void navigated_to_top_deals_page() {
		testContext.objectManager.getLandingPage().switchToTopDealsPage();
	}

	@Then("product images are not broken")
	public void product_images_are_not_broken() {
		testContext.objectManager.getLandingPage().verifyImagesLinksAreNotBrokenOnHomepage(testContext);
	}

	@When("^user enter (.+) in the search bar$")
	public void user_enter_product_name_in_the_search_bar(String product){
		testContext.objectManager.getLandingPage().enterProductInSearchBar(product);
	}

	@Then("^(.+) is displayed in the search result$")
	public void product_is_displayed_in_the_search_result(String expectedProductName) throws InterruptedException {
		String actualProductName = testContext.objectManager.getLandingPage().retriveProductNameWhenSearched();
		Assert.assertEquals(actualProductName, expectedProductName);
	}
}
