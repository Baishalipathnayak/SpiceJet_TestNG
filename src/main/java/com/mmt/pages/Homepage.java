package com.mmt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homepage {
    WebDriver driver;
    WebDriverWait wait;

    By FromCity= By.xpath("//div[text()='From']");
    By ToCity=By.xpath("//div[text()='To']");
    By DepartureDate=By.xpath("//div[@data-testid=\"departure-date-dropdown-label-test-id\"]");


    public Homepage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterFromCity(String from) {
        driver.findElement(FromCity).click();
        driver.findElement(By.xpath("//input[@value='from']")).sendKeys(from);
    }

    public void enterToCity(String to) {
        driver.findElement(ToCity).click();
        driver.findElement(By.xpath("//input[@value='To']")).sendKeys(to);

    }

    public void ChooseDeepatureDate()
    {
        // Open the calendar
        driver.findElement(DepartureDate).click();
        while (true) {
            String monthYear = driver.findElement(By.xpath("//div[@data-testid='undefined-month-June-2025']")).getText();

            if (monthYear.contains("June") && monthYear.contains("2025")) {
                break;
            } else {
                // Click next arrow to go to the next month
                driver.findElement(By.xpath("//div[@data-testid='rightArrow']")).click();
            }
        }

        driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-day-5']")).click();
    }


}
