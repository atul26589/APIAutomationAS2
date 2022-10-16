package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import annotations.FrameworkAnnotations;
import reports.ExtentLogger;
import reports.ExtentReport;

public class TestListeners implements ITestListener,ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();
	}
	
	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.tearDownReports();
	}
	
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getName());
		//find author and category
		String[] authors=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author();
		ExtentReport.addAuthor(authors);
		String [] category=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category();
		ExtentReport.addCategory(category);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		if(!result.isSuccess()) {
			ExtentLogger.pass(result.getName()+" is passed");
		}
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(String.valueOf(result.getThrowable()));
	}
	
}
