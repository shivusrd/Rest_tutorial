package pathAndQueryParam;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation {
	
	@Test
	void jsonSchema() {
		//https://reqres.in/api/users?page=2&id=5
		
		when().get("https://reqres.in/api/users")
		.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("reqres.json"));
		

}
}