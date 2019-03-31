import org.junit.Test;
import org.openqa.selenium.By;

public class TestingDzSecond extends Runner {
    @Test
    public void testCase1() {
        driver.get("https://www.google.ru/");
        driver.findElement(By.xpath("//input[contains(@class, 'gLFyf gsfi')]")).click();
        driver.findElement(By.xpath("//input[contains(@class, 'gLFyf gsfi')]")).sendKeys("мобайл тинькофф");
        driver.findElement(By.xpath("//div[contains(@class, 'FPdoLc VlcLAe')]//input[contains(@value, 'Поиск в Google')]"));
        driver.
    }
}
