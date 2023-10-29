
import acm.program.*;

public class problem345 extends ConsoleProgram {

	public void run() {

		while (true) {
			int n = readInt("Enter integer: ");
			if (n == -1)
				break;
			println(luckyNumber(n) ? "Is Lucky" : "Is not Lucky");
		}
	}
	
	
	// Lucky number method
	private boolean luckyNumber(int n) {

		while (n != 0) {

			int reminder = n % 10;
			if (reminder != 4 && reminder != 7)
				return false;
			n /= 10;
		}
		return true;
	}
}
