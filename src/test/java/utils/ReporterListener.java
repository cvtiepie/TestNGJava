package utils;
import io.qameta.allure.Attachment;
import java.util.Objects;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

public class ReporterListener extends BaseTest implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    //Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    //HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        CustomLogger.info("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        CustomLogger.info("I am in onFinish method " + iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        CustomLogger.info(getTestMethodName(iTestResult) + " test is starting.");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        CustomLogger.info(getTestMethodName(iTestResult) + " test is succeed.");
        //ExtentReports log operation for passed tests.
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        CustomLogger.info(getTestMethodName(iTestResult) + " test is failed.");

        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        //Allure ScreenShotRobot and SaveTestLog
        if (driver != null) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            saveScreenshotPNG(driver);
        }

        //Save a log on allure.
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");

        //Take base64Screenshot screenshot for extent reports
        String base64Screenshot =
                "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        CustomLogger.info(getTestMethodName(iTestResult) + " test is skipped.");
        //ExtentReports log operation for skipped tests.
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        CustomLogger.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}