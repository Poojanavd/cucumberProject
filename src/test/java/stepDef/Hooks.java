package stepDef;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automation.utils.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	TestContext testContext;

	public Hooks(TestContext testContext) {
		this.testContext = testContext;
	}

	@Before
	public void setup(Scenario scenario) {
		testContext.base.initializeDriver();
		testContext.base.setScenario(scenario);
	}

	@After
	public void tearDown() {
		testContext.base.tearDown();

	}

	@AfterStep
	public void isScenarioFailed(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] failedImage = ((TakesScreenshot) testContext.objectManager.driver).getScreenshotAs(OutputType.BYTES);
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd_MMM_yyyy_HH_mm_ss");
			scenario.attach(failedImage, "image/png", scenario.getName() + "_" + LocalDateTime.now().format(format));
		}
	}
}
