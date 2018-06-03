import org.testng.annotations.Test;

import Library.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateCommentJira {
	
	@Test
	public void postData()
	{
		
		
		RestAssured.baseURI="http://localhost:8080";
		Response res=given().
		header("Content-Type","application/json").
		header("Cookie","JSESSIONID="+ReusableMethods.getSessionKey()+"").
		body("{\r\n" + 
				"      \"body\": \"updating 2ndcomment from automation script\",\r\n" + 
				"      \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"      }\r\n" + 
				"    }").
		when().
		put("/rest/api/2/issue/10004/comment/10002").
		then().assertThat().statusCode(200).
        extract().response();
		
		
		
		JsonPath js=ReusableMethods.rawtoJSON(res);
		String Issueid=js.get("id");
		System.out.println(Issueid);
	
	}

}
