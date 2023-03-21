package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;
    private By nameInput = By.xpath(".//label[text()='Имя']/../input");
    private By emailInput = By.xpath(".//label[text()='Email']/../input");
    private By passwordInput = By.xpath(".//label[text()='Пароль']/../input");
    private By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private By loginButton = By.xpath(".//a[@href = '/login']");
    private By errorMessage = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setNameInput(String text) {
        getNameInput().sendKeys(text);
    }

    public void setEmailInput(String text) {
        getEmailInput().sendKeys(text);
    }

    public void setPasswordInput(String text) {
        getPasswordInput().sendKeys(text);
    }

    public WebElement getNameInput() {
        return driver.findElement(nameInput);
    }

    public WebElement getErrorMessage() {
        return driver.findElement(errorMessage);
    }

    public WebElement getEmailInput() {
        return driver.findElement(emailInput);
    }

    public WebElement getPasswordInput() {
        return driver.findElement(passwordInput);
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public void registration(String name, String email, String password) {
        setNameInput(name);
        setEmailInput(email);
        setPasswordInput(password);
        clickRegistrationButton();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
