package swaglab;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class home_page {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\web driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		String url = "https://www.saucedemo.com";
		driver.get(url);
		driver.manage().window().maximize();
		String userName = "standard_user";
		String password = "secret_sauce";
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(userName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/input")).click();
		int expectedItemsAdded = 8;

		List<WebElement> myButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < myButtons.size(); i++) {
			myButtons.get(i).click();
		}
		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
		String actualItemsAdded = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
		int realNumber = Integer.parseInt(actualItemsAdded);
		Assert.assertEquals(realNumber, expectedItemsAdded);

		// String actualTitle = driver.getTitle();
		// String expectedTitle = "Swag Labs";
		// Assert.assertEquals(actualTitle, expectedTitle);
		// if (actualTitle == expectedTitle) {
		// System.out.println("Passed");

		// } else {
		// System.out.println("Failed title");
		// }

	}

}
