package com.unicoStudio.tests;


import com.unicoStudio.pages.HomePage;
import com.unicoStudio.utilities.BrowserUtils;
import com.unicoStudio.utilities.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;


public class HomePageTests extends TestBase{

    HomePage homePage;

    @Test
    public void homePageTest() {

        homePage=new HomePage();
        String actAboutText =homePage.aboutBtn.getText();
        System.out.println("actAboutText = " + actAboutText);

        String actGamesText =homePage.gamesBtn.getText();
        System.out.println("actGamesText = " + actGamesText);

        String actCareersText =homePage.careersBtn.getText();
        System.out.println("actCareersText = " + actCareersText);

        String actContactText =homePage.contactBtn.getText();
        System.out.println("actContactText = " + actContactText);

        String actHomeTitle = driver.getTitle();
        System.out.println("homeTitle = " + actHomeTitle);


        Assert.assertEquals(actAboutText, ConfigurationReader.get("expAboutText"));
        Assert.assertEquals(actGamesText, ConfigurationReader.get("expGamesText"));
        Assert.assertEquals(actCareersText, ConfigurationReader.get("expCareersText"));
        Assert.assertEquals(actContactText, ConfigurationReader.get("expContactText"));
        Assert.assertEquals(actHomeTitle, ConfigurationReader.get("expHomeTitle"));

        String homeWindow = driver.getWindowHandle();
        System.out.println("homeWindow = " + homeWindow);
        Set<String> windowHandles;
        Iterator t;

        /* Facebook test*/
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",homePage.facebookBtn);
        windowHandles = driver.getWindowHandles();
        t = windowHandles.iterator();
        String mainPage  = (String) t.next();
        String newWindow= (String) t.next();
        driver.switchTo().window(newWindow);
        BrowserUtils.waitForPageToLoad(1);
        BrowserUtils.waitFor(1);
        String actFacebook=driver.getTitle();
        System.out.println("actFacebook = " + actFacebook);
        Assert.assertEquals(actFacebook,ConfigurationReader.get("expFacebook"));
        driver.close();
        driver.switchTo().window(mainPage);

          /* Twitter test*/
        jse.executeScript("arguments[0].click();",homePage.twitterBtn);
        windowHandles = driver.getWindowHandles();
        t = windowHandles.iterator();
        mainPage  = (String) t.next();
        newWindow= (String) t.next();
        driver.switchTo().window(newWindow);
        BrowserUtils.waitForPageToLoad(1);
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForPageToLoad(1);
        BrowserUtils.waitFor(1);
        String actTwitter=driver.getTitle();
        System.out.println("actTwitter = " + actTwitter);
        BrowserUtils.waitFor(1);
      //  Assert.assertEquals(actTwitter,ConfigurationReader.get("expTwitter"));
        driver.close();
        driver.switchTo().window(mainPage);

        /* Instagram test*/
        jse.executeScript("arguments[0].click();",homePage.instagramBtn);
        windowHandles = driver.getWindowHandles();
        t = windowHandles.iterator();
        mainPage  = (String) t.next();
        newWindow= (String) t.next();
        driver.switchTo().window(newWindow);
        BrowserUtils.waitForPageToLoad(1);
        String actInstagram=driver.getTitle();
        System.out.println("actInstagram = " + actInstagram);
        Assert.assertTrue(actInstagram.contains("Instagram"));
     //   Assert.assertEquals(actInstagram,ConfigurationReader.get("expInstagram"));
        driver.close();
        driver.switchTo().window(mainPage);


        /* LinkedIn test*/
        jse.executeScript("arguments[0].click();",homePage.linkedinBtn);
        windowHandles = driver.getWindowHandles();
        t = windowHandles.iterator();
        mainPage  = (String) t.next();
        newWindow= (String) t.next();
        driver.switchTo().window(newWindow);
        BrowserUtils.waitForPageToLoad(1);
        BrowserUtils.waitFor(2);
        String actLinkedIn=driver.getTitle();
       // Assert.assertEquals(actLinkedIn,ConfigurationReader.get("expLinkedIn"));
        driver.close();
        driver.switchTo().window(mainPage);


        /* Term of Conditions test*/

        jse.executeScript("arguments[0].click();",homePage.termAndCon);
        String termAndConTextText = homePage.termAndConText.getText();
        System.out.println("termAndConTextText = " + termAndConTextText);
        Assert.assertEquals(termAndConTextText,"Terms and Conditions");
        driver.navigate().back();

        /* PP test*/

        jse.executeScript("arguments[0].click();",homePage.privacyPolicy);
        String privacyPolicyTextText = homePage.privacyPolicyText.getText();
        System.out.println("privacyPolicyTextText = " + privacyPolicyTextText);
        Assert.assertEquals(privacyPolicyTextText,"Privacy Policy");
        driver.navigate().back();

        // Google Play sayfasına geçişin kontrol edilmesi

        jse.executeScript("arguments[0].click();",homePage.googlePlayBtn);
        windowHandles = driver.getWindowHandles();
        t = windowHandles.iterator();
        mainPage  = (String) t.next();
        String googlePlayWindow= (String) t.next();
        driver.switchTo().window(googlePlayWindow);
        BrowserUtils.waitFor(1);
        String actGooglePlayTitle=driver.getTitle();
        System.out.println("actGooglePlayTitle : " + driver.getTitle());
        Assert.assertEquals(actGooglePlayTitle,ConfigurationReader.get("expGooglePlayTitle"));
        driver.close();
        driver.switchTo().window(mainPage);

        // AppStore sayfasına geçişin kontrol edilmesi

        jse.executeScript("arguments[0].click();",homePage.appStoreBtn);
        windowHandles = driver.getWindowHandles();
        t = windowHandles.iterator();
        mainPage  = (String) t.next();
        googlePlayWindow= (String) t.next();
        driver.switchTo().window(googlePlayWindow);
        BrowserUtils.waitFor(1);
        String actAppStoreTitle=driver.getTitle();
        System.out.println("actAppStoreTitle= " + actAppStoreTitle);
        Assert.assertEquals(actAppStoreTitle,ConfigurationReader.get("expAppStoreTitle"));
        driver.close();
        driver.switchTo().window(mainPage);

    }

}

