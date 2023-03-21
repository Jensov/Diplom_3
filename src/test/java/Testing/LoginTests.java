package Testing;

import Pages.ForgotPasswordPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class LoginTests extends BaseTests {

    @Test
    @DisplayName("Check Login On Personal Account Button")
    @Description("Проверяется авторизация пользователя через кнопку Личный кабинет")
    public void loginOnPersonalAccountButtonTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(user.getName(), user.getEmail(), user.getPassword());

        loginPage.getInputButton().isDisplayed();
        loginPage.login(user.getEmail(), user.getPassword());

        isUserRegistered = true;
        homePage.getCreateOrderButton().isDisplayed();
    }

    @Test
    @DisplayName("Check Login On Login Account Button")
    @Description("Проверяется авторизация пользователя через кнопку Войти в аккаунт")
    public void loginOnLoginAccountButtonTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(user.getName(), user.getEmail(), user.getPassword());

        loginPage.getInputButton().isDisplayed();
        loginPage.login(user.getEmail(), user.getPassword());

        isUserRegistered = true;
        homePage.getCreateOrderButton().isDisplayed();
    }

    @Test
    @DisplayName("Check Login On Sign In Button In Registration Page")
    @Description("Проверяется авторизация пользователя через кнопку Войти на странице регистрации")
    public void loginOnSignInButtonInRegistrationPageTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(user.getName(), user.getEmail(), user.getPassword());

        loginPage.clickRegistrationButton();
        registrationPage.clickLoginButton();
        loginPage.getInputButton().isDisplayed();
        loginPage.login(user.getEmail(), user.getPassword());

        isUserRegistered = true;
        homePage.getCreateOrderButton().isDisplayed();
    }

    @Test
    @DisplayName("Check Login On Sign In Button In Forgot Password Page")
    @Description("Проверяется авторизация пользователя через кнопку Войти на странице восстановления пароля")
    public void loginOnSignInButtonInForgotPasswordPageTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(user.getName(), user.getEmail(), user.getPassword());

        loginPage.clickForgotPasswordButton();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickLoginButton();
        loginPage.getInputButton().isDisplayed();
        loginPage.login(user.getEmail(), user.getPassword());

        isUserRegistered = true;
        homePage.getCreateOrderButton().isDisplayed();
    }
}
