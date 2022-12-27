package challenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static io.restassured.RestAssured.given;


public class ScanLink {


    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("https://www.elba-tech.com/");
        driver.manage().window().maximize();


        WebElement closeAccept = driver.findElement(By.xpath("//a[@title=\"Close and Accept\"]"));
        closeAccept.click();


        List<WebElement> allLinks = driver.findElements(By.tagName("link"));
        List<String> list = new ArrayList<String>();

        for (WebElement e : allLinks) {
            list.add(e.getAttribute("href"));
        }
        for (String url : list) {
            Response response = given().get(url);
            int status = response.statusCode();
            System.out.println(url + " status = " + status);
        }
        for (String url : list) {
            Response response = given().get(url);
            int status = response.statusCode();
            Assert.assertTrue(status >= 400 && status < 500);
        }

        driver.close();
    }


  //  public static void main(String[] args) throws InterruptedException {

        @Test
        public void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.elba-tech.com/");
        driver.manage().window().maximize();



        WebElement closeAccept = driver.findElement(By.xpath("//a[@title=\"Close and Accept\"]"));
        closeAccept.click();


        WebElement homeButton = driver.findElement(By.xpath("(//span[.='Home'])[1]"));
        homeButton.click();
        Thread.sleep(20);
        String home = driver.getCurrentUrl().toLowerCase();
        String expectedProducts = "https://www.elba-tech.com/";
        Assert.assertEquals(home, expectedProducts);



        WebElement solutionButton = driver.findElement(By.xpath("(//a[@href=\"https://www.elba-tech.com/solutions\"])[1]"));
        solutionButton.click();
        Thread.sleep(20);
        String solutions = driver.getCurrentUrl().toLowerCase();
        String expectedSolutions = "https://www.elba-tech.com/solutions";
        Assert.assertEquals(solutions, expectedSolutions);



        WebElement aboutButton = driver.findElement(By.xpath("(//span[.=\"About\"])[1]"));
        aboutButton.click();
        Thread.sleep(20);
        String about = driver.getCurrentUrl().toLowerCase();
        String expectedAbout = "https://www.elba-tech.com/solutions#";
        Assert.assertEquals(about, expectedAbout);



        WebElement careersButton = driver.findElement(By.xpath("(//span[.=\"Careers\"])[1]"));
        careersButton.click();
        Thread.sleep(20);
        String careers = driver.getCurrentUrl().toLowerCase();
        String expectedCareers = "https://www.elba-tech.com/careers/";
        Assert.assertEquals(careers, expectedCareers);


    }
}




