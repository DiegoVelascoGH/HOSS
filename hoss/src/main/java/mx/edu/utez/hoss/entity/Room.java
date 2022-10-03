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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "rooms")
public class Room implements Serializable {

	private final static long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//Foreign key for building
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "building")
	private Building building;
	
	//Foreign key for status
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "status")
	private Status status;
	
	//Configuration for observations
	@OneToMany(mappedBy = "room")
	@JsonIgnore
	private List<Observation> observations;
	
	//Configuration for assignedRoom
	@OneToMany(mappedBy = "room")
	@JsonIgnore
	private List<AssignedRoom> assignedRooms;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Observation> getObservations() {
		return observations;
	}

	public void setObservations(List<Observation> observations) {
		this.observations = observations;
	}

	public List<AssignedRoom> getAssignedRooms() {
		return assignedRooms;
	}

	public void setAssignedRooms(List<AssignedRoom> assignedRooms) {
		this.assignedRooms = assignedRooms;
	}
	
}
