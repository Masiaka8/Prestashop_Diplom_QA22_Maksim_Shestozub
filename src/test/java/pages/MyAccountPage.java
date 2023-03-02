package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{

    private static final By ACCOUNT_HAS_BEEN_CREATED_MESSAGE = By.cssSelector(".alert.alert-success");
    private static final By ADD_ADDRESS_LOCATOR = By.cssSelector(".icon-building");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean successfulCreatedMessage(){
        return driver.findElement(ACCOUNT_HAS_BEEN_CREATED_MESSAGE).isDisplayed();
    }

    public void addMyFirstAddress(){
        driver.findElement(ADD_ADDRESS_LOCATOR).click();
    }


}
