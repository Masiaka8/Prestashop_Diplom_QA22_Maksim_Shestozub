package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAddressesPage extends BasePage{

    private static final By SUCCESS_ADD_ADDRESSES_LOCATOR = By.cssSelector("[title='Update']");

    public MyAddressesPage(WebDriver driver) {
        super(driver);
    }

    public boolean successfulCreatedAddressMessage(){
        return driver.findElement(SUCCESS_ADD_ADDRESSES_LOCATOR).isDisplayed();
    }

}
