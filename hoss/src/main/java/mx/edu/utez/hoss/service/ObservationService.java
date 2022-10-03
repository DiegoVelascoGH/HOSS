package mx.edu.utez.hoss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.hoss.entity.Observation;
import mx.edu.utez.hoss.repository.IObservation;

@Service
public class ObservationService {

	@Autowired
	private IObservation observationRepository;
	
	public List<Observation> getAll() {
		return observationRepository.findAll();
	}
	
	public Observation getOne(long id) {
		return observationRepository.findById(id).get();
	}
	
	public Observation saveOrUpdate(Observation observation) {
		return observationRepository.save(observation);
	}
	
	public void remove(long id) {
		observationRepository.deleteById(id);
	}
}
