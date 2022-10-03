package mx.edu.utez.hoss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.hoss.entity.User;
import mx.edu.utez.hoss.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	public User getOne(long id) {
		return userRepository.findById(id).get();
	}
	
	public User saveOrUpdate(User user) {
		return userRepository.save(user);
	}
	
	public void remove(long id) {
		userRepository.deleteById(id);
	}
	
}
