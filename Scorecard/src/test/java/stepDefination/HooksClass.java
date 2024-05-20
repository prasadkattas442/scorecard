package stepDefination;

import baseUtils.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HooksClass extends BaseClass {


    @Before
    public void setup() {
        readConfig = new Properties();
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            readConfig.load(fis);
        } catch (Exception e) {
            System.out.println();
        }
        log = LogManager.getLogger("stepDefination");
        driver = new ChromeDriver();

    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {


            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());


        }
        driver.close();
        driver.quit();

    }

}
