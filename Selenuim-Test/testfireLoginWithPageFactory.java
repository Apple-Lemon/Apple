package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactory.testfireHomePage;
import PageFactory.testfireLogin;




public class testfireLoginWithPageFactory {

	WebDriver driver;
	testfireLogin objLogin;
	testfireHomePage objHomePage;
	
	@BeforeTest
	public void setup(){
		System .setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.testfire.net/login.jsp");
	}

	/**
	 * This test go to http://www.testfire.net/login.jsp
	 * Verify login page title as Online Banking Login
	 * Login to application
	 * Verify the home page using Dashboard message
	 */
	@Test(priority=0)
	public void test_Home_Page_Appear_Correct(){
		//Create Login Page object 
	objLogin = new testfireLogin(driver);
	//Verify login page title
	String loginPageTitle = objLogin.getLoginTitle();
	//System.out.println("The getText is: " +loginPageTitle);
	Assert.assertEquals(loginPageTitle,"Online Banking Login");
	//login to application
	objLogin.loginTotestfire("admin", "admin");
	// go the next page
	objHomePage = new testfireHomePage(driver);
	//Verify home page
	Assert.assertEquals(objHomePage.getHomePageDashboardUserName(),"Congratulations!");
	}
	
}
