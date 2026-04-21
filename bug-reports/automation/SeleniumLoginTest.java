import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLoginTest {

    static WebDriver driver;

    public static void main(String[] args) {
        // Set up driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Run tests
        testValidLogin();
        testInvalidPassword();
        testEmptyFields();

        driver.quit();
        System.out.println("All tests completed.");
    }

    // TC_01: Valid login should reach secure area
    static void testValidLogin() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String url = driver.getCurrentUrl();
        if (url.contains("secure")) {
            System.out.println("PASS — TC_01: Valid login successful");
        } else {
            System.out.println("FAIL — TC_01: Valid login failed");
        }
    }

    // TC_02: Invalid password should show error
    static void testInvalidPassword() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("wrongpassword");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement error = driver.findElement(By.id("flash"));
        if (error.isDisplayed()) {
            System.out.println("PASS — TC_02: Error message shown for invalid password");
        } else {
            System.out.println("FAIL — TC_02: No error message shown");
        }
    }

    // TC_03: Empty fields should show error
    static void testEmptyFields() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement error = driver.findElement(By.id("flash"));
        if (error.isDisplayed()) {
            System.out.println("PASS — TC_03: Validation shown for empty fields");
        } else {
            System.out.println("FAIL — TC_03: No validation shown");
        }
    }
}
