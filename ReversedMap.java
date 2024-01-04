import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import acm.program.ConsoleProgram;

public class ReversedMap extends ConsoleProgram{
	public void run(){
		Map<String, String> pets = new HashMap<String, String>();
		pets.put("nika", "dog");
		pets.put("ana", "cat");
		pets.put("vaxo", "dog");
		pets.put("bidzo", "zebra");
		println(pets);
		println(pets.toString()); //same as upper one
		
		Map<String, ArrayList<String>> reversedMap = ReversedHashMap(pets);
		println(reversedMap);
	}

	private Map<String, ArrayList<String>> ReversedHashMap(Map<String, String> pets) {
		Map<String, ArrayList<String>> newMap = new HashMap<String, ArrayList<String>>();
		for(String name : pets.keySet()){
			String pet = pets.get(name);
			ArrayList<String> owners = newMap.get(pet);
			if(owners == null){
				owners = new ArrayList<String>();
			}
			owners.add(name);
			newMap.put(pet, owners);
		}
		return newMap;
	}
}
