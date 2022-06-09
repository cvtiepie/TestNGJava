package tests;

import core.DriverManager;
import core.DriverManagerFactory;
import core.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

public class BaseTest {

    private DriverManager driverManager;
    public static WebDriver driver;


    public WebDriver getDriver() {
        return driver;
    }


    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }


    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }


    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }
}
