package tests;

import dataModels.Address;
import dataModels.User;
import enums.State;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressTest extends BaseTest{

    @Test(groups = {"Regressive", "LogIn"}, description = "Test to add delivery address")
    public void addNewAddress() {
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
        Assert.assertTrue(myAddressesPage.successfulCreatedAddressMessage());
    }
}
