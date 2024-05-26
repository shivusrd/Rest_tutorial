package pathAndQueryParam;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.restassured.response.Response;

public class JsonBodyValidations extends ExtentReportListener{
	
	@BeforeTest
	void startExtentReport() {
		generateExtentReport();
	}
	
@Test
	void jsonBody() {
		
		
		given()
		.get("https://reqres.in/api/users?page=2")
		.then().body("data[1].last_name", equalTo("Ferguson"));
		String methodName=new Exception().getStackTrace()[0].getMethodName();
		String className=new Exception().getStackTrace()[0].getClassName();

		extentReport.createTest(methodName, "verify the last name in json response");
		//test.log(Status.INFO, "Hit the APi and verify the last name details");
		
		
	}
@Test
void jsonBodyMulti() {
	
	
	Response response =given()
	.get("https://reqres.in/api/users?page=2");
	
	Assert.assertEquals(response.getStatusCode(), 200);
	String lastname=response.jsonPath().get("data[2].last_name");
	Assert.assertEquals(lastname, "Funke");
	
}

@Test
void jsonBodyMultiJson() {
	
	boolean status=false;
	Response response =given()
	.get("https://reqres.in/api/users?page=2");
	
	JSONObject ob= new JSONObject(response.asString());//converting string to json object
	for(int i=0;i<ob.getJSONArray("data").length();i++) {
		System.out.println(ob.getJSONArray("data").getJSONObject(i).get("last_name").toString());
		
	}
	//to check particalur last name is present or not
	for(int i=0;i<ob.getJSONArray("data").length();i++) {
		String ln=ob.getJSONArray("data").getJSONObject(i).get("last_name").toString();
		if(ln.equals("Funke")) {
			status=true;
			break;
		}
	}
		Assert.assertEquals(status, true);
		
	}
	
@AfterTest
void endReport() {
	extentReport.flush();
}

}
