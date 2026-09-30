package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class BaseTest {

    protected static AndroidDriver driver;

    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "RKCW700LLVJ");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        caps.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
//        caps.setCapability("noReset", true);
        caps.setCapability("noReset", false);


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
