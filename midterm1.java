
import acm.program.ConsoleProgram;

public class midterm1 extends ConsoleProgram{
	public void run(){
		String str = readLine();
		int count = countAB1(str);
		println(count);
	}
	private int countAB1(String s){
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            int ab = 0;
            for(int j = i; j < s.length(); j++){

                if(s.charAt(j) == 'a') ab++;
                else ab--;
                if(ab == 0) ans++;
            }
        }

        return ans;
    }

}
