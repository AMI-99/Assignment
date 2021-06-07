package pomAssignment;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLogin1 {
	public String url = "https://github.com/";
	public String path = "C:\\Selenium\\driver\\chromedriver.exe";
	public WebDriver driver;
	Login1 objLogin;
	String expectualString = "Sign in to GitHub  · GitHub";

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get(url);
		objLogin = new Login1(driver);
	}

	@Test
	public void testLogin1() {
		driver.findElement(By.linkText("Sign in")).click();
		objLogin.loginPageGithub("lelythuyvi.h214cla@gm.uit.edu.vn", "@Khongconhom1");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), expectualString);
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
