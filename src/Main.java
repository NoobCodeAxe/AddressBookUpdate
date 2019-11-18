import static spark.Spark.*;
import spark.*;

import java.io.IOException;
import org.elasticsearch.*;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.google.gson.Gson;

import spark.ResponseTransformer;


public class Main {
	
	public static String toJson(Object object) {
		ObjectMapper ow = new ObjectMapper();
		
		String json = "";
		
		try{
			json = ow.writeValueAsString(object);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json;
	}


	public static void main(String[] args) {
	
		final ContactService contacts  = new ContactService();
		
		
		get("contact", (request, response) -> {
			response.type("application/json");
			return new Gson().toJson(new Gson().toJsonTree(contacts.getAllUsers()));
        });
		
        post("contact", (request, response) -> {
        	response.type("application/json");
        	User user = new User(request.queryParams("fname"),request.queryParams("lname"),request.queryParams("pnum"),request.queryParams("address"), request.queryParams("email"));
        	contacts.newUser(user);
        	return new Gson().toJson(new Gson().toJsonTree(contacts.getUser(user.getFullName())));
        });
        
        get("contact/:fullName", (request, response) -> {
        	response.type("application/json");
        	return new Gson().toJson(new Gson().toJsonTree(contacts.getUser(request.params(":fullName"))));
        });
        
        put("contact/:fullName", (request, response) -> {
        	response.type("application/json");
        	User user = contacts.getUser(request.params(":fullName"));
        	if(user == null){
        		return "NO USER BY THAT NAME";
        	}
        	
        	user.setfName(request.queryParams("fname"));
        	user.setlName(request.queryParams("lname"));
        	user.setPhoneNumber(request.queryParams("pnum"));
        	user.setAddress(request.queryParams("address"));
        	user.setEmail(request.queryParams("email"));
        
        	return new Gson().toJson(new Gson().toJsonTree(contacts.getUser(request.params(":fullName"))));
        });
        
        delete("contact/:fullName", (request, response) -> {
        	response.type("application/json");
        	return new Gson().toJson(new Gson().toJsonTree(contacts.deleteUser(request.params(":fullName"))));
        });
   
	}

}
