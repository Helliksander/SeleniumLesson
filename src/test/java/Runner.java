import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Runner {

    WebDriver driver;
    String baseUrl;
    public String browserName = System.getProperty("browser");

    @Before
    public void setUp() throws Exception {
        driver = getDriver();
        baseUrl = "https://www.tinkoff.ru/career/vacancies/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private WebDriver getDriver() {
        try {
            BrowserChoice.valueOf(System.getProperty("browser"));
        } catch (NullPointerException e) {
            browserName = randomBrowserPicker();
            System.setProperty("browser", browserName);

        }
        return BrowserChoice.valueOf(browserName).create();
    }

    private String randomBrowserPicker() {
        System.out.println("\nThe driver is not set. Running a random browser...\"");
        int pick = new Random().nextInt(BrowserChoice.values().length);
        return BrowserChoice.values()[pick].toString();

    }


}
