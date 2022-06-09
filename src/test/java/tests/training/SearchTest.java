package tests.training;


import data.LoginData;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MainPage;
import tests.BaseTest;
import utils.ReporterListener;

@Listeners({ ReporterListener.class})
@Feature("Search in Rate Your Music")
public class SearchTest extends BaseTest {

    @Test(priority = 1, description = "Find an Artist 'Modest Mouse'")
    public static void FindAnArtistsByName() {
        String searchItem = "Modest Mouse";
        MainPage mainPage = new MainPage(driver);

        mainPage.goToPage()
                .navBar.searchItem(searchItem)
                .checkFirstItemInSearch(searchItem);

    }

    @Test(priority = 1, description = "Find and Album 'The Lonesome Crowded West'")
    public static void FindAnAlbumByName() {
        String searchItem = "The Lonesome Crowded West";
        MainPage mainPage = new MainPage(driver);

        mainPage.goToPage()
                .navBar.searchItem(searchItem)
                .checkFirstItemInSearch(searchItem);

    }

}
