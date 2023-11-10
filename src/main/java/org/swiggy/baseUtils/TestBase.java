package org.swiggy.baseUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.swiggy.pages.HomePage;
import org.swiggy.pages.SearchPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    private static Properties properties = new Properties();
    public static Logger log = Logger.getLogger(TestBase.class);

    public static HomePage homePage;
    public static SearchPage searchPage;

    public static void setup() {
        loadProperties();
        setUpDriver();
        initializePages();
        navigateToURL();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        log.info("Browser Opened");
    }

    public static void initializePages() {
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
    }

    private static void loadProperties() {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config/config.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setUpDriver() {
        String browserType = properties.getProperty("browser.type");

        if (browserType.equalsIgnoreCase("chrome")) {
            setupChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            setupFirefoxDriver();
        } // Add more browser setups if needed
    }

    private static void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Add any specific Chrome options if needed
        driver = new ChromeDriver(options);
    }

    private static void setupFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        // Add any specific Firefox options if needed
        driver = new FirefoxDriver(options);
    }

    private static void navigateToURL() {
        String baseUrl = properties.getProperty("project.url");
        driver.get(baseUrl);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            log.info("Browser closed");
        }
    }
}
