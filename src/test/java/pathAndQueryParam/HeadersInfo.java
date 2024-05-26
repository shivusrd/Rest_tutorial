package pathAndQueryParam;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class HeadersInfo {

	//@Test(priority=1)
	void testHeader() {
		
		given()
		.get("https://www.google.com/")
		.then().header("Content-Type", "text/html; charset=ISO-8859-1")
		.log().headers();
		
	}
	
	@Test(priority=2)
void getHeadersInfo() {
		
		Response res=given()
		.get("https://www.google.com/");
		//get single header
		
		String header_value=res.getHeader("Content-Encoding");
		System.out.println("Content-Encoding value is "+  header_value);
		
		//get multiple headers
	Headers headers_values=res.getHeaders();
		for(Header key:headers_values) {
			
			System.out.println(key.getName()+ "     "+ key.getValue());
		}
		
		
		
	}
}
