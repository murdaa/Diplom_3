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

    @FindBy(how = How.XPATH, using = ".//label[.='Email']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//button[.='Войти']")
    private SelenideElement enterButton;

    @FindBy(how = How.XPATH, using = ".//a[@href='/register']")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//a[@href='/forgot-password']")
    private SelenideElement resetPasswordButton;

    @Step("клик на логотип")
    public void clickOnLogo() {
        logo.click();
    }

    @Step("клик на 'Конструктор'")
    public void clickOnConstructorButton() {
        constructorButton.click();
    }

    @Step("клик на кнопку 'Войти'")
    public void clickOnEnterButton() {
        enterButton.click();
    }

    @Step("клик на кнопку 'Зарегистрироваться'")
    public void clickOnRegisterButton() {
        registerButton.click();
    }

    @Step("клик на кнопку 'Восстановить пароль'")
    public void clickOnResetPasswordButton() {
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
    public void fulfillLoginForm(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
        clickOnEnterButton();
    }
}
