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
	}

	private Map<String, ArrayList<String>> ReversedHashMap(Map<String, String> pets) {
		
		return null;
	}
}
