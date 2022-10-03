package mx.edu.utez.hoss.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "username", nullable = false, unique = true)
	@NotEmpty(message = "Esta campo es requerido")
    @Size(min = 2, max = 45)
    private String username;
	
	@Column(name = "email", nullable = false, unique = true)
    @NotEmpty(message = "Este campo es requerido")
    @Pattern(regexp = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$")
    @Size(min = 3, max = 50)
    private String email;

    @Column(name = "password", nullable = false)
    @NotEmpty(message = "Este campo es requerido")
    @Size(min = 8, message = "La contraseña debe contener al menos 8 caracteres")
    private String password;
    
    //Foreign key for person
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", nullable = false, unique = true)
    private Person person;
    
    //Foreign key for role
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
    
    //Foreign key for status
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	//Configuration for observations
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Observation> observations;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<AssignedRoom> assignedRooms;
}
