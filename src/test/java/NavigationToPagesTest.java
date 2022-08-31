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

import static api.UserClient.create;
import static api.UserClient.deleteUser;
import static com.codeborne.selenide.Selenide.*;

public class NavigationToPagesTest {

    HomePage homePage = page(HomePage.class);
    LoginPage loginPage = page(LoginPage.class);
    AccountPage accountPage = page(AccountPage.class);

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
        homePage.clickPrivateAccountButton();
        loginPage.fulfilLoginForm(user.getEmail(), user.getPassword());
    }

    @After
    public void tearDown() {
        deleteUser(accessToken);
        closeWindow();
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Проверить переход по клику на «Личный кабинет»")
    public void navigationToAccountTest() {
        homePage.clickPrivateAccountButton();
        String expected = "История заказов";
        String actual = accountPage.getTextFromOrderHistoryButton();
        System.out.println(expected);
        Assert.assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор через лого")
    @Description("Проверить переход из личного кабинета в конструктор через лого")
    public void navigationToHomePageViaLogoTest() {
        homePage.clickPrivateAccountButton();
        accountPage.clickLogo();
        String expected = "Соберите бургер";
        String actual = homePage.getHeaderText();
        System.out.println(expected);
        Assert.assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    @Description("Проверить переход из личного кабинета в конструктор по клику на «Конструктор»")
    public void navigationToHomePageViaConstructorButtonTest() {
        homePage.clickPrivateAccountButton();
        accountPage.clickConstructorButton();
        String expected = "Соберите бургер";
        String actual = homePage.getHeaderText();
        System.out.println(expected);
        Assert.assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Выход из личного кабинета по клику на «Выход»")
    @Description("Проверить выход из личного кабинета по клику на «Выход»")
    public void exitFromPrivateAccountTest() {
        homePage.clickPrivateAccountButton();
        accountPage.clickExitButton();
        String expected = "Вход";
        String actual = loginPage.getHeaderText();
        System.out.println(expected);
        Assert.assertEquals(actual, expected);
    }
}
