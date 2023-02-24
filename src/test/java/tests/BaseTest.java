package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import modals.newUserModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {
    protected static Faker faker = new Faker();
    public final static String BASE_URL = PropertyReader.getProperty("base_url");
    public final static String BASE_USERNAME = PropertyReader.getProperty("username");
    public final static String BASE_PASSWORD = PropertyReader.getProperty("password");
    protected String userEmail;

    protected String userPassword;
    protected WebDriver driver;
    protected HomePage homePage;
    protected AuthenticationOnePage authenticationOnePage;
    protected AuthenticationTwoPage authenticationTwoPage;
    protected newUserModal newUserModal;


    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext testContext) throws Exception {
        String browserName = System.getProperty("browser", "Chrome");
        String headless = System.getProperty("headless", "false");
        if(browserName.equals("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            if(headless.equals("true")) {
                options.addArguments("--headless");}
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        } else if(browserName.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new Exception("Incorrect browser name");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        testContext.setAttribute("driver", driver);

        homePage = new HomePage(driver);
        authenticationOnePage = new AuthenticationOnePage(driver);
        authenticationTwoPage = new AuthenticationTwoPage(driver);
        newUserModal = new newUserModal(driver);

    }

    public void userRegistration() {
        userEmail = faker.internet().emailAddress();
        //userPassword = faker.internet().password();
    }


    @BeforeMethod(alwaysRun = true)
    public void  navigate() {
        driver.get("http://prestashop.qatestlab.com.ua/en/");
    }

    @AfterClass(alwaysRun = true)
    public void  tearDown() {
        driver.quit();
    }
}