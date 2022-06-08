package com.unicoStudio.pages;

import com.unicoStudio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage {

    public AboutPage() {

        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath= "//h2[normalize-space()='Who are we?']")
    public WebElement whoWeAre;

    @FindBy(xpath="//span[normalize-space()='500']")
    public WebElement millionImg;

    @FindBy(xpath = "/html[1]/body[1]/main[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/h2[1]")
    public WebElement teamMates;

    @FindBy(xpath = "//h2[normalize-space()='Team']")
    public WebElement theTeam;

    @FindBy(xpath="//p[contains(text(),'We have a talented and diverse team of managers, d')]")
    public WebElement theTeamInf;

    @FindBy(xpath ="//a[@class='btn-shadow-rounded-large hover-gray px-4 p-2']")
    public WebElement checkOpenPosition;

    @FindBy(xpath ="//a[normalize-space()='Google Play']")
    public WebElement googlePlayAboutBtn;

    @FindBy(xpath = "//a[normalize-space()='App Store']")
    public WebElement appStoreAboutBtn;
    //a[normalize-space()='Google Play']
    //a[normalize-space()='App Store']
    //i[@class='bx bxl-twitter']
    //i[@class='bx bxl-facebook']
    //i[@class='bx bxl-instagram']
    //i[@class='bx bxl-linkedin']


}
