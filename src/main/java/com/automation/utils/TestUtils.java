package com.automation.utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.hc.core5.http.impl.nio.ExpandableBuffer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {

	public WebDriver driver;

	public TestUtils(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitleOfWebPage() {
		return driver.getTitle();
	}

	public String getURLOfCurrentWebPage() {
		return driver.getCurrentUrl();
	}

	public void clickElement(WebElement ele) {
		ele.click();
	}

	public void switchToWindow() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parentWindow = itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
	}

	public List<String> retriveStaticDropdownValues(WebElement ele) {
		Select select = new Select(ele);
		return select.getOptions().stream().map(options -> options.getText()).collect(Collectors.toList());
	}

	public void selectElementByValue(WebElement ele, String textToSelect) {
		Select select = new Select(ele);
		select.selectByValue(textToSelect);
	}

	public HashMap<String, Integer> verifyBrokenImages(List<WebElement> ele) {
		HashMap<String, Integer> codes = new HashMap<String, Integer>();
		int code = 0;
		int links = ele.size();
		for (int i = 0; i < links; i++) {
			String url = ele.get(i).getAttribute("src");
			code = verifyURL(url);
			if (code != 200) {
				codes.put(url, code);
			}
		}
		return codes;
	}

	private int verifyURL(String url) {
		int code = 0;
		URL link;
		HttpURLConnection conn = null;
		try {
			link = new URL(url);
			conn = (HttpURLConnection) link.openConnection();
			conn.setConnectTimeout(2000);
			conn.connect();
			code = conn.getResponseCode();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			conn.disconnect();
		}
		return code;
	}
	
	public void sendText(WebElement ele,String textToEnter) {
		ele.sendKeys(textToEnter);
	}
	
	public void waitTillElementIsVisible(WebElement ele,int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public String getTextOfWebElement(WebElement ele) {
		return ele.getText();
	}
}
