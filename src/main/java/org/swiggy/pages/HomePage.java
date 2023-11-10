package org.swiggy.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Search')]")
    private WebElement searchField;
    @FindBy(xpath = "//h2[contains(text(),'Best offers for you')]")
    private WebElement bestOffersHeader;
    @FindBy(xpath = "//h2[contains(text(),'What's on your mind?')]")
    private WebElement foodTypeHeader;
    public Logger log = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyHomePageLoaded() {
        bestOffersHeader.isDisplayed();
        foodTypeHeader.isDisplayed();
        log.info("Home Page Loaded");
    }

    public void navigateToSearchPage() {
        searchField.click();
        log.info("search field clicked");
    }
}
