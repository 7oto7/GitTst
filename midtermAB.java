import acm.program.ConsoleProgram;

public class midtermAB extends ConsoleProgram {
	public void run() {
		String s = "abab";
		//int count = countAB1(s);
		int count = countAB2(s);
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
    private int countAB2(String s){
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j < s.length(); j++){
                String s1 = s.substring(i,j);
                if(check(s1)) ans++;
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
