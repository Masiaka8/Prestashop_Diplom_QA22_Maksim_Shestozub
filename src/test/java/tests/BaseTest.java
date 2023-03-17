package tests;

import com.github.javafaker.Faker;
import dataModels.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import modals.*;
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
    public final String BASE_USERNAME = faker.internet().emailAddress();
    public final String BASE_PASSWORD = faker.internet().password();
    protected WebDriver driver;
    protected HomePage homePage;
    protected AuthenticationFirstStepPage authenticationFirstStepPage;
    protected AuthenticationSecondStepPage authenticationSecondStepPage;
    protected NewUserModal newUserModal;
    protected MyAccountPage myAccountPage;
    protected NewAddressModal newAddressModal;
    protected AddAddressPage addAddressPage;
    protected MyAddressesPage myAddressesPage;
    protected WomenPage womenPage;
    protected ProductDetailsPage productDetailsPage;
    protected BaseModal baseModal;
    protected ShoppingCartPage shoppingCartPage;
    protected MyWishListPage myWishListPage;


    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext testContext) throws Exception {
        String browserName = System.getProperty("browser", "Chrome");
        String headless = System.getProperty("headless", "false");
        if(browserName.equals("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--window-size=1900,600");
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
        authenticationFirstStepPage = new AuthenticationFirstStepPage(driver);
        authenticationSecondStepPage = new AuthenticationSecondStepPage(driver);
        newUserModal = new NewUserModal(driver);
        myAccountPage = new MyAccountPage(driver);
        newAddressModal = new NewAddressModal(driver);
        addAddressPage = new AddAddressPage(driver);
        myAddressesPage = new MyAddressesPage(driver);
        womenPage = new WomenPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        baseModal = new BaseModal(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        myWishListPage = new MyWishListPage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void  navigate() {
        driver.get(BASE_URL);
    }

    @BeforeMethod(onlyForGroups = "LogIn")
    public void registrationNewUser() {
        homePage.clickLoginButton();
        authenticationFirstStepPage.emailNewInput(BASE_USERNAME);
        authenticationFirstStepPage.clickCreateButton();
        User testUser = User.builder()
                .lastName(faker.name().lastName())
                .firstName(faker.name().firstName())
                .password(BASE_PASSWORD)
                .build();
        newUserModal.fillFormUser(testUser);
        authenticationSecondStepPage.clickRegisterButton();
        homePage.clickSignOutButton();
    }

    @AfterClass(alwaysRun = true)
    public void  tearDown() {
        driver.quit();
    }
}