package com.automation.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.utils.TestUtils;

public class TopDealpage extends TestUtils {

	WebDriver driver;

	@FindBy(id = "page-menu")
	private WebElement pageSizeDD;

	@FindBy(xpath = "//tbody//tr")
	private List<WebElement> tableRows;

	public TopDealpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<String> getPageSizeDropdownValues() {
		return retriveStaticDropdownValues(pageSizeDD);
	}

	public void selectPageSizeFromDropdown(String pageSize) {
		selectElementByValue(pageSizeDD, pageSize);
	}

	public int giveCountOfProductsPresentInTable() {
		return tableRows.size();
	}

}
