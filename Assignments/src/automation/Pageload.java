package automation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Security;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Pageload {
	static WebDriver driver=null;
	@Test(priority=0)
	public static void main() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
		long start = System.currentTimeMillis();
		String url="http://www.astro.com.my/";
		driver.get(url);	
		driver.manage().window().maximize();
		
		HttpURLConnection huc = null;
        int respCode = 200;

		WebElement ele = driver.findElement(By.xpath(".//*[@id='acmlogin']/a"));
		long finish = System.currentTimeMillis();
		long totalTime = finish - start; 
		System.out.println("Total Time for page load - "+totalTime); 
		long totaltimeinSec=((totalTime/ 1000) % 60);
		System.out.println("Total time for page load:"+totaltimeinSec+"S");
		if (totaltimeinSec>0.1){
			System.out.println("Page Load time is"+totaltimeinSec+"Seconds");
		}else{
			System.out.println("Page Load time is 0.1 S");
		}
List<WebElement> links = driver.findElements(By.tagName("a"));
        
        Iterator<WebElement> it = links.iterator();
        
        while(it.hasNext()){
            
            url = it.next().getAttribute("href");
            
            System.out.println(url);
        
            if(url == null || url.isEmpty()){
System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            
            if(!url.startsWith(url)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
            
            try {
            	if (!url.startsWith("mailto")){
                        
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                
                if(respCode >= 400){
                    System.out.println(url+" is a broken link"+"& the response code is:"+respCode);
                }
                else{
                    System.out.println(url+" is a valid link"+"& the response code is:"+respCode);
                }
            	} else{
            		System.out.println("Mailto URl:"+url);
            	}
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }catch(StaleElementReferenceException e){
            	e.printStackTrace();
            }
        }
        
			
				
				
				
				
	}
}
