package tests;

import dataModels.User;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{

    @Test
    public void newUserRegistrationTest(){
        homePage.clickLoginButton();
        authenticationFirstStepPage.emailNewInput(userEmail);
        authenticationFirstStepPage.clickCreateButton();
        User testUser = User.Builder()
                .lastName(faker.name().lastName())
                .firstName(faker.name().firstName())
                .password(faker.internet().password())
                .build();
        newUserModal.fillFormUser(testUser);





}




































}
