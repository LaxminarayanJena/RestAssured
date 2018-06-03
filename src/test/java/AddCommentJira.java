import org.testng.annotations.Test;

import Library.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddCommentJira {
	
	@Test
	public void postData()
	{
		
		
		RestAssured.baseURI="http://localhost:8080";
		Response res=given().
		header("Content-Type","application/json").
		header("Cookie","JSESSIONID="+ReusableMethods.getSessionKey()+"").
		body("{\r\n" + 
				"  \"fields\": {\r\n" + 
				"    \"project\": {\r\n" + 
				"      \"key\": \"RES\"\r\n" + 
				"    },\r\n" + 
				"    \"summary\": \"rupaya Card Defect\",\r\n" + 
				"    \"description\": \"Creating 5th bug\",\r\n" + 
				"    \"issuetype\": {\r\n" + 
				"      \"name\": \"Bug\"\r\n" + 
				"    }\r\n" + 
				"   \r\n" + 
				"   \r\n" + 
				"    \r\n" + 
				"  }\r\n" + 
				"}").
		when().
		post("/rest/api/2/issue").
		then().assertThat().statusCode(201).
        extract().response();
		
		JsonPath js=ReusableMethods.rawtoJSON(res);
		String Issueid=js.get("id");
		System.out.println(Issueid);
	
	}

}
