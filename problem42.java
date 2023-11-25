import java.awt.event.MouseEvent;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

//Paint-ის მონაკვეთის ხატვის გაკეთება, ჯერ აჭერ მაუსს, ფიქსირდება ერთი წვერო, მერე
//მაუსის მოძრაობისას მონაკვეთიც მოძრაობს რადგან მეორე წვერო არაა დაფიქსირებული და
//კლიკით ფიქსირდება მეორე წვეროც.
public class problem42 extends GraphicsProgram{
	public void run(){
		addMouseListeners();
		
	}
	public void mouseClicked(MouseEvent e){
		makeLine();
	}
	private void makeLine() {
		GLine line = new GLine(5, 5, 10, 10);
		add(line);
	}
}
