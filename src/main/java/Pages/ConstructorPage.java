package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConstructorPage {
    private final WebDriver driver;
    private By sauce = By.xpath("//span[text()='Соусы']");
    private By buns = By.xpath("//span[text()='Булки']");
    private By toppings = By.xpath("//span[text()='Начинки']");
    private By toppingsHeader = By.xpath(".//h2[text() = 'Начинки']");
    private By bunsHeader = By.xpath(".//h2[text() = 'Булки']");
    private By sauceHeader = By.xpath(".//h2[text() = 'Соусы']");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickSauce() {
        getSauce().click();
        getSauceHeader();
    }

    public void clickBuns() {
        getBuns().click();
        getBunsHeader();
    }

    public void clickToppings() throws InterruptedException {
        getToppings().click();
        Thread.sleep(5000l);
        getToppingsHeader();
    }

    public WebElement getSauce() {
        return driver.findElement(sauce);
    }

    public WebElement getBuns() {
        return driver.findElement(buns);
    }

    public WebElement getToppings() {
        return driver.findElement(toppings);
    }

    public WebElement getToppingsHeader() {
        return driver.findElement(toppingsHeader);
    }

    public WebElement getBunsHeader() {
        return driver.findElement(bunsHeader);
    }

    public WebElement getSauceHeader() {
        return driver.findElement(sauceHeader);
    }
}
