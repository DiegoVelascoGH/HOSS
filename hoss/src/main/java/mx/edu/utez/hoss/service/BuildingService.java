package mx.edu.utez.hoss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.edu.utez.hoss.repository.BuildingRepository;

import mx.edu.utez.hoss.entity.Building;
public class BuildingService {
    
    @Autowired
    private BuildingRepository buildingRepository;

    public List<Building> getAll() {
		return buildingRepository.findAll();
	}
	
	public Building getOne(long id) {
		return buildingRepository.findById(id).get();
	}
	
	public Building saveOrUpdate(Building building) {
		return buildingRepository.save(building);
	}
	
	public void remove(long id) {
		buildingRepository.deleteById(id);
	}
}
