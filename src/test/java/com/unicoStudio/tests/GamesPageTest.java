package com.unicoStudio.tests;

import com.unicoStudio.pages.AboutPage;
import com.unicoStudio.pages.GamesPages;
import com.unicoStudio.pages.HomePage;
import com.unicoStudio.utilities.ConfigurationReader;
import com.unicoStudio.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class GamesPageTest  extends TestBase{

    HomePage homePage=new HomePage();
    AboutPage aboutPage=new AboutPage();
    GamesPages gamesPages=new GamesPages();

    @Test(priority = 1)
    public void gamesPageTest() {
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",homePage.gamesBtn);
        String actUnicoStudioText = gamesPages.unicoStudio.getText();
        Assert.assertEquals(actUnicoStudioText,ConfigurationReader.get("expUnicoStudioText"));
        
        String actGamesPageTitle = driver.getTitle();
        Assert.assertEquals(actGamesPageTitle,ConfigurationReader.get("expGamesPageTitle"));



    }
    @Test(priority = 2) /* Brain Test Google Play Check*/
    public void brainTestGP() {
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",homePage.gamesBtn);
        String brainTestText = gamesPages.brainTest.getText(); // Verify that it is Brain Test Game
        System.out.println("brainTestText = " + brainTestText);

        Assert.assertEquals(driver.getTitle(),ConfigurationReader.get("expGamesPageTitle"));

        String homeWindow=driver.getWindowHandle();
        System.out.println("homeWindow = " + homeWindow);

        // Google Play sayfasına geçişin kontrol edilmesi

        jse.executeScript("arguments[0].click();",gamesPages.brainTestGP);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {

            if(!handle.equals(homeWindow)){
                driver.switchTo().window(handle);
            }

        }
        String googleGamesWindow=driver.getWindowHandle();
        System.out.println("googleWindow = " + googleGamesWindow);
        String actGPGamesTitle=driver.getTitle();
        Assert.assertEquals(actGPGamesTitle, ConfigurationReader.get("expGPGamesTitle"));// Assert burada yapılacak.
        driver.switchTo().window(homeWindow);



    }
    @Test(priority = 3) /* Brain Test AppStore Check*/
    public void brainTestAppStore() {
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",homePage.gamesBtn);

        String homeWindow=driver.getWindowHandle();
       // System.out.println("homeWindow = " + homeWindow);

        // AppStore sayfasına geçişin kontrol edilmesi

        jse.executeScript("arguments[0].click();",gamesPages.brainTestAppSore);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {

            if(!handle.equals(homeWindow)){
                driver.switchTo().window(handle);
            }

        }
        String appStoreGamesWindow=driver.getWindowHandle();
        System.out.println("googleWindow = " + appStoreGamesWindow);
        Assert.assertEquals(gamesPages.brainTestAppText.getText(), ConfigurationReader.get("expBTAppStore"));// Assert burada yapılacak.
        driver.switchTo().window(homeWindow);



    }
    @Test(priority = 4)  /* Brain Test AppStore Check*/
    public void brainTestPoki() {
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",homePage.gamesBtn);

        String homeWindow=driver.getWindowHandle();
       // System.out.println("homeWindow = " + homeWindow);

        // AppStore sayfasına geçişin kontrol edilmesi

        jse.executeScript("arguments[0].click();",gamesPages.brainTestPoki);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {

            if(!handle.equals(homeWindow)){
                driver.switchTo().window(handle);
            }

        }
        String brainTestPokiWindow=driver.getWindowHandle();
        System.out.println("brainTestPokiWindow = " + brainTestPokiWindow);
//        String actBTPokiTitle=driver.getCurrentUrl();
//        System.out.println("actBTPokiTitle " + actBTPokiTitle);
//        //   Assert.assertEquals(actGooglePlayTitle, ConfigurationReader.get("expGooglePlayTitle"));// Assert burada yapılacak.
//        driver.switchTo().window(homeWindow);
//        driver.quit();
        //brainTestPokiWindow = CDwindow-0A322D78CA06A56FB52E5EB402B9EAB6
        //brainTestPokiWindow = CDwindow-B347FF76FFDE3CF6505237D5175FACD9
        //brainTestPokiWindow = CDwindow-D14B7B0B7FB72841EA30AE8E110767E5
        String text = driver.findElement(By.xpath("//h1[@class='DetailedTile__DetailedTileTitleText-sc-1ercfrx-4 guwtdr']")).getText();
        System.out.println("text = " + text);
    //    Driver.closeDriver();

    }
    /*Bundan sonra aynı patern diğer oyunlarında kontrolü yapılabilir..*/



}
