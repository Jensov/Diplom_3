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
        checkSauceHeader();
    }

    public void clickBuns() {
        getBuns().click();
        checkBunsHeader();
    }

    public void clickToppings() throws InterruptedException {
        getToppings().click();
        checkToppingsHeader();
                Thread.sleep(500L);
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

    public void checkSauceHeader() {
        driver.findElement(By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']//span[text()='Соусы']")).isDisplayed();
        driver.findElement(sauceHeader).isDisplayed();
    }

    public void checkBunsHeader() {
        driver.findElement(By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']//span[text()='Булки']")).isDisplayed();
        driver.findElement(bunsHeader).isDisplayed();
    }

    public void checkToppingsHeader() {
        driver.findElement(By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']//span[text()='Начинки']")).isDisplayed();
        driver.findElement(toppingsHeader).isDisplayed();
    }
}
