import api.User;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.*;

import static api.UserClient.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest {

    HomePage homePage = page(HomePage.class);
    LoginPage loginPage = page(LoginPage.class);
    AccountPage accountPage = page(AccountPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);
    ResetPasswordPage resetPasswordPage = page(ResetPasswordPage.class);

    User user = new User(RandomStringUtils.randomAlphanumeric(5) + "@yandex.ru",
            RandomStringUtils.randomAlphanumeric(8),
            RandomStringUtils.randomAlphanumeric(8));

    String accessToken = create(user);

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        //для запуска Яндекс.браузера установила сам браузер и прописывала путь до актуального яндекс драйвера:
        //System.setProperty("webdriver.chrome.driver", "C:\\yandexdriver\\yandexdriver.exe");
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        final String URL_HOME_PAGE = "https://stellarburgers.nomoreparties.site/";
        open(URL_HOME_PAGE);
    }

    @After
    public void tearDown() {
        accountPage.clickExitButton();
        deleteUser(accessToken);
        closeWindow();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Проверить вход по кнопке «Войти в аккаунт» на главной")
    public void loginButtonClickOnHomePageTest() {
        homePage.clickLoginButton();
        loginPage.fulfilLoginForm(user.getEmail(), user.getPassword());
        homePage.clickPrivateAccountButton();
        String expected = "История заказов";
        String actual = accountPage.getTextFromOrderHistoryButton();
        System.out.println(expected);
        Assert.assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет» на главной")
    @Description("Проверить вход через кнопку «Личный кабинет» на главной")
    public void privateAccountButtonClickOnHomePageTest() {
        homePage.clickPrivateAccountButton();
        loginPage.fulfilLoginForm(user.getEmail(), user.getPassword());
        homePage.clickPrivateAccountButton();
        String expected = "История заказов";
        String actual = accountPage.getTextFromOrderHistoryButton();
        System.out.println(expected);
        Assert.assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверить вход через кнопку в форме регистрации")
    public void loginFromRegistrationFormTest() {
        homePage.clickLoginButton();
        loginPage.clickRegisterButton();
        registrationPage.clickEnterButton();
        loginPage.fulfilLoginForm(user.getEmail(), user.getPassword());
        homePage.clickPrivateAccountButton();
        String expected = "История заказов";
        String actual = accountPage.getTextFromOrderHistoryButton();
        System.out.println(expected);
        Assert.assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверить вход через кнопку в форме восстановления пароля")
    public void loginFromResetPasswordFormTest() {
        homePage.clickLoginButton();
        loginPage.clickResetPasswordButton();
        resetPasswordPage.clickEnterButton();
        loginPage.fulfilLoginForm(user.getEmail(), user.getPassword());
        homePage.clickPrivateAccountButton();
        String expected = "История заказов";
        String actual = accountPage.getTextFromOrderHistoryButton();
        System.out.println(expected);
        Assert.assertEquals(actual, expected);
    }
}
