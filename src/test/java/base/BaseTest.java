package base;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

import utils.ConfigReader;

public class BaseTest {

    public static WebDriver driver;

    @BeforeMethod

    public void setup() throws Exception {

        String execution =
                ConfigReader.getProperty(
                        "execution");

        String browser =
                ConfigReader.getProperty(
                        "browser");

        // LOCAL EXECUTION
        if (execution.equalsIgnoreCase(
                "local")) {

            WebDriverManager.chromedriver()
                    .setup();

            driver = new ChromeDriver();
        }

        // REMOTE EXECUTION
        else if (execution.equalsIgnoreCase(
                "remote")) {

            DesiredCapabilities capabilities =
                    new DesiredCapabilities();

            capabilities.setBrowserName(
                    browser);

            driver = new RemoteWebDriver(

                    new URL(
                            "http://localhost:4444"),

                    capabilities);
        }

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(
                        Duration.ofSeconds(10));

        driver.get(
                ConfigReader.getProperty(
                        "url"));
    }

    @AfterMethod

    public void tearDown() {

        if (driver != null) {

            driver.quit();
        }
    }
}