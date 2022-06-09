package pages;

import data.Urls;
import helpers.ExpectedConditionsHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

public class MainPage extends BasePage {

    @Override
    public MainPage goToPage() {
        driver.get(Urls.mainPage);
        return this;
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By loginButton = By.xpath("//a[@href='/account/login']");
    private final By userNameElement = By.id("header_profile_username");
    private final By burgerButton = By.xpath("//div[@onclick = 'RYMheader.onClickBars()']");

    private final By logoutButton = By.xpath("//span[contains(text(), 'Log out')]");

    public final NavBar navBar = new NavBar();

    @Step("Open Login Page")
    public LoginPage openLoginPage() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    @Step("Get User Name")
    private String getUserName() {
        ExpectedConditionsHelper waitFor = new ExpectedConditionsHelper();
        waitFor.waitForElementPresence(this.userNameElement, Optional.of(10));
        return driver.findElement(userNameElement).getText();
    }

    @Step("Check User Name")
    public void checkUserName(String expectedName) {
        var actualName = this.getUserName();
        this.assertStrings(actualName, expectedName);
    }

    @Step("Open Burger Menu")
    public void openBurgerMenu() {
        ExpectedConditionsHelper waitFor = new ExpectedConditionsHelper();
        waitFor.waitForElementPresence(this.burgerButton, Optional.of(10));
        driver.findElement(burgerButton).click();
    }

    @Step("Logout")
    public MainPage logout() {
        this.openBurgerMenu();
        ExpectedConditionsHelper waitFor = new ExpectedConditionsHelper();
        waitFor.waitForElementPresence(this.logoutButton, Optional.of(10));
        driver.findElement(logoutButton).click();
        driver.switchTo().alert().accept();
        waitFor.waitForElementPresence(this.loginButton, Optional.of(10));
        return this;
    }

}
