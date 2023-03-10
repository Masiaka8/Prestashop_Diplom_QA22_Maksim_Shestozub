package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.stream.Collectors;

public class WomenPage extends BasePage{

    private final static By RESULT_SEARCH_MESSAGE = By.xpath("//span[@class='heading-counter']");
    private final static By ERROR_RESULT_SEARCH_MESSAGE = By.cssSelector(".alert.alert-warning");
    private final String PRODUCT_CONTAINER_LOCATOR = "//*[@class='product_img_link' and @title='%s']/ancestor::div[@class='product-container']";
    private final static By PRODUCT_LOCATOR = By.cssSelector(".right-block .product-name");
    private final static By DROPDOWN_SORTING_LOCATOR = By.cssSelector("#selectProductSort");
    private final static By LOADING_ICON_LOCATOR = By.xpath("//*[@class = 'product_list grid row']//img[@src='http://prestashop.qatestlab.com.ua/img/loader.gif' and contains(text(), '')]");
    private final static By ITEM_BUTTON = By.cssSelector("#center_column .product-name");
    private final static By OPTION_BAGS_LOCATOR = By.cssSelector("#uniform-layered_category_16");


    public WomenPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public String getResultSearchMassageText() {
        logger.debug("Message {}", getResultSearchMassageText());
        return driver.findElement(RESULT_SEARCH_MESSAGE).getText();
    }

    @Step
    public boolean resultSearchErrorMessage() {
        logger.info("Message is displayed");
        return driver.findElement(ERROR_RESULT_SEARCH_MESSAGE).isDisplayed();
    }

    @Step
    private WebElement getProductContainerByName(String itemName) {
        logger.debug("Get product container {}", itemName );
        return driver.findElement(By.xpath(String.format(PRODUCT_CONTAINER_LOCATOR, itemName)));
    }

    @Step
    public void openItemByName(String itemName) {
        logger.debug("Open item {}", itemName );
        WebElement productContainer = getProductContainerByName(itemName);
        productContainer.findElement(PRODUCT_LOCATOR).click();
    }

    @Step
    public void selectSortingOrderOption (String optionName) {
        logger.debug("Selecting {}", optionName );
        Select select = new Select(driver.findElement(DROPDOWN_SORTING_LOCATOR));
        select.selectByVisibleText(optionName);
    }

    @Step
    public void waitForLoadingIsDisappear() {
        logger.info("Wait for loading");
        waitForElementDisappear(LOADING_ICON_LOCATOR);
    }

    @Step
    public List<String> getSortingListItemName (){
        List<WebElement> listItemName = driver.findElements(ITEM_BUTTON);
        List<String> allListItemName = listItemName.stream().map(WebElement::getText).collect(Collectors.toList());
        return allListItemName;
    }

    @Step
    public void clickOptionBags() {
        logger.info("Clicking bags checkbox");
        driver.findElement(OPTION_BAGS_LOCATOR).click();
    }
}
