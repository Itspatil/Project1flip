package pomclasess;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utlclasses.Utl1;

public class Homepage extends Utl1{

	WebDriver driver;
	@FindBy(xpath="//div[text()='patil']")
	private WebElement profilename;
	
	@FindBy(xpath="//input[@class='_3704LK']")
	private WebElement searchbox;
	
	@FindBy(xpath="//span[@class='_10Ermr']")
	private WebElement textonproductlist;
	
	@FindBy(xpath="(//div[@class=\"_30jeq3 _1_WHN1\"])[1]")//
	private WebElement productchek;
	
	@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")
	private List<WebElement> pricelistofproduct;      
	
	@FindBy(xpath="//div[text()='My Profile']")  
	private WebElement myprofilename;
	
	
	
     public Homepage(WebDriver driver) {
    
		PageFactory.initElements(driver, this); 
		this.driver = driver;
		
	}
	
	public String gettext() throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement newtext =wait.until(ExpectedConditions.visibilityOf(profilename));
		String pname =newtext.getText();
		
		return pname;
		
	}
	public void serachproduct() {
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement searchelement =wait.until(ExpectedConditions.visibilityOf(searchbox));
		searchelement.sendKeys("Motorola");
		searchelement.sendKeys(Keys.ENTER);
		
		
	}
	
	public String getvalidtext() {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(productchek));
		String actualwholetext = textonproductlist.getText();
		
		return actualwholetext;
		
	}
	
	public int findlowestprice() {
		List<Integer> pricetag=new ArrayList<>();
		
		for(WebElement prices :pricelistofproduct ){
			pricetag.add(Integer.parseInt(prices.getText().replace("₹", "").replace(",", "")));
		}
		System.out.println(pricetag);	
		Collections.sort(pricetag);
		return pricetag.get(0);
	}

	public void switchtopage(int a) {
		  
		driver.findElement(By.xpath("//a[text()='"+a+"']")).click();
			 WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='ge-49M _2Kfbh8' and text()='"+a+"']")));
			 
			 }

	
	public void hoveronprofile() {
		Actions act=new Actions(driver);
		act.moveToElement(profilename).perform();	
	}
	
	public void clickonmyprofile() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", myprofilename);
		// myprofilename.click();
		}

	

}


