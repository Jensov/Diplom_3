package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By loginAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginAccountButton() {
        driver.findElement(loginAccountButton).click();
    }

    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }
}
