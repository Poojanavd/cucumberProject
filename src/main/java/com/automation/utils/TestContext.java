package com.automation.utils;

import com.automation.pageObjects.PageObjectManager;

public class TestContext {

	public TestBase base;
	public PageObjectManager objectManager; 
	public TestUtils utils;
	
	public TestContext() {
		base = new TestBase();
		objectManager = new PageObjectManager(base.initializeDriver());
		utils = new TestUtils(base.initializeDriver());
	}
}
