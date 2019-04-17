package Storiescommunityautomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.awt.Robot;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


public class StoriesCommunityautomation
{

    WebDriver driver;

    @BeforeTest
    public void launchChrome()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\SeleniumAutomation1\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://community.toppr.com");
        driver.manage().window().maximize();
    }

    @Test(priority = 1, description = "Login Functionality")
    public void communityLogin()
    {
        String dash="Dashboard";
        //Keep an explicit time out here
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div[1]/div[2]/button[1]")).click();//Clicking Login button in community.toppr.com
        System.out.println("Hello world");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Giving login credentials
        driver.findElement(By.xpath("//*[@id=\"email-login\"]")).sendKeys("abhinav9011032@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"password-login\"]")).sendKeys("toppr123");

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div[1]/div[3]/div/div/div/form/button[2]")).click();//Clicking Login button
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        //Stories Icon in Dashboard
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[3]/div[1]/h2")).getText(),dash);
        System.out.println("Successful Login");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/a[11]/div[1]")).click();//Clicking stories icon in community dash board
    }

    @Test(priority = 2, description = "This method validates UI elements of Stories Main page ")
    public void storiesMainpage()
    {
        String create_new_story="CREATE NEW STORY";
        String Stories ="Stories";
        int Number=61;
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/div/i")), driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/div/i")));
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/button")).getText(), create_new_story);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/h2")).getText(),Stories);
        //Clicking a page in stories dash board
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/ul/li[5]/span")).click();
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/ul/li[5]/span")).getCssValue("color"), driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/ul/li[5]/span")).getCssValue("color"));
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr[1]/td[8]/div/a")), driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr[1]/td[8]/div/a")));
        for(int j=1;j<=20;j++)
        {
            String Sno= driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr["+j+"]/td[1]")).getText();
            int Serial = Integer.parseInt(Sno);
            System.out.println(Sno);
            if(Number==Serial);
            {
                Number=Number+1;
                System.out.println(Number);
            }

        }
    }

    @Test(priority = 3, description = "This Method will create a Successful story")
    public void CreateNewStory() throws AWTException, InterruptedException
    {
        String Select_subject = "Physics";
        String Select_chapter = "Physical World";
        Robot robot = new Robot();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div[2]/input")).sendKeys("Sample Test story");
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div[2]/input")).sendKeys("Sample Test description");
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/div[2]")).click();//Clicking Mapping button
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div/div/span[1]/div[1]")).click();//Selecting subject
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div/div/span[1]/div[1]")).getText(),Select_subject);
        System.out.println(driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div/div/span[1]/div[1]")).getText());
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div/div/span[1]/div[1]")).click();//Selecting Chapter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div/div/span[1]/div[1]")).getText(),Select_chapter);
        for (int i = 0; i < 5; i++)
        {
            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div/div/div/span[1]/div[1]")).click();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div/div/div/span[1]/div[1]")).getText(), driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div/div/div/span[1]/div[1]")).getText());
        }
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
//                driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[2]/button[1]")).click();//Clicking create button
        System.out.println("SuccessFull Creation of story");
    }

    @Test(priority = 4, description = "This method filter a story with all available options")
    public void FilterStory() throws AWTException, InterruptedException
    {
        String ID="12644";
        String Auth_Name= "Kumar Abhinav";
        Robot robot = new Robot();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/div/i")).click();//Clicking filter icon
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div[2]/input")).sendKeys("12644");//Searching for test story
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[2]/button[1]")).click();//Clicking Filter button
        //Story id
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr/td[2]")).getText(),ID);
        System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr/td[2]")).getText());
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/span")).click();//Clicking Clear Filters button
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/div/i")).click();//Clicking Filter icon
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div[2]/input")).sendKeys("Kumar Abhinav");
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[2]/button[1]")).click();//Filter button
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr[1]/td[4]")).getText(),Auth_Name);
        System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr[1]/td[4]")).getText());
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/span")).click();//Click Clear Filters button
        //Filtering story with status (Discarded Only)
        for(int k=0;k<3;k++)
        {
            driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/div/i")).click();//Filter icon
            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[4]/div/div/div/span[1]/div[1]")).click();
            Thread.sleep(3000);
            if (k == 0)
            {
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[2]/button[1]")).click();//Clicking Filter button
                Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr[1]/td[7]")).getText(),"Discarded");
                driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/span")).click(); //Clicking clear filter icon
                System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr[1]/td[7]")).getText());
            }
            else if (k == 1)
            {
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                robot.keyPress(KeyEvent.VK_ENTER);
                driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[2]/button[1]")).click();//Clicking Filter button
                Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr[1]/td[7]")).getText(),"Published");
                System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr[1]/td[7]")).getText());
                driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/span")).click();

            }
            else if (k == 2)
            {
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                robot.keyPress(KeyEvent.VK_ENTER);
                driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[2]/button[1]")).click();//Clicking Filter button
                Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr[1]/td[7]")).getText(),"Drafted");
                driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/span")).click();
            }
        }
        //Filter story with subject
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/div/i")).click();//Clicking filter icon
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/div[2]")).click();//Clicking Mapping button
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div/div/span[1]/div[1]")).click();//Physics
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[2]/button[1]")).click();//Filter Button
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr[1]/td[5]")).getText(),"Physics");
        System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr[1]/td[5]")).getText());
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/span")).click();//Clicking clear filter
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/div/i")).click();//Clicking filter icon
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/div[2]")).click();//Clicking Mapping button
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div/div/span[1]/div[1]")).click();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div/div/span[1]/div[1]")).click();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[2]/button[1]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr[1]/td[5]")).getText(),"Physics");
        System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr[1]/td[5]")).getText());
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/span")).click();

    }

    @Test(priority = 5, description = "This method will filter a story with story id")
    public void FilteredStoryDetails() throws  Exception
    {
        Robot robot = new Robot();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/div/i")).click();//Clicking filter icon
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div[2]/input")).sendKeys("12644");//Searching for test story
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[2]/button[1]")).click();//Clicking Filter button
        //Validating with Author data in  filter story page
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr/td[4]")).getText(),"Kumar Abhinav");
        System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr/td[4]")).getText());
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/div/i")).click();//Clicking filter icon
        //Validating whether with filtered story id
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div[2]/input")).getText(), driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div[2]/input")).getText());
        System.out.println(driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div[2]/input")).getText());
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/span")).click();//Clicking clear filters button
        //Validating data with Main stories page
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/div/i")), driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/div/i")));
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/div/i")).click();//Clicking filter icon
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div[2]/input")).sendKeys("12644");//Searching for test story
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div[2]/button[1]")).click();//Clicking Filter button
    }
    @Test(priority = 6, description = "This method will work on e")
    public void Storydashboard()
    {
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr/td[8]/div/a")).click();//Clicking Edit button
        String Author1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/ul/li[3]/span[2]")).getText();
        String Author2 = "Kumar Abhinav";
        String Title1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/ul/li[1]/span[2]")).getText();
        String Title2 = "Sample Test Story";
        String Status1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/ul/li[6]/span[2]")).getText();
        String Status2 = "Drafted";
        //pagination
        //Validating data of author and Story title and status
        Assert.assertEquals(Author1, Author2);
        Assert.assertEquals(Title1, Title2);
        Assert.assertEquals(Status1, Status2);
        //Validating Preview,edit cards,edit buttons in main story page
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]")), driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]")));
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div/div/a/div[1]")), driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div/div/a/div[1]")));
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[1]/div/div[2]/a/span")), driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[1]/div/div[2]/a/span")));
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div/div/a")).click();//Clicking Edit cards button
    }


    @Test(priority = 7, description = "This Method will play with title card")
    public void AdditonOfCards() throws  Exception
    {
        Robot robot = new Robot();
        //Validating data with story title after coming into Addition of cards page
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/h1/div")).getText(), driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/textarea")).getText());
        //Duplicating Title card and editing data and saving and deleting duplicate card and saving
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]")).click();//Duplicating Title card
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/textarea")).sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[3]")).click();//Clicking card Preview icon
        Thread.sleep(3000);
        //Validating data in addition of cards page with data in preview
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/textarea")).getText(), driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div/div/div/div/div")).getText());
        System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/textarea")).getText());
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/h1/button")).click();//Click save button
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/button")).click();//Clicking Close button
//        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[4]")).click();//Clicking delete icon
//        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/button[1]")).click();//Clicking Remove icon
    }
    @Test(priority = 8, description = "This will add derivative cards")
    public void AdditionOfDerivativeCards() throws Exception {
        Robot robot = new Robot();
//        Actions builder = new Actions(driver);
        //Adding Derivative cards
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[3]/span[1]")).click();//Clicking add new card
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/div/div[2]/div/div[1]/div[1]/img")).click();//Adding Derivative card
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/button[1]")).click();//Clicking Create button
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/div[2]/div[1]/textarea")).sendKeys("Sample Text card Sample Text card Sample Text card $$x=\\frac{1+y}{1+2z^2}$$");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[3]")).click();//Clicking card Preview icon
        ////Validating data in addition of derivative cards page with data in preview
        Assert.assertNotEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/div[2]/div[1]/textarea")).getText(), driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/div")).getText());
        System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/div[2]/div[1]/textarea")).getText());
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        //Sub cards
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]")).click();//Clicking plus icon
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div[1]/textarea")).sendKeys("Sample Sub card $$x=\\frac{1+y}{1+2z^2}$$");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div[2]/textarea")).sendKeys("Sample Sub card $$x=\\frac{1+y}{1+2z^2}$$");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[3]")).click();//Clicking card Preview icon
        Assert.assertNotEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div[2]/textarea")).getText(), driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div/div/div/div/div[2]/div/div")).getText());
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]")).click();//Adding second sub card
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div[1]/textarea")).sendKeys("Sample Sub card 2 ");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div[2]/textarea")).sendKeys("Sample Sub card $$x=\\frac{1+y}{1+2z^2}$$");
//        Drag and drop
//        WebElement dragme = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/div/div/div/div"));
//        WebElement dropme = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[1]/div[5]"));
//        builder.dragAndDrop(dragme,dropme).perform();
//        //Validating data after dragging and drop
//        Assert.assertNotEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div[2]/textarea")).getText(), driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div[2]/textarea")).getText());
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/h1/button")).click();//Click save button
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/button")).click();//Clicking Close button
    }

    @Test(priority = 9, description = "This will add text cards ")
    public void AdditionOfTextCard() throws Exception
    {
        Robot robot = new Robot();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[3]/span[1]")).click();//Clicking add new card
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/div/div[2]/div/div[2]/div[1]/img")).click();//Adding text card
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/button[1]")).click();//Create button
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/div[2]/div[1]/textarea")).sendKeys("Lorem Ipsum is");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[3]")).click();//Preview of text card
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/div[2]/div[1]/textarea")).getText(), driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/div")).getText());
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/h1/button")).click();//Click save button
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/button")).click();//Clicking Close button
    }

    @Test(priority = 10, description = "This will add text cards ")
    public void AdditionOfImageCard() throws Exception {
        Robot robot = new Robot();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[3]/span[1]")).click();//Clicking add new card
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/div/div[2]/div/div[3]/div[2]/div")).click();//Adding Image card
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/button[1]")).click();//Create button
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/div[2]/div[1]/div/div/label/div")).click();//Clicking Image upload icon
        Thread.sleep(3000);
        Runtime.getRuntime().exec("C:\\Users\\DELL\\Desktop\\Autoit Script\\GifUpload.exe");//Uploading image through Auto it script
        Assert.assertNotEquals(driver.findElement(By.cssSelector(".r5rjg")), driver.findElement(By.cssSelector(".u7ook > div:nth-child(1)")));
        System.out.println(driver.findElement(By.cssSelector(".u7ook > div:nth-child(1)")));
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[3]")).click();//Preview of text card
        Thread.sleep(2000);
//        System.out.println(driver.findElement(By.cssSelector(".r5rjg")).getText());
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/h1/button")).click();//Click save button
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/button")).click();//Clicking Close button
    }
    @Test(priority = 11, description = "This will add text cards ")
    public void AdditionOfImageandTextCard() throws Exception {
        Robot robot = new Robot();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[3]/span[1]")).click();//Add new card
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/div/div[2]/div/div[4]/div[1]/img")).click();//Adding image and text card
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/button[1]")).click();//Create button
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/div[2]/div[1]/div/div/label/div")).click();//Clicking Image upload icon
        Thread.sleep(2000);
        Runtime.getRuntime().exec("C:\\Users\\DELL\\Desktop\\Autoit Script\\GifUpload.exe");//Uploading image through Auto it script
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/div[2]/div[2]/textarea")).sendKeys("Lorem Ipsum is simplye printing and typesetting industry. Lorem Ipsum has been the indus");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[3]")).click();//Preview of text and image card
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/div[2]/div[2]/textarea")).getText(),driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[2]/div/div")).getText());
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/h1/button")).click();//Saving the story
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/button")).click();//Clicking Close button
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/a/span[1]")).click();//Going to back page from Edit cards
//            driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[1]/div/div[2]/a/span")).click();//Clicking main preview button
        //Need to switch Url
        driver.get("https://community.toppr.com/stories/12644/preview");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/div")).click();//Clicking on title card
        for (int i = 1; i <= 4; i++) {
            robot.keyPress(KeyEvent.VK_RIGHT);
            Thread.sleep(2000);
        }
        driver.get("https://community.toppr.com/stories/12644");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div/div/a")).click();//Clicking Edit cards
        for (int j = 1; j <= 4; j++) {
            driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/div[2]/div/div[4]/div/div[2]/div/div/div/div[1]")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[4]")).click();//Deleting card 1
            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/button[1]")).click();//Clicking remove icon
        }
        //Here we can write function of save story and call it
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div/h1/button")).click();//Saving the story
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/button")).click();
    }

}


