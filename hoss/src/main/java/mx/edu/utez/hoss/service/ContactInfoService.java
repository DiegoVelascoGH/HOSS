package mx.edu.utez.hoss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.hoss.entity.ContactInfo;
import mx.edu.utez.hoss.repository.ContactInfoRepository;

@Service
public class ContactInfoService {

	@Autowired
	private ContactInfoRepository contactInfoRepository;
	
	public List<ContactInfo> getAll() {
		return contactInfoRepository.findAll();
	}
	
	public ContactInfo getOne(long id) {
		return contactInfoRepository.findById(id).get();
	}
	
	public ContactInfo saveOrUpdate(ContactInfo address) {
		return contactInfoRepository.save(address);
	}
	
	public void remove(long id) {
		contactInfoRepository.deleteById(id);
	}
	
}
