import java.util.ArrayList;

public class ClusteringResult {

	
	Cluster clusters = new Cluster();
	String message = new String();
	
	
	public ClusteringResult(Cluster clusters, String message) {

		this.clusters = clusters;
		this.message = message;

	}



	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}



	public Cluster getClusters() {
		return clusters;
	}



	public void setClusters(Cluster clusters) {
		this.clusters = clusters;
	}


	
	
}
