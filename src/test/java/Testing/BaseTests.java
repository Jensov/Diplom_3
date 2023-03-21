package Testing;

import Api.UserRequest;
import User.RegistrationUser;
import User.UserGenerator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTests {
    public WebDriver driver;
    private final UserGenerator generator = new UserGenerator();
    public RegistrationUser user;
    public boolean isUserRegistered = false;

    @Before
    public void beforeTest() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/");
        user = generator.random();
    }

    @After
    public void tearDown() {
        driver.quit(); // закрываем браузер
        if (isUserRegistered) {
            String token = UserRequest.getToken(user);
            UserRequest.deleteUser(token);
        }
    }
}
