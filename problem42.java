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
		makeLine(e.getX(), e.getY(), e.getX(), e.getY());
	}
	private void makeLine(int i, int j, int k, int l) {
		GLine line = new GLine(i, j, k, l);
		add(line);
	}
}
