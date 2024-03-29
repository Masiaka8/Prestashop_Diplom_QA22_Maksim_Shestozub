package tests;

import dataModels.Address;
import dataModels.User;
import enums.State;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest{

    private final static String ITEM_NAME ="Faded Short Sleeve T-shirts";

    @Test(groups = {"Smoke", "LogIn"}, description = "Test to payment verification")
    public void checkoutTest() {
        homePage.clickLoginButton();
        authenticationFirstStepPage.setUsername(BASE_USERNAME);
        authenticationFirstStepPage.setPassword(BASE_PASSWORD);
        authenticationFirstStepPage.clickSignInButton();
        myAccountPage.addMyFirstAddress();
        Address testAddress = Address.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().firstName())
                .address(faker.address().streetAddress())
                .zipCode(String.valueOf(faker.number().numberBetween(10000, 99999)))
                .city(faker.address().city())
                .homePhone(faker.phoneNumber().phoneNumber())
                .state(State.ALASKA)
                .addressTitle(faker.name().firstName())
                .build();
        newAddressModal.fillFormAddress(testAddress);
        addAddressPage.clickSaveButton();
        baseModal.goToHomePage();
        homePage.clickWomenButton();
        womenPage.openItemByName(ITEM_NAME);
        productDetailsPage.clickAddToCart();
        productDetailsPage.waitForAddMessage();
        productDetailsPage.clickCloseMessageButton();
        baseModal.clickSoppingCartButton();
        shoppingCartPage.clickProcessedToCheckoutButton();
        shoppingCartPage.clickProcessedToCheckoutButtonForAddress();
        shoppingCartPage.clickCheckboxIAgree();
        shoppingCartPage.clickProcessedToCheckoutButton();
        Assert.assertTrue(shoppingCartPage.checkoutMessage());
    }
}
