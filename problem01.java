
//კარელი დგას 1x1 უჯრაზე. 3x1 უჯრაზე დევს ბრილიანტი, კარელმა ბრილიანტი უნდა
//გადაიტანოს 4x1 უჯრაზე და დაამთავროს მუშაობა.

import stanford.karel.Karel;



public class problem01 extends Karel{
	public void run(){
		move();
		move();
		pickBeeper();
		move();
		putBeeper();
		
	}
}
