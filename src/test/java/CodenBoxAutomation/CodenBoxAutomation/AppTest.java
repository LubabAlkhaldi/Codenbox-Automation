package CodenBoxAutomation.CodenBoxAutomation;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {

	WebDriver driver = new ChromeDriver();
	String URL = "https://codenboxautomationlab.com/practice/";
	Random random = new Random();

	// Open site and maximize browser
	@BeforeTest
	public void Setup() {

		driver.get(URL);
		driver.manage().window().maximize();
	}

	// Select random radio button
	@Test(priority = 1)
	public void RadioButton() {

		List<WebElement> AllRadioButton = driver.findElements(By.className("radioButton"));
		int TotalRadioButtons = driver.findElements(By.className("radioButton")).size(); // Count radio buttons
		int RandomRadioButtonIndex = random.nextInt(TotalRadioButtons);
		
		AllRadioButton.get(RandomRadioButtonIndex).click();
	}

	// Select random country
	@Test(priority = 2)
	public void DynamicDropdown() throws InterruptedException {

		String[] Countries = { "US", "CA", "FR", "DE", "JP", "CN", "IN", "BR", "AU", "IT" };
		int RandomCountriesIndex = random.nextInt(Countries.length);
		WebElement InputField = driver.findElement(By.id("autocomplete"));
		
		InputField.sendKeys(Countries[RandomCountriesIndex]); // Type country name
		Thread.sleep(1000);
		InputField.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));
	}
	
	// Select from static dropdown
	@Test(priority = 3)
	public void StaticDropdown() throws InterruptedException {

		WebElement dropdownElement = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(dropdownElement); // Initialize dropdown
		List<WebElement> Static = dropdown.getOptions();
		int randomIndex = random.nextInt(Static.size() - 1) + 1;

		dropdown.selectByIndex(randomIndex);
		
	    // Print selected option
		String selectedOption = Static.get(randomIndex).getText();
		System.out.println("Selected option from dropdown: " + selectedOption);
	}

	// Click random checkboxes
	@Test(priority = 4)
	public void Checkbox() {

		List<WebElement> Checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		int Options = random.nextInt(Checkboxes.size()) + 1;

	    // Click random checkboxes
		for (int i = 0; i < Options; i++) {
			Checkboxes.get(i).click();
		}
	}

}
