package com.addressBookSystem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

class Contacts {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private Long zip;
	private Long phoneNumber;
	private String email;

	@Override
	public String toString() {
		return "Contacts{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", address='"
				+ address + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", zip=" + zip
				+ ", phoneNumber=" + phoneNumber + ", email='" + email + '\'' + '}';
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getZip() {
		return zip;
	}

	public void setZip(Long zip) {
		this.zip = zip;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	protected void remove(Contacts contacts) {

	}
}
class Sort {
	static Comparator<Contacts> compareCity = new Comparator<Contacts>() {
		public int compare(Contacts one, Contacts two) {
			return one.getCity().compareTo(two.getCity());
		}
	};

}
class AddressBook {
	public List<Contacts> list = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	public void operation() {
		System.out.println("Enter Number of contact you want to add");
		int count = scan.nextInt();
		int contactCount = 1;
		while (contactCount <= count) {

			this.add();
			contactCount++;
		}
		boolean status = true;
		do {

			System.out.println("Choose Operation you want to do");
			System.out.println("1. Add\t2.Edit\t3.Delete\t4.sortCity");
			switch (scan.nextInt()) {
			case 1:
				add();
				break;
			case 2:
				edit();
				break;
			case 3:
				delete();
				break;
			case 4:
				sortCity();
			default:
				status = false;
			}
		} while (status);
	}

	public void add() {
		Contacts contacts = new Contacts();
		System.out.println("Enter the First name:");
		String firstName = scan.next();
		contacts.setFirstName(firstName);

		System.out.println("Enter the Last name:");
		String lastName = scan.next();
		contacts.setLastName(lastName);

		System.out.println("Enter the address:");
		String address = scan.next();
		contacts.setAddress(address);

		System.out.println("Enter the City:");
		String city = scan.next();
		contacts.setCity(city);

		System.out.println("Enter the State:");
		String state = scan.next();
		contacts.setState(state);

		System.out.println("Enter the Zip:");
		Long zip = scan.nextLong();
		contacts.setZip(zip);

		System.out.println("Enter the Phone Number:");
		Long phoneNumber = scan.nextLong();
		contacts.setPhoneNumber(phoneNumber);

		System.out.println("Enter the Email");
		String email = scan.next();
		contacts.setEmail(email);
		this.list.add(contacts);
		print();
	}

	public void edit() {
		System.out.println("Enter your First name:");
		String firstName = scan.next();

		Iterator<Contacts> iterator = this.list.listIterator();

		while (iterator.hasNext()) {
			Contacts contacts = iterator.next();

			if (firstName.equals(contacts.getFirstName())) {
				System.out.println("Choose field you want to add:");
				System.out.println("1.Last Name\t2.Address\t3.City\t4.State\t5. Zip\t6.Phone Number\t7.Email");
				switch (scan.nextInt()) {
				case 1:
					System.out.println("Re-Correct your Last Name");
					contacts.setLastName(scan.next());
					break;
				case 2:
					System.out.println("Re-Correct your Address");
					contacts.setAddress(scan.next());
					break;
				case 3:
					System.out.println("Re-Correct your City");
					contacts.setCity(scan.next());
					break;
				case 4:
					System.out.println("Re-Correct your State");
					contacts.setState(scan.next());
					break;
				case 5:
					System.out.println("Re-Correct your Zip");
					contacts.setZip(scan.nextLong());
					break;
				case 6:
					System.out.println("Re-Correct your Phone Number");
					contacts.setPhoneNumber(scan.nextLong());
				case 7:
					System.out.println("Re-Correct your Email");
					contacts.setEmail(scan.next());
				}

			}
		}
	}

	public void delete() {
		System.out.println("Enter your First name:");
		String firstName = scan.next();

		Iterator<Contacts> iterator = list.listIterator();
		while (iterator.hasNext()) {
			Contacts contacts = iterator.next();

			if (firstName.equals(contacts.getFirstName())) {
				list.remove(contacts);
			}
		}
	}

	public void print() {
		Iterator<Contacts> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public void sortCity() {
		Collections.sort(list, Sort.compareCity);
	}

	@Override
	public String toString() {
		return "AddressBook{" + "list=" + list + '}';
	}
}
public class UC8_SearchPerson {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book System");
		Map<String, AddressBook> map = new HashMap<>();
		System.out.println("Enter Number of address book you want to add");
		Integer count = scan.nextInt();
		Integer i = 0;
		while (i < count) {
			System.out.println("Enter  book name");
			String bookName = scan.next();
			AddressBook addressBook = new AddressBook();
			addressBook.operation();
			map.put(bookName, addressBook);
			i++;
		}
		System.out.println(map);

	}

}
