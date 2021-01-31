import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConvertAnnos2GOToGAF20 {
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

			    	words = line.split(" ");
			    	
			    	for(int i = 2;i<words.length;i++)
			    		if(words[i].startsWith("GO:"))
			    			sb.append("Intact").append("\t").append(words[1]).append("\t").append(words[1]).append("\t").append("\t")
			    	.append(words[i]).append("\t").append("\t").append("EXP").append("\t").append("\t").append("F").append("\t")
			    	.append("kamilizm").append("\t").append("kamilizm").append("\t").append("protein").append("\t").append("taxon:"+words[0]).append("\t").append("20163112").append("\t")
			    	.append("Intact").append("\t").append("\t").append("\n");
			    	
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
