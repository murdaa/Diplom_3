package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Лента Заказов']")
    private SelenideElement ordersFeedButton;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;

    @FindBy(how = How.CSS, using = "input[name='name']")
    private SelenideElement emailField;

    @FindBy(how = How.CSS, using = "input[name='Пароль']")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement enterButton;

    @FindBy(how = How.XPATH, using = ".//a[@href='/register']")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//a[@href='/forgot-password']")
    private SelenideElement resetPasswordButton;

    @FindBy(how = How.XPATH, using = ".//h2[.='Вход']")
    private SelenideElement headerText;

    @Step("клик на логотип")
    public void clickLogo() {
        logo.click();
    }

    @Step("клик на 'Конструктор'")
    public void clickConstructorButton() {
        constructorButton.click();
    }

    @Step("клик на кнопку 'Войти'")
    public void clickEnterButton() {
        enterButton.click();
    }

    @Step("клик на кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {
        registerButton.click();
    }

    @Step("клик на кнопку 'Восстановить пароль'")
    public void clickResetPasswordButton() {
        resetPasswordButton.click();
    }

    @Step("ввести значение в поле 'Email'")
    public void setEmailField(String email) {
        emailField.setValue(email);
    }

    @Step("ввести значение в поле 'Password'")
    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }

    @Step("заполнить форму авторизации пользователя")
    public void fulfilLoginForm(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
        clickEnterButton();
    }

    @Step("получение текста заголовка 'Вход'")
    public String getHeaderText() {
        return headerText.getText();
    }
}
