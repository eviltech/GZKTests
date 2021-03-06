package by.nca.oz;

import by.nca.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PageScreenShot;

import java.io.IOException;

/**
 * Created by eviltech on 05.09.2015.
 */
public class OzNcaByTest extends BaseTest {

    @BeforeMethod()
    public void getNewDriver()	{
        getDriver();
        nullErrors();
    }

    @AfterMethod
    public void closeBrowser()	{
        driver.quit();
    }

    @Test(priority = 1)
    public void SearchForRealEstateObject() throws IOException, InterruptedException {

        String orgId = "500";
        String num = "6248";

        String name = "Monitoring";
        String key = "cdE!b4952q";

        IndexScreen indexScreen = (new IndexScreen(driver));
        indexScreen.selectInvNum();
        SearchByInvNumScreen searchByInvNumScreen = indexScreen.goToOzNcaBy_SearchByInvNumScreen();
        searchByInvNumScreen.insertOrgId(orgId);
        searchByInvNumScreen.selectIn();
        searchByInvNumScreen.insertNum(num);
        searchByInvNumScreen.clickFindBtn();
        searchByInvNumScreen.clickCopying();
        searchByInvNumScreen.login(name, key);
        Thread.sleep(10000);
        PageScreenShot screenshot = new PageScreenShot(driver);
        screenshot.takeScreenShot("Oz_Поиск по объекту недвижимого имущества");
        boolean actualResult = driver.getPageSource().contains("500/C-6248");

        Assert.assertEquals(actualResult,true);
    }
}
