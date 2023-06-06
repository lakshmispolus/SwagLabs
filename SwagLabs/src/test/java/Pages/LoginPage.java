package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilies.WebDriverManager_Base_Class;

public class LoginPage extends WebDriverManager_Base_Class {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	private WebElement Username;
	
	@FindBy(id = "password")
	private WebElement Password;
	
	@FindBy(id = "login-button")
	private WebElement LoginButton;
	
	@FindBy(xpath = "//div[@class='app_logo']")
	private WebElement LoginPageName;
	
	
	
	public String SwagLabsLogin(String UserName,String UserPassword)
	{
		Username.sendKeys(UserName);
		Password.sendKeys(UserPassword);
		LoginButton.click();
		String PageName=LoginPageName.getText();
		return PageName;
	}
	
}