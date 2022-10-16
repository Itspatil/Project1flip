package pomclasess;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utlclasses.Utl1;

public class Profilepage extends Utl1 {


	@FindBy(xpath="//div[text()='patil dada']")  
	private WebElement username;
	
	WebDriver driver;
	@FindBy(xpath="//div[text()='Manage Addresses']")
	private WebElement manageadress;
	
	@FindBy(xpath="//div[text()='ADD A NEW ADDRESS']")
	private WebElement addadress;
	
	@FindBy(xpath="//span[text()='Manage Addresses']")
	private WebElement manageadresstab;
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement namefield;
	
	@FindBy(xpath="//button[text()='Save']")  
	private WebElement savebutton;
	
	@FindBy(xpath="//textarea[@tabindex='5']")
	private WebElement adresstabb;
	
	@FindBy(xpath="//div[@class='_1CeZIA']")
	private List<WebElement> addresscounts;
	

	public Profilepage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	 
	public boolean verifyenterinprofile() {
		 
		try {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='patil dada']")));
       }catch(Exception e){
    	   return false;
    	   
       }
		return true;
		
	}
	
	public void openmanageadress() {
		manageadress.click();
		}
	
	public void addnewadress(List<String> addressdetails) { 
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(addadress));
		addadress.click();
		
		for(int i=1;i<=4;i++) {
			
			driver.findElement(By.xpath("//input[@tabindex='"+i+"']")).sendKeys(addressdetails.get(i-1));
			}
		
		   adresstabb.sendKeys(addressdetails.get(4));
		   savebutton.click();
		

		}


	public int getaddrescount() {
		return addresscounts.size();
	}
	

}



