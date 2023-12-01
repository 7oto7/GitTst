import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

//ამოცანა 5. ოხერი წრე (35 ქულა)
//თქვენი ამოცანაა დაწეროთ გრაფიკული პროგრამა, რომელიც ფანჯრის ცენტრში დახატავს CIRCLE_D დიამეტრის მქონე შავად გაფერადებულ წრეს. 
//გარდა ამისა პროგრამა უნდა აკმაყოფილებდეს ორ მოთხოვნას:
//•მაუსის ნებისმიერ ადგილზე კლიკით, წრე უნდა იცვლიდეს ფერს რომელიმე შემთხვევით ფერზე. 
//•მაუსის დრაგზე, თუ დარგი მოხდა ცენტრისკენ წრე უნდა შემცირდეს შესაბამისი მანძილით და პირიქით წრე უნდა გაიზარდოს თუ დრაგი მოხდა ცენტრიდან ფანჯრის საზღვრებისკენ.
//ანუ თუ დრაგის დროს მაუსი წრის ცენტრს უახლოვდება, რამდენი პიქსელითაც უფრო ახლოს არის მაუსი ცენტრთან იმდენი პიქსელით უნდა შემცირდეს წრეწირის რადიუსი.
//თუ მაუსი წრეწირის ცენტრს შორდება, მაშინ წრის რადიუსი უნდა გაიზარდოს იგივე პრინციპით.
public class midtermOxeriWre extends GraphicsProgram {
	private int CIRCLE_D = 80;
	private GOval circle;
	private int prev;
	private int curr;
	RandomGenerator rgen = RandomGenerator.getInstance();

	public void run() {
		addMouseListeners();
		makeCircle();
	}

	private void makeCircle() {
		circle = new GOval(CIRCLE_D, CIRCLE_D);
		circle.setFilled(true);
		add(circle, getWidth() / 2 - CIRCLE_D / 2, getHeight() / 2 - CIRCLE_D / 2);
	}

	public void mouseClicked(MouseEvent e) {
		circle.setColor(rgen.nextColor());
	}

	public void mouseDragged(MouseEvent e) {
		if (e.getX() > 0 && e.getX() < getWidth()) {
			curr = e.getX();
			if (e.getX() > getWidth() / 2 && curr - prev > 0) {
				CIRCLE_D += 1;
				remove(circle);
				makeCircle();
			} else if (e.getX() > getWidth() / 2 && curr - prev < 0) {
				CIRCLE_D -= 1;
				remove(circle);
				makeCircle();
			}
			if (e.getX() < getWidth() / 2 && curr - prev > 0) {
				CIRCLE_D -= 1;
				remove(circle);
				makeCircle();
			} else if (e.getX() > getWidth() / 2 && curr - prev < 0) {
				CIRCLE_D += 1;
				remove(circle);
				makeCircle();
			}

			if (e.getX() > getWidth() / 2 && curr - prev < 0) {
				CIRCLE_D -= 1;
				remove(circle);
				makeCircle();
			} else if (e.getX() > getWidth() / 2 && curr - prev > 0) {
				CIRCLE_D += 1;
				remove(circle);
				makeCircle();
			}
			if (e.getX() < getWidth() / 2 && curr - prev < 0) {
				CIRCLE_D += 1;
				remove(circle);
				makeCircle();
			} else if (e.getX() > getWidth() / 2 && curr - prev > 0) {
				CIRCLE_D -= 1;
				remove(circle);
				makeCircle();
			}

			prev = e.getX();
		}

	}

	public void mousePressed(MouseEvent e) {
		prev = e.getX();
	}
}
