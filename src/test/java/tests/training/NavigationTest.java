package tests.training;

import data.LoginData;
import data.Urls;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MainPage;
import tests.BaseTest;
import utils.ReporterListener;

@Listeners({ ReporterListener.class})
@Feature("Rate Your Music Navigation Test")
public class NavigationTest extends BaseTest {

    @Test(priority = 1, description = "Navigate to New Music Page")
    public static void navigateToNewMusicPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToPage()
                .navBar.openNewMusicPage();
        String currentUrl = mainPage.getCurrentUrl();
        mainPage.assertStrings(currentUrl, Urls.newMusicPage);
    }

    @Test(priority = 1, description = "Navigate to Genres Page")
    public static void navigateToGenresPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToPage()
                .navBar.openGenresPage();
        String currentUrl = mainPage.getCurrentUrl();
        mainPage.assertStrings(currentUrl, Urls.genresPage);
    }

    @Test(priority = 1, description = "Navigate to Charts Page")
    public static void navigateToChartsPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToPage()
                .navBar.openChartsPage();
        String currentUrl = mainPage.getCurrentUrl();
        mainPage.assertStrings(currentUrl, Urls.chartsPage);
    }

    @Test(priority = 1, description = "Navigate to Lists Page")
    public static void navigateToListsPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToPage()
                .navBar.openListsPage();
        String currentUrl = mainPage.getCurrentUrl();
        mainPage.assertStrings(currentUrl, Urls.listsPage);
    }



}
