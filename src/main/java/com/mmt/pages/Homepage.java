package com.mmt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homepage {
    WebDriver driver;
    WebDriverWait wait;

    By FromCity= By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']/input[@autocapitalize='sentences'])[1]");
    By ToCity=By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']/input[@autocapitalize='sentences'])[2]");
   By DepartureDate=By.xpath("(//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73'])[1]");
    By searchButton=By.xpath("//div[@data-testid='home-page-flight-cta']");

    public Homepage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterFromCity(String from) {
        WebElement fromInput = driver.findElement(FromCity);
        fromInput.click();
        fromInput.clear();
        fromInput.sendKeys(from);
        //driver.findElement(By.xpath("//div[contains(text(),'" + from + "')]")).click();
    }

    public void enterToCity(String to) {
        WebElement toInput = driver.findElement(ToCity);
        System.out.println("Clicked");
        toInput.click();
        toInput.clear();
        toInput.sendKeys(to);
        System.out.println(to+"entered");
    }

    public void ChooseDeepatureDate(String dateString)
    {
        String[] parts = dateString.trim().split(" ");
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Click to open calendar
        //WebElement datePicker = wait.until(ExpectedConditions.elementToBeClickable(DepartureDate));
       // js.executeScript("arguments[0].scrollIntoView(true);", datePicker);
        //js.executeScript("arguments[0].click();", datePicker);

        String expectedMonthYear = month + " " + year;


            WebElement currentMonthElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']")));
            String currentMonthYear = currentMonthElement.getText();

            if (currentMonthYear.equalsIgnoreCase(expectedMonthYear)) {
                String dayXpath = "//div[@data-testid='undefined-calendar-day-" + day + "']";
                WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayXpath)));
                //js.executeScript("arguments[0].scrollIntoView(true);", dateElement);
                js.executeScript("arguments[0].click();", dateElement);
                System.out.println("Date is selected");
            } else {
                WebElement rightArrow = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']")));
                //js.executeScript("arguments[0].scrollIntoView(true);", rightArrow);
                js.executeScript("arguments[0].click();", rightArrow);
            }



    }
}
