import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public enum  BrowserChoice {

    chrome {
        public WebDriver create() {
            updateProperty("chrome");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
//            options.addArguments("--headless");
            return new ChromeDriver(options);
        }
    },
    firefox {
        public WebDriver create() {
            updateProperty("firefox");
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "./src/test/java/log");

            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("dom.webnotifications.enabled", false);
            return new FirefoxDriver();
        }
    };

    public WebDriver create() {
        return null;
    }

    void updateProperty(String browserName) {
        System.out.println("\n starting %s-browser ....." + browserName);
        if (System.getProperty("browser") == null) System.setProperty("browser", browserName);
    }
}
