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
import ch.zli.m223.api20a.crm.role.Roles;

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
	
	int createThisManyUsers = 100;
	
	int createThisManyCustomers = 50;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		addSomeUsers();
		/*
		
		createAppUser("1@1.1", "geri", Roles.ADMIN);
		
		createAppUser(emailGenerator(4,3,2), passwordGenerator(5), roleGenerator());
		createAppUser(emailGenerator(8,6,3), passwordGenerator(9), roleGenerator());
		
		
		Random rnd = new Random();
		//TOAKS nextint without 0 ?
		for(int i = 0; i < createThisManyUsers; i++) {
			createAppUser(emailGenerator(rnd.nextInt(10)+1, rnd.nextInt(8)+1, rnd.nextInt(5)+1), passwordGenerator(rnd.nextInt(12)), roleGenerator());
		}
		
		for(int i = 0; i < createThisManyCustomers; i++) {
			createCustomer(nameGenerator(), streetGenerator(), cityGenerator(), memoGenerator());
		}
		*/
		
	}
	
	public void addSomeUsers() {
		AppUserImpl user;
		List<String> roles = new ArrayList<>();
		
		roles.clear();
		roles.add(Roles.USER);
		user = userRepository.save(new AppUserImpl("user", "user"));
		roleRepository.setRoles(user, roles);
		
		roles.clear();
		roles.add(Roles.ADMIN);
		user = userRepository.save(new AppUserImpl("admin", "admin"));
		roleRepository.setRoles(user, roles);
		
		roles.clear();
		roles.add(Roles.USER);
		roles.add(Roles.ADMIN);
		user = userRepository.save(new AppUserImpl("usemin", "usemin"));
		roleRepository.setRoles(user, roles);
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
	
	public String memoGenerator() {
		
		Random random = new Random();
		List<String> memoList = new ArrayList<>();
		memoList.add("he is a dick");
		memoList.add("pays well");
		memoList.add("is a good customer");
		memoList.add("allways complanins about the service");
		memoList.add("doesn't talk a lot");
		memoList.add("wierdo");
		memoList.add("nothing to report");
		memoList.add("this is a memo example");
		memoList.add("nemo is the memo");
		memoList.add("upgrade the version");
		memoList.add("1.2 is outdated");
		memoList.add("bananaphone");
		memoList.add("she has great ...");
		memoList.add("i think there was something in my drink");

		return memoList.get(random.nextInt(memoList.size()));
	}
	
	public String cityGenerator() {
		
		Random rnd = new Random();
		List<String> cityList = new ArrayList<>();
		cityList.add(rnd.nextInt(9999)+ " " + "Mühlhausen");
		cityList.add(rnd.nextInt(9999) + " " + "Entenhausen");
		cityList.add(rnd.nextInt(9999) + " " + "Gotham-City");
		cityList.add(rnd.nextInt(9999) + " " + "Maintown");
		cityList.add(rnd.nextInt(9999) + " " + "Dreckshack");
		cityList.add(rnd.nextInt(9999) + " " + "Megatown");
		cityList.add(rnd.nextInt(9999) + " " + "Hinterrieden");
		cityList.add(rnd.nextInt(9999) + " " + "Oftren");
		cityList.add(rnd.nextInt(9999) + " " + "Güdingen");
		cityList.add(rnd.nextInt(9999) + " " + "Rindlishausen");
		cityList.add(rnd.nextInt(9999) + " " + "Büdishausen");
		cityList.add(rnd.nextInt(9999) + " " + "Reiden");
		cityList.add(rnd.nextInt(9999) + " " + "Rüeblisalat");
		cityList.add(rnd.nextInt(9999) + " " + "Georgstetten");

		return cityList.get(rnd.nextInt(cityList.size()));
	}
	
	public String streetGenerator() {
		
		Random random = new Random();
		List<String> streetList = new ArrayList<>();
		streetList.add("Tannenweg" + " " + random.nextInt(30));
		streetList.add("Hinter der Heide" + " " + random.nextInt(30));
		streetList.add("Gürtelbackerweg" + " " + random.nextInt(30));
		streetList.add("Am Arsch der Heide" + " " + random.nextInt(30));
		streetList.add("Baumholzerweg" + " " + random.nextInt(30));
		streetList.add("Hauptstrasse" + " " + random.nextInt(30));
		streetList.add("Obergrundhöhe" + " " + random.nextInt(30));
		streetList.add("MixindaGarden" + " " + random.nextInt(30));
		streetList.add("Seitenbacherweg" + " " + random.nextInt(30));
		streetList.add("Dorfstrasse" + " " + random.nextInt(30));
		streetList.add("Landstrasse" + " " + random.nextInt(30));
		streetList.add("Autobahnstrasse" + " " + random.nextInt(30));
		streetList.add("Landweg" + " " + random.nextInt(30));
		streetList.add("Güdisbacherstrasse" + " " + random.nextInt(30));

		return streetList.get(random.nextInt(streetList.size()));
	}
	
	public String nameGenerator() {
		
		return firstNameGenerator() + "-" + lastNameGenerator();
	}
	
	public String lastNameGenerator() {
		
		Random random = new Random();
		List<String> lastNameList = new ArrayList<>();
		lastNameList.add("Müller");
		lastNameList.add("Meier");
		lastNameList.add("Bäcker");
		lastNameList.add("Torfstecher");
		lastNameList.add("Bieraustrinker");
		lastNameList.add("Hugentobler");
		lastNameList.add("Arschwanden");
		lastNameList.add("Köppler");
		lastNameList.add("Gönner");
		lastNameList.add("Nicht-Gönner");
		lastNameList.add("Von-Seite");
		lastNameList.add("Unterhueber");
		lastNameList.add("Hueber");
		lastNameList.add("Meiser");

		return lastNameList.get(random.nextInt(lastNameList.size()));
	}
	
	public String firstNameGenerator() {
		
		Random random = new Random();
		List<String> firstNameList = new ArrayList<>();
		firstNameList.add("Hans");
		firstNameList.add("Fritz");
		firstNameList.add("Gerhart");
		firstNameList.add("Joscht");
		firstNameList.add("Kurt");
		firstNameList.add("Max");
		firstNameList.add("Kevin");
		firstNameList.add("Armin");
		firstNameList.add("Justus");
		firstNameList.add("Geri");
		firstNameList.add("Tobi");
		firstNameList.add("Köbi");
		firstNameList.add("Hugo");
		firstNameList.add("Karl");

		return firstNameList.get(random.nextInt(firstNameList.size()));
	}
	
	public String roleGenerator() {
		
		Random random = new Random();
		List<String> roleList = new ArrayList<>();
		roleList.add("Partner");
		roleList.add("Director");
		roleList.add("Helpdesk Manager");
		roleList.add("Compliance Admin");
		roleList.add("Security Support");
		roleList.add("Generated Role");
		roleList.add("Cloud Data deleter");
		roleList.add("Billing Guy");
		roleList.add("Maintenance");
		roleList.add("Specialised Role");
		roleList.add("Top Secret Role");
		roleList.add("Semi Chef");
		roleList.add("Chef");
		roleList.add("Worker");

		return roleList.get(random.nextInt(roleList.size()));
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
		
		return stringGenerator(preAtLetters) + "@" + stringGenerator(afterAtLetters) + "." + stringGenerator(afterDotLetters);
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
