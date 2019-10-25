import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RemoveRepeatingEdges {

	public static void main(String[] args) {
		
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
			FileReader fr = new FileReader(args[0]); 
			BufferedReader br = new BufferedReader(fr); 

				String line;
				String[] cells;
//				annotations = new ArrayList<String>(); bir proteine denk gelen belirtimlerin biricik olması için

				while((line = br.readLine())!=null)
				{ 
					cells = line.split("\\t");
					if(!cells[0].equals(cells[1])) {
						bw.write(line);
						bw.newLine();
					}		
				}
			br.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
}
