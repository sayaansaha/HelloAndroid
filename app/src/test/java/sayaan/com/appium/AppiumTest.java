package com.leanplum.appium;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.CapabilityType;





/**
 * Created by sayaan on 4/22/17.
 */

public class AppiumTest{

    AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "FA6BR0303282");

        //sets app activity
        capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, ".SplashActivity");


        //Sets the app package
        capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.leanplum.testproj");

        //Sets android as desired platform
        capabilities.setCapability("platformName", "Android");

         driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void newsFeedMesssage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement inbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.leanplum.testproj:id/buttonInbox")));
        inbox.click();
        WebElement msg = wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/text1")));
        msg.click();
    }

    @Test
    public void alerts() throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement inbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.leanplum.testproj:id/buttonInbox")));
        driver.navigate().back();
        WebElement cancel = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.leanplum.testproj:id/buttonSchedule")));
        cancel.click();
        WebElement alertbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/alertTitle")));

    }

    @Test
    public void centerPop(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement inbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.leanplum.testproj:id/buttonInbox")));
        driver.navigate().back();
        WebElement cancel = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.leanplum.testproj:id/buttonEndeavour")));
        cancel.click();
        WebElement centpop = wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.TextView")));

    }

    @Test
    public void interstitial(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement inbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.leanplum.testproj:id/buttonInbox")));
        driver.navigate().back();
        WebElement cancel = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.leanplum.testproj:id/buttonCancel")));
        cancel.click();
        WebElement interstitial = wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.TextView")));
    }

    @Test
    public void confirm(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement inbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.leanplum.testproj:id/buttonInbox")));
        driver.navigate().back();
        WebElement cancel = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.leanplum.testproj:id/buttonChallenger")));
        cancel.click();
        WebElement confirmbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
        confirmbox.click();
    }

    @Test
    public void pauseResumeApp(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement inbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.leanplum.testproj:id/buttonInbox")));
        driver.openNotifications();
        WebElement pushNotification = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[contains(@text,'Triggered Push')]")));
        pushNotification.click();
    }




    @After
    public void tearDown(){
        driver.closeApp();
        driver.quit();
    }

    }
