import java.util.ArrayList;

public class Item {
	
	int freq = 0;
	ArrayList<String> set = new ArrayList<String>();
	
	
	public Item(ArrayList<String> set, int freq) {
		this.set = set;
		this.freq = freq;
	}
	
	
	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public ArrayList<String> getSet() {
		return set;
	}

	public void setSet(ArrayList<String> set) {
		this.set = set;
	}


	
}
