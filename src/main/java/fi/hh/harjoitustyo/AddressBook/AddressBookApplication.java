package fi.hh.harjoitustyo.AddressBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.harjoitustyo.AddressBook.domain.Address;
import fi.hh.harjoitustyo.AddressBook.domain.AddressRepository;
import fi.hh.harjoitustyo.AddressBook.domain.City;
import fi.hh.harjoitustyo.AddressBook.domain.CityRepository;
import fi.hh.harjoitustyo.AddressBook.domain.User;
import fi.hh.harjoitustyo.AddressBook.domain.UserRepository;



@SpringBootApplication
public class AddressBookApplication {
	private static final Logger log = LoggerFactory.getLogger(AddressBookApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner addressDemo(AddressRepository repository, CityRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("cities");
			crepository.save(new City("Helsinki"));
			crepository.save(new City("Vantaa"));
			crepository.save(new City("Tuusula"));
			crepository.save(new City("Turku"));
			crepository.save(new City("Lappeenranta"));
			crepository.save(new City("Oulu"));
			
			log.info("example addresses");
			repository.save(new Address("Elli", "Esimerkki", "Koivukuja 5", "00123", crepository.findByName("Helsinki").get(0)));
			repository.save(new Address("Matti", "Meikäläinen", "Vuoritie 2 C", "01234", crepository.findByName("Vantaa").get(0)));

			log.info("all addresses");
			for (Address address : repository.findAll()) {
				log.info(address.toString());
			}
			
			User user1 = new User("user1", "$2a$04$iRlYk.DM1TjjJiaC5HAK9OLckN64vQW3t1MzEkkT.1ljKHDewzELS", "user1@users.com", "USER");
			User user2 = new User("user2", "$2a$04$Z287eJLugsd.j1701qWMp.b15bDgT.bV9oMWC87fjHUR3xN0CdmWS", "user2@users.com", "USER");
			User user3 = new User("admin", "$2a$04$iw6lfvK6LFWMMsEKuBGVOu.J.PxWJuGxIl916elcjaVZCiqsNlx4q", "admin@bookstore.com", "ADMIN");
			urepository.save(user2);
			urepository.save(user1);
			urepository.save(user3);
		};
	}
}