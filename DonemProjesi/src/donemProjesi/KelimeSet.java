package donemProjesi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;




public class KelimeSet {
	
	public int kelimeSayı;
	
	public KelimeSet(int kelimeSayı) {
		this.kelimeSayı = kelimeSayı;
		
	}
	
	public String[] kelimeSec() {
		
		
		String[] kelime = new String[kelimeSayı];
		
		
		for(int i = 0; i<kelimeSayı;i++) {
			
			Random rand = new Random();
			int n = rand.nextInt(14316);
			
			try {
				
				kelime[i] = (String) readData().toArray()[n];
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
		return kelime;
		
	}
	
	public ArrayList<String> readData() throws IOException { 
	    
	    String file = "/home/hhnigdeli/eclipse-workspace/donemProjesi/tr/EsAnlamlilar.csv";
	    ArrayList<String> content = new ArrayList<>();
	    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	        String line = "";
	        while ((line = br.readLine()) != null) {
	            content.add(line.trim());
	        }
	    } catch (FileNotFoundException e) {
	      //Some error logging
	    }
	    return content;
	}

}
