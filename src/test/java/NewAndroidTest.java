import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class NewAndroidTest {

    AppiumDriver driver; //the appium driver as in selenium for selenium driver

    @BeforeTest //the actions to happen before each test
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities(); //used to begin sessions and use capabilities with appium server
        caps.setCapability("platformName" , "Android");
        caps.setCapability("automationName", "UIAutomator2");

        caps.setCapability("platformVersion" , "5.1.1"); // the android version of the device used or emulator
        caps.setCapability("appActivity" , "com.android.calculator2"); // The app under test which is the built-in mobile calculator app.

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps); //The appium server config. for local host and port
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test //the test case to be executed in the test cycle
    public void clickAppButton(){

        driver.findElementByAccessibilityId("App").click();
//        driver.findElements(ByXPath("//android.widget.button")).get(0).click();
        driver.findElementByXPath("android.widget.button").click();
        driver.findElement(By.name("7")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterTest //the actions to happen after each test
    public void tearDown() {
        if (null!= driver) {
            driver.quit();
        }

    }

}
