import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Convert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> nodes = new HashSet<String>();
		try {
			FileReader fr = new FileReader(args[0]); 
			BufferedReader br = new BufferedReader(fr); 

			String line;
			String[] cells;
			
			
			while((line = br.readLine())!=null)
			{ 
				cells = line.split("\t");

				nodes.add(cells[0]);
				nodes.add(cells[1]);

			}
			br.close();

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(args[2]));
					
			for (String protein : nodes) {
				bw.write(protein);
				bw.newLine();
			}
			
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(args[3]));
//			List<String> annotations;	
			Set<String> annotations;
			for (String protein : nodes) {
				String line;
				String[] cells;
//				annotations = new ArrayList<String>(); bir proteine denk gelen belirtimlerin biricik olması için
				annotations = new HashSet<String>();
				annotations.clear();
				FileReader fr = new FileReader(args[1]); 
				BufferedReader br = new BufferedReader(fr); 
				while((line = br.readLine())!=null)
				{ 
					cells = line.split("\\t");
					if(cells[1].equals(protein) )
							annotations.add(cells[2]);
				}
				br.close();
				if (annotations.size()>0) {
					bw.write(protein);
					System.out.print(protein + " ");
					bw.write(" ");
					for (String string : annotations) {
						bw.write(string.substring(3));
						bw.write(" ");
						System.out.print(string + " ");
					}
					bw.newLine();
				}
				System.out.println();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
