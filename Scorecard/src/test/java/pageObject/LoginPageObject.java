package pageObject;

import baseUtils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageObject extends BaseClass {
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement employeeId;
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitButton;




    public String enterEmployeeId(String employeeId) {
        this.employeeId.sendKeys(employeeId);
        return employeeId;
    }

    public void clickSubmit() {
        submitButton.click();
    }


}
