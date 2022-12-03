package stepDef;

import org.testng.Assert;

import com.automation.pageObjects.LandingPage;
import com.automation.utils.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

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
}
