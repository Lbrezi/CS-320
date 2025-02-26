package contacts;

public class Contact {
	
	private String lastName;
	private String firstName;
	private String id;
	private String phone;
	private String address;
	
	public Contact(String firstName, String lastName, String id, String phone, String address) {
		if(firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid name");
		}
		if(lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid name");
		}
		if(id == null || id.length()>10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if(phone == null || phone.length()!=10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if(address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		  this.firstName = firstName;
		  this.lastName = lastName;
		  this.id = id;
		  this.phone = phone;
		  this.address = address;
	}
	
	// Id getter/setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	// FirstName getter/setter
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	// LastName getter/setter
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// Phone getter/setter
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	// Address getter/setter
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
