package mx.edu.utez.hoss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.hoss.entity.Status;
import mx.edu.utez.hoss.repository.StatusRepository;

@Service
public class StatusService {

	@Autowired
	private StatusRepository statusRepository;
	
	public List<Status> getAll() {
		return statusRepository.findAll();
	}
	
	public Status getOne(long id) {
		return statusRepository.findById(id).get();
	}
	
	public Status saveOrUpdate(Status status) {
		return statusRepository.save(status);
	}
	
	public void remove(long id) {
		statusRepository.deleteById(id);
	}
	
}
