package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{

    private final static By ADD_TO_CART_BUTTON = By.cssSelector(".buttons_bottom_block.no-print .exclusive");
    private final static By ADDED_MESSAGE = By.cssSelector(".icon-ok");
    private final static By CLOSE_MESSAGE_BUTTON = By.cssSelector(".cross");
    private final static By ADD_TO_WISH_LIST_BUTTON = By.cssSelector("#wishlist_button");
    private final static By ADDED_TO_WISH_LIST_MESSAGE = By.cssSelector(".fancybox-item.fancybox-close");


    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void clickAddToCart() {
        logger.info("Clicking add to cart button");
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    @Step
    public void clickAddToWishList() {
        logger.info("Clicking add to wishlist button");
        driver.findElement(ADD_TO_WISH_LIST_BUTTON).click();
    }

    @Step
    public boolean addedItemMessage() {
        logger.info("Message about added item is displayed");
        return driver.findElement(ADDED_MESSAGE).isDisplayed();
    }

    @Step
    public void waitForAddMessage() {
        logger.info("Wait add message");
        waitForElementDisplayed(ADDED_MESSAGE);
    }

    @Step
    public void clickCloseMessageButton() {
        logger.info("Clicking close button");
        driver.findElement(CLOSE_MESSAGE_BUTTON).click();
    }

    @Step
    public void clickCloseAddToWishListMessage() {
        logger.info("Clicking close add message button");
        driver.findElement(ADDED_TO_WISH_LIST_MESSAGE).click();
    }
}
