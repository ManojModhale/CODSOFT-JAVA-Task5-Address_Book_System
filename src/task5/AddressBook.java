package task5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddressBook implements Serializable 
{
	private List<Contact> contacts;

	public AddressBook() {
		super();
		// TODO Auto-generated constructor stub
		this.contacts=new ArrayList<Contact>();
	}
	
	public void addContact(Contact contact)
	{
		if(contacts.add(contact))
		{
			System.out.println("Contact Added Successfully.");
			
		}
		
	}
	
	public void removeContact(String name)
	{
		Iterator<Contact> iterator=contacts.iterator();
		while(iterator.hasNext())
		{
			Contact contact=iterator.next();
			if(contact.getName().equalsIgnoreCase(name))
			{
				iterator.remove();
			}
		}
		
	}
	
	public Contact searchConatct(String name)
	{
		for (Contact contact : contacts) 
		{
			if(contact.getName().equalsIgnoreCase(name))
			{
				return contact;
				
			}
		}
		return null;
	}
	
	public void displayAll()
	{
		if(contacts.isEmpty())
		{
			System.out.println("Address Book is Empty.");
		}
		else
		{
			System.out.println("All Contacts : ");
			for (Contact contact : contacts) 
			{
				System.out.println(contact);
			}
		}		
	}
	
	 public void readFromStorage(String filename) 
	 {
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) 
	        {
	            contacts = (List<Contact>) ois.readObject();
	            System.out.println("Data loaded successfully.");
	        } 
	        catch (FileNotFoundException e) 
	        {
	            System.out.println("File not found. Creating a new address book.");
	            contacts = new ArrayList<>();
	        } 
	        catch (IOException | ClassNotFoundException e) 
	        {
	            System.out.println("Error reading data from storage.");
	            e.printStackTrace();
	        }
	    }

	    public void writeToStorage(String filename) 
	    {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) 
	        {
	            oos.writeObject(contacts);
	            System.out.println("Data saved successfully.");
	        } 
	        catch (IOException e) 
	        {
	            System.out.println("Error writing data to storage.");
	            e.printStackTrace();
	        }
	    }

}
