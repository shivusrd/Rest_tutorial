package apiChaining;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;


public class GetUser {
@Test
	void test_GetUser(ITestContext c) {
	
	int id=(Integer) c.getAttribute("user_id");
	String bearerToken="f69b35e19f86c7cb7a968270910a84c5c86e89e54609fb290728ad8355925b47";
	
	given().
	headers("Authorization","Bearer "+bearerToken)
	.pathParam("id", id)
	.when()
	.get("https://gorest.co.in/public/v2/users/{id}")
	.then().statusCode(200).log().all();
}
}

