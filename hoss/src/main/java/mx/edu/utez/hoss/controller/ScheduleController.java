package mx.edu.utez.hoss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.hoss.entity.Schedule;
import mx.edu.utez.hoss.service.ScheduleService;

@RestController
@RequestMapping("/hoss")
@CrossOrigin(origins = "http://127.0.0.1:8081")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleServ;
	
	@GetMapping("/schedules")
	public List<Schedule> list(){
		return scheduleServ.getAll();
	}
	
	@GetMapping("/schedules/{id}")
	public Schedule edit(@PathVariable("id") long id) {
		return scheduleServ.getOne(id);
	}
	
	@PutMapping("/schedules")
	public Schedule update (@RequestBody Schedule schedule) {
		return scheduleServ.saveOrUpdate(schedule);
	}
	
	@DeleteMapping("/schedules")
	public void delete(@RequestParam("id")long id) {
		scheduleServ.remove(id);
	}
}
