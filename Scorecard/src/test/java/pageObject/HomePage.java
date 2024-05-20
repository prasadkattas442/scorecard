package pageObject;

import baseUtils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseClass {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
////tbody//td/span[@class='flex items-center']/parent::td/following::td/a/button
    @FindBy(xpath = "//input[@placeholder='Name/Id/Designation/Role']")
    WebElement SearchBar;

    @FindBy(xpath = "//table")
    WebElement table;

    public void searchByEmployeeName(String employeeName) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            String rowText = row.findElement(By.tagName("//table//tbody/tr[1]/td/span[text()='" + employeeName + "']")).getText(); // Adjust based on your table structure

            if (rowText.equals(employeeName)) {
                String cellXPath = row.toString() + "/td[6]";
                WebElement cellToClick = driver.findElement(By.xpath(cellXPath));
                cellToClick.click();
                break;
            }
        }
    }
}
