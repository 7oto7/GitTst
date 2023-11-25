import java.awt.event.MouseEvent;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

//Paint-ის მონაკვეთის ხატვის გაკეთება, ჯერ აჭერ მაუსს, ფიქსირდება ერთი წვერო, მერე
//მაუსის მოძრაობისას მონაკვეთიც მოძრაობს რადგან მეორე წვერო არაა დაფიქსირებული და
//კლიკით ფიქსირდება მეორე წვეროც.
public class problem42 extends GraphicsProgram {
	private GLine line;
	private int x2;

	public void run() {
		addMouseListeners();

	}

	public void mouseClicked(MouseEvent e) {
		if (line == null) {
            // Create a new line only if it hasn't been created yet
            line = new GLine(e.getX(), e.getY(), e.getX(), e.getY());
            add(line);
        } else {
            // Update the endpoint if the line has already been created
            line.setEndPoint(e.getX(), e.getY());
        }
	}
	
//	public void mouseClicked(MouseEvent e) {
//		line = new GLine(e.getX(), e.getY(), e.getX(), e.getY());
//		add(line);
//	}
//
//	public void mouseMoved(MouseEvent e) {
//		line.setEndPoint(e.getX(), e.getY());
//	}
}
