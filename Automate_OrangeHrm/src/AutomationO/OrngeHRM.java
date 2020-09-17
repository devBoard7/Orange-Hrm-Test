package AutomationO;



import java.sql.Time;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrngeHRM {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Actions action = new Actions(driver);
		WebElement pim = driver.findElement(By.id("menu_pim_viewPimModule"));
		action.moveToElement(pim).moveToElement(driver.findElement(By.id("menu_pim_addEmployee"))).click().build().perform();
		driver.findElement(By.id("firstName")).sendKeys("Test");
		driver.findElement(By.id("lastName")).sendKeys("Employee");
		String id_value=driver.findElement(By.id("employeeId")).getText().toString();
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		List<WebElement> employees_record=driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr"));
		int count=employees_record.size();
		for (int i=1;i==count;i++) 
		{  
			WebElement cells=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[i]/td[2]"));
			String cell_value=cells.getText().toString();
			if(cell_value==id_value) {
				
				WebElement check=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[i]/td[1]"));
				check.click();
			}
				
			
		}
		
		driver.findElement(By.id("btnDelete")).click();
	/*	Alert alert = driver.switchTo().alert();
		alert.accept();
		
		for (int i=1;i==count;i++) 
		{  
			WebElement cells=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr["+i+"]/td[2]"));
			String cell_value=cells.getText().toString();
			if(cell_value==id_value) {
				
				  System.out.println("Record not deleted");
			}
				
			else
			{
				  System.out.println("Record deleted successfully");
			}
		}*/
		
	}

}
