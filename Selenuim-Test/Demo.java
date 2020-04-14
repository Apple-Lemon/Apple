package selenium.WebDriverTest;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
	
public static void main(String[] args) throws InterruptedException {
	System .setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://www.baidu.com/"); 
	System.out.println("The testing page title is: " + driver.getTitle());
	WebElement element = driver.findElement(By.id("kw"));//ͨ��"id"Ԫ�ض�λ������
	element.sendKeys("selenium");
	((WebElement) driver.findElement(By.xpath("//input[@id='su']"))).click();//ͨ��"xpath"���ж�λ������ť
	String text = driver.findElement(By.xpath("//*[@id=\"s_tab\"]/div/b")).getText();
	System.out.println("The getText is: " +text);
	assertEquals(text, "��ҳ");
	Thread.sleep(20000);
	driver.quit();
}
}
