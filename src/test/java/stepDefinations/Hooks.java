package stepDefinations;

import java.io.IOException;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;

public class Hooks {

	public static String sc_name;
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{		//execute this code only when place id is null
		//write a code that will give you place id
		
		StepDefination m =new StepDefination();
		if(StepDefination.place_id==null)
		{
		
		m.add_Place_Payload_with("Shetty", "French", "Asia");
		m.user_calls_with_http_request("AddPlaceAPI", "POST");
		m.verify_place_Id_created_maps_to_using("Shetty", "getPlaceAPI");
		}
		
		

	}
	@Before
	public String getScenarioName(Scenario scenario) {
		
		sc_name = scenario.getName();
		
		return sc_name;
		
	}
}
