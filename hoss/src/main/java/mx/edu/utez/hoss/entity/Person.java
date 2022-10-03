package mx.edu.utez.hoss.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "people")
public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 50)
    @Pattern(regexp = "^[A-ZÁÉÍÓÚ]{1}[a-zñáéíóú ]*((\\s)?((\\'|\\-|\\.)?([A-ZÁÉÍÓÚ]{1}[a-zñáéíóú]*)+))*$", message = "El nombre debe contener solo caracteres normales y empezar con mayúscula")
    @NotEmpty(message = "Este campo es requerido")
    @Size(min = 2, max = 50)
    private String name;

    @Column(name = "surname", nullable = false, length = 50)
    @Pattern(regexp = "^[A-ZÁÉÍÓÚ]{1}[a-zñáéíóú ]*((\\s)?((\\'|\\-|\\.)?([A-ZÁÉÍÓÚ]{1}[a-zñáéíóú]*)+))*$", message = "El apellido solo debe contener caracteres normales")
    @NotEmpty(message = "Este campo es requerido")
    @Size(min = 2, max = 50)
    private String surname;

    @Column(name = "second_surname", nullable = true, length = 50)
    @Pattern(regexp = "^[A-ZÁÉÍÓÚ]{1}[a-zñáéíóú ]*((\\s)?((\\'|\\-|\\.)?([A-ZÁÉÍÓÚ]{1}[a-zñáéíóú]*)+))*$", message = "El apellido solo debe contener caracteres normales")
    @Size(min = 2, max = 50)
    private String secondSurname;
    
    //Configuration for user
    @OneToOne(mappedBy = "person")
    @JsonIgnore
    private User user;
    
    //Foreign key for address
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_info_id", unique = true, nullable = false)
    private ContactInfo contactInfo;
	
    public Person() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
    
}
