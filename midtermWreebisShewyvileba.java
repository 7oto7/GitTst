import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.ConsoleProgram;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

//ამოცანა 5. წრეების შეწყვილება (35 ქულა)
//დაწერეთ გრაფიკული თამაში, რომელიც გაშვებისთანავე დაამატებს CIRCLE_NUM წყვილ CIRCLE_D დიამეტრის მქონე წრეს. 
//წყვილში ორივე წრე უნდა იყოს გაფერადებული ერთი და იმავე შემთხვევითი ფერით და თითოეულისთვის უნდა შეირჩეს ცალცალკე შემთხვევითი ლოკაცია. 
//ამის შემდეგ პროგრამა იგივე პირობებით ყოველ DELAY მილიწამში ერთხელ ამატებს ახალ წყვილს, მანამ სანამ არ დასრულდება თამაში.
//თუ მომხმარებელი ერთმანეთის მიმდევრობით აკლიკებს ერთსა და იმავე ფერის წრეს, მაშინ ორივე წრე ქრება.
//გაითვალისწინეთ რომ წრეები ქრებიან მხოლოდ მაშინ როდესაც ერთმანეთის მიყოლებით ორ ერთსა და იმავე ფერის წრეს ვაკლიკავთ.
//ანუ ამ კლიკებს შორის არ უნდა მოხდეს კლიკი სხვა მესამე წრეზე ან ცარიელ ადგილზე. თამაში მთავრდება როცა ყველა წრე გაქრება დაფიდან.
//თამაშის დამთავრებისას პროგრამაც უნდა გაჩერდეს და აღარ დახატოს ახალი წრეები.
//შენიშვნა: წრეების დამატება უნდა მოხდეს ფანჯრის საზღვრებს შიგნით
public class midtermWreebisShewyvileba extends GraphicsProgram{

//		int b = 8;
//		char a = 'a';
//		char c = (char) (a + b);
//		int d = a + b;
		private static final int CIRCLE_D = 40;
		private static final int CIRCLE_NUM = 1;
		private static final int DELAY = 3000;
		
		private int circleNum;
		private RandomGenerator random = RandomGenerator.getInstance();
		private GObject last;

	public void init() {
		addMouseListeners();
		for (int i = 0; i < CIRCLE_NUM; i++) {
			drawCircles();
		}
		circleNum = 2 * CIRCLE_NUM;
	}
		public void run(){
			while(circleNum != 0){
				drawCircles();
				circleNum += 2;
				pause(DELAY);
			}
		}
		
		
		
		private void drawCircles(){
			Color color = random.nextColor();
			drawCircle(color);
			drawCircle(color);
		}
		
		private void drawCircle(Color color){
			GOval circle1 = new GOval(CIRCLE_D, CIRCLE_D);
			circle1.setFilled(true);
			circle1.setColor(color);
			add(circle1, random.nextInt(0, getWidth() - CIRCLE_D), random.nextInt(0, getHeight() - CIRCLE_D));
		}
		
		public void mouseClicked(MouseEvent e){
			GObject obj = getElementAt(e.getX(), e.getY());
			if(obj != null){
				if(last != null){
					if(last.getColor() == obj.getColor() && last != obj) {
						remove(obj);
						remove(last);
						circleNum -= 2;
					} else {
						last = obj;
					}
				} else {
					last = obj;
				}
			} else {
				last = null;
			}
		}

	}
		
	

