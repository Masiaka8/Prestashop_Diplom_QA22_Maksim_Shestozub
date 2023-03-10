package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    private final static String ITEM_NAME ="Faded Short Sleeve T-shirts";

    @Test(groups = {"Smoke"}, description = "Test to payment verification")
    public void addItemToCartTest() {
        homePage.clickWomenButton();
        womenPage.openItemByName(ITEM_NAME);
        productDetailsPage.clickAddToCart();
        productDetailsPage.waitForAddMessage();
        Assert.assertTrue(productDetailsPage.addedItemMessage());
    }

    @Test(groups = {"Regressive"}, description = "Always failing test to delete item")
    public void removeItemFromCartTest() {
        homePage.clickWomenButton();
        womenPage.openItemByName(ITEM_NAME);
        productDetailsPage.clickAddToCart();
        productDetailsPage.waitForAddMessage();
        productDetailsPage.clickCloseMessageButton();
        baseModal.clickSoppingCartButton();
        shoppingCartPage.clickDeleteItemButton();
        Assert.assertEquals(shoppingCartPage.getItemPrice(), 0);
    }
}
