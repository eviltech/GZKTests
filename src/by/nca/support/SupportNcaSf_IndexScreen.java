package by.nca.support;

import by.nca.BaseIndexScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverWrapper;

/**
 * @author Makovsky Dmitry
 * @since 15.09.2015
 */
public class SupportNcaSf_IndexScreen extends BaseIndexScreen {
    private static final String PAGE_URL = "http://support.nca.by:8888/nka_sf.nsf";
    private DriverWrapper wrapper;

    public SupportNcaSf_IndexScreen(WebDriver driver) {
        super(driver, PAGE_URL);
        wrapper = new DriverWrapper(driver);
    }

    //--------Xpath----------
    private static final String USERNAME_FIELD = "//input[@name='Username']";
    private static final String PASSWORD_FIELD = "//input[@name='Password']";
    private static final String LOGIN_BUTTON   = "//input[@value='Войти']";
    //--------Xpath End------

    public SupportNcaSf_MainScreen goToSupportNcaSf_MainScreen(){
        driver.findElement(By.xpath(USERNAME_FIELD)).sendKeys("Test TOR");
        driver.findElement(By.xpath(PASSWORD_FIELD)).sendKeys("123456");
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
        return new SupportNcaSf_MainScreen(driver);
    }
}
