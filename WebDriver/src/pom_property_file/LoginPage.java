package pom_property_file;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import library.Utility;

public class LoginPage {
	
	WebDriver driver;
	ResourceBundle rb;
	
	public LoginPage(WebDriver driver){
	this.driver = driver;
	rb = ResourceBundle.getBundle("Elements");
	}
	
	public void enterUsername(String uname){
	WebElement e = driver.findElement(By.id(rb.getString("username_id")));
	e.sendKeys(uname);
	Utility.highlightElement(driver, e);
	}

	public void enterPassword(String passw){
    driver.findElement(By.id(rb.getString("password_id"))).sendKeys(passw);  	
	}

	public void clickSignin(){
    driver.findElement(By.xpath(rb.getString("signin_xpath"))).click();
        
	}

}
