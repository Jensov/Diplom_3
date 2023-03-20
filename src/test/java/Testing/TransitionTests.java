package Testing;

import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class TransitionTests extends BaseTests {

    @Test
    @DisplayName("Check Transition Into Personal Account Page From Constructor Page")
    @Description("Проверяется переход по клику на «Личный кабинет»")
    public void transitionToPersonalAccount() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(user.getName(), user.getEmail(), user.getPassword());

        loginPage.getInputButton().isDisplayed();
        loginPage.login(user.getEmail(), user.getPassword());

        homePage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.checkPersonalAccountInfo(user.getName(), user.getEmail());
        isUserRegistered = true;
    }

    @Test
    @DisplayName("Check Transition Into Constructor Page From Personal Account")
    @Description("Проверяется переход по клику на «Конструктор» и на логотип Stellar Burgers")
    public void transitionToConstructor() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(user.getName(), user.getEmail(), user.getPassword());

        loginPage.getInputButton().isDisplayed();
        loginPage.login(user.getEmail(), user.getPassword());

        homePage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.checkPersonalAccountInfo(user.getName(), user.getEmail());
        personalAccountPage.clickConstructorButton();

        homePage.getCreateOrderButton().isDisplayed();
        homePage.clickPersonalAccountButton();

        personalAccountPage.clickStellarBurgerButton();

        homePage.getCreateOrderButton().isDisplayed();
        isUserRegistered = true;
    }

    @Test
    @DisplayName("Check Exit Personal Account")
    @Description("Проверяется выход из аккаунта по кнопке «Выйти» в личном кабинете")
    public void exitPersonalAccount() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(user.getName(), user.getEmail(), user.getPassword());

        loginPage.getInputButton().isDisplayed();
        loginPage.login(user.getEmail(), user.getPassword());

        homePage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.checkPersonalAccountInfo(user.getName(), user.getEmail());
        personalAccountPage.clickExitButton();
        loginPage.getInputButton().isDisplayed();
        isUserRegistered = true;
    }

    @Test
    @DisplayName("Check Transition To Section Toppings In Constructor Page")
    @Description("Проверяется переход в раздел Начинки")
    public void transitionToSectionToppings() throws InterruptedException {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickToppings();
    }

    @Test
    @DisplayName("Check Transition To Section Sauce In Constructor Page")
    @Description("Проверяются переход в раздел Соусы")
    public void transitionToSectionSauce() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickSauce();
    }

    @Test
    @DisplayName("Check Transition To Section Buns In Constructor Page")
    @Description("Проверяется переход в раздел Булки")
    public void transitionToSectionBuns() throws InterruptedException {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickToppings();
        constructorPage.clickBuns();
    }
}
