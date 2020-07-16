package pkg1;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class AuthenticateTest {

/*
 * Auth is sample code and will fail scripts as it is just to show as an example
 */
	@Test(dataProvider = "Data_Page_User_Number")
	public void getListOfUsers(int pageNumber, int userNumberVal) {
		given()
		.auth()
		.preemptive()
		.basic("User1", "User2")
		.param("page", pageNumber)
		.when().get("https://reqres.in/api/users");
	}

	@Test(dataProvider = "Data_Page_User_Number")
	public void getSingleUser(int pageNumber, int userNumberVal) {
		given()
		.auth()
		.form("UserId", "Password")
		.pathParam("userNumber", userNumberVal).when().get("https://reqres.in/api/users/{userNumber}").then()
				.log().all();
	}
	
	/*
	 * @Test(dataProvider = "Data_Page_User_Number") public void getSingleUser(int
	 * pageNumber, int userNumberVal) { given() .auth() .oauth2(accessToken)
	 * .pathParam("userNumber",
	 * userNumberVal).when().get("https://reqres.in/api/users/{userNumber}").then()
	 * .log().all(); }
	 */

	// TestNg Data Provider

	@DataProvider(name = "Data_Page_User_Number")
	public Object[][] getPageNumbernUserNumber() {

		return new Object[][] { { 1, 2 }, { 2, 3 }, { 2, 4 } };

	}

}
