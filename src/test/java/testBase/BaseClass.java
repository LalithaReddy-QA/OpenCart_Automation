package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

		public static WebDriver driver;
		public Logger logger;
		public Properties p;
		
		@BeforeClass(groups= {"sanity", "Regression", "Master"})
		@Parameters({"os","browser"})
		public void setup(String os, String br) throws IOException
		{
			//Loading config.properties files
			FileReader file=new FileReader("./src//test//resources//config.properties");
			p=new Properties();
			p.load(file);
			
			logger=LogManager.getLogger(this.getClass());
			
			
			//executing remote environment
			if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
			{
				DesiredCapabilities capabilities=new DesiredCapabilities();
				
				if(os.equalsIgnoreCase("window"))
				{
					capabilities.setPlatform(Platform.WIN11);
				}
				else if(os.equalsIgnoreCase("mac"))
				{
					capabilities.setPlatform(Platform.MAC);
				}
				else
				{
					System.out.println("No matching os...");
				}
				
				switch(br.toLowerCase())
				{
				case "chrome" : capabilities.setBrowserName("chrome"); break;
				case "edge" : capabilities.setBrowserName("edge"); break;
				default: System.out.println("no browser found.."); return;
				}
				
				driver = new RemoteWebDriver (new URL("http://192.168.0.199:4444/wd/hub"), capabilities);
			}
			
			
			//executing local environment
			
			if(p.getProperty("execution_env").equalsIgnoreCase("local"))
			{
			switch(br.toLowerCase())
			{
			case "chrome" : ChromeOptions options = new ChromeOptions();

	            Map<String, Object> prefs = new HashMap<>();

	            // Disable Chrome password breach warning
	            prefs.put("profile.password_manager_leak_detection", false);

	            // Disable password manager
	            prefs.put("credentials_enable_service", false);
	            prefs.put("profile.password_manager_enabled", false);

	            options.setExperimentalOption("prefs", prefs);

	            driver = new ChromeDriver(options);
	            break;
	            
			case "edge" : driver=new EdgeDriver(); break;
			default : System.out.println("Invalid Browser.."); return;
			}
			}
			
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("appURL"));
			driver.manage().window().maximize();
		}
		
		
		
		@AfterClass(groups= {"sanity", "Regression", "Master"})
		public void teardown()
		{
			driver.quit();
		}
		
		public String randomeString()
		{
			String generatedString=RandomStringUtils.randomAlphabetic(5);
			return generatedString;
		}
		
		public String randomeNumber()
		{
			String generatedNumber=RandomStringUtils.randomNumeric(10);
			return generatedNumber;
		}
		
		public String randomeAlphaNumeric()
		{
			String generatedString=RandomStringUtils.randomAlphabetic(5);
			String generatedNumber=RandomStringUtils.randomNumeric(5);
			return (generatedString+ "@" + generatedNumber);	
		}
		
		
		
		public String captureScreen (String tname)
		{
			String timeStamp=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
			
			TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
			File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + " " + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
			
			return targetFilePath;
		}
		
	}
