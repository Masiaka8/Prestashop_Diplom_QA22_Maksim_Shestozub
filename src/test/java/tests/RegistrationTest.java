package tests;

import dataModels.User;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{

    @Test
    public void newUserRegistrationTest(User testUser){
        homePage.clickLoginButton();
        authenticationOnePage.emailNewInput(userEmail);
        authenticationOnePage.clickCreateButton();
        User.builder()
                .lastName(faker.name().lastName())
                .firstName(faker.name().firstName())
                .password(faker.internet().password())
                .build();
        newUserModal.fillFormUser(testUser);





}




































}
