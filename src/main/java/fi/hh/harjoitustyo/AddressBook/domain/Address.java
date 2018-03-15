package fi.hh.harjoitustyo.AddressBook.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName ;
	private String lastName;
	private String street;
	private String postalCode;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "cityid")
	private City city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", street=" + street
				+ ", postalCode=" + postalCode + ", city=" + city + "]";
	}

	public Address(Long id, String firstName, String lastName, String street, String postalCode, City city) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
	}
	
	public Address(String firstName, String lastName, String street, String postalCode, City city) {
		super();
		this.id = null;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
	}
	
	public Address() {
		super();
		this.id = null;
		this.firstName = null;
		this.lastName = null;
		this.street = null;
		this.postalCode = null;
		this.city = null;
	}


	
	
	
}
