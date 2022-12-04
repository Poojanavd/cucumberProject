package com.automation.pageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.utils.TestContext;
import com.automation.utils.TestUtils;

public class LandingPage extends TestUtils {

	WebDriver driver;

	@FindBy(xpath = "//a[text()='Top Deals']")
	private WebElement topDealLink;

	@FindBy(css = ".product-image img")
	private List<WebElement> productImg;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getLandingPageTitle() {
		return getTitleOfWebPage();
	}

	public void switchToTopDealsPage() {
		clickElement(topDealLink);
		switchToWindow();
		Assert.assertEquals(getURLOfCurrentWebPage(), "https://rahulshettyacademy.com/seleniumPractise/#/offers");
	}

	public void verifyImagesLinksAreNotBrokenOnHomepage(TestContext testContext) {
		HashMap<String, Integer> links = verifyBrokenImages(productImg);
		if (links.size() != 0) {
			for (Entry<String, Integer> link : links.entrySet()) {
				testContext.base.getScenario()
						.log("Broken URL : " + link.getKey() + " -- " + "Response code :" + link.getValue());
			}
			Assert.fail();
		}
	}

}
