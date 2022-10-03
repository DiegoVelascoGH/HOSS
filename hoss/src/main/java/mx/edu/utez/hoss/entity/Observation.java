package mx.edu.utez.hoss.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "observations")
public class Observation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	//Foreign key for user
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	//Foreign key for room
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
	

}
