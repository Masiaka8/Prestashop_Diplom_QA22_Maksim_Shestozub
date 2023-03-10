package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyWishListPage extends BasePage{

    private final static By WISH_LIST_LOCATOR = By.cssSelector(".bold.align_center");


    public MyWishListPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public String getAmountOfItem() {
        logger.debug("Amount of item {}", getAmountOfItem());
        return driver.findElement(WISH_LIST_LOCATOR).getText();
    }
}
