import org.junit.*;
import org.openqa.selenium.*;

import static org.junit.Assert.assertEquals;

public class TestingDzFirst extends Runner{

    @Test
    public void testCase1() {
        driver.get("https://www.tinkoff.ru/career/vacancies/");
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'name')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'birthday')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'city')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'email')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'phone')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'socialLink0')]")).click();
        assertEquals("Поле обязательное", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Дата рождения'])[1]/following::div[3]")).getText());
    }
    @Test
    public void testCase2() {

        driver.get("https://www.tinkoff.ru/career/vacancies/");
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'name')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'name')]")).clear();
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'name')]")).sendKeys("1111111111111111111");
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'city')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'city')]")).clear();
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'city')]")).sendKeys("00.00.0000");
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'city')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'city')]")).clear();
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'city')]")).sendKeys("00000000");
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'email')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'email')]")).clear();
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'email')]")).sendKeys("фывав");
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'phone')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'phone')]")).clear();
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'phone')]")).sendKeys("+7(000) 000-00-00");
        driver.findElement(By.xpath("//div[contains(@class, 'ui-input__column')]/input[contains(@name, 'email')]")).click();
        assertEquals("Допустимо использовать только буквы русского алфавита и дефис", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия и имя'])[1]/following::div[2]")).getText());
        assertEquals("Поле заполнено некорректно", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Дата рождения'])[1]/following::div[3]")).getText());
        assertEquals("Введите корректный адрес эл. почты", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Электронная почта'])[1]/following::div[2]")).getText());
        assertEquals("Код города/оператора должен начинаться с цифры 3, 4, 5, 6, 8, 9", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Мобильный телефон'])[1]/following::div[2]")).getText());
    }

}
