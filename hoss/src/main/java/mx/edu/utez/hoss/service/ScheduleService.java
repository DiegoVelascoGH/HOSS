package mx.edu.utez.hoss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.hoss.entity.Schedule;
import mx.edu.utez.hoss.repository.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepo;
	
	public List<Schedule> getAll(){
		return scheduleRepo.findAll();
	}
	
	public Schedule getOne(long id) {
		return scheduleRepo.findById(id).get();
	}
	
	public Schedule saveOrUpdate(Schedule schedule) {
		return scheduleRepo.save(schedule);
	}
	
	public void remove(long id) {
		scheduleRepo.deleteById(id);
	}
	
}
