package org.epam.seleniumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SampleTests {

    @Test
    public void verifyEpamContactUsPage() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.epam.com/");

        //Go to contact us
        driver.findElement(By.cssSelector("[aria-label='Main navigation']+[data-gtm-category=header-contact-cta]")).click();

        //Verify Contact Us Logo
        WebElement contactUsLogo = driver.findElement(By.xpath("//span[contains(text(),'Contact Us')]"));
        Assert.assertTrue(contactUsLogo.isDisplayed());
        driver.quit();

    }
}
