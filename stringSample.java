import acm.program.ConsoleProgram;

public class stringSample extends ConsoleProgram{
	public void run(){
		String str1 = "oto";
		String str2 = "oto";
		String str3 = new String("oto");
		String str4 = readLine("enter str4: ");
		
		println("1, 2 " + (str1 == str2) +  "" + str1.equals(str2));
		println("1, 3 " + (str1 == str3) +  "" + str1.equals(str3));
		println("1, 4 " + (str1 == str4) +  "" + str1.equals(str4));
	}
}
