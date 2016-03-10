package org.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
@Table(name = "customers")
@SequenceGenerator(name = "customer_seq_gen", sequenceName = "customer_id_seq", allocationSize = 1)
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq_gen")
	@Column(name = "customer_id")
	private long id;
	
	@Column(name = "first_name")
	private String firstName = "";
	
	@Column(name = "last_name")
	private String lastName = "";
	
	@Column(name = "address")
	private String address = "";
	
	@Column(name = "city")
	private String city = "";
	
	@Column(name = "state")
	private String state = "";
	
	@Column(name = "postal_code")
	private String postalCode = "";
	
	@Column(name = "phone_number")
	private String phoneNumber = "";

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
