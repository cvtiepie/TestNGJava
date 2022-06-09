package pages;

import data.Urls;
import org.openqa.selenium.WebDriver;

public class ChartsPage extends BasePage {
    public ChartsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ChartsPage goToPage() {
        driver.get(Urls.chartsPage);
        return this;
    }

}
