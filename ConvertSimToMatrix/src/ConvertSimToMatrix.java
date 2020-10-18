
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/*
 * This class creates a matrix similarity file out of two .gw type network files and a node pair based similarity file.
 * 
 */
public class ConvertSimToMatrix {
	
	HashMap<String,Integer> network1 = new HashMap<String,Integer>();
	HashMap<String,Integer> network2 = new HashMap<String,Integer>();
	double[][] similarityMatrix;
	
	public ConvertSimToMatrix(String network1File, String network2File, String simFile) {
		
		try {
			FileReader fr = new FileReader(network1File); 
			BufferedReader br = new BufferedReader(fr); 
			String line;
			int count = -1;
			int network1Size = 0;
			while((line = br.readLine())!=null)
			{ 
				count++;
				if(count<3)
					continue;
				
				if(count==3) {
					network1Size = Integer.parseInt(line);
					continue;
				}
				    
				
			    if (count>3 && count<network1Size+4)
			    {
			    	line = line.replaceAll("\\|\\{", "").replaceAll("\\}\\|", "");
			    	network1.put(line, count-4);
			    	System.out.println((count-4)+" - "+line);
			    }
			    
			    if(count ==network1Size+4)
			    	break;
			    
			}
			br.close();		 
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		try {
			FileReader fr2 = new FileReader(network2File); 
			BufferedReader br2 = new BufferedReader(fr2); 
			String line;
			int count = -1;
			int network2Size = 0;
			while((line = br2.readLine())!=null)
			{ 
				count++;
				if(count<3)
					continue;
				
				if(count==3) {
					network2Size = Integer.parseInt(line);
					continue;
				}
			    if (count>3 && count<network2Size+4) 
			    {
			    	line = line.replaceAll("\\|\\{", "").replaceAll("\\}\\|", "");
			    	network2.put(line, count-4);
			    	System.out.println((count-4)+" - "+line);
			    }
			    
			    if(count ==network2Size+4)
			    	break;
			}
			br2.close();			 
			fr2.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		similarityMatrix  = new double[network1.size()][network2.size()];
		
		try {
			FileReader fr3 = new FileReader(simFile); 
			BufferedReader br3 = new BufferedReader(fr3); 		
			String line;
			String[] words;
			double maxSimilarity = 0.0;
			int count = 0;
	    	System.out.println("size: "+network1.size());
	    	System.out.println("size: "+network2.size());
			
			while((line = br3.readLine())!=null)
			{ 
					count++;
					words = line.split(" ");
					if(network1.containsKey(words[0])&&network2.containsKey(words[1])) {
						
						if(maxSimilarity<Double.parseDouble(words[2]))
							maxSimilarity = Double.parseDouble(words[2]);
//						System.out.println(count+" - "+network1.get(words[0])+":  "+words[0]+" - "+network2.get(words[1])+": "+words[1]);
				    	similarityMatrix[network1.get(words[0])][network2.get(words[1])] = Double.parseDouble(words[2]);   
					} 
//					    else
//							System.err.println(count+" - "+network1.get(words[0])+":  "+words[0]+" - "+network2.get(words[1])+": "+words[1]);
			    	 
			}
			
			System.out.println("Maximum Similarity: "+maxSimilarity);
			
			for (int i = 0;i<similarityMatrix.length;i++)
				for (int j = 0;j<similarityMatrix[i].length;j++)
					similarityMatrix[i][j] = similarityMatrix[i][j]/maxSimilarity;
			
			br3.close();		 
			fr3.close();
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
	
	public void writeMatrix(String outputFile) {
		
		try {
			FileWriter fw = new FileWriter(outputFile); 	
			StringBuilder sb = new StringBuilder(0);
			sb.append(network1.size()).append(" ").append(network2.size());
			fw.append(sb.toString());
			fw.append("\n");
			sb.setLength(0);
			
			for (int i = 0;i<network1.size();i++) {
				for (int j = 0;j<network2.size();j++) {
					sb.append(similarityMatrix[i][j]).append(" ");
				}
				sb.setLength(sb.length() - 1);
				fw.append(sb.toString());
				if(i<network2.size()-1)
					fw.append("\n");
				sb.setLength(0);
			}			 
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
	
	
	public static void main(String[] args) {
		ConvertSimToMatrix cstm = new ConvertSimToMatrix(args[0],args[1],args[2]);
		cstm.writeMatrix(args[3]);		
	}

}
