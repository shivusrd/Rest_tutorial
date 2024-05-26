package pathAndQueryParam;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class PathQuey {

	@Test
	void testANdQuerParams() {
		//https://reqres.in/api/users?page=2&id=5
		
		given().pathParam("mypath","users").queryParam("page",2).queryParam("id",5)
		.when().get("https://reqres.in/api/{mypath}") // we don't need to provide query paramteres.
		                                               // query params goes alongwith the request
		.then().statusCode(200)
		.log().all();
		
	}
}
