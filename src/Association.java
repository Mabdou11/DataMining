import java.util.ArrayList;

public class Association {


	ArrayList<String> items1 = new ArrayList<String>();
	ArrayList<String> items2 = new ArrayList<String>();
	int items1F = 0;
	int items2F = 0;
	ArrayList<String> result = new ArrayList<String>();
	
	double confidence = 0;
	
	public Association(ArrayList<String> items1, ArrayList<String> items2, int items1F, int items2F) {

		this.items1 = items1;
		this.items2 = items2;
		this.items1F = items1F;
		this.items2F = items2F;
		
		this.confidence = (double)((double)items2F/(double)items1F);
		
		ArrayList<String> result = new ArrayList<String>();
		
		for (String string : items2) {
				if(!items1.contains(string)) 
					result.add(string);
		}
		this.result = result;
		
	}
	
	public String toString() {

		return this.items1+" ==> "+this.result+": "+String.format("%.3f",this.confidence);
	}
	
	

	public ArrayList<String> getItems1() {
		return items1;
	}

	public void setItems1(ArrayList<String> items1) {
		this.items1 = items1;
	}

	public ArrayList<String> getItems2() {
		return items2;
	}

	public void setItems2(ArrayList<String> items2) {
		this.items2 = items2;
	}

	public ArrayList<String> getResult() {
		return result;
	}

	public void setResult(ArrayList<String> result) {
		this.result = result;
	}

	public double getConfidence() {
		return confidence;
	}

	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}

	
	
	public int getItems1F() {
		return items1F;
	}

	public void setItems1F(int items1f) {
		items1F = items1f;
	}

	public int getItems2F() {
		return items2F;
	}

	public void setItems2F(int items2f) {
		items2F = items2f;
	}
	
	
	
	
	
	
}
