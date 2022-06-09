package tests.training;
import data.LoginData;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MainPage;
import tests.BaseTest;
import utils.ReporterListener;

@Listeners({ ReporterListener.class})
@Feature("Rate Your Music Authorization")
public class LoginTest extends BaseTest {

    @Test(priority = 0, description = "Successful Login to RYM")
    public static void loginInRYM() {

        MainPage mainPage = new MainPage(driver);

        mainPage.goToPage()
                .openLoginPage()
                .loginAsUser(LoginData.JohnChanLogin, LoginData.JohnChanPassword)
                .checkUserName(LoginData.JohnChanLogin);
    }

    @Test(priority =  1, description = "Login to RYM: Wrong Password")
    public static void wrongPasswordLoginToRYM() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);

        mainPage.goToPage()
                .openLoginPage()
                .LoginAsUserWithWrongCredentials(LoginData.JohnChanLogin, LoginData.WrongJohnChanPassword)
                .checkLoginError();

    }

    @Test(priority = 1, description = "Login to RYM: Wrong Username")
    public static void wrongUserNameLoginToRYM() {
        MainPage mainPage = new MainPage(driver);

        mainPage.goToPage()
                .openLoginPage()
                .LoginAsUserWithWrongCredentials(LoginData.WrongJohnChanLogin, LoginData.JohnChanPassword)
                .checkLoginError();

    }

    @Test(priority = 1, description = "Logout from RYM")
    public static void logoutFromRYM() {
        MainPage mainPage = new MainPage(driver);

        mainPage.goToPage()
                .openLoginPage()
                .loginAsUser(LoginData.JohnChanLogin, LoginData.JohnChanPassword)
                .logout();
    }
}
