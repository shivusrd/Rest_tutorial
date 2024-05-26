package apiChaining;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;


public class CreateUser {
		@Test
	void test_createUser(ITestContext c) 
	{
		Faker f=new Faker();
		JSONObject ob= new JSONObject();
		ob.put("name", f.name().fullName());
		ob.put("gender", "female");
		ob.put("email", f.internet().emailAddress());
		ob.put("status", "inactive");
		
		String bearerToken="f69b35e19f86c7cb7a968270910a84c5c86e89e54609fb290728ad8355925b47";
		
		int id=given().
		headers("Authorization","Bearer "+bearerToken)
		.contentType("application/json")
		.body(ob.toString())
		
		.when().post("https://gorest.co.in/public/v2/users").jsonPath().getInt("id");
		c.setAttribute("user_id", id);
	}

}
