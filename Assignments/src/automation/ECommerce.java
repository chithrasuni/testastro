package automation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class ECommerce {
	static WebDriver driver=null;
	@Test(priority=0)
	public static void main() throws InterruptedException {
		
				System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
				driver=new ChromeDriver();
				
				String url="http:\\www.amazon.in";
				driver.get(url);
				driver.manage().window().maximize();
				Thread.sleep(30);
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
		WebElement element=driver.findElement(By.name("field-keywords"));
		element.sendKeys("iphone 7");
		WebElement element1=driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input"));
		element1.click();
		String Amazon_Product_name=driver.findElement(By.xpath(".//*[@id='result_0']/div/div/div/div[2]/div[1]/div[1]/a/h2")).getText();
		//driver.findElement(By.xpath(".//*[@id='result_0']/div/div/div/div[2]/div[1]/div[1]/a/h2")).click();
		
		String Amazon_Title=driver.getTitle();
		System.out.println("Product name is:"+Amazon_Product_name);
		String Amazon_Url=driver.getCurrentUrl();
		String Amazon_Product_Price=driver.findElement(By.xpath("//*[@id='result_0']/div/div/div/div[2]/div[2]/div[1]/div[1]/a/span")).getText();
		//System.out.println("Price in Amazon is:"+Amazon_Product_Price);
		driver.navigate().to("https://www.ebay.in/");
		WebElement ele=null;
		ele=driver.findElement(By.xpath(".//*[@id='gh-ac']"));
		ele.sendKeys("Iphone 7");
		Thread.sleep(50);
		Select Sel=new Select(driver.findElement(By.xpath(".//*[@id='gh-cat']")));
		Sel.selectByVisibleText("Mobile Phones");
	    Thread.sleep(10);
		ele=driver.findElement(By.xpath(".//*[@id='gh-btn']"));
		ele.click();
		ele=driver.findElement(By.xpath("//*[@id='item2f1cb98fbf']/h3/a"));
		ele.click();
		String EBAY_Product_Name=driver.findElement(By.xpath(".//*[@id='itemTitle']")).getText();
		String EBAY_Title=driver.getTitle();
		String EBAY_Url=driver.getCurrentUrl();
	    String EBAY_Product_Price=driver.findElement(By.xpath(".//*[@id='prcIsum']")).getText();
	    //System.out.println("Product name in EBAY is:"+EBAY_Product_Name);
	    System.out.println("Product Price in EBAY is:"+EBAY_Product_Price);
	    int compare = Amazon_Product_Price.compareToIgnoreCase(EBAY_Product_Price);
	    if (compare<0){
	    	System.out.printf("Price is less in EBAY & the price is:%s \n Url is:%s \n Product name: %s \n Name of the website %s \n",EBAY_Product_Price,EBAY_Url,EBAY_Product_Name,EBAY_Title);
	    	
	    	    	
	    }else
	    {
	    	
	    	System.out.printf("Price is less in Amazon is less & is:%s \n Url is:%s \n Product name: %s \n Name of the website %s \n",Amazon_Product_Price,Amazon_Url,Amazon_Product_name,Amazon_Title);
	
	    	
	    }
	    }
	    
	}


	


