package org.swiggy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Search for restaurants or dishes']")
    private WebElement searchTextBox;

    @FindBy(xpath = "//span[contains(text(),'Restaurants')]")
    private WebElement selectRestaurantsDiv;

    @FindBy(xpath = "//span[contains(text(),'Dishes')]")
    private WebElement selectDishesDiv;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchRestaurantsAndFood(String searchText) {
        searchTextBox.sendKeys(searchText);
    }

    public void verifySearchResults() {
        selectRestaurantsDiv.isDisplayed();
        selectDishesDiv.isDisplayed();
    }
}
