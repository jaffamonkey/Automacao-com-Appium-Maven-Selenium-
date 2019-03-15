import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
 
public class ChromeTest {
 
	public static void main(String[] args) {
		
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "MIKE");
		caps.setCapability("udid", "ce0616061ab9360204"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.0");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("noReset", true);
		
		//Set ChromeDriver location
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mike.pradella\\eclipse-workspace\\AppiumTest\\chromedriver.exe");
		
		//Instantiate Appium Driver
		AppiumDriver<MobileElement> driver = null;
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
				
		//Open URL in Chrome Browser
		driver.get("http://www.google.com");
	}

}
