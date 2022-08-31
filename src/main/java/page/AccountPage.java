package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage {

    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Лента Заказов']")
    private SelenideElement ordersFeedButton;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;

    @FindBy(how = How.XPATH, using = ".//input[@name='Name']")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = ".//div/input[@name='name']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//li[3]/div/div/input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//button[text()='Сохранить']")
    private SelenideElement saveButton;

    @FindBy(how = How.XPATH, using = ".//button[text()='Отмена']")
    private SelenideElement cancelButton;

    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement exitButton;

    @FindBy(how = How.XPATH, using = ".//a[@href='/account/order-history']")
    private SelenideElement orderHistoryButton;

    @Step("клик на кнопку 'Выход'")
    public void clickExitButton() {
        exitButton.click();
    }

    @Step("метод для получения текста кнопки 'История заказов'")
    public String getTextFromOrderHistoryButton() {
        return orderHistoryButton.getText();
    }

    @Step("клик на логотип")
    public void clickLogo() {
        logo.click();
    }

    @Step("клик на 'Конструктор'")
    public void clickConstructorButton() {
        constructorButton.click();
    }

}
