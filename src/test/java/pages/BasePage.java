package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected final Logger logger = LogManager.getLogger(this.getClass().getName());
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    protected void waitForElementDisplayed(By elmentLocator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elmentLocator));
    }

    protected void waitForElementDisappear(By elmentLocator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elmentLocator));
    }

    protected void jsClick(WebElement element)    {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}


