package com.unicoStudio.pages;

import com.unicoStudio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CareersPage {

    public CareersPage() {

        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath= "//h1[@class='font-impact']")
    public WebElement joinUs;

    @FindBy(xpath="//h2[normalize-space()='What do we offer?']")
    public WebElement whatWeOffer;

    @FindBy(xpath = "//h2[normalize-space()='Amazing Team']")
    public WebElement amazingTeam;

    @FindBy(xpath = "//h2[normalize-space()='Team']")
    public WebElement theTeam;

    @FindBy(xpath = "//div[@class='col-12 mb-4']/h2")
    public WebElement whatWeOfferSub1;

    @FindBy(xpath = "//div[@class='col-12 mb-4']/h2")
    public List<WebElement> whatWeOfferSub;

    @FindBy(xpath = "//a[@class='btn-shadow-rounded-large hover-gray px-4 p-2 mb-4']")
    public WebElement checkOpenings;

//a[@class='btn-shadow-rounded-large hover-gray px-4 p-2 mb-4']
//a[@class='btn-shadow-rounded-large hover-gray px-4 p-2 mb-4']

    @FindBy(xpath="//p[contains(text(),'We have a talented and diverse team of managers, d')]")
    public WebElement theTeamInf;
}
