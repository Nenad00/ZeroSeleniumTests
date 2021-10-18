import Pages.AccountSummaryPage;
import Pages.HomePage;
import Pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogInFeatureTests {
    ChromeOptions chromeOptions = new ChromeOptions();
    private HomePage homePage;
    private LogInPage logInPage;
    private AccountSummaryPage accountSummaryPage;
    private WebDriver driver;


   public String expectedHeaderString = "Log in to ZeroBank";
   @BeforeClass
   public void beforeClass(){

       chromeOptions.addArguments("--allow-insencure-localhost");
       chromeOptions.addArguments("--incognito");
       chromeOptions.addArguments("--ignore-certificate-errors");

       driver = new ChromeDriver(chromeOptions);
       homePage = new HomePage(driver);
       logInPage = new LogInPage(driver);
       accountSummaryPage = new AccountSummaryPage(driver);


       driver.get("http://zero.webappsecurity.com/login.html");

   }

   @Test(priority = 1)
   public void IncorectLogInForm () {
       logInPage.setUsername();
       logInPage.clickLoginButton();
       String expectedMessage = "Login and/or password are wrong.";
       Assert.assertEquals(logInPage.getErrorMessage(),expectedMessage);

   }

    @Test(priority = 2)
    public void successfulLoginTest () {

        logInPage.setUsername();
       logInPage.setPassword();
       logInPage.clickLoginButton();

       String expectedUrl = "account-summary.html";
       String currentUrl = driver.getCurrentUrl();
       boolean isCorrectUrl = currentUrl.contains(expectedUrl);
       Assert.assertTrue(isCorrectUrl);

   }

    @AfterClass
    public void afterClass(){
        driver.close();
        driver.quit();
    }

}
