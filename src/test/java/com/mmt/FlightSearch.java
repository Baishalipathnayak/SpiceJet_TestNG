package com.mmt;

import com.mmt.Base.basetest;
import com.mmt.pages.Homepage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlightSearch extends basetest {
    Homepage homePage;

    @BeforeMethod
    public void setUpPages() {
        homePage = new Homepage(driver);

    }

    @Test
    public void bookFlight() {

        homePage.enterFromCity("Pun");
        homePage.enterToCity("Kol");
        homePage.ChooseDeepatureDate("25 Dec 2025");
       // homePage.clickSearch();
        WebElement searchBtn = driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBtn);
    }
}
