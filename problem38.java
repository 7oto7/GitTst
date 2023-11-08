import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

//მოხმარებელს აქვს საწყისი თანხა 1000, თამაშობს მანამ სანამ არ წააგებს ყველაფერს. ყოველ
//ჯერზე შეყავს ფსონის თანხა და რიცხვი რომელზეც დებს. ხდება რულეტკის დატრიალების
//სიმულაცია(0-დან 36-მდე შემთხვევითი რიცხვი), მოგების შემთხვევაში მოთამაშეს
//უორმაგედბა დადებული თანხა წაგების შემთხვევაში კი მოთამაშე კარგავს დადებულ თანხას.
//მოთამაშე მოგებულია მაშინ თუ რულეტკაზე ამოსული რიცხვი ემთხვევა მის მიერ დადებულ
//რიცხვს. პროგრამა ყოველ მოქმედებაზე უნდა ბეჭდავდეს შესაბამის შეტყობინებას, ადვილად
//
//რომ გაერკვეს მოთამაშე, რა რიცხვი ამოვიდა, რამდენი წააგო, რამდენი მოიგო, რამდენი აქვს
//ბალანსი.

public class problem38 extends ConsoleProgram{
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private static final int MYBET = 100;
	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 36;
	public void run() {
		int money = 1000;
		while(money != 0){
			int betNumber = readBet();
			int winningNumber = spinRoullete();
			if(betNumber != winningNumber){
				println("You lose 100$");
				money = money - MYBET;
				println("Your balance is " + money);
			} else {
				println("You won 200$");
				money = money + 200;
				println("Your balance is " + money);
			}
		}
	}
	private int readBet() {
		while(true){
			int bet = readInt("Enter number from " + MIN_NUMBER + " to " + MAX_NUMBER);
			if(bet >= MIN_NUMBER && bet <= MAX_NUMBER){
				return bet;
			}
		}
	}
	private int spinRoullete() {
		int winningNum = rgen.nextInt(MIN_NUMBER, MAX_NUMBER);
		println("Roulette result is: " + winningNum);
		return winningNum;
	}
}   
