import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
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
					
			for (String protein : nodes) {;
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
			StringBuilder newLine = new StringBuilder();		
			for (String protein : nodes) {
				newLine.setLength(0);
				newLine.append(protein);
				newLine.append(" ");
//				bw.write(protein);
//				bw.write(" ");

				String line;
				String[] cells;
				FileReader fr = new FileReader(args[1]); 
				BufferedReader br = new BufferedReader(fr); 
				boolean nonempty = false;
				while((line = br.readLine())!=null)
				{ 
					cells = line.split("\\tGO:");
					if(cells[0].equals(protein) )
						for (int i = 1;i<cells.length;i++) {
//							bw.write(cells[i]);bw.write(" ");
							newLine.append(cells[i]);newLine.append(" ");
							nonempty = true;
						}	
					System.out.println(cells.length-1);
				}	
				br.close();
				if(nonempty) {
					bw.write(newLine.toString());
					bw.newLine();
				}
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Entry<String,List<String>> proteinAnnotations;



	}

}
