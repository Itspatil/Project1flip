package pomclasess;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utlclasses.Utl1;

public class Loginpage extends Utl1 {

	//POM  contains WebElement constructor methods
	
		@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
		private WebElement Emailid;

		@FindBy(xpath="//input[@type='password']")
		private WebElement password;
		
		@FindBy(xpath="(//button[@type='submit'])[2]")
		private WebElement clickbtn;

		public Loginpage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
			
			
		}
		
		public void entermailid() throws IOException {
			Emailid.sendKeys(getconfigdata("email"));
			
		}
		
		public void enterpassword() throws IOException {
			password.sendKeys(getconfigdata("password"));
			
		}
		
		public void loginbutton() {
			clickbtn.click();
			
		}
		

	}



