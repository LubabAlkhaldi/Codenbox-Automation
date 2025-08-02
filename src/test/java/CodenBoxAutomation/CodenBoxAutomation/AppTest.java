package CodenBoxAutomation.CodenBoxAutomation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

		List<WebElement> Checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int RandomCheckboxIndex = random.nextInt(Checkbox.size());
		Checkbox.get(RandomCheckboxIndex).click();
	}

	// Switch Window
	@Test(priority = 5, enabled = false)
	public void SwitchWindow() {

		driver.findElement(By.id("openwindow")).click();

		Set<String> handles = driver.getWindowHandles();
		List<String> WindowList = new ArrayList<>(handles);

		driver.switchTo().window(WindowList.get(0));
		System.out.println(driver.getTitle());

		driver.switchTo().window(WindowList.get(1));
		System.out.println(driver.getTitle());
	}

	// Switch Tab
	@Test(priority = 6)
	public void SwitchTab() throws InterruptedException {
		driver.findElement(By.id("opentab")).click();

		Set<String> handels = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(handels);

		driver.switchTo().window(windowList.get(1));
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		driver.switchTo().window(windowList.get(0));
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

	}

	// Handles an alert popup by accepting or dismissing it
	@Test(priority = 7)
	public void Alert() throws InterruptedException {

		WebElement Name1 = driver.findElement(By.id("name"));
		Name1.sendKeys("Lubab");
		Thread.sleep(2000);

		WebElement alertbtn = driver.findElement(By.id("alertbtn"));
		alertbtn.click();
		Thread.sleep(2000);

		driver.switchTo().alert().accept();

		WebElement Name2 = driver.findElement(By.id("name"));
		Name2.sendKeys("Lubab");
		Thread.sleep(2000);

		WebElement confirmbtn = driver.findElement(By.id("confirmbtn"));
		confirmbtn.click();
		Thread.sleep(2000);

		driver.switchTo().alert().dismiss();
	}

	// Prints table cells that contain the word "Selenium"
	@Test(priority = 8)
	public void Table() {

		WebElement TheTable = driver.findElement(By.id("product"));

		List<WebElement> AllThedataInTheTable = TheTable.findElements(By.tagName("td"));

		for (int i = 1; i < AllThedataInTheTable.size(); i = i + 3) {

			if (AllThedataInTheTable.get(i).getText().contains("Selenium")) {
				System.out.println(AllThedataInTheTable.get(i).getText());
			}
		}
	}

	// Hides and shows a textbox and checks its visibility
	@Test(priority = 9)
	public void HideAndShow() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1800)");
		Thread.sleep(2000);

		WebElement displayed_text = driver.findElement(By.id("displayed-text"));
		WebElement hideButton = driver.findElement(By.id("hide-textbox"));

		hideButton.click();
		Thread.sleep(2000);

		Assert.assertFalse(displayed_text.isDisplayed());
		System.out.println("Is text box displayed? " + displayed_text.isDisplayed());
	}

	// Enables and disables a textbox, then enters text into it
	@Test(priority = 10)
	public void EnableAndDisable() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 1800)");
		Thread.sleep(2000);

		WebElement DisableBtn = driver.findElement(By.id("disabled-button"));
		Thread.sleep(2000);

		DisableBtn.click();
		Thread.sleep(2000);

		WebElement EnableBtn = driver.findElement(By.id("enabled-button"));
		EnableBtn.click();
		Thread.sleep(2000);

		WebElement InputField = driver.findElement(By.id("enabled-example-input"));
		InputField.sendKeys("Lubab");
	}

	// Performs mouse hover over a button and prints the options
	@Test(priority = 11)
	public void MouseHover() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1800)");
		Thread.sleep(2000);

		Actions action = new Actions(driver);
		WebElement hoverBtn = driver.findElement(By.id("mousehover"));
		action.moveToElement(hoverBtn).perform();
		Thread.sleep(2000);

		List<WebElement> menuItems = driver.findElements(By.cssSelector(".mouse-hover-content a"));
		for (WebElement item : menuItems) {
			System.out.println("Hover option: " + item.getText());
		}
	}

	// Opens the calendar widget and prints available dates
	@Test(priority = 12)
	public void CalendarOpenTest() throws InterruptedException {
		driver.findElement(By.linkText("Booking Calendar")).click();
		Thread.sleep(2000);

		Set<String> handles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(handles);
		String mainWindow = driver.getWindowHandle();

		for (String handle : windowList) {
			driver.switchTo().window(handle);
			if (driver.getCurrentUrl().contains("booking")) {
				break;
			}
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".datepick.wpbc_calendar")));

		List<WebElement> days = driver.findElements(
				By.xpath("//table[contains(@class,'wpbc_calendar')]//td[not(contains(@class,'date_disabled'))]"));
		for (WebElement day : days) {
			if (!day.getText().trim().isEmpty()) {
				System.out.println("Available day: " + day.getText());
			}
		}

		driver.close();
		driver.switchTo().window(mainWindow);
	}

	// Switches into an iframe and interacts with a dropdown menu
	@Test(priority = 13)
	public void Iframe() throws InterruptedException {
		
		driver.get(URL);
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("window.scrollTo(0,2100)");
		Thread.sleep(3000);
		
		driver.switchTo().frame("courses-iframe");
 
		WebElement BurgerMenu = driver.findElement(By.cssSelector(".ct-mobile-meta-item.btn-nav-mobile.open-menu"));
		BurgerMenu.click();
	}
 
}