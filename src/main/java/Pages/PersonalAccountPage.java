package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {
    private final WebDriver driver;
    private final By profileText = By.xpath(".//a[text()='Профиль']");
    private final By storyOrdersText = By.xpath(".//a[text()='История заказов']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By stellarBurgerButton = By.className("AppHeader_header__logo__2D0X2");
    private final By exitButton = By.xpath(".//button[text()='Выход']");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkProfileWord() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(profileText));
    }

    public void checkStoryOrdersWord() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(storyOrdersText));
    }

    public void checkNameFieldValue(String userName) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@value='" + userName + "']")));
    }

    public void checkLoginFieldValue(String userLogin) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@value='" + userLogin + "']")));
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void clickStellarBurgerButton() {
        driver.findElement(stellarBurgerButton).click();
    }

    public void clickExitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(exitButton));
        driver.findElement(exitButton).click();
    }

    public void checkPersonalAccountInfo(String name, String email) {
        checkProfileWord();
        checkProfileWord();
        checkStoryOrdersWord();
        checkNameFieldValue(name);
        checkLoginFieldValue(email);
    }
}
