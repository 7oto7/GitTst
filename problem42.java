import java.awt.event.MouseEvent;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

//Paint-ის მონაკვეთის ხატვის გაკეთება, ჯერ აჭერ მაუსს, ფიქსირდება ერთი წვერო, მერე
//მაუსის მოძრაობისას მონაკვეთიც მოძრაობს რადგან მეორე წვერო არაა დაფიქსირებული და
//კლიკით ფიქსირდება მეორე წვეროც.
public class problem42 extends GraphicsProgram {
	private GLine line;
	private boolean firstVertexFixed;
	public void run() {
		addMouseListeners();

	}

	public void mousePressed(MouseEvent e) {
        if (!firstVertexFixed) {
            // First click: fix the first vertex
            line = new GLine(e.getX(), e.getY(), e.getX(), e.getY());
            add(line);
            firstVertexFixed = true;
        } else {
            // Second click: fix the second vertex
            line.setEndPoint(e.getX(), e.getY());
            firstVertexFixed = false; // Reset for the next line segment
        }
    }

    public void mouseMoved(MouseEvent e) {
        if (line != null && firstVertexFixed) {
            // While dragging, update the second vertex
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
