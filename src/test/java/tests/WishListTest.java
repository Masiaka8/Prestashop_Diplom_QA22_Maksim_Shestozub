package tests;

import dataModels.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListTest extends BaseTest{

    private final static String ITEM_NAME ="Faded Short Sleeve T-shirts";


    @Test(groups = {"Regressive", "LogIn"}, description = "Test to add item in wishlist")
    public void addItemToWishlist() {
        homePage.clickLoginButton();
        authenticationFirstStepPage.setUsername(BASE_USERNAME);
        authenticationFirstStepPage.setPassword(BASE_PASSWORD);
        authenticationFirstStepPage.clickSignInButton();
        homePage.clickWomenButton();
        womenPage.openItemByName(ITEM_NAME);
        productDetailsPage.clickAddToWishList();
        productDetailsPage.clickCloseAddToWishListMessage();
        homePage.clickMyAccountButton();
        myAccountPage.clickWishListButton();
        Assert.assertEquals(myWishListPage.getAmountOfItem(), 1);
        myWishListPage.clickMyWishList();
        Assert.assertTrue(myWishListPage.itemInWishListIsDisplayed(ITEM_NAME));
    }
}
