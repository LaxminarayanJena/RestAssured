import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.*;

import Library.ReusableMethods;

public class ParsingJSONToExtractValues {

	@Test
	public void Test() {
		
		RestAssured.baseURI="https://maps.googleapis.com";
		
		Response res=given().
		
		     param("location","-33.8670522,151.1957362").
		     param("radius", "1500").
		     param("key","AIzaSyBGZXSmhZ27OIlH2xDSfCnzNqylx2FpoE4").
		     when().
		     get("/maps/api/place/nearbysearch/json").
		     then().assertThat().statusCode(200).and().contentType(ContentType.JSON) .and().
		     //http://jsoneditoronline.org/
		     body("results[0].name",equalTo("Sydney")). and().
		     body("results[0].place_id",equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
		     header("Server","scaffolding on HTTPServer2").
		     extract().response();
		
		 JsonPath js=ReusableMethods.rawtoJSON(res);
		 int count=js.get("results.size()");
		 System.out.println(count);
		 
		 for(int i=0;i<count;i++)
		 {
			System.out.println(js.get("results["+i+"].name"));
		 }
		 
		
		     
		     
		
		
		

		

		  

	}

}
