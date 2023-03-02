package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertyReader;

public class HomePage  extends BasePage{

    private static final String BASE_URL = PropertyReader.getProperty("base_url");
    private static final By LOGIN_LOCATOR = By.cssSelector("a.login");
    private static final By SEARCH_LOCATOR = By.cssSelector("#search_query_top");
    private static final By WOMEN_BUTTON_LOCATOR = By.cssSelector(".sf-with-ul[title='Women']");
    private static final By SHOPPING_CART_LOCATOR = By.xpath("//div[@class='shopping_cart']/./a");
    private static final By SIGN_OUT_LOCATOR = By.cssSelector("a.logout");
    private static final By MY_ACCOUNT_LOCATOR = By.cssSelector(".account");
    private static final By POPULAR_BUTTON_LOCATOR = By.cssSelector(".homefeatured");
    private static final By BESTSELLERS_BUTTON_LOCATOR = By.xpath("//*[@class='blockbestsellers']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_LOCATOR).click();
    }

    public void clickMyAccountButton() {
        driver.findElement(MY_ACCOUNT_LOCATOR).click();
    }


    public void searchItemToText(String item) {
        WebElement search = driver.findElement(SEARCH_LOCATOR);
        search.sendKeys(item);
        search.sendKeys(Keys.ENTER);
    }

    public void clickWomenButton() {
        driver.findElement(WOMEN_BUTTON_LOCATOR).click();
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void clickOnTheShoppingCart() {
        driver.findElement(SHOPPING_CART_LOCATOR).click();
    }

    public void clickSignOutButton() {
        driver.findElement(SIGN_OUT_LOCATOR).click();
    }
}
