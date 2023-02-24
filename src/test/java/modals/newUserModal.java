package modals;

import elements.Input;
import org.openqa.selenium.WebDriver;
import dataModels.User;

public class newUserModal extends BaseModal {

    public newUserModal(WebDriver driver) {
        super(driver);
    }


    public void fillFormUser(User user) {
        new Input(driver, "customer_firstname").setValue(user.getFirstName());
        new Input(driver, "customer_lastname").setValue(user.getLastName());
        new Input(driver, "passwd").setValue(user.getPassword());
    }
}