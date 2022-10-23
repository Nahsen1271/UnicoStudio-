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

public class AboutPageTest extends TestBase{

    AboutPage aboutPage=new AboutPage();
    HomePage homePage=new HomePage();

    @Test
    public void aboutPageTest() {
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",homePage.learnAboutUs);
//        homePage.learnAboutUs.click();
        String aboutPageTitle = driver.getTitle();
        System.out.println("aboutPageTitle = " + aboutPageTitle);

        String whoWeAreText = aboutPage.whoWeAre.getText();
        System.out.println("whoWeAreText = " + whoWeAreText);

//        String millionImgText = aboutPage.millionImg.getText();
//        System.out.println("millionImgText = " + millionImgText);

        String teamMatesText = aboutPage.teamMates.getText();
        System.out.println("teamMatesText = " + teamMatesText);

        String theTeamText = aboutPage.theTeam.getText();
        System.out.println("theTeamText = " + theTeamText);

        String theTeamInfText = aboutPage.theTeamInf.getText();
        System.out.println("theTeamInfText = " + theTeamInfText);

        String homeWindow = driver.getWindowHandle();
        System.out.println("homeWindow = " + homeWindow);
        Set<String> windowHandles;
        Iterator t;

        /* Facebook test*/
        jse= (JavascriptExecutor) driver;
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





    }


}
