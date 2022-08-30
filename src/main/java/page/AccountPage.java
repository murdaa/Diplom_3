package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage {

    @FindBy(how = How.XPATH, using = ".//input[@name='Name']")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = ".//div/input[@name='name']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//li[3]/div/div/input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//button[.='Сохранить']")
    private SelenideElement saveButton;

    @FindBy(how = How.XPATH, using = ".//button[.='Отмена']")
    private SelenideElement cancelButton;

    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement exitButton;

    @Step("клик на кнопку 'Выход'")
    public void clickOnExitButton() {
        exitButton.click();
    }
}
