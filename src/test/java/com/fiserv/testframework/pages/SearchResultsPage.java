package com.fiserv.testframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    private WebElement getSearchResultElement() {
        By searchResultSelector = By.cssSelector("h3");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultSelector));
    }

    public String getFirstResultText() {
        WebElement firstResult = getSearchResultElement();
        return firstResult.getText();
    }

    public void clickOnFirstResult() {
        WebElement firstResult = getSearchResultElement();
        firstResult.click();
    }

}
