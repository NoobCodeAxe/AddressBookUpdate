import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 

public class ContactService {

// doing everything with spark and java, then going to figure out how to integrate Elasticsearch

Map<String, User> allUsers = new HashMap<>();

ContactService(){
	//test user
	User user = new User("Mark","Astley");
	allUsers.put(user.getFullName(), user);
}
	
public List<User> getAllUsers() {
	return new ArrayList<>(allUsers.values());
}

public User getUser(String fullname) {
	return allUsers.get(fullname);
}

public boolean userExist(String fullname) {
	if(allUsers.get(fullname)!=null) {
		return true;
	}
	
	return false;
}
	
public void newUser(String fname, String lname, String phone, String address, String email) {
	//check if user is there 
	
	if(getUser(fname+" "+lname) == null) {
		User user = new User(fname,lname,phone,address,email);
		allUsers.put(user.getFullName(), user);
	}
	
}

public String newUser(String fname, String lname, String phone) {
	//check if user is there 
	
	if(getUser(fname+" "+lname) == null) {
		User user = new User(fname,lname,phone);
		allUsers.put(user.getFullName(), user);
		return user.getFullName() + " added";
	}
	return fname + " " +lname+" not added";
}

public String newUser(User user) {
	//check if user is there 
	
	if(getUser(user.getFullName()) == null) {
		allUsers.put(user.getFullName(), user);
		return user.getFullName() + " added";
	}
	return user.getFullName() +" not added";
}

public String newUser(String fname, String lname) {
	//check if user is there 
	
	if(getUser(fname+" "+lname) == null) {
		User user = new User(fname,lname);
		allUsers.put(user.getFullName(), user);
		return user.getFullName() + " added";
	}
	
	return fname + " " +lname+" not added";
}
	

public String deleteUser(String fullName) {
	//check if user is there then delete 
	
	if(getUser(fullName) == null) {
		return "No Such User";
	}else {
		allUsers.remove(fullName);
		return fullName + " removed";
	}
	
}
	
}
