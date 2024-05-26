package pathAndQueryParam;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesAndHeader {

	//@Test(priority=1)
	void testCookies() {
		
		given()
		.get("https://www.google.com/")
		.then().cookie("AEC","AQTF6Hy48OPp3P7GIJmDGEGD6J-CpWUrne5XGp9Q28x2bQ3mPfLAMG3d2w")
		.log().all();
		
	}
	
	@Test(priority=2)
void getCokkiesInfo() {
		
		Response res=given()
		.get("https://www.google.com/");
		//get single cookie
		
		String cookie_value=res.getCookie("AEC");
		System.out.println(cookie_value);
		
		//get multiple cookies
		Map<String,String> cookies_values=res.getCookies();
		for(String key:cookies_values.keySet()) {
			
			System.out.println(key +"    "+res.getCookie(key));
		}
		
		
		
	}
}
