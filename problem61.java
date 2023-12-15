import java.util.HashMap;

import acm.program.ConsoleProgram;

public class problem61 extends ConsoleProgram{
	HashMap <Integer, Integer> hashMap = new HashMap<Integer, Integer>();
	public void run(){
		int m = readInt(), n = readInt();
		int[] array = new int[n];
		for(int i = 0; i < n; i++){
			array[i] = readInt();
		}
		
		Boolean found = false;
		for(int i  = 0; i < n; i++){
			//looking for (m - array[i])
//			for(int j = i + 1; j < n; j++){
//				if(array[j] == m - array[i]){
//					found = true;
//					println(i + " " + j);
//					break;
//				}
//			}
			
			int index = hashMap.getOrDefault(m - array[i], -1);
			if(index != -1){
				println(index + " " + i);
				found = true;
				break;
			}
			hashMap.put(array[i], i);
			
		}
		if(!found){
			println("NOT FOUND!!!");
		}
	}
}
