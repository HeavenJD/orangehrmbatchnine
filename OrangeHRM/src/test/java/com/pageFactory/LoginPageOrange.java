package com.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageOrange {
	WebDriver driver;

	public LoginPageOrange(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='txtUsername']")
	private WebElement username;
	
	@FindBy(how = How.XPATH, using = "//*[@id='txtPassword']")
	private WebElement password;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\\'btnLogin\\']")
	private WebElement signin;

	public WebElement getUsername() {
		return username;
	}

	public void setUsername(WebElement username) {
		this.username = username;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getSignin() {
		return signin;
	}

	public void setSignin(WebElement signin) {
		this.signin = signin;
	}

	
	
	
	
}
