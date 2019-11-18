
public class User {
    private String fName;
    private String lName;
    private String phoneNumber;
    private String address;
    private String email;
    private String fullName;
    
    //provide all contact fields  
    User(String fname, String lname, String phoneNumber,String address, String email){
    	this.fName = fname;
    	this.lName = lname;
    	this.fullName = fname + "_" + lname;
    	this.phoneNumber = phoneNumber;
    	this.address = address;
    	this.email = email;
    }
    
    //provide optimal contact fields 
    User(String fname, String lname, String phoneNumber){
    	this.fName = fname;
    	this.lName = lname;
    	this.fullName = fname + "_" + lname;
    	this.phoneNumber = phoneNumber;
    	this.address = "No Address Provided";
    	this.email = "N/A";
    }
    
    //provide bare minimum contact fields 
    User(String fname, String lname){
    	this.fName = fname;
    	this.lName = lname;
    	this.fullName = fname + "_" + lname;
    	this.phoneNumber = "N/A";
    	this.address = "No Address Provided";
    	this.email = "N/A";
    }
    
    //getters and setters
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	 
    
    
    
}
