package Commanutility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.inject.BindingAnnotation;
import com.google.inject.name.Named;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.naming.Name;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class Listeners implements ITestListener {


    public static ExtentTest test;
    ExtentReports extent = ExtentReportTest.getReportObject();


    @Override
    public void onTestStart(ITestResult result) {
        boolean desc = result.getMethod().getDescription().isEmpty();
        if(desc == true){
            test = extent.createTest(result.getMethod().getMethodName(),""+result.getMethod().getTestClass().getRealClass().getSimpleName());
            test.log(Status.INFO,"Test Method Name: "+result.getMethod().getMethodName());
        }
        else {
            test = extent.createTest(result.getMethod().getDescription(),""+result.getMethod().getTestClass().getRealClass().getSimpleName());
            //test = extent.createTest(result.getMethod().getDescription());
            test.log(Status.INFO,"Test Case Name: "+result.getMethod().getDescription());
            test.log(Status.INFO,"Test Method Name: "+result.getMethod().getMethodName());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL,"Test Faild");
        test.log(Status.FAIL,result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP,"Test skipped" +result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
