package pkg1;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParametersTest {

	/**
	 * Use of TestNG data provider and making Data driven approach
	 * @param pageNumber
	 * @param userNumberVal
	 */

	@Test(dataProvider = "Data_Page_User_Number")
	public void getListOfUsers(int pageNumber, int userNumberVal) {
		given().param("page", pageNumber).when().get("https://reqres.in/api/users").then().log().all();
	}

	@Test(dataProvider = "Data_Page_User_Number")
	public void getSingleUser(int pageNumber, int userNumberVal) {
		given().pathParam("userNumber", userNumberVal).when().get("https://reqres.in/api/users/{userNumber}").then()
				.log().all();
	}

	// TestNg Data Provider

	@DataProvider(name = "Data_Page_User_Number")
	public Object[][] getPageNumbernUserNumber() {

		return new Object[][] { { 1, 2 }, { 2, 3 }, { 2, 4 } };

	}

}
