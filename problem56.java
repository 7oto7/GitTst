//კონსოლიდან შეგყვავს n და შემდეგ n ცალი მთელი რიცხვი, დაალაგეთ რიცხვები
//ზრდადობით და დაბეჭდეთ.
import acm.program.ConsoleProgram;

public class problem56 extends ConsoleProgram{
	public void run(){
		int n = readInt("Enter n: ");
		int[] nums = new int[n];
		for(int i = 0; i < n; i++){
			nums[i] = readInt("Enter numbre: ");
		}
	}
}
