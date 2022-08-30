package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    @FindBy(how = How.XPATH, using = ".//fieldset[1]/div[@class='input__container']/div/input[@name='name']")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = ".//fieldset[2]/div[@class='input__container']/div/input[@name='name']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//button[.='Зарегистрироваться']")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//a[@href='/login']")
    private SelenideElement enterButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement errorText;

    @Step("ввести значение в поле 'Имя'")
    public void setNameField(String name) {
        nameField.setValue(name);
    }

    @Step("ввести значение в поле 'Email'")
    public void setEmailField(String email) {
        emailField.setValue(email);
    }

    @Step("ввести значение в поле 'Пароль'")
    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }

    @Step("клик на кнопку 'Зарегистрироваться'")
    public void clickOnRegistrationButton() {
        registerButton.click();
    }

    @Step("клик на кнопку 'Войти'")
    public void clickOnEnterButton() {
        enterButton.click();
    }

    @Step("заполнить форму регистрации пользователя")
    public void fulfillLoginForm(String name, String email, String password) {
        setNameField(name);
        setEmailField(email);
        setPasswordField(password);
        clickOnRegistrationButton();
    }

    @Step("получение текста ошибки 'Некорректный пароль'")
    public String getErrorText() {
        return errorText.getText();
    }

}
