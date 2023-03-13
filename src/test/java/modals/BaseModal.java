package modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BaseModal extends BasePage {

    private static final By SHOPPING_CART_BUTTON = By.xpath("//*[@class='shopping_cart']/a");
    private static final By HOME_PAGE_LOCATOR = By.cssSelector("#header_logo");

    public BaseModal(WebDriver driver) {
        super(driver);
    }

    public void clickSoppingCartButton() {
        driver.findElement(SHOPPING_CART_BUTTON).click();
    }

    public void goToHomePage() {
        driver.findElement(HOME_PAGE_LOCATOR).click();
    }




}
