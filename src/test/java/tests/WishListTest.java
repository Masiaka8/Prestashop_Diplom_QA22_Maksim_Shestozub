package tests;

import dataModels.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListTest extends BaseTest{

    private final static String ITEM_NAME ="Faded Short Sleeve T-shirts";


    @Test(groups = {"Regressive"}, description = "Test to add item in wishlist")
    public void addItemToWishlist() {
        homePage.clickLoginButton();
        authenticationFirstStepPage.emailNewInput(userEmail);
        authenticationFirstStepPage.clickCreateButton();
        User testUser = User.builder()
                .lastName(faker.name().lastName())
                .firstName(faker.name().firstName())
                .password(faker.internet().password())
                .build();
        newUserModal.fillFormUser(testUser);
        authenticationSecondStepPage.clickRegisterButton();
        baseModal.goToHomePage();
        homePage.clickWomenButton();
        womenPage.openItemByName(ITEM_NAME);
        productDetailsPage.clickAddToWishList();
        productDetailsPage.clickCloseAddToWishListMessage();
        homePage.clickMyAccountButton();
        myAccountPage.clickWishListButton();
        Assert.assertEquals(myWishListPage.getAmountOfItem(), 1);
    }
}
