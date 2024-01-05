package com.fiserv.testframework.tests;

import com.fiserv.testframework.pages.SearchResultsPage;
import com.fiserv.testframework.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchEngineTest {
    private WebDriver driver;
    private SearchResultsPage searchResultsPage;
    private static final Logger logger = LogManager.getLogger(SearchEngineTest.class);

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.createChromeDriver();
        searchResultsPage = new SearchResultsPage(driver);
    }

    @DataProvider(name = "searchTerms")
    public Object[][] searchData() {
        return new Object[][]{
                {"Java Programming"},
                {"Test Automation"},
                // Add more search terms as needed
        };
    }

    @Test(dataProvider = "searchTerms")
    public void testSearchEngine(String searchTerm) {
        logger.info("Starting test for search term: {}", searchTerm);

        // Navigate to the search engine
        driver.get("https://www.google.com");

        // Perform a search
        // ...

        // Get the first result from the search results page
        String actualResult = searchResultsPage.getFirstResultText();

        // Assert the result
        Assert.assertTrue(actualResult.contains(searchTerm),
                "Expected result to contain the search term: " + searchTerm);

        logger.info("Test completed successfully");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
