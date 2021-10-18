package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

    public LogInPage(WebDriver driver){
        super(driver);
    }

    @FindBy(className = "page-header")
    private WebElement headerByClassName;

    public boolean isHeaderElementDisplayed() {
    return headerByClassName.isDisplayed();
    }

    public String getHeaderText(){
        return headerByClassName.getText();
    }

    @FindBy(css = "input[name=\"user_login\"")
    private WebElement usernameInputField;

    public void setUsername(){
         usernameInputField.sendKeys("username");
    }

    @FindBy(css = "input[name = \"user_password\"]")
    private WebElement passwordInputField;

    public void setPassword(){
        passwordInputField.sendKeys("password");
    }

    @FindBy(css = "input[name=\"submit\"]")
    private WebElement submitButton;

    public void clickLoginButton(){
        submitButton.click();
    }

    @FindBy(css = "div[class=\"alert alert-error\"]")
    private WebElement errorMessage;

    public String getErrorMessage(){
        return errorMessage.getText();
    }

}
