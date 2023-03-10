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
    public int getAmountOfItem() {
        logger.info("Getting amount of item");
        int expResult;
        String result = driver.findElement(WISH_LIST_LOCATOR).getText();
        logger.info("Amount value: {}", result);
        expResult = Integer.parseInt(result);
        return expResult;
    }
}
