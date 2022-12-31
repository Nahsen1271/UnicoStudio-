package com.unicoStudio.tests;

import com.unicoStudio.pages.AboutPage;
import com.unicoStudio.pages.HomePage;
import com.unicoStudio.utilities.BrowserUtils;
import com.unicoStudio.utilities.ConfigurationReader;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;

public class AboutPageTest extends TestBase {

    AboutPage aboutPage;
    HomePage homePage;

    JavascriptExecutor jse;
    Set<String> windowHandles;
    Iterator t;
    String mainPage ;
    String newWindow ;

 //   @Test
    public void testAbout1() {
        BrowserUtils.waitFor(1);
        aboutPage = new AboutPage();
        homePage = new HomePage();
        BrowserUtils.waitForClickablility(homePage.aboutBtn,10);
        homePage.aboutBtn.click();
        String aboutPageTitle = driver.getTitle();
        System.out.println("aboutPageTitle = " + aboutPageTitle);
        Assert.assertTrue(aboutPageTitle.contains("About"));

        String whoWeAreText = aboutPage.whoWeAre.getText();
        System.out.println("whoWeAreText = " + whoWeAreText);

        String teamMatesText = aboutPage.teamMates.getText();
        System.out.println("teamMatesText = " + teamMatesText);

        String theTeamText = aboutPage.theTeam.getText();
        System.out.println("theTeamText = " + theTeamText);

        String theTeamInfText = aboutPage.theTeamInf.getText();
        System.out.println("theTeamInfText = " + theTeamInfText);


    }

    /* Facebook test*/
    @Test
    public void aboutPageFacebookTest() {

        jse = (JavascriptExecutor) driver;
        BrowserUtils.waitFor(1);
        aboutPage = new AboutPage();
        homePage = new HomePage();
        homePage.aboutBtn.click();
        BrowserUtils.waitFor(1);
        jse.executeScript("arguments[0].scrollIntoView(true);", aboutPage.googlePlayAboutBtn); //Scroll down the page
        BrowserUtils.waitFor(1);
        //aboutPage.aboutPageFB.click();
        jse.executeScript("arguments[0].click();",aboutPage.aboutPageFB);
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
            aboutPage = new AboutPage();
            homePage = new HomePage();
            BrowserUtils.waitForClickablility(homePage.aboutBtn,10);
            homePage.aboutBtn.click();
            BrowserUtils.waitFor(1);
            jse.executeScript("arguments[0].scrollIntoView(true);", aboutPage.googlePlayAboutBtn);
            BrowserUtils.waitFor(1);
            aboutPage.aboutPageTW.click();
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
            aboutPage = new AboutPage();
            homePage = new HomePage();
         //   BrowserUtils.waitForClickablility(homePage.aboutBtn,10);
            homePage.aboutBtn.click();
            BrowserUtils.waitFor(1);
            jse.executeScript("arguments[0].scrollIntoView(true);", aboutPage.googlePlayAboutBtn);
            BrowserUtils.waitFor(1);
       //     aboutPage.aboutPageINS.click();
            jse.executeScript("arguments[0].click();",aboutPage.aboutPageINS);
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
            aboutPage = new AboutPage();
            homePage = new HomePage();
            BrowserUtils.waitForClickablility(homePage.aboutBtn,10);
            homePage.aboutBtn.click();
            BrowserUtils.waitFor(1);
            jse.executeScript("arguments[0].scrollIntoView(true);", aboutPage.googlePlayAboutBtn);
            BrowserUtils.waitFor(2);
            //aboutPage.aboutLINKEDIN.click();
            jse.executeScript("arguments[0].click();",aboutPage.aboutLINKEDIN);
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



