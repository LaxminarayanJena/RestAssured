import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import Payload.payload;

public class AddAndDeletePlaceJSON {
	Properties prop;
	@BeforeTest
	public void getData() throws IOException {
		 prop= new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\env.properties");
	    prop.load(fis);
	}
	@Test
	public void postData()
	{
			
		//Task1-Grab the response
		RestAssured.baseURI=prop.getProperty("HOST");
		Response res=given().
		queryParam("key",prop.getProperty("key")).
		body(payload.getXMLPostData()).
		when().
		post("/maps/api/place/add/json"). 
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON) .and().
		body("status",equalTo("OK")).
		extract().response();
		String stringResponse=res.asString();
		System.out.println(stringResponse);
		
		//Task2-Grab the place id from response
		
		JsonPath js= new JsonPath(stringResponse);
		String placeid=js.get("place_id");
		System.out.println(placeid);
		
		
		//Task3- Delete the place using placeid
		
		
	
		given().
		queryParam("key","AIzaSyBGZXSmhZ27OIlH2xDSfCnzNqylx2FpoE4").
		body("{\r\n" + 
				"  \"place_id\": \""+placeid+"\"\r\n" + 
				"}").
		when().
		post("/maps/api/place/delete/json").
		 then().assertThat().statusCode(200).and().contentType(ContentType.JSON) .and().
		 body("status",equalTo("OK"));
		
		
	}
	}
