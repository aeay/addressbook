package fi.hh.harjoitustyo.AddressBook.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.harjoitustyo.AddressBook.domain.Address;
import fi.hh.harjoitustyo.AddressBook.domain.AddressRepository;
import fi.hh.harjoitustyo.AddressBook.domain.CityRepository;

@Controller
public class AddressController {
	
	@Autowired
	private AddressRepository repository;
	
	@Autowired
	private CityRepository crepository;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/addressbook", method=RequestMethod.GET)
	public String listAddresses(Model model){
		model.addAttribute("addresses", repository.findAll());
		return "addressbook";
	}
	
	 @RequestMapping(value = "/add")
	    public String addAddress(Model model){
	    	model.addAttribute("address", new Address());
	    	model.addAttribute("cities", crepository.findAll());
	        return "addaddress";
	    }     
	 
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Address address){
	        repository.save(address);
	        return "redirect:addressbook";
	    }    
	 
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteAddress(@PathVariable("id") Long addressId, Model model) {
	    	repository.delete(addressId);
	        return "redirect:/addressbook";
	    }  
	 
	 @RequestMapping(value= "/edit/{id}", method=RequestMethod.GET)
	 	public String editAddress(@PathVariable("id") Long addressId, Model model) {
		 	model.addAttribute("address", repository.findOne(addressId));
		 	model.addAttribute("cities", crepository.findAll());
		 	return "editaddress";
	 }  
	 
	 // REST
	 
	@RequestMapping(value="/addresses", method=RequestMethod.GET)
		public @ResponseBody List<Address> addressListRest() {
			return (List<Address>) repository.findAll();
		}
		
	@RequestMapping(value="/address/{id}", method = RequestMethod.GET)
		public @ResponseBody Address findAddressRest(@PathVariable("id") Long addressId) {
			return repository.findOne(addressId);
		}
	

}
