/**
 * Created by hillel on 30.06.17.
 */

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MyCode.Validator;

public class Tests {

    Validator myValidator;

    @BeforeTest
    void setUp(){
        System.out.println("Created Object");
        myValidator = new Validator();
    }

    @AfterMethod
    void afterM(ITestResult testResult){
        System.out.print(testResult.isSuccess() + "\t | \t");
        System.out.print(testResult.getParameters()[0] + "\t | \t");
        System.out.println(testResult.getMethod().getDescription());
    }

    // ---------- numbers ---------------------

    @DataProvider(name = "TestData")
    public Object[][] createData(){
        return new Object[][] {
                {"6000", Boolean.TRUE},
                {"6000,1", Boolean.FALSE},
                {"6000,10000", Boolean.TRUE},
                {"6000.10", Boolean.TRUE}
        };
    }

    @Test(dataProvider = "TestData", description = "Test for Numbers Validation")
    void Positive(String testString, Boolean expectedResult){
        Assert.assertEquals( (Boolean) myValidator.numbers(testString), expectedResult,"Bad input " + testString);
    }


    // ---------- emails ---------------------


    @DataProvider(name = "TestDataEmails")
    public Object[][] createDataEmails(){
        return new Object[][] {
                {"test@google.com,test2@gmail.com", Boolean.TRUE},
                {"test", Boolean.FALSE}
        };
    }

    @Test(dataProvider = "TestDataEmails", description = "Test for Emails Validation")
    void PositiveEmail(String testString, Boolean expectedResult){
        Assert.assertEquals( (Boolean) myValidator.emails(testString), expectedResult,"Bad input " + testString);
    }


    // ---------- replacement ---------------------


    @DataProvider(name = "TestDataReplacement")
    public Object[][] createDataReplacement(){
        return new Object[][] {
                {"hello I'm a java dev", "MASTER", Boolean.TRUE},
                {"software engineer", "MASTER", Boolean.FALSE},
        };
    }

    @Test(dataProvider = "TestDataReplacement", description = "Test for Emails Validation")
    void PositiveReplacement(String testString, String repleceString, Boolean expectedResult){

        Boolean status;
        String result = myValidator.replacement(testString, repleceString);

        Assert.assertEquals( (Boolean) ( result.indexOf(repleceString) != -1 ), expectedResult,"Bad input " + testString);
    }


//    @Parameters({"input"})
//    @Test
//    public static void Negative(String testString){
//        System.out.println(testString);
//        Assert.assertFalse(Validator.isNumberBetween(testString), "Bad input " + testString);    }
}
