package pkg1;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LogBasedOnSituations {
	/**
	 * 
	 */
	
	@Test
	public void getListOfUsersUsingFileRead() throws FileNotFoundException {
		FileInputStream fis=new FileInputStream("src/test/resources/createPayload.txt");
		given()
		.headers("content-type","application/json")
		.body(fis)
		.baseUri("https://reqres.in/api/users")
		.when()
		.post()
		.then().log().all();//Response Logging
	}
	
	@Test
	public void requestlogging() throws FileNotFoundException {
		JSONObject jo=new JSONObject();
		jo.put("name", "BrijBhanSIngh");
		jo.put("job", "TL11");
		
		//FileInputStream fis=new FileInputStream("src/test/resources/createPayload.txt");
		given()
		.log().body()//logging a Request Body
		.headers("content-type","application/json")
		.body(jo.toString())
		.baseUri("https://reqres.in/api/users")
		.when()
		.post().then().assertThat().statusCode(201);
		}
	
	@Test
	public void logwhenerror() throws FileNotFoundException {
		JSONObject jo=new JSONObject();
		jo.put("name", "BrijBhanSIngh");
		jo.put("job", "TL11");
		
		//FileInputStream fis=new FileInputStream("src/test/resources/createPayload.txt");
		given()
		.headers("content-type","application/json")
		.body(jo.toString())
		.baseUri("https://reqres.in/api/users")
		.when()
		.post().then().log().ifValidationFails()
		.assertThat().statusCode(203);
		}
	
	
	
}
