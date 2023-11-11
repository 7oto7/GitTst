


import acm.graphics.GLabel;

import acm.program.GraphicsProgram;

public class dvd extends GraphicsProgram {
	private static final int SPEED = 1;
	private static final int PAUSE_MS = 2;

	public void run() {
		GLabel label = myPanel();
		int vx = SPEED;
		int vy = SPEED;
		
		while (true) {
            label.move(vx, vy);
            pause(PAUSE_MS);

            if (label.getY() + label.getHeight() >= getHeight() || label.getY() <= 0) {
                vy = -vy;
            }

            if (label.getX() + label.getWidth() >= getWidth() || label.getX() <= 0) {
                vx = -vx;
            }
        }
    }
		
		
		
		
	/*	while (true) {
			if (lable.getX() + lable.getWidth() <= getWidth() && lable.getY() <= getHeight()) {
				lable.move(vx, vy);
				pause(PAUSE_MS);
			}
			if (lable.getY() > getHeight() || lable.getY() - lable.getHeight() < 0) {
				vy = -vy;
				lable.move(vx, vy);
			}
			if (lable.getX()  >= getWidth() || lable.getX() < 0) {
				vx = -vx;
				lable.move(vx, vy);
				pause(PAUSE_MS);
			}
		} */
	

	private GLabel myPanel() {
		GLabel lbl = new GLabel("D V D", 100, 100);
		lbl.setFont("Helvetica-50");
		add(lbl);
	    return lbl;
	}
}
