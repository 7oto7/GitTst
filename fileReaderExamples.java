import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import acm.program.ConsoleProgram;
import acm.util.ErrorException;

public class fileReaderExamples extends ConsoleProgram{
	public void run(){
		 BufferedReader rd = openFile("Please enter filename: ");
		 
		 try {
			 PrintWriter wr = new PrintWriter(
					 new FileWriter("MyFileCopy.txt"));
			 
			 while(true){
				 String line = rd.readLine();
				 if(line == null) break;
				 println("Copyong line: [" + line + "]");
				 wr.println(line);
			 }
			 
			 rd.close();
			 wr.close();
		 } catch (IOException ex){
			 throw new ErrorException(ex);
		 }
	}

	private BufferedReader openFile(String string) {
		BufferedReader rd = null;
		
		while(rd == null){
			try{
				String filename = readLine(string);
				rd = new BufferedReader(new FileReader(filename));
				
			} catch (Exception ex){
				println("Nice try pun. That file doesn't exist.");
			}
		}
		return rd;
	}
}
