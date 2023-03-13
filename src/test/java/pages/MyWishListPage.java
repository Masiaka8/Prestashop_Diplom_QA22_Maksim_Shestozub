package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyWishListPage extends BasePage{

    private final static By WISH_LIST_AMOUNT_LOCATOR = By.cssSelector(".bold.align_center");
    protected static final By MY_WISH_LIST_LOCATOR = By.xpath("//a[@href='javascript:;' and contains(@onclick, 'javascript:WishlistManage')]");
    private static final String ITEM_ON_WISH_LIST = "//*[@class='product-name' and contains(text(),'%s')]/small/ancestor::p";


    public MyWishListPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public int getAmountOfItem() {
        logger.info("Getting amount of item");
        int expResult;
        String result = driver.findElement(WISH_LIST_AMOUNT_LOCATOR).getText();
        logger.info("Amount value: {}", result);
        expResult = Integer.parseInt(result);
        return expResult;
    }

    @Step
    public void clickMyWishList(){
        logger.info("jsClick on MyWishList");
        jsClick(driver.findElement(MY_WISH_LIST_LOCATOR));
    }

    public boolean itemInWishListIsDisplayed(String itemName) {
        logger.info("Item by name: {} is displayed", itemName);
        return driver.findElement(By.xpath(String.format(ITEM_ON_WISH_LIST, itemName))).isDisplayed();
    }



}
