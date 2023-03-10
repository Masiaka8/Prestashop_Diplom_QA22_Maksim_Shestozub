package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage{

    private final static By DELETE_ITEM_BUTTON = By.cssSelector(".icon-trash");
    private final static By ITEM_PRICE_LOCATOR = By.cssSelector("#total_price");
    private final static By PROCESSED_TO_CHECKOUT_BUTTON= By.xpath("//*[@class='button btn btn-default standard-checkout button-medium']");
    private final static By PROCESSED_TO_CHECKOUT_BUTTON_FOR_ADDRESS = By.xpath("//*[@class='button btn btn-default button-medium']");
    private final static By I_AGREE_CHECKBOX_LOCATOR = By.cssSelector("#cgv");
    private final static By CHECKOUT_MESSAGE = By.cssSelector(".alert.alert-warning");


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void clickDeleteItemButton() {
        logger.info("Clicking delete button");
        driver.findElement(DELETE_ITEM_BUTTON).click();
    }

    @Step
    public String getItemPrice() {
        logger.debug("Item price {}", getItemPrice());
        return driver.findElement(ITEM_PRICE_LOCATOR).getText();
    }

    @Step
    public void clickProcessedToCheckoutButtonForAddress() {
        logger.info("Clicking ProcessedToCheckout button");
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
        logger.info("Message is displayed");
        return driver.findElement(CHECKOUT_MESSAGE).isDisplayed();
    }
}
