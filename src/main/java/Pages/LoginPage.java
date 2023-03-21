package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private By emailInput = By.xpath(".//label[text()='Email']/../input");
    private By passwordInput = By.xpath(".//label[text()='Пароль']/../input");
    private By inputButton = By.xpath(".//button[text()='Войти']");
    private By registrationButton = By.xpath(".//a[@href='/register']");
    private By forgotPasswordButton = By.xpath(".//a[@href='/forgot-password']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegistrationButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(registrationButton));
        driver.findElement(registrationButton).click();
    }

    public void setEmailInput(String text) {
        getEmailInput().sendKeys(text);
    }

    public void setPasswordInput(String text) {
        getPasswordInput().sendKeys(text);
    }

    public WebElement getEmailInput() {
        return driver.findElement(emailInput);
    }

    public WebElement getPasswordInput() {
        return driver.findElement(passwordInput);
    }

    public void clickInputButton() {
        driver.findElement(inputButton).click();
    }

    public WebElement getInputButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(inputButton));
        return driver.findElement(inputButton);
    }

    public void login(String email, String password) {
        setEmailInput(email);
        setPasswordInput(password);
        clickInputButton();
    }

    public void clickForgotPasswordButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(forgotPasswordButton));
        WebElement element = driver.findElement(forgotPasswordButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(forgotPasswordButton).click();
    }
}
