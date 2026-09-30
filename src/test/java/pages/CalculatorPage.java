package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class CalculatorPage {
    private static CalculatorPage instance;
    private AndroidDriver driver;
    private WebDriverWait wait;

    private CalculatorPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));


    }


    public static CalculatorPage getInstance(AndroidDriver driver) {
        if (instance == null) {
            instance = new CalculatorPage(driver);
        }
        return instance;
    }

    // Locators
    private By btnTwo = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02");
    private By btnThree = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03");
    private By btnAdd = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add");
    private By btnEqual = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal");
    private By btnSubtract = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_sub"); //
    private By btnMultiply = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_mul");

    private By btnDivide = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_div");
    private By resultField = By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula");
    private By btnSix = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_06");


    // Actions

    // Actions with wait
    public void clickTwo() { wait.until(ExpectedConditions.elementToBeClickable(btnTwo)).click(); }
    public void clickThree() { wait.until(ExpectedConditions.elementToBeClickable(btnThree)).click(); }
    public void clickAdd() { wait.until(ExpectedConditions.elementToBeClickable(btnAdd)).click(); }
    public void clickSubtract() { wait.until(ExpectedConditions.elementToBeClickable(btnSubtract)).click(); }
    public void clickMultiply() {
        wait.until(ExpectedConditions.elementToBeClickable(btnMultiply)).click();
    }
    public void clickDivide() {
        wait.until(ExpectedConditions.elementToBeClickable(btnDivide)).click();
    }

    public void clickSix() {
        wait.until(ExpectedConditions.elementToBeClickable(btnSix)).click();
    }



    public void clickEqual() { wait.until(ExpectedConditions.elementToBeClickable(btnEqual)).click(); }


    public String getResult() {
        String rawResult = wait.until(ExpectedConditions.presenceOfElementLocated(resultField)).getText();

        return rawResult.replace("Calculation result", "").trim();
    }
}
