package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class FilterTest extends BaseTest{

    @Test(groups = {"Regressive"}, description = "Test to check the filter of products on the women page",
            dataProvider = "filterTestData")
    public void filterTest(List<String> expectedItemList) {
        homePage.clickWomenButton();
        womenPage.clickOptionBags();
        womenPage.waitForLoadingIsDisappear();
        Assert.assertEquals(womenPage.getSortingListItemName(), expectedItemList);
    }
    @DataProvider
    public Object[][] filterTestData() {
        return new Object[][]{
                {Arrays.asList("Leatherette bags in stock","Stylish leather bags in stock","Leather bags in stock",
                        "Leather bags with wooden handle in stock","Braided leather bags in stock","Leather bags in stock",
                        "Leather light brown bag","Сrocodile bag" ,"Сlutches in stock")},
        };
    }
}