package restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SimpleGetTest {
	
	
	@Test
	public void GetWeatherDeatail() {
		
		RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification  httpRequest = RestAssured.given();
		
		Response response= httpRequest.request(Method.GET,"/Noida");
		
		String responseBody = response.getBody().asString();
		
		System.out.println("Resposne body is :"+ responseBody);
		
		
		int statusCode = response.getStatusCode();
		
		// Assert that correct status code is returned.

		Assert.assertEquals(statusCode, 200, "User failed to login");
		
		String statusLine = response.getStatusLine();
		
		System.out.println(statusLine);
		  
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type value: " + contentType);
		
		String serverType =  response.header("Server");
		System.out.println("Server value: " + serverType);
		
		String acceptLanguage = response.header("Content-Encoding");
		System.out.println("Content-Encoding: " + acceptLanguage);
		
		
		Headers allHeaders = response.headers();
		 
		// Iterate over all the Headers
		for(Header header : allHeaders)
		{
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}
	
	
		// Retrieve the body of the Response
		ResponseBody body = response.getBody();
	 
		// By using the ResponseBody.asString() method, we can convert the  body
		// into the string representation.
		System.out.println("Response Body is: " + body.asString());
	
		String bodyAsString = body.asString();
		Assert.assertEquals(bodyAsString.contains("Hyderabad") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");

		
	}
	
	
	
	

}
