package pathAndQueryParam;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener {
	
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extentReport;
	public static ExtentTest test;

	public void generateExtentReport() {
	
	  sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/extent/sparkReport.html");
	  sparkReporter.config().setDocumentTitle("Rest Assured Automation API Test");
	  sparkReporter.config().setReportName("Rest Assured Automation");
	  sparkReporter.config().setTheme(Theme.DARK);
	  extentReport= new ExtentReports();
	  extentReport.attachReporter(sparkReporter);
	  
	}

}
