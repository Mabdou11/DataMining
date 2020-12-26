import java.util.Arrays;

public class ItemSet {
	int freq = 0;
	double[] set = new double[4];
	
	
	public ItemSet(double[] set, int freq) {
		this.set = set;
		this.freq = freq;
	}
		
	public ItemSet() {
		Arrays.fill(this.set,-1);
		this.freq = 0;
	}
	
	
	
	
		
	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public double[] getSet() {
		return set;
	}

	public void setSet(double[] set) {
		this.set = set;
	}


	
}
