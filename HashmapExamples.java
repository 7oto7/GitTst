import java.util.ArrayList;
import java.util.HashMap;

import acm.program.ConsoleProgram;

public class HashmapExamples extends ConsoleProgram{
	public void run(){
		HashMap <String, Integer> hashMap = new HashMap <String, Integer>();
		ArrayList <Integer> arrayList = new ArrayList <Integer>();
		
		if(!hashMap.containsKey("ABC")){
			hashMap.put("ABC", 2000);
		}
		hashMap.putIfAbsent("ABC", 3000);
		
		hashMap.getOrDefault(key, 7); //null is nacvlad abrunebs default mnishvnelobas (7)
		hashMap.get(key);
		
		hashMap.put("ABC", 3000);
		
		println(hashMap.size());
		println(hashMap);
		println(hashMap.toString());
		
		for( String x : hashMap.keySet()){
			println(x + " " + hashMap.get(x));
		}
	}
}
