package apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private Properties prop;
	private ConfigReader configReader;

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		driverFactory = new DriverFactory();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserType = prop.getProperty("browser");
		driverFactory.init_driver(browserType);
		driver = DriverFactory.getDriver();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String fileName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", fileName);
		}
	}

	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
}
