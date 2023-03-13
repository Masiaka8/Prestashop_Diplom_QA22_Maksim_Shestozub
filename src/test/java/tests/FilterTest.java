package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class FilterTest extends BaseTest{

    @Test(groups = {"Regressive"}, description = "Test to check the filter of products on the women page", dataProvider = "filterTestData")
    public void filterTest(String filterName, List<String> itemName) {
        homePage.clickWomenButton();
        womenPage.setFilter(filterName);
        womenPage.waitForLoadingIsDisappear();
        Assert.assertEquals(womenPage.getSortingListItemName(), itemName);
    }
    @DataProvider
    public Object[][] filterTestData() {
        return new Object[][]{
                {"Tops", Arrays.asList("Faded Short Sleeve T-shirts", "Blouse", "Black blouse with flowers",
                        "V Neckline Top - White", "Floral Top", "Stripe Top", "Black Top", "White Top",
                        "Black and white striped top", "Black top", "Blue blouse", "Pink Cotton Shirt")},
                {"Dresses", Arrays.asList("Printed Dress", "Dress", "Printed Summer Dress", "Printed Summer Dress",
                        "Printed Chiffon Dress", "V-back Dress", "V-back Dress","Printed Maxi Dress",
                        "White Lace Cami Romper", "Rainbow Printed Maxi Dress", "Red Dress", "Red Maxi Dress")},
                {"Jackets", Arrays.asList("Red Jacket", "Warm Red Jacket", "Light Pink Jacket", "Long Black Jacket",
                        "White Jacket", "Great White Jacket", "Knitted Beige Jacket", "Wool Light Brown Jacket",
                        "Knitted Brown Jacket", "Elegant Light Jacket", "Bright Blue Jacket", "Light Sleeveless Brown Jacket")},
                {"Shoes", Arrays.asList("Leather shoes in stock", "Elegant Leather shoes in stock", "Leather sandals in stock",
                        "Leather step-ins in stock")},
                {"Bags", Arrays.asList("Leatherette bags in stock", "Stylish leather bags in stock", "Leather bags in stock",
                        "Leather bags with wooden handle in stock", "Braided leather bags in stock", "Leather bags in stock",
                        "Leather light brown bag", "Сrocodile bag" , "Сlutches in stock")},
                {"Suits", Arrays.asList("Grey Suite", "Light Blue Elegant Suite", "Classic Black Suite",
                        "Light Grey Suite", "Elegant Beige Suite", "Black Pantsuit",
                        "Womanly Grey Suite", "Classic Black Medium length Sleeve Suite")},
        };
    }
}