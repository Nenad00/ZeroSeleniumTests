import Pages.AccountSummaryPage;
import Pages.HomePage;
import Pages.LogInPage;
import Pages.TransferFounds;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TransferFoundTest {
    ChromeOptions chromeOptions = new ChromeOptions();
    private HomePage homePage;
    private LogInPage logInPage;
    private AccountSummaryPage accountSummaryPage;
    private WebDriver driver;
    private TransferFounds transferFounds;

    @BeforeClass
    public void beforeClass(){

        chromeOptions.addArguments("--allow-insencure-localhost");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(chromeOptions);
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);
        accountSummaryPage = new AccountSummaryPage(driver);
        transferFounds = new TransferFounds(driver);


        driver.get("http://zero.webappsecurity.com/login.html");
        logInPage.setUsername();
        logInPage.setPassword();
        logInPage.clickLoginButton();
         accountSummaryPage.clickTransferFounds();
    }

    @Test
    public void TransferFound(){
        transferFounds.clickDropDown();
       transferFounds.clickSelect3option();
       transferFounds.setAmount();
       transferFounds.setDescription();

       transferFounds.clickContinueButton();
       transferFounds.clickSubmitButton();

       String expectedMessage = "You successfully submitted your transaction.";
        Assert.assertEquals(transferFounds.successfulMessage(),expectedMessage);

        String expectedToAcount = "Savings";
        String expectedAmount = "$ 300";
        Assert.assertEquals(transferFounds.fromAccountText(),expectedToAcount);
        Assert.assertEquals(transferFounds.fromAccountText(),expectedToAcount);
        Assert.assertEquals(transferFounds.amountText(),expectedAmount);

    }
    @AfterClass
    public void afterClass(){
        driver.close();
        driver.quit();
    }

}
