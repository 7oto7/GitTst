//62. კონსოლიდან შეგვყავს სახელები, მანამ სანამ არ შევიყვანთ ცარიელ სტრინგს. 
//დაბეჭდეთ სახელი და მის გასწვრივ რაოდენობა რამდენჯერ შევიყვანეთ ეს სახელი.

import java.util.HashMap;
import java.util.Map;

import acm.program.ConsoleProgram;

public class problem62 extends ConsoleProgram{
	private static final String SENTINEL = "";
	public void run() {
		Map<String, Integer> nameCounts = 
				new HashMap<String, Integer>();
		
		while(true) {
			String name = readLine("Enter name: ");
			if(name.equals(SENTINEL)) {
				break;
			}
			
			if(!nameCounts.containsKey(name)) {
				nameCounts.put(name, 0);
			}
			
			int newCount = nameCounts.get(name) + 1;
			nameCounts.put(name, newCount);
		}
		
		println(nameCounts);
		
//		 // create an HashMap
//	    HashMap<String, Integer> primeNumbers = new HashMap<>();
//
//	    // add mappings to HashMap
//	    primeNumbers.put("Two", 2);
//	    primeNumbers.put("Three", 3);
//	    System.out.println("Prime Numbers: " + primeNumbers);
//
//	    // create another HashMap
//	    HashMap<String, Integer> numbers = new HashMap<>();
//	    numbers.put("One", 1);
//	    numbers.put("Two", 22);
//
//	    // Add all mappings from primeNumbers to numbers
//	    numbers.putAll(primeNumbers);
//	    System.out.println("Numbers: " + numbers);
		
	}

}