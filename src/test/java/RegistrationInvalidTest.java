import api.User;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.HomePage;
import page.LoginPage;
import page.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationInvalidTest {

    HomePage homePage = page(HomePage.class);
    LoginPage loginPage = page(LoginPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);
    User user = new User(RandomStringUtils.randomAlphanumeric(5) + "@yandex.ru",
            RandomStringUtils.randomAlphanumeric(8),
            RandomStringUtils.randomAlphanumeric(8));

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
        closeWindow();
    }

    @Test
    @DisplayName("Тест безуспешной регистрации")
    @Description("Проверить, что с некорректным паролем не произойдет регистрации нового пользователя")
    public void invalidRegistrationTest() {
        homePage.clickLoginButton();
        loginPage.clickRegisterButton();
        registrationPage.fulfillRegisterForm(user.getName(),
                user.getEmail(), "12345");
        String expected = "Некорректный пароль";
        String actual = registrationPage.getErrorText();
        Assert.assertEquals(actual, expected);
    }
}
