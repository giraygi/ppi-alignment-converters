import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConvertIsobaseToPlainAC {
	
	public static void main(String[] args) {
		
		try {
			FileReader fr = new FileReader(args[0]); 
			BufferedReader br = new BufferedReader(fr); 
			FileWriter fw = new FileWriter(args[1]); 	
			String line;
			StringBuilder sb = new StringBuilder(0);
			String[] words;
			String[] goa;
			while((line = br.readLine())!=null)
			{ 

			    	words = line.split("\t");
			    	goa = words[1].split("\\|");
			    	for (int i = 0;i<goa.length;i++)
			    		sb.append(words[0]).append("\t").append(goa[i]).append("\n");
			    	line = sb.toString();
	//		    	System.out.print(line);
			    	fw.write(line, 0, line.length());
			    	sb.setLength(0);

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
