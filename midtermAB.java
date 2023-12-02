import acm.program.ConsoleProgram;

public class midtermAB extends ConsoleProgram {
	public void run() {
		String s = "abab";
		//int count = countAB1(s);
		int count = countAB(s);
		println(count);
	}

	private boolean check(String s){
        int a = 0;
        int b = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a'){
                a++;
            }
            else b++;
        }
        return a == b;
    }
    // brute force solution
	
	
	
	private int countAB(String s){
        int ans = 0;
        String used = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j <= s.length(); j++){
                String s1 = s.substring(i,j);
                System.out.println(s1);
                if(!used.contains(' ' + s1 +  ' ')){
                    System.out.println("z");
                    if(check(s1))
                        ans++;
                    used += ' ' + s1 + ' ';
                }
            }
        }

        return ans;
    }
 
//	private int countAB1(String s) {
//		int ans = 0;
//		for (int i = 0; i < s.length(); i++) {
//			int ab = 0;
//			for (int j = i; j < s.length(); j++) {
//
//				if (s.charAt(j) == 'a') {
//					ab++;
//				} else {
//					ab--;
//				}
//				if (ab == 0) {
//					ans++;
//				}
//			}
//		}
//
//		return ans;
//	}
}
