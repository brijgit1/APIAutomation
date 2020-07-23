package pkg1;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PathScenarios {
	/**
	 * 
	 */
	
	@Test
	public void getListOfUsersUsingFileRead() throws FileNotFoundException {
		given()
		.headers("content-type","application/json")
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.get()
		.then().log().all()
		.root("data[0]")
		.body("id", equalTo(1));
	}
	
	@Test
	public void rootPathinRest() {
		//RestAssured.rootPath="data[0]";
		String str=given()
		.headers("content-type","application/json")
		.when()
		.get("https://reqres.in/api/users?page=2").body().asString();
		
		JsonPath jp=new JsonPath(str);//JsonPath scenarios
		
		System.out.println(jp.get("data[0]"));
		
	}
	
	@Test
	public void PrepareSpecification() {
		//RestAssured.rootPath="data[0]";
		RequestSpecBuilder rsb=new RequestSpecBuilder();//Used to prepare Request Spec
		rsb.addHeader("content-type", "application/json");
		rsb.addQueryParam("page", "2");
		rsb.setBaseUri("https://reqres.in/");
		RequestSpecification reqSpec=rsb.build();
		//
		given()
		.spec(reqSpec)
		.when()
		.get("api/users")
		.then().assertThat().statusCode(200);
				
	}
	
	@Test
	public void jsonplaceholderCommentVerification() {
		given()
		.when()
		.get("https://jsonplaceholder.typicode.com/posts/7/comments?id=33")
		.then()
		.body("[0].email", equalTo("Jaeden.Towne@arlene.tv"));
		
	}
		
	
	
}
