package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActitimeLoginUsingParameters {
	WebDriver driver;
	@Given("user launches browser and enters URL of actitime")
	public void user_launches_browser_and_enters_url_of_actitime() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("^enters (.*) and (.*)$")
	public void enters_admin_and_manager(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
	}

	@And("hits on login button")
	public void hits_on_login_button() {
		driver.findElement(By.id("loginButton")).click();
	}

	@Then("^Actitime home page with (.*) is displayed$")
	public void actitime_home_page_with_success_is_displayed(String status) {
		System.out.println(status);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Time-Track"));
		driver.quit();
	}
}
