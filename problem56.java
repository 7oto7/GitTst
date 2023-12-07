//კონსოლიდან შეგყვავს n და შემდეგ n ცალი მთელი რიცხვი, დაალაგეთ რიცხვები
//ზრდადობით და დაბეჭდეთ.
import java.util.Arrays;

import acm.program.ConsoleProgram;

public class problem56 extends ConsoleProgram{
	public void run(){
		int n = readInt("Enter n: ");
		int[] nums = new int[n];
		for(int i = 0; i < n; i++){
			nums[i] = readInt("Enter numbre: ");
		}
		String sorted = sort(nums);
		println(sorted);
		
	}
	private String sort(int[] nums){
		for(int i = 0; i < nums.length; i++){
			int a = nums[i];
			for(int j = i + 1; j < nums.length; j++){
				int b = nums[j];
				if(b < a){
					a = b;
				}
			}
			nums[i] = a;
		}
		String str = Arrays.toString(nums);
		return str;
	}
}
