package mx.edu.utez.hoss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.hoss.entity.Person;
import mx.edu.utez.hoss.repository.PersonRepository;

@Service
public class PersonSevice {

	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> getAll() {
		return personRepository.findAll();
	}
	
	public Person getOne(long id) {
		return personRepository.findById(id).get();
	}
	
	public Person saveOrUpdate(Person person) {
		return personRepository.save(person);
	}
	
	public void remove(long id) {
		personRepository.deleteById(id);
	}
	
}
