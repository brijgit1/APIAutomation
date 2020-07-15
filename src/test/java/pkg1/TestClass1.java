package pkg1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestClass1 {

	@Test
	public void getListOfUsers() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		// RestAssured.basePath="";
		RequestSpecification reqSpec = RestAssured.given();
		Response response=reqSpec.get();
		int status=response.statusCode();
		System.out.println(status);
	}
	
	@Test
	public void getListOfUsers1() {
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath="api/users?page=2";
		RequestSpecification reqSpec = RestAssured.given();
		Response response=reqSpec.get();
	}

}
