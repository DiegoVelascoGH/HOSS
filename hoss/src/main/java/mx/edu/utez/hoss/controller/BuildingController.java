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
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.hoss.entity.Building;
import mx.edu.utez.hoss.service.BuildingService;

@RestController
@RequestMapping("/hoss")
@CrossOrigin(origins = "http://127.0.0.1:8080")
public class BuildingController {
    
    
    @Autowired
	private BuildingService buildingService;

    @GetMapping("/buildings")
	public List<Building> list() {
		return buildingService.getAll();
	}
	
	@GetMapping("/buildings/{id}")
	public Building edit(@PathVariable("id") long id) {
		return buildingService.getOne(id);
	}
	
	@PostMapping("/buildings")
	public Building save(@RequestBody Building building) {
		return buildingService.saveOrUpdate(building);
	}
	
	@PutMapping("/buildings")
	public Building update(@RequestBody Building building) {
		return buildingService.saveOrUpdate(building);
	}
	
	@DeleteMapping("/buildings/{id}")
	public void delete(@PathVariable("id") long id) {
		buildingService.remove(id);
	}
}
