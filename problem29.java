//მოხმარებელს შეყავს მთელი რიცხვი n, პროგრამამ უნდა დაბეჭდოს ფიბონაჩის მიმდევრობის
//მე n წევრი.
import acm.program.ConsoleProgram;

public class problem29 extends ConsoleProgram {
	public void run(){
		int n = readInt("Enter number: ");
		int fibonacci = 0;
		calculateFibonacci(n);
		println(fibonacci);
	}

	private int calculateFibonacci(int n) {	
		int fibonacci = 0;
		int a = 0;
		int b = 1;
		if(n == 1){
			fibonacci = 0;
		} else if(n == 2 ){
			fibonacci = 1;
		} else {
			for(int i = 3; i <= n; i++){
				if( i % 2 == 1){
					a = b + a;
					fibonacci = a;
				} else {
					b = a + b;
					fibonacci = b;
				}
			}		
		}
		return fibonacci;
	}
}
