package test;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
 
@org.junit.Test
public void test12() throws Exception{

File currDir = new File(".");
String path = currDir.getAbsolutePath();
System.out.println(path);
System.setProperty("webdriver.chrome.driver",  "C:\\Katalon\\Katalon_Studio_Windows_64-7.9.1\\configuration\\resources\\drivers\\chromedriver_win32\\chromedriver.exe" );

//Initialize browser
WebDriver driver=new ChromeDriver();

//Open facebook
driver.get("http://www.amazon.com");

//Maximize browser
Thread.sleep(5000);
driver.manage().window().maximize();
Thread.sleep(5000);
WebElement searchbox = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
searchbox.sendKeys("qa testing for beginners");
Thread.sleep(5000);
WebElement elementsearch = driver.findElement(By.cssSelector("input[id='nav-search-submit-button']"));
elementsearch.click();
Thread.sleep(5000);
WebElement image = driver.findElement(By.cssSelector("img[alt='Sponsored Ad - Unit Testing Principles, Practices, and Patterns: Effective testing styles, patterns, and reliable automati...']"));
image.click();
Thread.sleep(5000);
//get the price before clicking the cart
WebElement getprice = driver.findElement(By.cssSelector("span[id='newBuyBoxPrice']"));
String priceforthbook = getprice .getText();

// get the price


Thread.sleep(5000);
WebElement addcart = driver.findElement(By.cssSelector("input[id='add-to-cart-button']"));
addcart.click();
Thread.sleep(5000);
WebElement proceedwith = driver.findElement(By.cssSelector("a[id='hlb-ptc-btn-native']"));
proceedwith.click();

Thread.sleep(5000);
//get the price from checkout page
WebElement getcheckoutprice = driver.findElement(By.cssSelector("span[id='newBuyBoxPrice']"));
String checkoutpr =  getcheckoutprice .getText();
// compare the first price with the checkout price
Assert.assertEquals(checkoutpr, priceforthbook);



}
 
}
