package com.unicoStudio.tests;


import com.unicoStudio.pages.HomePage;
import com.unicoStudio.utilities.BrowserUtils;
import com.unicoStudio.utilities.ConfigurationReader;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        /* Facebook test*/
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",homePage.facebookBtn);
        BrowserUtils.waitForPageToLoad(1);
        BrowserUtils.waitFor(1);
        String actFacebook=driver.getTitle();
        System.out.println("actFacebook = " + actFacebook);
        Assert.assertEquals(actFacebook,ConfigurationReader.get("expFacebook"));
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

        /* Term of Conditions test*/

        jse.executeScript("arguments[0].click();",homePage.termAndCon);
        String termAndConTextText = homePage.termAndConText.getText();
        System.out.println("termAndConTextText = " + termAndConTextText);
        driver.navigate().back();

        /* PP test*/

        jse.executeScript("arguments[0].click();",homePage.privacyPolicy);
        String privacyPolicyTextText = homePage.privacyPolicyText.getText();
        System.out.println("privacyPolicyTextText = " + privacyPolicyTextText);
        driver.navigate().back();

        driver.switchTo().window(homeWindow); // Return to the home page

        // Google Play sayfasına geçişin kontrol edilmesi

        jse.executeScript("arguments[0].click();",homePage.googlePlayBtn);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {

            if(!handle.equals(homeWindow)){
                driver.switchTo().window(handle);
                    }

        }
        String googleWindow=driver.getWindowHandle();
        System.out.println("googleWindow = " + googleWindow);
        String actGooglePlayTitle=driver.getTitle();
        System.out.println("actGooglePlayTitle " + driver.getTitle());
        Assert.assertEquals(actGooglePlayTitle,ConfigurationReader.get("expGooglePlayTitle"));
        driver.switchTo().window(homeWindow);

        // AppStore sayfasına geçişin kontrol edilmesi
     //   homePage.appStoreBtn.click();
        jse.executeScript("arguments[0].click();",homePage.appStoreBtn);
        System.out.println("driver.getTitle()Son = " + driver.getTitle());

        windowHandles = driver.getWindowHandles();
        String appWindow;
        for (String handle : windowHandles) {

            if (!handle.equals(googleWindow))
                if (!handle.equals(homeWindow)) {
                    driver.switchTo().window(handle);

                }

        }
        appWindow = driver.getWindowHandle();
        System.out.println("appWindow = " + appWindow);
        String actAppStoreTitle=driver.getTitle();
        System.out.println("actAppStoreTitle= " + actAppStoreTitle);
        driver.switchTo().window(homeWindow);
        System.out.println("driver.getTitle(2) = " + driver.getTitle());








//        WebElement username= driver.findElement(By.cssSelector("#identifierId"));
//        //  username.click();
//        username.sendKeys("nahsen@unicostudio.co");
//        WebElement forwordBut= driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[1]"));
//        forwordBut.click();
//        WebElement checkBtn= driver.findElement(By.xpath("(//input)[5]"));
//     //   Thread.sleep(2000);
//        JavascriptExecutor jse= (JavascriptExecutor) driver;
//     //   jse.executeScript("arguments[0].click();",checkBtn);
//
//        Thread.sleep(2000);
//        WebElement password= driver.findElement(By.xpath("(//input)[4]"));
//        Thread.sleep(2000);
//        password.sendKeys("HerseySenden");
//        Thread.sleep(1000);
//        WebElement forwordBut2= driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[1]"));
//        forwordBut2.click();
//        Thread.sleep(2000);
//        WebElement developerChoose= driver.findElement(By.xpath("(//developer-item)[1]"));
//        developerChoose.click();
//        Thread.sleep(1000);
//        WebElement WhoIs= driver.findElement(By.xpath("//div[(text()='Who is? Brain Teaser & Riddles')]"));
//        WhoIs.click();
//        Thread.sleep(2000);
//        JavascriptExecutor jse1= (JavascriptExecutor) driver;
//        for (int i = 0; i < 10; i++) {
//            Thread.sleep(1000);
//            jse1.executeScript("window.scrollBy(0,250)");
//
//        }
//
////        WebElement ratingAndReviewsBtn= driver.findElement(By.xpath("//body/div/root[@id='console-root-021280']/console-chrome[@class='_ngcontent-nfa-0 _nghost-nfa-1']/div[@class='console-content _ngcontent-nfa-1']/material-drawer[@class='desktop-navigation-drawer _ngcontent-nfa-1 mat-drawer-expanded']/navigation-bar[@class='_ngcontent-nfa-1 _nghost-nfa-16']/div[@class='group-container _ngcontent-nfa-16']/expandable-container[@class='_ngcontent-nfa-16 _nghost-nfa-25 group-children']/div[@id='a31466219-FD58-4428-AFCC-75A74890EF88--40']/div[@class='content _ngcontent-nfa-25']/navigation-subtree[1]/navigation-element[1]/div[1]/material-ripple[1]"));
////        JavascriptExecutor jse2= (JavascriptExecutor) driver;
////        jse2.executeScript("arguments[0].scrollIntoView(true);",ratingAndReviewsBtn);
// //       ratingAndReviewsBtn.click();
//
//        Thread.sleep(1000);
//        WebElement ratingAndReviewsBtn= driver.findElement(By.xpath("//i[normalize-space()='comment']"));
//    //    JavascriptExecutor jse2= (JavascriptExecutor) driver;
//        jse.executeScript("arguments[0].scrollIntoView(true);",ratingAndReviewsBtn);
//        ratingAndReviewsBtn.click();
//
//        WebElement reviews= driver.findElement(By.cssSelector("div[class='row _ngcontent-nfa-26 child-element selected'] material-ripple[class='_ngcontent-nfa-26']"));
//        reviews.click();
    }

}

