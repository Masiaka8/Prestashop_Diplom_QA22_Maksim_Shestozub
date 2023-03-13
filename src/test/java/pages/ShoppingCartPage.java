package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage{

    private final static By DELETE_ITEM_BUTTON = By.cssSelector(".icon-trash");
    private final static By ITEM_PRICE_LOCATOR = By.cssSelector("#total_price");
    private final static By PROCESSED_TO_CHECKOUT_BUTTON= By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium");
    private final static By PROCESSED_TO_CHECKOUT_BUTTON_FOR_ADDRESS = By.xpath("//*[@class='button btn btn-default button-medium']");
    private final static By I_AGREE_CHECKBOX_LOCATOR = By.cssSelector("#cgv");
    private final static By CHECKOUT_MESSAGE = By.cssSelector(".alert.alert-warning");
    private final static By ITEM_LOCATOR = By.xpath("//td/p[@class='product-name']/a");


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void clickDeleteItemButton() {
        logger.info("Clicking delete button");
        driver.findElement(DELETE_ITEM_BUTTON).click();
    }

    @Step
    public void waitFarTrashButtonIsDisappear() {
        logger.info("Wait for trashButton is disappear");
        waitForElementDisappear(DELETE_ITEM_BUTTON);
    }

    @Step
    public String getItemPrice() {
        logger.info("Getting item price");
        String itemPrice = driver.findElement(ITEM_PRICE_LOCATOR).getText();
        logger.info("Price value: {}", itemPrice);
        return itemPrice;
    }

    @Step
    public void clickProcessedToCheckoutButtonForAddress() {
        logger.info("Clicking ProcessedToCheckout for address button");
        driver.findElement(PROCESSED_TO_CHECKOUT_BUTTON_FOR_ADDRESS).click();
    }

    @Step
    public void clickProcessedToCheckoutButton() {
        logger.info("Clicking ProcessedToCheckout button");
        driver.findElement(PROCESSED_TO_CHECKOUT_BUTTON).click();
    }

    @Step
    public void clickCheckboxIAgree() {
        logger.info("Clicking IAgree checkbox");
        driver.findElement(I_AGREE_CHECKBOX_LOCATOR).click();
    }

    @Step
    public boolean checkoutMessage() {
        logger.info("Message about buying is displayed");
        return driver.findElement(CHECKOUT_MESSAGE).isDisplayed();
    }

    public String getItemName() {
        logger.info("Getting item name");
        String itemName = driver.findElement(ITEM_LOCATOR).getText();
        logger.info("Item name: {}", itemName);
        return itemName;
    }
}
