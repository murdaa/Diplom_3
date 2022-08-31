import api.Credentials;
import api.User;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import page.HomePage;
import page.LoginPage;
import page.RegistrationPage;

import static api.UserClient.deleteUser;
import static api.UserClient.loginUser;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationValidTest {

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
        String accessToken = loginUser(new Credentials(user.getEmail(), user.getPassword()));
        deleteUser(accessToken);
        closeWindow();
    }

    @Test
    @DisplayName("Тест успешной регистрации")
    @Description("Проверить успешную регистрацию нового пользователя")
    public void validRegistrationTest() {
        homePage.clickLoginButton();
        loginPage.clickRegisterButton();
        registrationPage.fulfillRegisterForm(user.getName(),
                user.getEmail(), user.getPassword());
        String expected = "Вход";
        String actual = loginPage.getHeaderText();
        Assert.assertEquals(actual, expected);
    }
}
