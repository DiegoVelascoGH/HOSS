package mx.edu.utez.hoss.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "addresses")
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id", nullable = false)
	private Long addressId;
	
	@Column(name = "street", nullable = false)
	@NotEmpty(message = "Este campo es requerido")
	private String street;
	
	@Column(name = "number", nullable = false)
	@NotEmpty(message = "Este campo es requerido")
	private String number;
	
	@Column(name = "colony", nullable = false)
	@NotEmpty(message = "Este campo es requerido")
	private String colony;
	
	@Column(name = "city", nullable = false)
	@NotEmpty(message = "Este campo es requerido")
	private String city;
	
	//Configuration for user
    @OneToOne(mappedBy = "address_id")
    @JsonIgnore
    private Person person;
    
    public Address() {
    	
    }

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getColony() {
		return colony;
	}

	public void setColony(String colony) {
		this.colony = colony;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
