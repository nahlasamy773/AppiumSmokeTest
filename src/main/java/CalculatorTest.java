import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class CalculatorTest {
    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "RKCW700LLVJ"); // اسم الجهاز من adb devices
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        caps.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

        caps.setCapability("noReset", true);

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // تجربة بسيطة: 2 + 3
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02"))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03"))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"))).click();




// استنى ثانية علشان النتيجة تظهر
        Thread.sleep(1000); // استنى ثانية بعد الضغط على =

        String rawResult = driver.findElement(
                By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();

// نظف النص وخلي الرقم بس
        String result = rawResult.replace("Calculation result", "").trim();

        System.out.println("Result is: " + result);




        Thread.sleep(3000);
        driver.quit();
    }
}
