package SpotifyTest;

import com.shaft.driver.SHAFT;
import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class TestSpotify {
    SHAFT.GUI.WebDriver driver;


    //Locators
    By emailInput = By.xpath("//input[@name='username']");
    By NextButton = By.xpath("//button[@data-testid='submit']");
    By passwordInput = By.id("new-password");
    By NameInput = By.xpath("//input[@name='displayName']");
    By DayInput = By.xpath("//input[@name='day']");
    By MonthInput = By.xpath("//select[@name='month']");
    By YearInput = By.xpath("//input[@name='year']");
    By GenderOption = By.xpath("//label[@for='gender_option_female']");
    By checkbox_one = By.xpath("//label[@for='checkbox-marketing']");
    By checkbox_second = By.xpath("//label[@for='checkbox-privacy']");
    By SignupButton = By.xpath("//button[@data-testid='submit']");
    By LoginButton = By.xpath("//button[@id=\"login-button\"]");
    By EmailLoginInput = By.xpath("//input[@id=\"login-username\"]");
    By PassLoginInput = By.xpath("//input[@id=\"login-password\"]");
    By PlayButton = By.xpath("//button[@data-testid='control-button-playpause' and @aria-label='Play']");
    By Addbutton = By.xpath("//button[@aria-label=\"Create playlist or folder\"]");
    By CreatePlaylist = By.xpath("//button[@role='menuitem']//span[normalize-space(text())='Create a new playlist']\n");
    By ToPlaylist = By.xpath("//div[@data-encore-id=\"listRow\" and .//p[@data-encore-id=\"listRowTitle\" and contains(., 'Liked Songs')]]\n");
    By MoreOption = By.xpath("//div[@role='row' and @aria-rowindex='2']//button[@data-testid='more-button']");
    By AddToPlaylist = By.xpath("//button[@role='menuitem' and .//span[normalize-space()='Add to playlist']]\n");
    By SelectPlaylist = By.xpath("((//button[.//span[starts-with(normalize-space(), 'My Playlist #3')]");
    By GoToPlaylist = By.xpath("((//button[.//span[starts-with(normalize-space(), 'My Playlist #')])[1]");


    //Method
    @Test
    public void SignupSteps() throws InterruptedException  {
        driver.browser().navigateToURL("https://www.spotify.com/eg-ar/signup?forward_url=https%3A%2F%2Fopen.spotify.com%2F");
        driver.element().type(emailInput, "esraauber4@gmail.com")
                .and().click(NextButton)
                .and().type(passwordInput, "E@123456789")
                .and().click(NextButton);
        driver.element().type(NameInput, "EsraaMohammed")
                .and().type(DayInput, "11")
                .and().select(MonthInput, "November")
                .and().type(YearInput, "2000")
                .and().click(GenderOption)
                .and().click(NextButton);
        driver.element().click(checkbox_one)
                .and().click(checkbox_second)
                .and().click(SignupButton);

        Thread.sleep(10000);


    }

    @Test
    public void LoginSteps()throws InterruptedException
    {
        driver.browser().navigateToURL("https://accounts.spotify.com/en/login?continue=https%3A%2F%2Fopen.spotify.com%2F");
        driver.element().type(EmailLoginInput, "esraamelghorab@gmail.com")
                .and().type(PassLoginInput, "spotify1112000")
                .and().click(LoginButton);
        Thread.sleep(10000);

    }

    @Test
    public void PlaySong() throws InterruptedException {
      driver.browser().navigateToURL("https://accounts.spotify.com/en/login?continue=https%3A%2F%2Fopen.spotify.com%2F");
      driver.element().type(EmailLoginInput, "esraamelghorab@gmail.com")
              .and().type(PassLoginInput, "spotify1112000")
              .and().click(LoginButton);
      driver.element().click(PlayButton);

        driver.assertThat()
                .element(PlayButton)
                .isEnabled()
                .perform();


      Thread.sleep(90000);

    }

    @Test
    public void CreatePlaylist() throws InterruptedException {
        driver.browser().navigateToURL("https://accounts.spotify.com/en/login?continue=https%3A%2F%2Fopen.spotify.com%2F");
        driver.element().type(EmailLoginInput, "esraamelghorab@gmail.com")
                .and().type(PassLoginInput, "spotify1112000")
                .and().click(LoginButton);
        driver.element().click(Addbutton)
                .and().click(CreatePlaylist);

        Thread.sleep(9000);

    }

    @Test
    public void AddToPlaylist() throws InterruptedException {
        driver.browser().navigateToURL("https://accounts.spotify.com/en/login?continue=https%3A%2F%2Fopen.spotify.com%2F");
        driver.element().type(EmailLoginInput, "esraamelghorab@gmail.com")
                .and().type(PassLoginInput, "spotify1112000")
                .and().click(LoginButton);
        driver.element().click(Addbutton)
                .and().click(CreatePlaylist);
        Thread.sleep(1000);
        driver.browser().navigateToURL("https://open.spotify.com/");
        driver.element().click(ToPlaylist)
                .and().click(MoreOption)
                .and().click(AddToPlaylist)
                .and().click(SelectPlaylist);
        driver.browser().navigateToURL("https://open.spotify.com/");
        driver.element().click(GoToPlaylist);


        Thread.sleep(9000);

    }

    //Before Method
    @BeforeClass
    public void Setup()
    {
        driver= new SHAFT.GUI.WebDriver();
    }

    //After Method
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
