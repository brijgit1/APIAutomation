package pkg1;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class ParametersTest2 {

	/**
	 * 
	 * Get value of data[0].id from one API call and use this value to next call
	 */
	@Test
	public void getListOfUsers() {
		
		int i=given()
		.when().get("https://reqres.in/api/users")
		.then()
		.extract()
		.path("data[0].id");
		
		System.out.println("Value of i is: "+i);
		given()
		.pathParam("paramName", i)
		.when().get("https://reqres.in/api/users/{paramName}")
		.then().log().all();
		
		
	}

}
