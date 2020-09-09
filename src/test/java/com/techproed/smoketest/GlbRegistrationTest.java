
package com.techproed.smoketest;
import com.techproed.pages.GlbHomePage;
import com.techproed.pages.GlbRegisterPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbRegistrationTest {
    @Test
    public void positiveTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
        GlbRegisterPage glbRegisterPage=new GlbRegisterPage();
        GlbHomePage glbHomePage=new GlbHomePage();
        glbHomePage.joinNowButton.click();
        glbRegisterPage.email.sendKeys(ConfigReader.getProperty("test_email"));
        glbRegisterPage.name.sendKeys(ConfigReader.getProperty("test_username"));
        glbRegisterPage.phoneNumber.sendKeys(ConfigReader.getProperty("test_phone_number"));
        glbRegisterPage.password.sendKeys(ConfigReader.getProperty("test_password"));
        glbRegisterPage.repassword.sendKeys("12347000");//hard coded
        Thread.sleep(3000);
        glbRegisterPage.signUp.click();
        Assert.assertTrue(glbRegisterPage.message.getText().equals("Success!"));
        //This will fail. Expected = Success! But Actual = Success!!
        Driver.closeDriver();

    }
}
