

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;

public class AwtBugDemonstrator extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {		
			primaryStage.setTitle("Awt Bug Demonstrator");	
			BorderPane bp = new BorderPane();
			Scene scene = new Scene(bp, 400, 400);
			
			SwingNode sn = new SwingNode();
			ChartPanel c = new ChartSample().getPanel();
			
			try {
			SwingUtilities.invokeAndWait(
				()->{
						// hangs inside here...
						sn.setContent(c);
					}
			);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			bp.setCenter(sn);	
			primaryStage.setScene(scene);
			primaryStage.show();		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	//public class LineChartDemo6 extends ApplicationFrame {
	public class ChartSample  {
		ChartPanel chartPanel;
	    public ChartSample() {

	    }
	    
	    public ChartPanel getPanel() {
	    	return chartPanel;
	    }
	    

	
	    private JFreeChart createChart(final XYDataset dataset) {
	        
	        final JFreeChart chart = ChartFactory.createXYLineChart(
	            "Bug Demonstrator",   "X",    "Y",   dataset,             
	            PlotOrientation.VERTICAL,true, true, false    
	        );

	        final XYPlot plot = chart.getXYPlot();
	        
	        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	        plot.setRenderer(renderer);
	        
	        return chart;
	        
	    }
	}

}