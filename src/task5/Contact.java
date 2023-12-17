package task5;

import java.io.Serializable;

public class Contact implements Serializable 
{
	private String name;
	private String phoneno;
	private String email;
	private Address address;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(String name, String phoneno, String email, Address address) {
		super();
		this.name = name;
		this.phoneno = phoneno;
		this.email = email;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Contact [name=" + name + ", phoneno=" + phoneno + ", email=" + email + ", address=" + address + "]";
	}
}
