package mx.edu.utez.hoss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.hoss.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
