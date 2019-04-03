import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class TestingDzSecond extends Runner {
    @Test
    public void testCase1() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://www.google.ru/");
        driver.findElement(By.xpath("//input[contains(@class, 'gLFyf gsfi')]")).click();
        driver.findElement(By.xpath("//input[contains(@class, 'gLFyf gsfi')]")).sendKeys("мобайл тинькофф");
        driver.findElement(By.xpath("//div[contains(@class, 'VlcLAe')]//input[contains(@value, 'Поиск в Google')]")).click();

        wait

                .ignoring(StaleElementReferenceException.class)
                .withMessage("Чо то не так идет")
                .pollingEvery(Duration.ofMillis(500))
                .until(d -> {
                    By listofResponses = By.xpath("//h3");
                    List<WebElement> elements = driver.findElements(listofResponses);
                    for (WebElement element : elements) {
                        if (element.getText().contains("мобайл тинькофф тарифы")) element.click();
                        break;
                    }
                    return d.getTitle().equals("мобайл тинькофф тарифы");

                });


    }
}
