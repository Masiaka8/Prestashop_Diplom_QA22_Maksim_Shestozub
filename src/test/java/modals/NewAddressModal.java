package modals;

import dataModels.Address;
import elements.*;
import org.openqa.selenium.WebDriver;

public class NewAddressModal extends BaseModal {

    public NewAddressModal(WebDriver driver) {
        super(driver);
    }

    public void fillFormAddress(Address address) {
        new Input(driver, "firstname").setValue(address.getFirstName());
        new Input(driver, "lastname").setValue(address.getLastName());
        new Input(driver, "address1").setValue(address.getAddress());
        new Input(driver, "postcode").setValue(address.getZipCode());
        new Input(driver, "city").setValue(address.getCity());
        new Input(driver, "phone").setValue(address.getHomePhone());
        new Dropdown(driver, "id_state").selectDropdownValue(address.getState().getName());
        new Input(driver, "city").setValue(address.getCity());
        new Input(driver, "alias").setValue(address.getAddressTitle());
    }
}
