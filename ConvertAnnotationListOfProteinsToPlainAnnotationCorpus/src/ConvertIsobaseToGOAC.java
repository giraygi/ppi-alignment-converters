import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConvertIsobaseToGOAC {
	
	public static void main(String[] args) {
		
		try {
			FileReader fr = new FileReader(args[0]); 
			BufferedReader br = new BufferedReader(fr); 
			FileWriter fw = new FileWriter(args[1]); 	
			String line;
			StringBuilder sb = new StringBuilder(0);
			String[] words;
			String[] goa;
			String[] evc;
			String[] aspect;
			while((line = br.readLine())!=null)
			{ 
			    
				words = line.split("\t");
			    	goa = words[1].split("\\|");
			    	evc = words[2].split("\\|");
			    	aspect = words[3].split("\\|");
			    	
			    	for (int i = 0;i<goa.length;i++) {
			    		System.out.println(words[0]+" - "+goa[i]+" - " +evc [i]+" - " +aspect[i]);
			    		if(words[0].substring(0, 2).equals("dm"))
			    			sb.append("7227").append("\t").append(words[0]).append("\t").append(goa[i]).append("\t").append(evc[i]).append("\t").append("-").append("\t").append("kamilizm").append("\t").append("-").append("\t").append(Category.valueOf(aspect[i]).label).append("\n");
			    		else if(words[0].substring(0, 2).equals("ce"))
		    			sb.append("6239").append("\t").append(words[0]).append("\t").append(goa[i]).append("\t").append(evc[i]).append("\t").append("-").append("\t").append("kamilizm").append("\t").append("-").append("\t").append(Category.valueOf(aspect[i]).label).append("\n");
			    		else if(words[0].substring(0, 2).equals("sc"))
			    			sb.append("4932").append("\t").append(words[0]).append("\t").append(goa[i]).append("\t").append(evc[i]).append("\t").append("-").append("\t").append("kamilizm").append("\t").append("-").append("\t").append(Category.valueOf(aspect[i]).label).append("\n");
			    		else if(words[0].substring(0, 2).equals("hs"))
			    			sb.append("9606").append("\t").append(words[0]).append("\t").append(goa[i]).append("\t").append(evc[i]).append("\t").append("-").append("\t").append("kamilizm").append("\t").append("-").append("\t").append(Category.valueOf(aspect[i]).label).append("\n");
			    	}
			    	line = sb.toString();
			    	
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
		} catch(IllegalArgumentException e) {
			System.err.println("kamilizm");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

enum Category {
    P("Process"),
    F("Function"),
    C("Component");
	
	public final String label;

    private Category(String label) {
        this.label = label;
    }
    
}
