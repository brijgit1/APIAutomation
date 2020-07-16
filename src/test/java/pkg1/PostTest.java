package pkg1;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostTest {
	/**
	 * Sample example of POST API hit
	 */
	
	@Test
	public void getListOfUsers() {
		given()
		.headers("content-type","application/json")
		.body("{\r\n" + 
				"    \"name\": \"BrijTraining\",\r\n" + 
				"    \"job\": \"TL\"\r\n" + 
				"}")
		.baseUri("https://reqres.in/api/users")
		.when()
		.post()
		.then().log().all();
	}
	
	@Test
	public void getListOfUsers1() {
		given()
		.contentType(ContentType.JSON)
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.get()
		.then().statusCode(200);
	}
	
	@Test
	public void getListOfUsers2() {
		Response response=given()
		.contentType(ContentType.JSON)
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.get();
		
		System.out.println(response.asString());
		
	}
	
	@Test
	public void getListOfUsers3() {
		given()
		.contentType(ContentType.JSON)
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.get().then().body("page", equalTo(1));
		
		/*
		 * JsonPath jp=new JsonPath(responseInString); jp.get("page");
		 */	
	}
	
	@Test
	public void validateEmailOfData3() {
		given()
		.contentType(ContentType.JSON)
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.get()
		.then()
		.assertThat()
		.body("data[2].email", containsString("emma.wong@reqres.in"));	
	}
	
	@Test
	public void validateResponseHeaderServer() {
		given()
		.contentType(ContentType.JSON)
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.get().then()
		.assertThat().header("server", equalTo("cloudflare"));
	}

}
