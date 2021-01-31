import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConvertGene2GOToGAF20 {
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

			    	words = line.split("\t");
			    	
			    	if (words[4].equals("-"))
			    			words[4] = "";
			    	if (words[6].equals("-"))
		    			words[6] = "";
			    	else
			    		words[6] = "PMID:"+words[6];
			    	
			    	sb.append("BioGRID").append("\t").append(words[1]).append("\t").append(words[1]).append("\t").append(words[4]).append("\t")
			    	.append(words[2]).append("\t").append(words[6]).append("\t").append(words[3]).append("\t").append("\t").append(words[7].charAt(0)).append("\t")
			    	.append(words[5]).append("\t").append(words[5]).append("\t").append("protein").append("\t").append("taxon:"+words[0]).append("\t").append("20173112").append("\t")
			    	.append("BioGRID").append("\t").append("\t").append("\n");
			    	
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
