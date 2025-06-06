package guru.qa.jupiter;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BrowserScreenExtension implements TestExecutionExceptionHandler, AfterAllCallback, TestWatcher {

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {

        byte[] screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
        // add to Allure
        throw throwable;
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        getWebDriver().close();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        byte[] screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
        // add to Allure
    }
}
