package utlclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v102.runtime.model.PropertyPreview.Type;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utl1 {

		//Explicit wait
		//screenshot
		//mouse action
		//javascriptexecutor -->scrolling,click,sendkeys
	
	public static void waittillelementappear(WebDriver driver,WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

    public static void waittillelementappear(WebDriver driver,WebElement element,int time) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
    
    public static void waittillelementappear(WebDriver driver,By element,int time) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
    
    public static String getconfigdata(String key) throws IOException {
    	FileInputStream file= new FileInputStream("configuration\\config.properties");
    	Properties prop=new Properties();
    	prop.load(file);
    	return prop.getProperty(key);
    	
    }
    
    public static String getscreenshot(WebDriver driver,String methodname) throws IOException {
    	String path="Screenshots\\"+methodname+".png";
    	TakesScreenshot  ts= (TakesScreenshot)driver;
    	File Source=ts.getScreenshotAs(OutputType.FILE);
    	File destination = new File(path);
    	FileHandler.copy(Source, destination);
    	return path;
    }
}

