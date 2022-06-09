package pages;

import data.CommonStrings;
import data.Urls;
import helpers.ExpectedConditionsHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

public class LoginPage extends BasePage {

    @Override
    public LoginPage goToPage() {
        driver.get(Urls.mainPage);
        return this;
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By userNameInput = By.id("username");

    private final By passwordInput = By.id("password");

    private final By submitLoginButton = By.id("login_submit");

    private final By errorMessage = By.id("error");

    @Step("Enter User Name")
    private void enterUserName(String userName) {
        driver.findElement(userNameInput).sendKeys(userName);
    }

    @Step("Enter Password")
    private void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Submit Login")
    private void submitLogin() {
        driver.findElement(submitLoginButton).click();
    }

    @Step("Login As User")
    public MainPage loginAsUser(String userName, String password) {
        ExpectedConditionsHelper waitFor = new ExpectedConditionsHelper();
        waitFor.waitForElementPresence(this.userNameInput, Optional.of(10));
        this.enterUserName(userName);
        this.enterPassword(password);
        this.submitLogin();
        return new MainPage(driver);
    }

    @Step("Login As User with Wrong Creds")
    public LoginPage LoginAsUserWithWrongCredentials(String userName, String password) {
        ExpectedConditionsHelper waitFor = new ExpectedConditionsHelper();
        waitFor.waitForElementPresence(this.userNameInput, Optional.of(10));
        this.enterUserName(userName);
        this.enterPassword(password);
        this.submitLogin();
        return this;
    }

    @Step("Check Login Error")
    public void checkLoginError() {
        ExpectedConditionsHelper waitFor = new ExpectedConditionsHelper();
        waitFor.waitForElementVisibility(this.errorMessage, Optional.of(10));
        final String text = driver.findElement(errorMessage).getText();
        this.assertStrings(text, CommonStrings.WrongCredsMessage);
    }




}
