package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchTest extends BaseTest{
    private final static String ITEM_NAME ="Dress";

    @Test(groups = {"Smoke"}, description = "Positive search test")
    public void positiveSearchTest() {
        homePage.setItemNameToSearchInput(ITEM_NAME);
        homePage.clickSearchButton();
        Assert.assertEquals(womenPage.getResultSearchMessageText(), "34 results have been found.");
    }

    @Test(groups = {"Negative"}, description = "Negative search test without request")
    public void negativeSearchTest() {
        homePage.setItemNameToSearchInput("");
        homePage.clickSearchButton();
        Assert.assertTrue(womenPage.resultSearchErrorMessage());
    }
}
