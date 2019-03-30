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
		Map<String, Integer> sortedMap = sortedMap(AsciiVal);
		for (String StID : sortedMap.keySet()) {
		    System.out.println(StID + " " + sortedMap.get(StID));		    
		}
	}
	
	//Create sortedMap
	@Override
	Map<String, Integer> sortedMap(HashMap<String, Integer> unsortedMap) {
		ArrayList<String> newWord = new ArrayList<String>();
		Set<Map.Entry<String, Integer>> unSorted = AsciiVal.entrySet();
		Iterator<Entry<String, Integer>> iterate = unSorted.iterator();
		
		for(int i = 0; i < unsortedMap.size(); i++){
			newWord.add(iterate.next().getKey());
		}
		
		Collections.sort(newWord);
		Map<String, Integer> sorted = new TreeMap<String, Integer>();
		for(int j = 0; j < newWord.size(); j++){
			String stid = newWord.get(j);
			Integer ascii = unsortedMap.get(stid);
			sorted.put(stid, ascii);	
		}
		return sorted;
	}
}