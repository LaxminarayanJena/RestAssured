package Library;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusableMethods {

	
	public static XmlPath rawtoXML(Response res)
	{
		
		String stringResponse=res.asString();
		System.out.println(stringResponse);	
		XmlPath x= new XmlPath(stringResponse);
		return x;
		
		
	}
	
	public static JsonPath rawtoJSON(Response res)
	{
		String stringResponse=res.asString();
		System.out.println(stringResponse);	
		JsonPath x= new JsonPath(stringResponse);
		return x;
		
		
	}
	
	public static String getSessionKey()
	{
		RestAssured.baseURI="http://localhost:8080";
		Response res=given().header("Content-Type","application/json").
		body("{ \"username\": \"selenium\", \"password\": \"123selenium\" }").
		when().
		post("/rest/auth/1/session").
		then().assertThat().statusCode(200).
		extract().response();
		
		JsonPath js=ReusableMethods.rawtoJSON(res);
		String sessionid=js.get("session.value");
		System.out.println(sessionid);
		return sessionid;
	}
}
