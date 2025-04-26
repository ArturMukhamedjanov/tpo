package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestContext {
    private WebDriver driver;
    private WebDriverWait wait;

    public TestContext(String browser) {
        this.driver = WebDriverFactory.createDriver(browser);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}