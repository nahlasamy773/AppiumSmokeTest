package tests;

import pages.CalculatorPage;
import base.BaseTest;

public class CalculatorTest extends BaseTest {
    public static void main(String[] args) throws Exception {
        CalculatorTest test = new CalculatorTest();
        test.setUp();

        CalculatorPage calculatorPage = CalculatorPage.getInstance(driver);

        //  2 + 3
        calculatorPage.clickTwo();
        calculatorPage.clickAdd();
        calculatorPage.clickThree();
        calculatorPage.clickEqual();
        Thread.sleep(1000);
        String resultAdd = calculatorPage.getResult();
        System.out.println("Result of 2+3 is: " + resultAdd);

        //  3 − 2
        calculatorPage.clickThree();
        calculatorPage.clickSubtract();
        calculatorPage.clickTwo();
        calculatorPage.clickEqual();
        Thread.sleep(1000);
        String resultSub = calculatorPage.getResult();
        System.out.println("Result of 3-2 is: " + resultSub);

        //  2 × 3
        calculatorPage.clickTwo();
        calculatorPage.clickMultiply();
        calculatorPage.clickThree();
        calculatorPage.clickEqual();
        Thread.sleep(1000);
        String resultMul = calculatorPage.getResult();
        System.out.println("Result of 2*3 is: " + resultMul);


// 6/2
        calculatorPage.clickSix();
        calculatorPage.clickDivide();
        calculatorPage.clickTwo();
        calculatorPage.clickEqual();
        Thread.sleep(1000);
        String resultDiv = calculatorPage.getResult();
        System.out.println("Result of 6/2 is: " + resultDiv);

        test.tearDown();
    }
}
