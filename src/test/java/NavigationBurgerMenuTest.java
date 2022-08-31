import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.HomePage;

import static com.codeborne.selenide.Selenide.*;

public class NavigationBurgerMenuTest {

    HomePage homePage = page(HomePage.class);

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
    @DisplayName("Переход к разделу «Булки»")
    @Description("Проверить переход к разделу «Булки»")
    public void navigationToBunMenuTest() {
        homePage.selectSauceOption();
        homePage.selectBunOption();
        String expected = "Булки";
        String actual = homePage.getBunHeaderText();
        System.out.println(expected);
        Assert.assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    @Description("Проверить переход к разделу «Соусы»")
    public void navigationToSauceMenuTest() {
        homePage.selectSauceOption();
        String expected = "Соусы";
        String actual = homePage.getSauceHeaderText();
        System.out.println(expected);
        Assert.assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    @Description("Проверить переход к разделу «Начинки»")
    public void navigationToFillingMenuTest() {
        homePage.selectFillingOption();
        String expected = "Начинки";
        String actual = homePage.getFillingHeaderText();
        System.out.println(expected);
        Assert.assertEquals(actual, expected);
    }
}
