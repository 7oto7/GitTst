import acm.graphics.GOval;
import acm.program.ConsoleProgram;

public class stringSample extends ConsoleProgram{
	public void run(){
//		String str1 = "oto";
//		String str2 = "oto";
//		String str3 = new String("oto");
//		String str4 = readLine("enter str4: ");
//		
//		println("1, 2 " + (str1 == str2) +  " " + str1.equals(str2));
//		println("1, 3 " + (str1 == str3) +  " " + str1.equals(str3));
//		println("1, 4 " + (str1 == str4) +  " " + str1.equals(str4));
//		//////////////////////////// == ar shevadarot stringebi////////////////////////
//		//1 da 2 misamartshia shenaxuli. 3 iqmneba axal misamartze.////////////////
//		
//		str1 = str1.substring(0, str1.length() - 1) + "i";
//		println(str1);
//		//////substringi igebs mititebuli indeqsebidan texts//////////////
		
	
			    int x = 1;
			    int y = 2;

			    GOval o = new GOval(2, 1); // width, height

			    println(racxa(x, 2, o));
			    println(racxa(y, x / 2 + x, o));

			  }

			  public int racxa(int x, int y, GOval o) {
			    String s = "hello world";

			    x = varesiRacxa(x / y, x + (int) o.getHeight(), s);
			    //o.scale(2);
			    y = varesiRacxa(x, y + (int) o.getHeight(), s);

			    return x + y;
			  }

			  public int varesiRacxa(double x, int y, String s) {
			    int z = (int) x + s.charAt(0) - s.charAt(1);
			    s = s.substring(1);

			    return z + y;
			  }

}
