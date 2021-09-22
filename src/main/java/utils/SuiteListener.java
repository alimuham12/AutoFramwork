package main.java.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import test.java.BaseTests;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class SuiteListener implements ITestListener, IAnnotationTransformer {
    @Override
    public void onTestStart(ITestResult iTestResult) {
    }


    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        String fileName = iTestResult.getMethod().getMethodName();
        File f = ((TakesScreenshot) BaseTests.driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(f,new File(("C:\\Users\\IVL-Muhammad\\IdeaProjects\\AutoFramwork\\screenshots\\" + fileName + ".png")));


        }
        catch (IOException e){
            e.printStackTrace();
        }

    }


    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }



    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method)
    {


    }



}
