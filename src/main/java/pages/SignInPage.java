package pages;

import utils.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonSeleniumUtils;
import utils.ConfigurationReader;

public class SignInPage {
CommonSeleniumUtils utils = new CommonSeleniumUtils();
	
	public SignInPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(css="input[name*='email']")
    public WebElement email;
	
	@FindBy(css="input[name*='password']")
    public WebElement password;
	
	@FindBy(css="button[type*='submit']")
    public WebElement signIn;
    
	@FindBy(xpath="//h1[.='sign in']")
	public WebElement homepagesignIntext;
	
//	@FindBy(css="body > div.cdk-visually-hidden")
//	public WebElement emailError;
//	
//	@FindBy(css="body > div.cdk-visually-hidden")
//	public WebElement passwordError;
	
    public void openHomePage(){
    	Driver.getDriver().navigate().to(ConfigurationReader.getProperty("cybertek"+ConfigurationReader.getProperty("environment")));
    }
    
    public void login(String emailStr, String passwordStr){
    	CommonSeleniumUtils.takeSnapShot();
    	utils.waitForVissibilityOfElement(email);
    	email.clear();
    	email.sendKeys(emailStr);
    	password.clear();
    	password.sendKeys(passwordStr);
    	signIn.click();
    	CommonSeleniumUtils.takeSnapShot();
    }
    
	public String getUserEmail(String role, String location){
		return ConfigurationReader.getProperty(role + "email" +location+ ConfigurationReader.getProperty("environment"));
	}
	
	public String getUserPassword(String role, String location){
		return ConfigurationReader.getProperty(role + "password" +location+ ConfigurationReader.getProperty("environment"));
	}
}
