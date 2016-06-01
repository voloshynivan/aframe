package com.aframe.reporting;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Created by ivoloshyn on 5/18/2016.
 */
public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult testResult){
        System.out.println(testResult.getName() + " was successfull");
    }

    @Override
    public void onTestFailure(ITestResult testResult){
        //// TODO: 5/18/2016 Add a screenshot

        System.out.println(testResult.getName() + "onTestSuccess says I failed " + testResult.getThrowable().getMessage());

    }

    @Override
    public void onTestSkipped(ITestResult testResult){
        System.out.println(testResult.getName() + " was skipped");
    }
}
