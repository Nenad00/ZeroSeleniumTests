import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LogInFeatureTests {
    public static final WebDriver driver = new ChromeDriver();
    static HomePage homePage = new HomePage();


    @Test
    public static void successfulLoginTest () {
        driver.get("http://zero.webappsecurity.com/");
        homePage.clickElement();



        driver.quit();

    }

}
