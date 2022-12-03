package com.automation.pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public WebDriver driver;
	public TopDealpage topDealpage;
	public LandingPage landingPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public TopDealpage getTopDealpage() {
		if (topDealpage == null) {
			topDealpage = new TopDealpage(driver);
		}
		return topDealpage;
	}

	public LandingPage getLandingPage() {
		if (landingPage == null) {
			landingPage = new LandingPage(driver);
		}
		return landingPage;
	}
}
