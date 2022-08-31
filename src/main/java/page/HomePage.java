package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Лента Заказов']")
    private SelenideElement ordersFeedButton;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;

    @FindBy(how = How.XPATH, using = ".//a[@href='/account']")
    private SelenideElement privateAccountButton;

    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunOption;

    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement sauceOption;

    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingOption;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = ".//h1[.='Соберите бургер']")
    private SelenideElement headerText;

    @FindBy(how = How.XPATH, using = ".//h2[.='Булки']")
    private SelenideElement headerBunText;

    @FindBy(how = How.XPATH, using = ".//h2[.='Соусы']")
    private SelenideElement headerSauceText;

    @FindBy(how = How.XPATH, using = ".//h2[.='Начинки']")
    private SelenideElement headerFillingText;

    @Step("клик на кнопку 'Личный кабинет'")
    public LoginPage clickPrivateAccountButton() {
        privateAccountButton.click();
        LoginPage loginPage = page(LoginPage.class);
        return loginPage;
    }

    @Step("клик на кнопку 'Войти в аккаунт'")
    public LoginPage clickLoginButton() {
        loginButton.click();
        LoginPage loginPage = page(LoginPage.class);
        return loginPage;
    }

    @Step("клик на раздел 'Булки'")
    public void selectBunOption() {
        bunOption.click();
    }

    @Step("клик на раздел 'Соусы'")
    public void selectSauceOption() {
        sauceOption.click();
    }

    @Step("клик на раздел 'Начинки'")
    public void selectFillingOption() {
        fillingOption.click();
    }

    @Step("получить текст заголовка 'Соберите бургер'")
    public String getHeaderText() {
        return headerText.getText();
    }

    @Step("получить текст заголовка 'Булки'")
    public String getBunHeaderText() {
        return headerBunText.getText();
    }

    @Step("получить текст заголовка 'Соусы'")
    public String getSauceHeaderText() {
        return headerSauceText.getText();
    }

    @Step("получить текст заголовка 'Начинки'")
    public String getFillingHeaderText() {
        return headerFillingText.getText();
    }
}