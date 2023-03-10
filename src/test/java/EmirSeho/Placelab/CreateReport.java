package EmirSeho.Placelab;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateReport {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String email = "";
		String password = "";
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebDriverWait hugeWait = new WebDriverWait(driver, Duration.ofSeconds(3600));
		
		driver.get("https://demo.placelab.com/");
		
		//login screen
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.cssSelector(".large-btn")).click();
		
		//open Data Extraction Report creation page
		driver.findElement(By.cssSelector("ul[class='nav'] li[class='dropdown']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Data Extraction Report']")));
		driver.findElement(By.xpath("//label[text()='Data Extraction Report']")).click();
		
		//browse button
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fileinput-button")));
		driver.findElement(By.cssSelector(".fileinput-button")).click();
		
		//upload file for extraction
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Emir\\Documents\\QAmp\\FileUpload.exe");
		
		//select country
		driver.findElement(By.cssSelector("#options .dropdown-toggle")).click();
		driver.findElement(By.xpath("//label[contains(text(), 'USA')]")).click();
		
		//create report button
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".large-btn")));
		driver.findElement(By.cssSelector(".large-btn")).click();
		
		Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp1);
		
		//go to reports
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#queries-nav-item")));
		driver.findElement(By.cssSelector("#queries-nav-item")).click();
		
		//click on report when it becomes a link
		hugeWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Report Name')]")));
		driver.findElement(By.xpath("//a[contains(text(), 'Report Name')]")).click();
		
		Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp2);
		
	}

}
