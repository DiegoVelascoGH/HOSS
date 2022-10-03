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
@Table(name = "statuses")
public class Status implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_id", nullable = false)
	private Long statusId;
	
	@Column(name = "description", nullable = false)
	@NotEmpty(message = "Este campo es requerido")
	private String description;
	
	//Configuration for user
	@OneToOne(mappedBy = "status")
	@JsonIgnore
	private User user;
	
	//Configuration for room
	@OneToOne(mappedBy = "status")
	@JsonIgnore
	private Room room;
	
	
	public Status() {
		
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
