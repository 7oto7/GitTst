
import stanford.karel.SuperKarel;

public class problem08 extends SuperKarel{
	public void run(){
		for(int i=0; i<5; i++){
			buildHouse();
			}
		drawSun();
	}
	
	private void drawSun() {
		turnLeft();
		for(int i=0; i<19; i++){
			move();
		}
		turnLeft();
		for(int i=0; i<5; i++){
			move();
		}
		turnAround();
		drawFirst();
		drawSecond();
		drawThird();
		drawSecond();
		drawFirst();
		for(int i=0; i<4; i++){
			move();
		}
		putBeeper();
		turnLeft();
		move();
		putBeeper();
		move();
		turnLeft();
	}


	private void drawThird() {
		while(frontIsClear()){
			move();
			putBeeper();
		}
		turnAround();
		move();
		turnAround();
		marjvena();
	}

	private void drawSecond() {
		move();
		move();
		for(int i=0; i<3; i++){
			move();
			putBeeper();
		}
		for(int i=0; i<3; i++){
			move();
		}
		marcxena();
	}

	private void marcxena() {
		move();
		turnLeft();
		move();
		turnRight();
		turnAround();
		
	}

	private void drawFirst() {
		move();
		move();
		for(int i=0; i<3; i++){
			move();
			putBeeper();
			move();
		}
		marjvena();
		
		
	}

	private void marjvena() {
		move();
		turnRight();
		move();
		turnLeft();
		turnAround();
		
	}

	private void buildHouse() {
		move();
		move();
		putBeeper();
		turnLeft();
		buildRow();
		buildRoof();
		turnAround();
		for(int i=0; i<5; i++){
			move();
			putBeeper();
		}
		turnAround();
		for(int i=0; i<4; i++){
			move();
		}
		turnLeft();
		move();
		for(int i=0; i<2; i++){
			move();
			putBeeper();
		}
		turnAround();
		for(int i=0; i<5; i++){
			move();
		}
		buildWindow();
		buildDoor();
		
	}

	private void buildWindow(){
		turnRight();
		move();
		putBeeper();
		move();
		putBeeper();
		for(int i=0; i<2; i++){
			turnLeft();
			move();
			putBeeper();
		}
	}

	private void buildDoor(){
		turnRight();
		move();
		for(int i=0; i<4; i++){
			move();
			putBeeper();
		}
		turnRight();
		move();
		move();
		putBeeper();
		turnRight();
		for(int i=0; i<3; i++){
			move();
			putBeeper();
		}
		turnRight();
		move();
		putBeeper();
		turnLeft();
		for(int i=0; i<5; i++){
			move();
		}
		turnRight();
		for(int i=0; i<3; i++){
			move();
		}
		turnRight();
		buildRow();
		turnLeft();
		move();
		
	}
	
	private void buildRow(){
		for(int i=0; i<8; i++){
			move();
			putBeeper();
		}

		
	}
	
	private void buildRoof(){
		turnRight();
		for(int i=0; i<3; i++){
			move();
			turnLeft();
			move();
			putBeeper();
			turnRight();
		}
		for(int i=0; i<3; i++){
			move();
			turnRight();
			move();
			putBeeper();
			turnLeft();
		}
	}
}
	