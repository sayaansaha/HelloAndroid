package com.leanplum.appium;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Created by sayaan on 5/1/17.
 */

public class AvtoSDK {
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
    public void pushReceived() throws URISyntaxException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement inbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.leanplum.testproj:id/buttonInbox")));
        driver.navigate().back();
        //now comes sending a push via a client service
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("https://www.leanplum.com")
                .setPath("/api?")
                .setParameter("appId", "app_An3lMA9MdccQUz2nnqUNBomjbB184npm5vPNozF460Q")
                .setParameter("clientKey", "prod_V3PHCjA775wALExdJ1N0u8ARtP8M1an0X4QGeVA8ZnM")
                .setParameter("action", "sendMessage")
                .setParameter("messageId","5541263528427520")
                .build();

        HttpGet req = new HttpGet(uri);

        driver.openNotifications();
    }

    @Test
    public void pushAppBackgrounded() throws URISyntaxException{
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("https://www.leanplum.com")
                .setPath("/api?")
                .setParameter("appId", "app_An3lMA9MdccQUz2nnqUNBomjbB184npm5vPNozF460Q")
                .setParameter("clientKey", "prod_V3PHCjA775wALExdJ1N0u8ARtP8M1an0X4QGeVA8ZnM")
                .setParameter("action", "sendMessage")
                .setParameter("messageId","4752549223071744")
                .build();

        HttpGet req = new HttpGet(uri);
        driver.runAppInBackground(10);

    }

    @Test
    public  void pushOpenURL() throws URISyntaxException {
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("https://www.leanplum.com")
                .setPath("/api?")
                .setParameter("appId", "app_An3lMA9MdccQUz2nnqUNBomjbB184npm5vPNozF460Q")
                .setParameter("clientKey", "prod_V3PHCjA775wALExdJ1N0u8ARtP8M1an0X4QGeVA8ZnM")
                .setParameter("action", "sendMessage")
                .setParameter("messageId","4752549223071744")
                .build();
        HttpGet req = new HttpGet(uri);

    }

    @Test
    public void Register4Push(){

    }




    @After
    public void tearDown(){
        driver.closeApp();
        driver.quit();
    }
}
