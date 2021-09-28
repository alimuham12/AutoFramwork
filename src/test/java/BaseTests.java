package test.java;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import main.java.utils.Constants;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    public static WebDriver driver;
    public ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;


    @BeforeTest
    public void beforeTestMethod()
    {

        htmlReporter = new ExtentSparkReporter(System.getProperty("C:\\Users\\IVL-Muhammad\\IdeaProjects\\AutoFramwork\\reports")+ "Report.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Reports of Automated Test cases");
        htmlReporter.config().setReportName("Test Results");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Quality Assurance Engineer","Muhammad Ali");


    }

    @BeforeMethod
    @Parameters(value = "browserName")
    public void beforeMethodMethod(String browserName, Method testMethod)
    {
        setupDriver(browserName);
        driver.manage().window().maximize();
        driver.get(Constants.url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethodMethod(ITestResult result)
    {
        if (result.getStatus()==ITestResult.SUCCESS)
        {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case : " + methodName + "Passed";
 //           Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
//            logger.log(Status.PASS, m);
        }

        else if(result.getStatus()==ITestResult.FAILURE)
        {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case : " + methodName + "Failed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL, m);



        }

        else if(result.getStatus()==ITestResult.SKIP)
        {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case : " + methodName + "Skipped";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
            logger.log(Status.SKIP, m);



        }

        driver.quit();

    }

    @AfterTest
    public void afterTestMethod()
    {
        extent.flush();

    }

    public void setupDriver(String browserName)
    {
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\IVL-Muhammad\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver =new ChromeDriver();

        }
        else if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","C:\\Users\\IVL-Muhammad\\Downloads\\chromedriver_win32\\geckodriver.exe");
            driver =new FirefoxDriver();

        }
        else
        {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\IVL-Muhammad\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver =new ChromeDriver();

        }
    }

}
