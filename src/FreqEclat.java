import java.util.ArrayList;

public class FreqEclat {


	ArrayList<String> items = new ArrayList<String>();
	ArrayList<Integer> instances = new ArrayList<Integer>();
	



	public FreqEclat(ArrayList<String> key, ArrayList<Integer> value) {

		this.items = key;
		this.instances = value;
		
	}


	public ArrayList<String> getItems() {
		return items;
	}


	public void setItems(ArrayList<String> items) {
		this.items = items;
	}


	public ArrayList<Integer> getInstances() {
		return instances;
	}


	public void setInstances(ArrayList<Integer> instances) {
		this.instances = instances;
	}
	

	
	
}
