import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class Calculator {
//WebDriver driver;
//Instantiate Appium Driver
		AppiumDriver<MobileElement> driver = null;

@BeforeClass
public void setUp() throws MalformedURLException{
	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("deviceName", "MIKE");
//	caps.setCapability("udid", "ce0616061ab9360204"); //Give Device ID of your mobile phone
	caps.setCapability("uidi", "10.14.10.167:5555");
	caps.setCapability("platformName", "Android");
	caps.setCapability("platformVersion", "8.0");
	//caps.setCapability("browserName", "Chrome");
	caps.setCapability("noReset", true);
 
   
   caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
// This package name of your app (you can get it from apk info app)
	caps.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)
//Create RemoteWebDriver instance and connect to the Appium server
 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
//   driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
   driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
}

@Test
public void testCal() throws Exception {
   //locate the Text on the calculator by using By.name()
//   WebElement two=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.Button[2]"));
   WebElement two=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_02"));
   two.click(); 							
   WebElement plus=driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Plus\"]"));
   plus.click();
   WebElement four=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.Button[1]"));
   four.click();
   WebElement plus2=driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Plus\"]"));
   plus2.click();
   WebElement four1=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.Button[1]"));
   four1.click();
   WebElement plus3=driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Plus\"]"));
   plus3.click();
   WebElement four4=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.Button[1]"));
   four4.click();
   WebElement equalTo=driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Equal\"]"));
   equalTo.click();
   Thread.sleep(6000);
   //locate the edit box of the calculator by using By.tagName()
  // WebElement results=driver.findElement(By.tagName("EditText"));
	//Check the calculated value on the edit box
//assert results.getText().equals("6"):"Actual value is : "+results.getText()+" did not match with expected value: 6";

}

@AfterClass
public void teardown(){
	//close the app
	driver.quit();
}
}