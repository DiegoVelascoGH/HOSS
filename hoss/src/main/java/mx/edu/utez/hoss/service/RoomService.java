package mx.edu.utez.hoss.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.hoss.entity.Room;
import mx.edu.utez.hoss.repository.RoomRepository;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAll() {
		return roomRepository.findAll();
	}
	
	public Room getOne(long id) {
		return roomRepository.findById(id).get();
	}
	
	public Room saveOrUpdate(Room room) {
		return roomRepository.save(room);
	}
	
	public void remove(long id) {
		roomRepository.deleteById(id);
	}
}
