import java.awt.event.MouseEvent;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

//Paint-ის მონაკვეთის ხატვის გაკეთება, ჯერ აჭერ მაუსს, ფიქსირდება ერთი წვერო, მერე
//მაუსის მოძრაობისას მონაკვეთიც მოძრაობს რადგან მეორე წვერო არაა დაფიქსირებული და
//კლიკით ფიქსირდება მეორე წვეროც.
public class problem42 extends GraphicsProgram {
	private GLine line;
	private int x2;
	private int y2;

	public void run() {
		addMouseListeners();

	}

	public void mousePressed(MouseEvent e) {
		line = new GLine(e.getX(), e.getY(), x2, y2);
		add(line);
	}

	public void mouseMoved(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
	}
}