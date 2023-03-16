package Testing;

import Pages.HomePage;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTests {

    private WebDriver driver;

    @Before
    public void beforeTest() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        // переход на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void tearDown() {
        driver.quit(); // закрываем браузер
    }

    @Test
    public void loginTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickPersonalAccountButton();
    }
}
