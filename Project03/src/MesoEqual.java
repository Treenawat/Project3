import java.io.BufferedReader;
import java.util.HashMap;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;

public class MesoEqual {
	String StID;
	
	//this.
	public MesoEqual(String StID) {
		this.StID = StID;
	}
	
	//create hashmap according to main (calAsciiEqual)
	public HashMap<String, Integer> calAsciiEqual() throws IOException{
		//Find same average as Fair
		HashMap<String, Integer> sameAverage = new HashMap<String, Integer>();
		ArrayList<String> mesonetArray = new ArrayList<String>();
		
		//Read file from Mesonet and assign it as newWord, then loop it to add those newWord into mesonetArray
		File file = new File("Mesonet.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String newWord;
		newWord = br.readLine();
		newWord = br.readLine();
		newWord = br.readLine();
		newWord = br.readLine();
		newWord = br.readLine();
		while(newWord != null) {
			mesonetArray.add(newWord.substring(2,  6));
			newWord = br.readLine();
		}
		br.close();
		
		//Use similar method from MesoAscii to find average
		int[] letter = new int[4];
		letter[0] = StID.charAt(0);
		letter[1] = StID.charAt(1);
		letter[2] = StID.charAt(2);
		letter[3] = StID.charAt(3);
		
		double mean = 0;
		for (int i = 0; i < letter.length; i++) {
			mean += letter[i];
		}
		mean = mean/letter.length;
		
		String[] split = String.valueOf(mean).split("\\.");
		int[] split2 = new int[2];
		split2[0]=Integer.parseInt(split[0]);
		split2[1]=Integer.parseInt(split[1]); 
		int firstDigit = Integer.parseInt(Integer.toString(split2[1]).substring(0, 1));

		int average = 0;
		if (firstDigit >= 5) {
			average = (int) Math.ceil(mean);
		}
		else {
			average = (int) Math.floor(mean);
		}
		
		
				
		
	}
}