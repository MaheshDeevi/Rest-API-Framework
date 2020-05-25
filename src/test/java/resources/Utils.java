package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import stepDefinations.Hooks;

public class Utils {

	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException
	{
		String name = Hooks.sc_name;
		if(req==null)
		{
			Date date = new Date();
			String exec_date = date.toString().replace(":", "_").replace(" ", "_");
			File file = new File(".\\src\\test\\java\\TestResults\\"+name+"("+exec_date+")");
			file.mkdirs();

		PrintStream log =new PrintStream(new FileOutputStream(".\\src\\test\\java\\TestResults\\"+name+"("+exec_date+")\\Request_And_Response.txt"));
		 req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build();
		 return req;
		}
		return req;
		
		
	}
	
	
	public static String getGlobalValue(String key) throws IOException
	{
		Properties prop =new Properties();
		FileInputStream fis =new FileInputStream(".\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	
		
		
	}
	
	
	public String getJsonPath(Response response,String key)
	{
		  String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		return js.get(key).toString();
	}
}
