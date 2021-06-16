package Commanutility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
public class ExtentReportTest {


    static ExtentReports extent;

    public static ExtentReports getReportObject(){
        //String path = System.getProperty("user.dir")+"\\report\\extentreport.html";
        String path = System.getProperty("user.dir")+"/report/extentreport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("GstHero Automation Report");
        reporter.config().setDocumentTitle("Test results");
        reporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Nitin");
        return extent;
    }


}
