package com.unicoStudio.tests;

import com.unicoStudio.pages.AboutPage;
import com.unicoStudio.pages.HomePage;
import com.unicoStudio.utilities.BrowserUtils;
import com.unicoStudio.utilities.ConfigurationReader;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        /* Facebook test*/
        jse.executeScript("arguments[0].click();",homePage.facebookBtn);
        BrowserUtils.waitForPageToLoad(1);
        BrowserUtils.waitFor(1);
        String actFacebook=driver.getTitle();
        System.out.println("actFacebook = " + actFacebook);
        Assert.assertEquals(actFacebook, ConfigurationReader.get("expFacebook"));
        driver.navigate().back();
        BrowserUtils.waitFor(1);

        /* Twitter test*/
        jse.executeScript("arguments[0].click();",homePage.twitterBtn);
        BrowserUtils.waitForPageToLoad(1);
        String actTwitter=driver.getTitle();
        System.out.println("actTwitter = " + actTwitter);
        driver.navigate().back();
        BrowserUtils.waitFor(1);

        /* Instagram test*/
        jse.executeScript("arguments[0].click();",homePage.instagramBtn);
        BrowserUtils.waitForPageToLoad(1);
        String actInstagram=driver.getTitle();
        System.out.println("actInstagram = " + actInstagram);
        driver.navigate().back();
        BrowserUtils.waitFor(1);

        /* LinkedIn test*/
        jse.executeScript("arguments[0].click();",homePage.linkedinBtn);
        BrowserUtils.waitForPageToLoad(1);
        String actLinkedIn=driver.getTitle();
        System.out.println("actLinkedIn = " + actLinkedIn);
        driver.navigate().back();




    }


}
