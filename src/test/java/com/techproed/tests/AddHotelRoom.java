package com.techproed.tests;

import com.techproed.pages.FaceLoginPage;
import com.techproed.pages.FhcLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class AddHotelRoom extends TestBase {
    @Test
    public void addHotelRoomTest(){
        driver.get("http://www.fhctrip.com/Account/Logon");
        FhcLoginPage fhcLoginPage = new FhcLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("Man1ager2!");
        fhcLoginPage.login.click();

    }

}
