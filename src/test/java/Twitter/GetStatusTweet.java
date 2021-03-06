package Twitter;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetStatusTweet {

	String ConsumerKey = "LukYUFWBLMwOE5xjjy8j1Pp17";
	String ConsumerSecret = "I1ygoeHA0M8ymi6O223NrkI038uF0s0n0uvvbas8m38AojLC3K";
	String Token = "1003172218380083200-2yHmYspJ6wCBB1xL3hD0gBFmRjuczy";
	String TokenSecret = "LdUqFQ8I2BfDaCyVe902hLAVs7gfqjmJtW89rzJD60hFm";

	@Test
	public void getLatestTweet()
	{
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
		
		Response res=given().
		auth().
		oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
		queryParam("count","1").
		 when().
	     get("/home_timeline.json").
	     then().extract().response();
		String response = res.asString();
		System.out.println(response);
		JsonPath js= new JsonPath(response);
		System.out.println(js.get("text"));
		System.out.println(js.get("id"));    
		
	}
}
