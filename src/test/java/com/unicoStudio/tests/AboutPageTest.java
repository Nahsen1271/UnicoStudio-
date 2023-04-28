package com.unicoStudio.tests;

import com.unicoStudio.pages.AboutPage;
import com.unicoStudio.pages.AllPages;
import com.unicoStudio.pages.HomePage;
import com.unicoStudio.utilities.BrowserUtils;
import com.unicoStudio.utilities.ConfigurationReader;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;

public class AboutPageTest extends TestBase {



    AllPages allPages;
    JavascriptExecutor jse;
    Set<String> windowHandles;
    Iterator t;
    String mainPage ;
    String newWindow ;

   @Test
    public void aboutGeneralTextTest() {
        BrowserUtils.waitFor(1);
        allPages = new AllPages();
        BrowserUtils.waitForClickablility(allPages.homePage().aboutBtn,10);
        allPages.homePage().aboutBtn.click();
        String aboutPageTitle = driver.getTitle();
        System.out.println("aboutPageTitle = " + aboutPageTitle);
        Assert.assertTrue(aboutPageTitle.contains("About"));

        String whoWeAreText = allPages.aboutPage().whoWeAre.getText();
        System.out.println("whoWeAreText = " + whoWeAreText);


        String theTeamText = allPages.aboutPage().theTeam.getText();
        System.out.println("theTeamText = " + theTeamText);

        String theTeamInfText = allPages.aboutPage().theTeamInf.getText();
        System.out.println("theTeamInfText = " + theTeamInfText);


    }

    /* Facebook test*/
    @Test
    public void aboutPageFacebookTest() {

        jse = (JavascriptExecutor) driver;
        BrowserUtils.waitFor(1);
        allPages= new AllPages();
        allPages.homePage().aboutBtn.click();
        BrowserUtils.waitFor(1);
        jse.executeScript("arguments[0].scrollIntoView(true);", allPages.aboutPage().googlePlayAboutBtn); //Scroll down the page
        BrowserUtils.waitFor(1);
        //aboutPage.aboutPageFB.click();
        jse.executeScript("arguments[0].click();",allPages.aboutPage().aboutPageFB);
        windowHandles = driver.getWindowHandles();
        t = windowHandles.iterator();
        mainPage = (String) t.next();
        newWindow = (String) t.next();
        driver.switchTo().window(newWindow);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitFor(10);
        String actFacebook = driver.getTitle();
        System.out.println("actFacebook = " + actFacebook);
        Assert.assertEquals(actFacebook, ConfigurationReader.get("expFacebook"));


    }

    /* Twitter test*/
        @Test
        public void aboutPageTwitterTest() {
            jse = (JavascriptExecutor) driver;
            BrowserUtils.waitFor(1);
            allPages= new AllPages();
            BrowserUtils.waitForClickablility(allPages.homePage().aboutBtn,10);
            allPages.homePage().aboutBtn.click();
            BrowserUtils.waitFor(1);
            jse.executeScript("arguments[0].scrollIntoView(true);",allPages.aboutPage().aboutPageTW);
            BrowserUtils.waitForClickablility(allPages.aboutPage().aboutPageTW,10);
            jse.executeScript("arguments[0].click();",allPages.aboutPage().aboutPageTW);
            windowHandles = driver.getWindowHandles();
            t = windowHandles.iterator();
            mainPage = (String) t.next();
            newWindow = (String) t.next();
            driver.switchTo().window(newWindow);
            BrowserUtils.waitForPageToLoad(10);
            BrowserUtils.waitFor(3);
            String actTwitter = driver.getTitle();
            System.out.println("actTwitter = " + actTwitter);
            BrowserUtils.waitFor(1);
        //  Assert.assertEquals(actTwitter,ConfigurationReader.get("expTwitter"));

        }


        /* Instagram test*/
        @Test
        public void aboutPageInstagramTest() {
            jse = (JavascriptExecutor) driver;
            BrowserUtils.waitFor(1);
            allPages= new AllPages();
            BrowserUtils.waitForClickablility(allPages.homePage().aboutBtn,10);
            allPages.homePage().aboutBtn.click();
            BrowserUtils.waitFor(1);
            jse.executeScript("arguments[0].scrollIntoView(true);", allPages.aboutPage().googlePlayAboutBtn);
            BrowserUtils.waitFor(1);
            jse.executeScript("arguments[0].click();",allPages.aboutPage().aboutPageINS);
            windowHandles = driver.getWindowHandles();
            t = windowHandles.iterator();
            mainPage = (String) t.next();
            newWindow = (String) t.next();
            driver.switchTo().window(newWindow);
            BrowserUtils.waitForPageToLoad(10);
            BrowserUtils.waitFor(3);
            String actInstagram = driver.getCurrentUrl();
            System.out.println("actInstagram = " + actInstagram);
        //    Assert.assertTrue(actInstagram.contains("instagram"));

        }

        /* LinkedIn test*/

        @Test
        public void aboutPageLinkedInTest() {
            jse = (JavascriptExecutor) driver;
            BrowserUtils.waitFor(1);
            allPages= new AllPages();
            BrowserUtils.waitForClickablility(allPages.homePage().aboutBtn,10);
            allPages.homePage().aboutBtn.click();
            BrowserUtils.waitFor(1);
            jse.executeScript("arguments[0].scrollIntoView(true);", allPages.aboutPage().googlePlayAboutBtn);
            BrowserUtils.waitFor(2);
            //aboutPage.aboutLINKEDIN.click();
            jse.executeScript("arguments[0].click();",allPages.aboutPage().aboutLINKEDIN);
            windowHandles = driver.getWindowHandles();
            t = windowHandles.iterator();
            mainPage = (String) t.next();
            newWindow = (String) t.next();
            driver.switchTo().window(newWindow);
            BrowserUtils.waitForPageToLoad(10);
            BrowserUtils.waitFor(3);
            String actLinkedIn = driver.getTitle();
            System.out.println("actLinkedIn = " + actLinkedIn);
            // Assert.assertEquals(actLinkedIn,ConfigurationReader.get("expLinkedIn"));

        }
    }



