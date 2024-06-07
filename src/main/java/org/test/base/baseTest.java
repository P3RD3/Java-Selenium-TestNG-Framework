package org.test.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.test.utilities.Constants;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class baseTest {

    public static WebDriver driver;
    public static Properties loc = new Properties();
    public static FileReader fr1;

    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;

    public static ExtentTest logger;

    @BeforeTest
    public void beforeTestMethod(){
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ File.separator+"resources"+File.separator+"reports"+File.separator+"TestReport");
        extent = new ExtentReports();
        sparkReporter.config().setTheme(Theme.DARK);
        extent.setSystemInfo("HostName","Alex");
        extent.setSystemInfo("UserName", "root");
        sparkReporter.config().setDocumentTitle("AutomationReport");
        sparkReporter.config().setReportName("Automation Report Test Results");
    }


    @BeforeMethod
    @Parameters("browser")
    public void beforeMethodMethod(String browser, Method testMethod) throws IOException {
        logger = extent.createTest(testMethod.getName());
        setUp(browser);
        driver.manage().window().maximize();
        driver.get(Constants.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"- Test Case Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"- Test Case Failed", ExtentColor.RED));
        } else if (result.getStatus()== ITestResult.SKIP) {
          logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "- Test Case Skipped", ExtentColor.ORANGE));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "- Test Case PASS", ExtentColor.GREEN));
        }
        driver.quit();
        System.out.println("Teardown successful");
    }


    public void setUp(String browser) throws IOException {
        if(driver == null){
            fr1 = new FileReader(System.getProperty("user.dir")+"/src/main/resources/configfiles/locators.properties");

            loc.load(fr1);


        }
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }

}
