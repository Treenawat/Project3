import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.Set;
import java.util.Iterator;
import java.util.TreeMap;

public class StationLexicographical extends MesoSortedAbstract {
	//create hashmap according to main (AsciiVal)
	HashMap<String, Integer> AsciiVal;
	
	//Sorted Map
	public StationLexicographical(HashMap<String, Integer> AsciiVal) {
		this.AsciiVal = AsciiVal;
		//use sortedMap on AsciiVal
		Map<String, Integer> sortedMap = sortedMap(AsciiVal);
		for (String StID : sortedMap.keySet()) {
		    System.out.println(StID + " " + sortedMap.get(StID));		    
		}
	}
	
	//Create sortedMap
	@Override
	Map<String, Integer> sortedMap(HashMap<String, Integer> unsortedMap) {
		//setUpfirst
		ArrayList<String> newWord = new ArrayList<String>();
		Set<Map.Entry<String, Integer>> unSorted = AsciiVal.entrySet();
		Iterator<Entry<String, Integer>> iterate = unSorted.iterator();
		
		//run thought unsortedmap and add them to newWord
		for(int i = 0; i < unsortedMap.size(); i++){
			newWord.add(iterate.next().getKey());
		}
		
		//Use collection to sorted newWord
		Collections.sort(newWord);
		Map<String, Integer> sorted = new TreeMap<String, Integer>();

		//run through for loop and add them into hashmap sorted
		for(int j = 0; j < newWord.size(); j++){
			String stid = newWord.get(j);
			Integer ascii = unsortedMap.get(stid);
			sorted.put(stid, ascii);	
		}
		return sorted;
	}
}