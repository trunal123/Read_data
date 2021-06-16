 package test;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import Commanutility.ExtentReportTest;
import Commanutility.Listeners;
import Commanutility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

 public class GMAILENT {

        public static WebDriver driver;
        static Properties prop = new Properties();

        public static void main(String[] Args) throws InterruptedException, IOException, AWTException {
///Call browser method
            browser();
            Log.invokeLogger();
            Log.info("Chrome invoked");


            //Listeners.test.info("trunal testing");
// Call Property file method
            propertyFile();
            Log.info("File is available");
// When calling driver from other method driver will be null
            WebDriver driver = null;
// intitiate new chrome driver
            driver = (WebDriver) new ChromeDriver();

// Maximize window
            windoMaximize(driver);

// get url from property file
            driver.get(prop.getProperty("URL"));

// Get current title
            currentpagetitle(driver.getTitle());

//  get Email from property file
            assertAttributeValueOfElementByID(driver, By.id("identifierId"), "Email");

// Click on Enter
            driver.findElement(By.id("identifierId")).sendKeys(Keys.ENTER);

//  implicit wait
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//   get Password from property file
            assertAttributeValueOfElementByID(driver, By.name("password"), "password");

// Click on Enter
            driver.findElement(By.name("password")).sendKeys(Keys.ENTER);

//  implicit wait
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

// Find Xpath of userID
            assertAttributeValueOfElementByXpath(driver, "//*[@id=\"gb\"]/div[2]/div[3]/div[1]/div[2]/div/a/img");

//  implicit wait
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//  Verify logged in UserID and compare with actual value and Excepted value
            assertAttributeValueOfElementByClass(driver);

            WebElement ActualTitle = driver.findElement(By.className("gb_ob"));

            String ExceptedTitle = "ouchdemo1@gmail.com";
            if (ActualTitle.equals(ExceptedTitle)) {
                currentpagetitle("user logged in  is matching");
            } else {
                currentpagetitle("user logged in  is matching");
            }

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

// Close UserID popup
            assertAttributeValueOfElementByXpath(driver, "//*[@id=\"gb\"]/div[2]/div[3]/div[1]/div[2]/div/a/img");

// Search mail by trunal.thakre@gmail.com ID

            assertAttributeValueOfElementByCssSelector(driver, By.cssSelector("#gs_lc50 > input:nth-child(1)"), "trunal.thakre@gmail.com");

//  Click on Enter

            enterKey();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

// Click on mail for specified Xpath
            assertAttributeValueOfElementByXpath(driver, "//tr[@class = \"zA yO\"] //td[@class = \"yX xY \"]");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

// Click on link available in the mail
            assertAttributeValueOfElementByXpath(driver, "//a[@href='https://www.flickonclick.com/checkout-these-exciting-latest-offers-from-jiomart/']");

// Open link on sext tab
            ArrayList<String> allTabs = new ArrayList<>(driver.getWindowHandles());
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

// Get title of new tab and compare Excepted and Actual value
            String ActualTitle1 = driver.getTitle();
            String ExceptedTitle1 = "checkout these exciting latest offers from jiomart";
            if (ActualTitle.equals(ExceptedTitle)) {
                currentpagetitle("link is matching");
            } else {
                currentpagetitle("link is not matching");
            }

// switch to first window
            switchWindow(driver, allTabs);

// Re verify userID and compare Excepted and Actual value

            WebElement ActualTitle2 = driver.findElement(By.className("gb_ob"));
            String ExceptedTitle2 = "ouchdemo1@gmail.com";
            if (ActualTitle2.equals(ExceptedTitle2)) {
                currentpagetitle("user logged in  is matching");
            } else {
                currentpagetitle("user logged in  is matching");
            }

//Close the browser
            closeTheBrowser(driver);


        }

        private static void enterKey() throws AWTException {
            Robot rb = new Robot();
            rb.keyPress(KeyEvent.VK_ENTER);
        }

        private static void closeTheBrowser(WebDriver driver) {
            driver.quit();
            System.out.println("Browser closed");
        }

        private static void assertAttributeValueOfElementByCssSelector(WebDriver driver, By by, String s) {
            driver.findElement(by).sendKeys(s);
        }

        private static void switchWindow(WebDriver driver, ArrayList<String> allTabs) {
            driver.switchTo().window(allTabs.get(0));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        private static void assertAttributeValueOfElementByXpath(WebDriver driver, String s) {
            driver.findElement(By.xpath(s)).click();
        }

        private static void assertAttributeValueOfElementByClass(WebDriver driver) {
            driver.findElement(By.className("gb_ob"));
        }

        private static void assertAttributeValueOfElementByID(WebDriver driver, By identifierId, String email) {
            assertAttributeValueOfElementByCssSelector(driver, identifierId, prop.getProperty(email));
        }

        private static void currentpagetitle(String title) {
            System.out.println(title);
        }

        private static void windoMaximize(WebDriver driver) {
            driver.manage().window().maximize();

        }

        private static void browser() {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
            //currentpagetitle("Chrome invoked");
        }

        private static void propertyFile() throws IOException {
            FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
            prop.load(fis1);
            //currentpagetitle("File is available");
        }
    }



