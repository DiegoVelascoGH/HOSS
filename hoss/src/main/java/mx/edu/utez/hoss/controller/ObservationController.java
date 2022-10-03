package mx.edu.utez.hoss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.hoss.entity.Observation;
import mx.edu.utez.hoss.service.ObservationService;

@RestController
@RequestMapping(value = "/hoss")
@CrossOrigin(origins = "http://127.0.0.1:8080")
public class ObservationController {

	@Autowired
	private ObservationService observationService;
	
	@GetMapping("/observations")
	public List<Observation> list() {
		return observationService.getAll();
	}
	
	@GetMapping("/observations/{id}")
	public Observation edit(@PathVariable("id") long id) {
		return observationService.getOne(id);
	}
	
	@PostMapping("/observations")
	public Observation save(@RequestBody Observation observation) {
		return observationService.saveOrUpdate(observation);
	}
	
	@PutMapping("/observations")
	public Observation update(@RequestBody Observation observation) {
		return observationService.saveOrUpdate(observation);
	}
	
	@DeleteMapping("/observations/{id}")
	public void delete(@PathVariable("id") long id) {
		observationService.remove(id);
	}
	
}
