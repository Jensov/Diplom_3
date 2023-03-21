package Testing;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;


public class RegistrationTests extends BaseTests {

    @Test
    @DisplayName("Check Registration")
    @Description("Проверяется регистрация пользователя")
    public void RegistrationTest() {

        HomePage homePage = new HomePage(driver);
        homePage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(user.getName(), user.getEmail(), user.getPassword());
        isUserRegistered = true;
        loginPage.getInputButton().isDisplayed();
    }

    @Test
    @DisplayName("Check Registration With Incorrect Password")
    @Description("Проверяется регистрация пользователя с невалидным паролем")
    public void RegistrationWithIncorrectPasswordTest() {

        HomePage homePage = new HomePage(driver);
        homePage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();

        user.setPassword("123");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(user.getName(), user.getEmail(), user.getPassword());
        registrationPage.getErrorMessage();
    }
}
