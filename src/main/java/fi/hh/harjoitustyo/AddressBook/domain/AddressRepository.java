package fi.hh.harjoitustyo.AddressBook.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long>{

	List<Address> findByFirstName(String firstName);

}