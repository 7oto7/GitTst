/*კარელმა უნდა გაამრავლოს ორი რიცხვი, 2x1 უჯრაზე დევს n ცალი ბრილიანტი, 3x1 უჯრაზე
m ცალი ბრილიანტი, კარელმა 4x1 უჯრაზე უნდა დადოს n * m ბრილიანტი. ჩათვალეთ, რომ
კარელს ჩანთაში უსასრულო რაოდენობის ბრილიანტი აქვს.*/
import stanford.karel.SuperKarel; 

public class problem09 extends SuperKarel{
	public void run(){
		move();
		check();
		takeRest();
	}

	private void takeRest() {
		move();
		while(beepersPresent()){
			pickBeeper();
		}
		move();
		move();
		
	}

	private void check() {
		while(beepersPresent()){
			pickBeeper();
			move();
			while(beepersPresent()){
				pickBeeper();
				move();
				putBeeper();
				move();
				putBeeper();
				turnAround();
				move();
				move();
				turnAround();
			}
				move();
				move();
				turnAround();
				while(beepersPresent()){
					pickBeeper();
					move();
					move();
					putBeeper();
					turnAround();
					move();
					move();
					turnAround();
				}
				move();
				move();
				move();
				turnAround();
		}
		
	}
}