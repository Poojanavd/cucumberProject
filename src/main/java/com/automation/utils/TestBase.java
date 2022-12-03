package com.automation.utils;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	WebDriver driver;
	private Scenario scenario;
	
	PropertyFileReader prop;

	public WebDriver initializeDriver() {
		prop = new PropertyFileReader();
		String browser = prop.getBrowser().toLowerCase();
		String browserVersion = prop.getBrowserVersion();
		String url = prop.getURL();
		
		if (driver == null) {
			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().browserVersion(browserVersion).setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				Assert.fail("Incorrect browser selected : " + browser);
			}
		}

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	public void tearDown() {
		driver.quit();
	}

	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

}
