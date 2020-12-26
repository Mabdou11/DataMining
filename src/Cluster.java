import java.util.ArrayList;

public class Cluster {

	ArrayList<ArrayList<Integer>> clusters =  new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> medoids =  new ArrayList<Integer>();
	double error = 0;
	
	public Cluster() {
		
	}
	
	
	public Cluster(ArrayList<ArrayList<Integer>> clusters, ArrayList<Integer> medoids, double error) {
		super();
		this.clusters = clusters;
		this.medoids = medoids;
		this.error = error;
	}
	
	public ArrayList<ArrayList<Integer>> getClusters() {
		return clusters;
	}
	public void setClusters(ArrayList<ArrayList<Integer>> clusters) {
		this.clusters = clusters;
	}
	public ArrayList<Integer> getMedoids() {
		return medoids;
	}
	public void setMedoids(ArrayList<Integer> medoids) {
		this.medoids = medoids;
	}
	public double getError() {
		return error;
	}
	public void setError(double error) {
		this.error = error;
	}
	

	
	
	
}
