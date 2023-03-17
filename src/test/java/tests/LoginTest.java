package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test(retryAnalyzer = RetryAnalyzer.class, groups = {"Smoke", "LogIn"}, description = "Authorization test")
    public void positiveLoginTest() {
        homePage.clickLoginButton();
        authenticationFirstStepPage.setUsername(BASE_USERNAME);
        authenticationFirstStepPage.setPassword(BASE_PASSWORD);
        authenticationFirstStepPage.clickSignInButton();
        Assert.assertTrue(myAccountPage.successfulSignInMessage());
    }

    @Test(groups = {"Negative"}, description = "Negative authorization test")
    public void negativeLoginTest() {
        homePage.clickLoginButton();
        authenticationFirstStepPage.setUsername("qweqwe@gmail.");
        authenticationFirstStepPage.setPassword("123123123");
        authenticationFirstStepPage.clickSignInButton();
        Assert.assertTrue(authenticationFirstStepPage.invalidEmailMessage());
    }

    @Test(groups = {"Regressive", "LogIn"}, description = "Test to check sign out button")
    public void logOutTest() {
        homePage.clickLoginButton();
        authenticationFirstStepPage.setUsername(BASE_USERNAME);
        authenticationFirstStepPage.setPassword(BASE_PASSWORD);
        authenticationFirstStepPage.clickSignInButton();
        baseModal.goToHomePage();
        homePage.clickSignOutButton();
        Assert.assertTrue(homePage.signInIsDisplayed());
    }
}
