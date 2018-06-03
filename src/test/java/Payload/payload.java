package Payload;

public class payload {
	
	public static String getJSONPostData()
	{
	String b=("{\r\n" + 
			"  \"location\": {\r\n" + 
			"    \"lat\": -33.8669710,\r\n" + 
			"    \"lng\": 151.1958750\r\n" + 
			"  },\r\n" + 
			"  \"accuracy\": 50,\r\n" + 
			"  \"name\": \"Google Shoes!\",\r\n" + 
			"  \"phone_number\": \"(02) 9374 4000\",\r\n" + 
			"  \"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\",\r\n" + 
			"  \"types\": [\"shoe_store\"],\r\n" + 
			"  \"website\": \"http://www.google.com.au/\",\r\n" + 
			"  \"language\": \"en-AU\"\r\n" + 
			"}");
	
	return b;
}
	
	
	
	public static String getXMLPostData()
	{
		String b="<PlaceAddRequest>\r\n" + 
				"  <location>\r\n" + 
				"    <lat>-33.8669710</lat>\r\n" + 
				"    <lng>151.1958750</lng>\r\n" + 
				"  </location>\r\n" + 
				"  <accuracy>50</accuracy>\r\n" + 
				"  <name>Google Shoes!</name>\r\n" + 
				"  <phone_number>(02) 9374 4000</phone_number>\r\n" + 
				"  <address>48 Pirrama Road, Pyrmont, NSW 2009, Australia</address>\r\n" + 
				"  <type>shoe_store</type>\r\n" + 
				"  <website>http://www.google.com.au/</website>\r\n" + 
				"  <language>en-AU</language>\r\n" + 
				"</PlaceAddRequest>";
		return b;
	}
}
