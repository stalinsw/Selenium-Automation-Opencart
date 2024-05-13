package testBase;

import java.io.File;


import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties pr;
	
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"os","browser"} )
	public void setup(String os, String br) throws IOException
	{
		FileReader fr= new FileReader(".//src/test/resources/config.properties");
		pr=new Properties();
		pr.load(fr);
		logger=LogManager.getLogger(this.getClass());
		
		if (pr.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			//OS using
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			if (os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os..");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome" :capabilities.setBrowserName("chrome");break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox" : capabilities.setBrowserName("FireFox"); break;
			default: System.out.println("No matching browser.."); return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		}
		
		
		switch(br.toLowerCase())
		{
		case "chrome":driver= new ChromeDriver(); break;
		case "firefox":driver= new FirefoxDriver(); break;
		case "edge":driver= new EdgeDriver(); break;
		default: System.out.println("No matching Browsers");
			return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(pr.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	@AfterClass(groups= {"sanity","regression","master"})
	public void teardown()
	{
		driver.close();
	}
	
	public String randomString() { 
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumeric() { 
		String generatedNumeric=RandomStringUtils.randomNumeric(10);
		return generatedNumeric;
	}
	
	public String randomAlphaNumeric() { 
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);

		return (str+"@"+num);
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
