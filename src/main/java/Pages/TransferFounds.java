package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TransferFounds extends BasePage {

    public TransferFounds(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "tf_toAccountId")
    private WebElement dropDown;

    public void clickDropDown(){
        dropDown.click();
    }


   @FindBy(css = "select[id =\"tf_toAccountId\"]>option[value =\"3\"]")
    private WebElement Select3option;

    public void clickSelect3option(){
        Select3option.click();
    }

    @FindBy(id = "tf_amount")
    private  WebElement amount;

    public void setAmount(){
        amount.sendKeys("300");
    }

  @FindBy(id = "tf_description")
    private WebElement description;

    public void setDescription(){
        description.sendKeys("nesto Jako");
    }

    @FindBy(id = "btn_submit")
    private WebElement continueButton;

    public void clickContinueButton(){
        continueButton.click();
    }

    @FindBy(id = "btn_submit")
    private WebElement submitButton;

    public void clickSubmitButton(){
        submitButton.click();
    }

    @FindBy(css = "div[class = \"alert alert-success\"]")
    private WebElement successfulMessage;

    public String successfulMessage(){
        return successfulMessage.getText();
    }


    @FindBy(css ="div [class = \"row\"]>div[class = \"span3\"]")
    List<WebElement> results;

    public String fromAccountText(){
        return results.get(0).getText();
    }

    public String toAccountText(){
        return results.get(1).getText();
    }

    public String amountText(){
        return results.get(2).getText();
    }



}
