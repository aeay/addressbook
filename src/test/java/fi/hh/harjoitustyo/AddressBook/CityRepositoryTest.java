package fi.hh.harjoitustyo.AddressBook;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.harjoitustyo.AddressBook.domain.City;
import fi.hh.harjoitustyo.AddressBook.domain.CityRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CityRepositoryTest {
	
	@Autowired
	private CityRepository repository;
	
	@Test
	public void findByNameShouldReturnCity() {
		List<City> cities = repository.findByName("Helsinki");
		assertThat(cities).hasSize(1);
	}

}
