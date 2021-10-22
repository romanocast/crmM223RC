package ch.zli.m223.api20a.crm.init;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.zli.m223.api20a.crm.model.impl.AppUserImpl;
import ch.zli.m223.api20a.crm.model.impl.CustomerImpl;
import ch.zli.m223.api20a.crm.repository.CustomerRepository;
import ch.zli.m223.api20a.crm.repository.MemoRepository;
import ch.zli.m223.api20a.crm.repository.RoleRepository;
import ch.zli.m223.api20a.crm.repository.UserRepository;

@Component
public class serverInitialiser implements ApplicationRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private MemoRepository memoRepository;
	
	int createThisManyUsers = 200;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		createAppUser(emailGenerator(4,3,2), passwordGenerator(5), roleGenerator());
		createAppUser(emailGenerator(8,6,3), passwordGenerator(9), roleGenerator());
		
		
		Random rnd = new Random();
		//TOAKS nextint without 0 ?
		for(int i = 0; i < createThisManyUsers; i++) {
			createAppUser(emailGenerator(rnd.nextInt(10), rnd.nextInt(8), rnd.nextInt(5)), passwordGenerator(rnd.nextInt(12)), roleGenerator());
		}
		
		createCustomer("Löffel-George", "HolzTanneWeg 2", "8743 Hinterfotzen", "fotzekönig");
		
	}
	
	public void createCustomer(String name, String street, String city, String memo) {
		CustomerImpl customer = customerRepository.save(new CustomerImpl(name, street, city));
		memoRepository.setMemos(customer, memo);
	}

	public void createAppUser(String email, String password, String role) {
		List<String> newRole = new ArrayList<>();
		newRole.add(role);
		AppUserImpl newUser = userRepository.save(new AppUserImpl(email, password));
		roleRepository.setRoles(newUser, newRole);
		newRole.clear();
	}
	
	public String roleGenerator() {
		Random random = new Random();
		List<String> lastNameList = new ArrayList<>();
		lastNameList.add("Partner");
		lastNameList.add("Director");
		lastNameList.add("Helpdesk Manager");
		lastNameList.add("Compliance Admin");
		lastNameList.add("Security Support");
		lastNameList.add("Generated Role");
		lastNameList.add("Cloud Data deleter");
		lastNameList.add("Billing Guy");
		lastNameList.add("Maintenance");
		lastNameList.add("Specialised Role");
		lastNameList.add("Top Secret Role");
		lastNameList.add("Semi Chef");
		lastNameList.add("Chef");
		lastNameList.add("Worker");

		return lastNameList.get(random.nextInt(lastNameList.size()));
	}
	
	public static String passwordGenerator(int length){
	    final String allowedChars = "0123456789abcdefghijklmnopqrstuvwABCDEFGHIJKLMNOP!§$%&?*+#";
	    SecureRandom random = new SecureRandom();
	    StringBuilder pass = new StringBuilder(length);
	    for (int i = 0; i < length; i++) {
	        pass.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
	    }
	    return pass.toString();
	}
	
	public String emailGenerator(int preAtLetters, int afterAtLetters, int afterDotLetters) {
		
		String email = stringGenerator(preAtLetters) + "@" + stringGenerator(afterAtLetters) + "." + stringGenerator(afterDotLetters);
		
		return email;
	}
	
	public String stringGenerator(int length) {

	    // create a string of all characters
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	    // create random string builder
	    StringBuilder sb = new StringBuilder();

	    // create an object of Random class
	    Random random = new Random();

	    // specify length of random string
	   
	    for(int i = 0; i < length; i++) {

	      // generate random index number
	      int index = random.nextInt(alphabet.length());

	      // get character specified by index
	      // from the string
	      char randomChar = alphabet.charAt(index);

	      // append the character to string builder
	      sb.append(randomChar);
	    }

	    String randomString = sb.toString();
	   
	    return randomString;
	  }
	
	/*
	 List<String> roles = new ArrayList<>();
		roles.add("chef"); roles.add("büetzer");
		AppUserImpl user = userRepository.save(new AppUserImpl("sankeTheRiddelFiddel@budugama.jupi", "hans-jörg"));
		roleRepository.setRoles(user, roles);
		
		roles.clear();
		
		roles.add("azubi"); roles.add("lehrnender");
		AppUserImpl user2 = userRepository.save(new AppUserImpl("sagurkel@budugama.jupi", "banana-joe"));
		roleRepository.setRoles(user2, roles);
	  
	  
	  
	  */
	 
}
