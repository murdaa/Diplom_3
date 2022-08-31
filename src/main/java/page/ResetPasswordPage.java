package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResetPasswordPage {

    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//button[.='Восстановить']")
    private SelenideElement resetButton;

    @FindBy(how = How.XPATH, using = ".//input[@name='Введите новый пароль']")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement codeField;

    @FindBy(how = How.XPATH, using = ".//button[.='Сохранить']")
    private SelenideElement saveButton;

    @FindBy(how = How.XPATH, using = ".//a[@href='/login']")
    private SelenideElement enterButton;

    @Step("ввести значение в поле 'Email'")
    public void setEmailField(String email) {
        emailField.setValue(email);
    }

    @Step("клик на кнопку 'Восстановить'")
    public void clickResetButton() {
        resetButton.click();
    }

    @Step("восстановить пароль")
    public void resetPassword(String email) {
        setEmailField(email);
        resetButton.click();
    }

    @Step("клик на кнопку 'Войти'")
    public void clickEnterButton() {
        enterButton.click();
    }

    @Step("ввести значение в поле 'Пароль'")
    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }

    @Step("ввести значение в поле 'Код из письма'")
    public void setCodeField(String code) {
        codeField.setValue(code);
    }

    @Step("клик на кнопку 'Сохранить'")
    public void clickSaveButton() {
        saveButton.click();
    }
}
