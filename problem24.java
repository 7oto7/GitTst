//მომხმარებელს შეყავს მთელი რიცხვი n, პროგრამამ უნდა დაბეჭდოს n ის გამყოფების
//რაოდენობა
import acm.program.ConsoleProgram;

public class problem24 extends ConsoleProgram {
	public void run() {
		int n = readInt("Enter number: ");
		int count = 0;
		for(int i = 1; i <= n; i++){
			if(n % 2 == 0){
				count++;
			}
		}
		println(count);
	}
}
