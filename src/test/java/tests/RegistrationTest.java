package tests;

import dataModels.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{

    @Test(groups = {"Smoke"}, description = "Test to registration users")
    public void newUserRegistrationTest() {
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
        Assert.assertTrue(myAccountPage.successfulCreatedMessage());
    }

    @Test(groups = {"Negative"}, description = "Negative registration test")
    public void negativeNewUserRegistrationTest() {
        homePage.clickLoginButton();
        authenticationFirstStepPage.emailNewInput("Qwedwd@gmail.");
        authenticationFirstStepPage.clickCreateButton();
        authenticationFirstStepPage.waitForInvalidMessage();
        Assert.assertTrue(authenticationFirstStepPage.invalidEmailMessage());
    }
}
