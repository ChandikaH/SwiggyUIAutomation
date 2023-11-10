package org.swiggy.listeners;


import io.cucumber.java.Scenario;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementation implements ITestListener {


    public void onTestStart(ITestResult result, ITestContext context, Scenario sc) {

        System.out.println("New Test Started" + result.getName());
        System.out.println("Execution started for Scenario: " + sc.getName());
        System.out.println(context.getStartDate());

    }

    public void onTestSuccess(ITestResult result, Scenario sc) {

        System.out.println("Test Successfully Finished" + result.getName());
        System.out.println("Execution successful for Scenario: " + sc.getName());
        System.out.println(sc.getStatus());

    }

    public void onTestFailure(ITestResult result, Scenario sc) {

        System.out.println("Test Failed" + result.getName());
        System.out.println("Execution successful for Scenario: " + sc.getName());
        System.out.println(sc.getStatus());
        System.out.println("Scenario failed: " + sc.isFailed());

    }

    public void onTestSkipped(ITestResult result, Scenario sc) {

        System.out.println("Test Skipped" + result.getName());
        System.out.println("Execution successful for Scenario: " + sc.getName());
        System.out.println(sc.getStatus());


    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        System.out.println("Test Failed but within success percentage" + result.getName());

    }

    public void onStart(ITestContext context) {


        System.out.println("This is onStart method" + context.getOutputDirectory());
        System.out.println(context.getSuite());


    }

    public void onFinish(ITestContext context) {

        System.out.println("This is onFinish method" + context.getPassedTests());
        System.out.println("This is onFinish method" + context.getFailedTests());
        System.out.println(context.getSkippedTests());
    }
}