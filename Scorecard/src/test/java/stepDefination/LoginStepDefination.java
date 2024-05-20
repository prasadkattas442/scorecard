package stepDefination;

import baseUtils.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pageObject.LoginPageObject;

public class LoginStepDefination extends BaseClass {

    LoginPageObject lop;

    @Given("user is on Nisum Scorecard Login Page")
    public void user_is_on_Nisum_Scorecard_Login_Page() {
//        driver = new ChromeDriver();
        lop = new LoginPageObject(driver);
        driver.get("https://nisumscorecard-qa.netlify.app/");
        log.info("user is on Nisum Scorecard Login Page");
    }

    @When("user provide {string}")
    public void user_provide(String employeeId) {
        lop.enterEmployeeId(employeeId);

        log.info("user provide");
    }

    @When("press tab and then enter key for submit button")
    public void press_tab_and_then_enter_key_for_submit_button() {
        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
        actions.sendKeys(Keys.TAB, Keys.ENTER).build().perform();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
//        actions.sendKeys(Keys.ENTER).build().perform();
    }

    @When("Click on Submit button")
    public void click_on_submit_button() throws InterruptedException {
        lop.clickSubmit();
        Thread.sleep(5000);
        log.info("Click on Submit button is successful");
    }

    @Then("Verify title of Scorecard homepage {string}")
    public void verify_title_of_scorecard_homepage(String title) {
        String ExpectedTitle = "ScoreCard";
        String ActualTitle = driver.getTitle();
        Assert.assertEquals(ExpectedTitle, ActualTitle);
    }

    @Then("Verify Failure message of Scorecard Login Page {string}")
    public void verify_failure_message_of_scorecard_login_page(String title) {
String errorMsg=title;
        String element = driver.findElement(By.xpath("//span[text()='Not Authorized']")).getText();

        Assert.assertEquals(element, errorMsg);
    }

    @Then("Verify title of Scorecard homepage")
    public void verify_title_of_scorecard_homepage() {

        String ExpectedTitle = "ScoreCard";
        String ActualTitle = driver.getTitle();
        Assert.assertEquals(ExpectedTitle, ActualTitle);


    }
}

