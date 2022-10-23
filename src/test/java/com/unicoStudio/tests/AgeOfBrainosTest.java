package com.unicoStudio.tests;

import com.unicoStudio.pages.AboutPage;
import com.unicoStudio.pages.CareersPage;
import com.unicoStudio.pages.HomePage;
import com.unicoStudio.utilities.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AgeOfBrainosTest extends TestBase{

    AboutPage aboutPage=new AboutPage();
    HomePage homePage=new HomePage();
    Set<String> windowHandles;
    Iterator t;

    @Test
    public void AgeOfBrainosTest1() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", homePage.ageOfBrainosBtn);
        windowHandles = driver.getWindowHandles();
        t = windowHandles.iterator();
        String mainPage  = (String) t.next();
        String newWindow= (String) t.next();
        driver.switchTo().window(newWindow);
        BrowserUtils.waitForPageToLoad(1);
        BrowserUtils.waitFor(1);
        String ageOfBrainosTitle = driver.getTitle();
        System.out.println("careersPageTitle = " + ageOfBrainosTitle);
        Assert.assertTrue(ageOfBrainosTitle.contains("Brainos")); //
        driver.close();
        driver.switchTo().window(mainPage);

    }

}

