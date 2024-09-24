package org.epam.seleniumtests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SampleTests {
    ExtentReports extentReports;
    ExtentSparkReporter spark;

    @BeforeSuite
    public void before(){
        extentReports = new ExtentReports();
        spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        extentReports.attachReporter(spark);
    }

    @Test
    public void verifyEpamContactUsPage() {
        ExtentTest extentTest = extentReports.createTest("EpamContactUs");
        extentTest.log(Status.INFO,"Launching Chrome Browser");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.epam.com/");

        //Go to contact us
        driver.findElement(By.cssSelector("[aria-label='Main navigation']+[data-gtm-category=header-contact-cta]")).click();

        //Verify Contact Us Logo
        WebElement contactUsLogo = driver.findElement(By.xpath("//span[contains(text(),'Contact Us')]"));
        Assert.assertTrue(contactUsLogo.isDisplayed());
        extentTest.pass("Test Success");
        driver.quit();

    }

    @AfterSuite
    public void after(){
        extentReports.flush();
    }
}
