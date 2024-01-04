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
	}
}
