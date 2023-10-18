/*კარელმა უნდა გაყოს ორი რიცხვი, 2x1 უჯრაზე დევს n ცალი ბრილიანტი, 3x1 უჯრაზე m
ცალი ბრილიანტი, კარელმა 4x1 უჯრაზე უნდა დადოს n / m ბრილიანტი. ჩათვალეთ, რომ n
ზუსტად იყოფა m-ზე და კარელს ჩანთაში უსასრულო რაოდენობის ბრილიანტი აქვს.*/
import stanford.karel.SuperKarel; 

public class problem10 extends SuperKarel{
	public void run(){
		move();
		move();
		turnAround(); //3*1 
		division();
		takeRest();
	}

	private void takeRest() {
		turnAround();
		move();
		while(beepersPresent()){
			pickBeeper();
		}
		
		
	}

	private void division() {
		while(beepersPresent()){
			while(beepersPresent()){
				pickBeeper();
				move();
				if(beepersPresent()){
					pickBeeper();
				}else {
					turnAround();
					move();
					if(beepersPresent()){
						while(beepersPresent()){
							pickBeeper();
						}					
					}
					move();
					move();
					while(beepersPresent()){
						pickBeeper();
					}
					turnAround();
					for(int i=0; i<4; i++){
						move();
					}
				}
				
				if(frontIsClear()){
					turnAround();
					move();
					move();//4*1
					move(); //5*1
					putBeeper();
					turnAround();
					move();
					move();											
				}		
			}
			turnAround();
			move();
			putBeeper();
			move();//5*1
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
		}		
	}
}