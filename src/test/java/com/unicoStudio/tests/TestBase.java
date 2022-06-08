package com.unicoStudio.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.unicoStudio.utilities.BrowserUtils;
import com.unicoStudio.utilities.ConfigurationReader;
import com.unicoStudio.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    //this class is used for starting nad building reports
    protected static ExtentReports report;
    //this class is used to create HTML report file
    protected static ExtentHtmlReporter htmlReporter;
    //this will  define a test, enables adding logs, authors, test steps
    protected static ExtentTest extentLogger;
    @BeforeTest
    public void setUpTest(){
        //Initialize the Class
        report=new ExtentReports();
        //create a report path
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath = " + projectPath);
        String path = projectPath + "/test-output/report.html";
        System.out.println("path = " + path);

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);
        //attach the html report to report object
        report.attachReporter(htmlReporter);
        //title in report
        htmlReporter.config().setReportName("Vytrack Smoke Test");
        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));

    }

    @BeforeMethod
    public void setUp(){
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        //If test fails
        if(result.getStatus()==ITestResult.FAILURE){
            //record the name of failed test case
            extentLogger.fail(result.getName());

            //take the screen shot and return location of screen shot
            String screenShotPath= BrowserUtils.getScreenshot(result.getName());

            // add SS to your report
            extentLogger.addScreenCaptureFromPath(screenShotPath);

            // capture rhe exceptions  and put inside the report.
            extentLogger.fail(result.getThrowable());

        }

        Thread.sleep(2000);
      //  Driver.closeDriver();
    }
    @AfterMethod
    public void tearDownTest(){
        //this is when the report is actually created
        report.flush();

    }

}
