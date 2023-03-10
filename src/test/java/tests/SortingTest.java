package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class SortingTest extends BaseTest{

    @Test(groups = {"Regressive"}, description = "Test to check the sorting of products on the women page",
            dataProvider = "sortingTestData")
    public void sortingTest(String optionName, List<String> expectedItemList) {
        homePage.clickWomenButton();
        womenPage.selectSortingOrderOption(optionName);
        womenPage.waitForLoadingIsDisappear();
        Assert.assertEquals(womenPage.getSortingListItemName(), expectedItemList);
    }
    @DataProvider()
    public Object[][] sortingTestData() {
        return new Object[][]{
                {"--", Arrays.asList("Faded Short Sleeve T-shirts", "Blouse", "Printed Dress",
                        "Dress", "Printed Summer Dress", "Printed Summer Dress","Blue Printed Maxi Dress",
                        "Printed Chiffon Dress","Black blouse with flowers","V Neckline Top - White",
                        "V-back Dress","Floral Top")},
                {"Price: Lowest first", Arrays.asList("Printed Chiffon Dress","Faded Short Sleeve T-shirts","Printed Dress", "Blouse",
                        "Printed Summer Dress","Printed Summer Dress", "Dress", "White Top",
                        "Black top","Red Dress", "White Lace Cami Romper","Blue blouse")},
                {"Price: Highest first", Arrays.asList("Red Maxi Dress", "Classic Black Suite",
                        "Classic Black Medium length Sleeve Suite", "Black Pantsuit", "Long Black Jacket","Elegant Beige Suite",
                        "Knitted Beige Jacket","Womanly Grey Suite","Light Grey Suite",
                        "Warm Red Jacket","Light White Sweater","Knitted Brown Jacket")},
                {"Product Name: A to Z", Arrays.asList("Abstract Print Summer Dress", "Air Red Dress", "Black and white striped top",
                        "Black And White Stripes T-shirt", "Black And White Stripes Top", "Black blouse with flowers","Black Bodycon Dress",
                        "Black Chiffon Dress","Black Pantsuit","Black top",
                        "Black Top","Blouse")},
                {"Product Name: Z to A", Arrays.asList("Сrocodile bag", "Сlutches in stock", "Yellow Cotton T - Shirt",
                        "Wool Light Brown Jacket", "Womanly Grey Suite", "White Top","White Top",
                        "White Lace Cami Romper","White Jacket","White Crisscross Back Shift Dress",
                        "White Cotton Top","White Cotton Shirt")},
        };
    }
}
