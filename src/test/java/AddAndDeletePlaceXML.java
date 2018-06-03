import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Library.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import Payload.payload;

public class AddAndDeletePlaceXML {
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
		post("/maps/api/place/add/xml"). 
		then().assertThat().statusCode(200).and().contentType(ContentType.XML) .and().
		extract().response();
		//Task2-Grab the place id from response	
		
		XmlPath x=ReusableMethods.rawtoXML(res);
		String placeid=x.get("PlaceAddResponse.place_id");
		System.out.println(placeid);
		
		
		//Task3- Delete the place using placeid
		
		
	/*
		given().
		queryParam("key","AIzaSyBGZXSmhZ27OIlH2xDSfCnzNqylx2FpoE4").
		body("{\r\n" + 
				"  \"place_id\": \""+placeid+"\"\r\n" + 
				"}").
		when().
		post("/maps/api/place/delete/json").
		 then().assertThat().statusCode(200).and().contentType(ContentType.JSON) .and().
		 body("status",equalTo("OK"));
		*/
		
	}
	}
