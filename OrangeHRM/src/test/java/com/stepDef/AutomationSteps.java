package com.stepDef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AutomationSteps {
	
	WebDriver driver;
    ArrayList<String> PriceList;
    String SecondPrice;
	
	
	//LoginPageAutomationPractice object;
	
	

@Given("^user open web browser and navigate to MyStore log in screen$")
public void user_open_web_browser_and_navigate_to_MyStore_log_in_screen() throws Throwable {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\16463\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
	
	driver = new ChromeDriver();
	driver.get("http://automationpractice.com/index.php");
	driver.manage().window().maximize();
	
    
}
@Then("^user Navigate to home Page and verify the Page Title is \"([^\"]*)\"$")
public void user_Navigate_to_home_Page_and_verify_the_Page_Title_is(String arg1) throws Throwable {
	System.out.println(driver.getTitle());	
		
}
    
@Then("^user click the sign in button on right the right$")
public void user_click_the_sign_in_button_on_right_the_right() throws Throwable {
    	
	WebElement signin = driver.findElement(By.xpath("//*[@class='login']"));
	signin.click();
	
    
}

@Then("^user enter a valid Email address and password$")
public void user_enter_a_valid_Email_address_and_password() throws Throwable {
	driver.findElement(By.xpath("//*[@id='email']")).sendKeys("johndessaijd@gmail.com");
	driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("13214");
		
	
//     object.getUsername().sendKeys("johndessaijd@gmail.com");
//     object.getPassword().sendKeys("13214");
     
}

@Then("^user click the sign in button$")
public void user_click_the_sign_in_button() throws Throwable {
	WebElement signin = driver.findElement(By.xpath("//*[@class='icon-lock left']"));
	signin.click();
    
}

@Then("^user click on the upper left corner dresses and display show five dresses$")
public void user_click_on_the_upper_left_corner_dresses_and_display_show_five_dresses() throws Throwable {
	driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a")).click();
}

@Then("^user print all the dress price in decending order$")
public void user_print_all_the_dress_price_in_decending_order() throws Throwable {
  
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy(0,1200)");
	
	List<WebElement> DressPrices = driver
			.findElements(By.xpath("//*[@class='product-desc']/following-sibling::div[1]"));

	PriceList = new ArrayList<String>();

	for (int i = 0; i < DressPrices.size(); i++) {
		PriceList.add(DressPrices.get(i).getText().toString());
	}
		Collections.sort(PriceList, Collections.reverseOrder());

		System.out.println("Dress Prices in Descending Order:" + PriceList);   
}

	@Then("^user select the second dress on the current list$")
	public void user_select_the_second_dress_on_the_current_list() throws Throwable {
	    
	SecondPrice = PriceList.get(1);
	System.out.println("Price of the second dress:"+ SecondPrice);
	driver.findElement(By.xpath("(//*[contains(text(),'" + SecondPrice + "')])[2]")).click();
	Thread.sleep(3000);   
		//driver.findElement(By.xpath("(//*[contains(text(),'30.50')])[2]")).click();
}

@Then("^user click on the next page to proceed checkout$")
public void user_click_on_the_next_page_to_proceed_checkout() throws Throwable {
	
	Thread.sleep(3000);
	
      driver.findElement(By.xpath("//*[contains(text(),'Proceed to checkout')]")).click();;
	
	
}

@When("^user click on the next page to verify the total price with shipping$")
public void user_click_on_the_next_page_to_verify_the_total_price_with_shipping() throws Throwable {
	Double ExpectedShippingPrice = Double.parseDouble(SecondPrice.replace("$", ""))+2;
	System.out.println("The total price with shipping is:"+ ExpectedShippingPrice);
	Double ActualShippingPrice = Double.parseDouble(driver.findElement(By.xpath("//*[@id='total_price']")).getText().replace("$", ""));
	Assert.assertTrue(ActualShippingPrice.equals(ExpectedShippingPrice));
	   
}

@Then("^user click on the sign out button and close the window$")
public void user_click_on_the_sign_out_button_and_close_the_window() throws Throwable {
	driver.findElement(By.xpath("(//*[contains(text(),'Sign out')])[1]")).click();
	driver.close();
	
	
	
   
}



}
