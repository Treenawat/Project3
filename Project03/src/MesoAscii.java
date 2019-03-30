public class MesoAscii extends MesoAsciiAbstract {
	String StID;
	
	public MesoAscii(MesoStation StID){
		this.StID = StID.getStID();
	}
	
	@Override
	int calAverage() {
		//Create array for containing int valuable of each character
		int[] letter = new int[4];
		letter[0] = StID.charAt(0);
		letter[1] = StID.charAt(1);
		letter[2] = StID.charAt(2);
		letter[3] = StID.charAt(3);
		
		//Calculate mean by adding all number and divide by the length
		double mean = 0;
		for (int i = 0; i < letter.length; i++) {
			mean += letter[i];
		}
		mean = mean/letter.length;
		
	}
	
	
}