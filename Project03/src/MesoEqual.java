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
		
		double StIDAverage = 0;
		for (int i = 0; i < letter.length; i++) {
			StIDAverage += letter[i];
		}
		StIDAverage = StIDAverage/letter.length;
		
		String[] split = String.valueOf(StIDAverage).split("\\.");
		int[] split2 = new int[2];
		split2[0]=Integer.parseInt(split[0]);
		split2[1]=Integer.parseInt(split[1]); 
		int firstDigit = Integer.parseInt(Integer.toString(split2[1]).substring(0, 1));

		int StIDAscii = 0;
		if (firstDigit >= 5) {
			StIDAscii = (int) Math.ceil(StIDAverage);
		}
		else {
			StIDAscii = (int) Math.floor(StIDAverage);
		}
		
		//Add word with same Average from Mesonet with word "Fair" to hashmap sameAverage
		for(int i = 0; i < mesonetArray.size(); ++i)
		{
			int[] letter2 = new int[4];
			letter2[0] = StID.charAt(0);
			letter2[1] = StID.charAt(1);
			letter2[2] = StID.charAt(2);
			letter2[3] = StID.charAt(3);
			
			//find average and set floor and ceiling
			double mean = 0;
			for (int j = 0; j < letter.length; j++) {
				mean += letter2[i];
			}
			mean = mean/letter2.length;

			String[] split3 = String.valueOf(mean).split("\\.");
			int[] split4 = new int[2];
			split4[0]=Integer.parseInt(split3[0]);
			split4[1]=Integer.parseInt(split3[1]); 
			int firstDecimal = Integer.parseInt(Integer.toString(split4[1]).substring(0, 1));
			
			int average = 0;
			if (firstDecimal >= 5) {
				average = (int) Math.ceil(mean);
			}
			else {
				average = (int) Math.floor(mean);
			}
			
			if(average == StIDAscii)
			{
				sameAverage.put(StID, average);
			}
		}
	return sameAverage;
	}
}