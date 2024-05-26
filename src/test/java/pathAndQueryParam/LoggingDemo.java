package pathAndQueryParam;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class LoggingDemo {
	
	@Test
	void TestLogs() {
		
		
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.log().body().log().headers().log().cookies();
		
	}

}
