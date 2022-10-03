package mx.edu.utez.hoss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.hoss.entity.Role;
import mx.edu.utez.hoss.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getAll() {
		return roleRepository.findAll();
	}
	
	public Role getOne(long id) {
		return roleRepository.findById(id).get();
	}
	
	public Role saveOrUpdate(Role role) {
		return roleRepository.save(role);
	}
	
	public void remove(long id) {
		roleRepository.deleteById(id);
	}
	
}
