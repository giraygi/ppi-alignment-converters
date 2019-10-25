import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CorrectFile {
	public static void main(String[] args) {
		
		try {
			FileReader fr = new FileReader(args[0]); 
			BufferedReader br = new BufferedReader(fr); 
			FileWriter fw = new FileWriter(args[1]); 	
			String line;
			StringBuilder sb = new StringBuilder(0);
			String[] words;
			while((line = br.readLine())!=null)
			{ 
			    //line = line.trim(); // remove leading and trailing whitespace
			    if (line.charAt(0) != ' ') // don't write out blank lines
			    {
			    	words = line.split(" -> ");
			    	sb.append(words[0]).append(" ").append(words[1]).append("\n");
			    	line = sb.toString();
			    	System.out.print(line);
			    	fw.write(line, 0, line.length());
			    	sb.setLength(0);
			    }
			}
						 
			fr.close();
			fw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
