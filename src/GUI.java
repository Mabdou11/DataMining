import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.stream.Collectors;

import com.jfoenix.controls.JFXSpinner;
import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.jfree.chart.renderer.*;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import java.util.LinkedList;


public class GUI {
	
	Stage stage = new Stage();
    Pane layout = new Pane();
	JFXSpinner bar = new JFXSpinner();
	Label label = new Label("Veuillez partiener s'il vous plait");
	
	public GUI() {
		
	}
	
	public GUI(Label timeLabel, StopWatch task) {
		label.setEffect(new DropShadow());
		timeLabel.textProperty().bind(task.timee);
		label.setFont(Font.font ("raleway", 20)); label.setLayoutX(125); 
		label.setLayoutY(300);
		timeLabel.setFont(Font.font ("Serif", 30)); timeLabel.setLayoutX(200);  timeLabel.setLayoutY(340);
		bar.setProgress(-1); bar.setEffect(new Reflection()); bar.setLayoutX(170); 
		bar.setLayoutY(125);  bar.setPrefHeight(200);  bar.setPrefWidth(150);
		layout.getChildren().addAll(bar,label,timeLabel);
		stage.setScene(new Scene(layout,500,500)); stage.setResizable(false);
		stage.setTitle("Recherche en profondeur en cours..."); stage.initModality(Modality.APPLICATION_MODAL);
	}
	
	public void showAlert(Timer timi,String header) {
		timi.cancel();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Termin�");
		bar.setProgress(100);
		label.setText("Recherche termin�");
		label.setLayoutX(175); 			
		alert.setHeaderText(header);
				
		alert.showAndWait();
		
		stage.close();
	}
	
	
	public void apriori(int parameters, ScrollPane scp, ArrayList<Map<ArrayList<String>, Integer>> Items,ArrayList<ArrayList<Association>> associationsList,double confidence, int Atype) {
		String motif = "";
		String arule = "";
		
		// 1 . a.getItems1 2. a.getItems2
		int x = 1;
		for (Map<ArrayList<String>,Integer> map : Items) {
			motif+="---------------------------- L"+x+"  ("+map.entrySet().size()+")----------------------------\n\n";

			for (Entry<ArrayList<String>,Integer> val : map.entrySet()) {
				motif+=val.getKey()+" : "+val.getValue()+"\n\n";
			}
			x++;
		}

		String[] ax= new String[6];
		
		
		ax[0] = "1 to 1";
		ax[1] = "1 to 2";
		ax[2] = "1 to 3";
		ax[3] = "2 to 1";
		ax[4] = "2 to 2";
		ax[5] = "3 to 1";
		
		x= 0;
		for (ArrayList<Association> associations : associationsList) {
			arule+="---------------------------- "+ax[x]+" ----------------------------\n\n";
			x++;
			for (Association a : associations) {
				if(a.getConfidence()>=(double)confidence/100.0) 
					arule+=a.toString()+" \n\n";
			}
		}	


		scp.setMinWidth(910);
		
		TextArea textFreqMotif = new TextArea(motif);
		TextArea textAsRules = new TextArea(arule);
		textFreqMotif.setMinHeight(600);
		textAsRules.setMinHeight(600);
		textFreqMotif.setMaxHeight(600);
		textAsRules.setMaxHeight(600);

		textFreqMotif.setMinWidth(490);
		textAsRules.setMinWidth(490);
		textFreqMotif.setMaxWidth(490);
		textAsRules.setMaxWidth(490);
		
		HBox h = new HBox();
		VBox v = new VBox();
		
		h.setMinWidth(960);
		h.setMinHeight(600);
		
		textFreqMotif.setPadding(new Insets(5));
		textAsRules.setPadding(new Insets(5));
		
		

		
		h.getChildren().addAll(textFreqMotif, new Label("   "),textAsRules);
		v.getChildren().addAll(h);
		
		
		scp.setContent(h);
		scp.setOpacity(1);
				
	}
	
	
	public void eclat(int parameters, ScrollPane scp, ArrayList<Map<ArrayList<String>, ArrayList<Integer>>> eclatList) {
		String motif = "";
		
		int x= 1;
		for (Map<ArrayList<String>,ArrayList<Integer>> map : eclatList) {
			motif+="\n\n------------------------------------------------------- L"+x+" ("+map.size()+") --------------------------------------------------------\n\n\n";
			x++;
			
			for (Entry<ArrayList<String>,ArrayList<Integer>> val : map.entrySet()) {
				motif+=val.getKey()+":"+val.getValue().size()+" inst. "+val.getValue()+"\n\n";
			}		
		}

		scp.setMinWidth(910);
		
		TextArea textFreqMotif = new TextArea(motif);
		textFreqMotif.setMinHeight(600);
		textFreqMotif.setMinWidth(960);
		
		HBox h = new HBox();
		VBox v = new VBox();
		h.setMinWidth(960);
		h.setMinHeight(600);
		
		
		
		h.getChildren().addAll(textFreqMotif);
		v.getChildren().addAll(h);
		
		
		scp.setContent(h);
		scp.setOpacity(1);
				
		
	}
		
	
	public void kmedoid(int parameters, ScrollPane scp, Cluster clusters, ArrayList<ArrayList<Double>> data) {
		
		TextArea text = new TextArea();

		String clStr ="";
		String mdStr ="Medoids:\n";


		for (Integer md : clusters.getMedoids()) {
			mdStr += md+" => "+data.get(md)+"\n";
		}
		
		mdStr +="\n";
		mdStr+="\nClusters:\n";
		for (ArrayList<Integer> cl : clusters.getClusters()) {
			clStr += "("+cl.size()+" instance) :"+cl+"\n\n";
		}
		
		clStr+= "Cout : "+clusters.getError();

		text.appendText(mdStr);
		text.appendText(clStr);

		text.setWrapText(true);
		
		text.setMinHeight(600);
		text.setMinWidth(960);
		
		HBox h = new HBox();
		VBox v = new VBox();
		h.setMinWidth(960);
		h.setMinHeight(600);
		
		
		
		h.getChildren().addAll(text);
		v.getChildren().addAll(h);
		
		
		scp.setContent(v);
		scp.setOpacity(1);
		
	}

	public void clarans(int parameters, ScrollPane scp, Cluster clusters, ArrayList<ArrayList<Double>> data) {
			
			TextArea text = new TextArea();

		
			String clStr ="";
			String mdStr ="Medoids:\n";
			
			
			for (Integer md : clusters.getMedoids()) {
				mdStr += md+" => "+data.get(md)+"\n";
			}
			mdStr +="\n";
			
			mdStr+="\nClusters:\n";
			for (ArrayList<Integer> cl : clusters.getClusters()) {
				clStr += "("+cl.size()+" instance) :"+cl+"\n\n";
			}
			
			clStr+= "Cout : "+clusters.getError();
			
			text.appendText(mdStr);
			text.appendText(clStr);
			
			
			text.setMinHeight(600);
			text.setMinWidth(960);
			text.setWrapText(true);
			
			HBox h = new HBox();
			VBox v = new VBox();
			
			
			h.setMinWidth(960);
			h.setMinHeight(600);
			
			h.getChildren().addAll(text);
			v.getChildren().addAll(h);
			
			// scatterChart? ?????
			
			
			scp.setContent(v);
			scp.setOpacity(1);
	}
	
	
	
	public void describe(String description, ScrollPane scp, ArrayList<ArrayList<Double>> data) {
		String widerDescription = "-------------------------------------------------"                      +"\n1. age: age of the patient       \r\n2. sex: gender of the patient       \r\n3. chest Pain: four different types of chest pain       \r\n4. Blood Pressure: Mesured when patient is at rest  \r\n5. serum Cholestoral: Cholestoral concentarion in serum sample given in mg/dl      \r\n6. Blood sugar: if value is above 120 mg/dl it is considered high, normal otherwise       \r\n7. resting ECG: Three values (0,1,2) are given measured at rest \r\n8. max HR: maximum heart rate achieved during the measurement \r\n9. e.i. angina: exercise induced angina    \r\n10. oldpeak : ST depression induced by exercise relative to rest\r\n11. slopeST: the slope of the peak exercise ST segment     \r\n12. Vessels: number of major vessels (0-3) colored by flourosopy        \r\n13.  thal: 3 = normal; 6 = fixed defect; 7 = reversable defect \n \n";
				
				String nb = "Number of instances: "+ data.size()+"."
						+ "\nNumber of attributes: "+(data.get(0).size()-1)+".";
				
		TextArea text = new TextArea(description+"\n"+widerDescription+nb);
		text.setMinHeight(625);
		scp.setContent(text);
		scp.setOpacity(1);
		
	}
	
	public void boxPlot(ArrayList<String> attributes, ArrayList<ArrayList<Double>> values, ScrollPane scrollPaneTable, HBox boxplotAttributes) {

//TODO: Get it on controller, only set content when click, else, is done after import
		SwingNode sn = new SwingNode();
	
        DefaultBoxAndWhiskerCategoryDataset data = new DefaultBoxAndWhiskerCategoryDataset();
        boxplotAttributes.getChildren().add(new Label("Selected attributes are:\t"));
        for (int i=0 ; i<attributes.size(); i++) {
        	List<Double> list = new ArrayList<Double>();
        	
    			switch(i) {
    			case 3:
        			boxplotAttributes.getChildren().add( new Label("\t"+attributes.get(i)+"\t"));     				
        			for (ArrayList<Double> arrayList : values) {		
                		list.add(arrayList.get(i));
            		} 
            		data.add( list ,"HeartStat", attributes.get(i));   
        			
    				break;
    			case 7:
        			boxplotAttributes.getChildren().add( new Label("\t"+attributes.get(i)+"\t"));     				
        			for (ArrayList<Double> arrayList : values) {		
                		list.add(arrayList.get(i));
            		} 
            		data.add( list ,"HeartStat", attributes.get(i));   
        			
    				break;
    			case 4:
        			boxplotAttributes.getChildren().add( new Label("\t"+attributes.get(i)+"\t"));     				
        			for (ArrayList<Double> arrayList : values) {		
                		list.add(arrayList.get(i));
            		} 
            		data.add( list ,"HeartStat", attributes.get(i));   

    				break;
     			default:
        			break;
    			}

    		}
        
		JFreeChart chartBox = ChartFactory.createBoxAndWhiskerChart( 
				"Box Plot", "Relevant Attributes",
				"Corresponding Values", data, false);			
		
		ChartPanel c = new ChartPanel(chartBox);
		sn.setContent(c);
		scrollPaneTable.setContent(sn);
		scrollPaneTable.setOpacity(1);

	}

	public void tableView(ArrayList<String> attributes, ArrayList<ArrayList<Double>> values, ScrollPane scrollPaneTable) {
		
		ObservableList<ArrayList<String>> liste = FXCollections.observableArrayList();
		
		// convert Double to string
		ArrayList<ArrayList<String>> stringValues = new ArrayList<ArrayList<String>>();
		
		int i = 0;
		for (ArrayList<Double> arrayList : values) {
			
			ArrayList<String> strList = new ArrayList<String>();			
				for (Double Double : arrayList) {
					switch(i) {
					case 1:
						if( (double) Double == 1.0) {
							strList.add("male");
						}else {
							strList.add("female");
						}
						break;
					case 5:
						if( (double) Double == 1.0) {
							strList.add("high");
						}else {
							strList.add("normal");
						}
						break;
					case 8:
						if( (double) Double == 1.0) {
							strList.add("true");
						}else {
							strList.add("false");
						}
						break;
					case 9:
						strList.add(""+Double);	
						break;
					case 13:
						if( (double) Double == 1.0) {
							strList.add("present");
						}else {
							strList.add("absent");
						}
						break;
					default:
						strList.add(""+ (int)((double)Double));
						break;
					}

					i++;
				}
				i = 0;
				stringValues.add(strList);
		}
		
			liste.addAll(stringValues);
		
		TableView<ArrayList<String>> table = new TableView<ArrayList<String>>();
		ArrayList<TableColumn<ArrayList<String>, String>> columns  = new ArrayList<>();

		for (String attribute : attributes) {
			columns.add(new TableColumn<ArrayList<String>, String>(attribute));
		}
		
		for (TableColumn<ArrayList<String>, String> tableColumn : columns) {
				tableColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(0)));
		}
		// eh... I don't know a better option hehe ^_^'
		columns.get(0).setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(0)));
		columns.get(1).setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(1)));
		columns.get(2).setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(2)));
		columns.get(3).setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(3)));
		columns.get(4).setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(4)));
		columns.get(5).setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(5)));
		columns.get(6).setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(6)));
		columns.get(7).setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(7)));
		columns.get(8).setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(8)));
		columns.get(9).setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(9)));
		columns.get(10).setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(10)));
		columns.get(11).setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(11)));
		columns.get(12).setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(12)));
		columns.get(13).setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(13)));
		for (TableColumn<ArrayList<String>, String> tableColumn : columns) {
			tableColumn.setComparator(new CustomComparator());
		}
		table.getColumns().addAll(columns);
		table.setItems(liste);
		table.setLayoutX(0);
		table.setLayoutY(0);
		table.setMinWidth(994);
		table.setMinHeight(650);
		
		scrollPaneTable.setContent(table);
		scrollPaneTable.setOpacity(1);
	}

	
	
	
	public void BadHistogramChart(int choiceX, ArrayList<String> attributes, ArrayList<ArrayList<Double>> values, ScrollPane scrollPaneTable) {
		
		
		values.sort(compList(choiceX));
		
		
	    // convert Double to string
		ArrayList<ArrayList<String>> stringValues = new ArrayList<ArrayList<String>>();
		for (ArrayList<Double> arrayList : values) {
			ArrayList<String> strList = new ArrayList<String>();			
				for (Double Double : arrayList) {
					strList.add(""+Double);
				}
				stringValues.add(strList);
		}
		
	    //Bar chart
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		LineChart<String,Number> bc = new LineChart<String,Number>(xAxis,yAxis);
		bc.setTitle("Histogam of: "+attributes.get(choiceX));
		bc.setMinHeight(650);
		bc.setMinWidth((994 *values.size() ) / 270);
		//bc.setBarGap(-1);
		
		xAxis.setLabel("Attribute");       
	    yAxis.setLabel("Frequency of apparition");
	    XYChart.Series series = new XYChart.Series();
	    series.setName(attributes.get(choiceX));  
	    
	    Double[][] datacollumns = new Double[14][270];
	    
		for (int i = 0; i < attributes.size(); i++) {
				for (int j = 0; j < values.get(0).size(); j++) {
					datacollumns[i][j]= (Double) values.get(j).get(i);
				}
		}
		
		
		
		
		for (ArrayList<String> arrayList : stringValues) {
	    	series.getData().add(new XYChart.Data(arrayList.get(choiceX), Double.parseDouble(arrayList.get(0))));
		}

	    bc.getData().addAll(series);
		scrollPaneTable.setContent(bc);
		scrollPaneTable.setOpacity(1);

	}
	
	public void HistogramChart(int choiceX, ArrayList<String> attributes, Map<Double, Integer> map, ScrollPane scrollPaneTable) {
		
		//values.sort(compList(choiceX));
		
	    // convert Double to string
		ArrayList<ArrayList<String>> stringValues = new ArrayList<ArrayList<String>>();
		
	    //Bar chart
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
		bc.setTitle("Histogam of: "+attributes.get(choiceX));
		bc.setMinHeight(650);
		bc.setMinWidth(994);
		//bc.setBarGap(-1);
		
		xAxis.setLabel("Attribute");       
	    yAxis.setLabel("Frequency of apparition");
   	    XYChart.Series series = new XYChart.Series();	 
   	    
   	    series.setName(attributes.get(choiceX));
   	    Comparator<Double> byName = (Double o1, Double o2)-> o1.compareTo(o2);

   	    LinkedHashMap<Double, Integer> sortedMap =  
   	    		map.entrySet().stream().sorted(Map.Entry.<Double,Integer>comparingByKey(byName))
             .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
   	 
    	for (Entry<Double, Integer> val : sortedMap.entrySet()) {
    		series.getData().add(new XYChart.Data(""+val.getKey(), val.getValue()));
    		
		}
   	     //   series.getData().sort(Comparator.comparingDouble(d -> d.getYValue().doubleValue()));
   	    
   	    bc.getData().add(series);
   	    bc.getData().sort((Series<String, Number> o1, Series<String, Number> o2) -> o1.getData().size() <= o2.getData().size()?1:0);
		scrollPaneTable.setContent(bc);
		scrollPaneTable.setOpacity(1);
		
	}

	public void ScatterChartClusters(int choiceX, int choiceY, ArrayList<String> attributes, ArrayList<ArrayList<ArrayList<Double>>> clusters, ArrayList<ArrayList<Double>> originalData, ScrollPane scrollPaneTable) {
		int type = 0; 

	    //Bar chart

		ArrayList<ArrayList<Double>> rows = new ArrayList<ArrayList<Double>>(GUIController.transpose(originalData));
		double minX = Data.min(rows.get(choiceX));
		double maxX = Data.max(rows.get(choiceX));
		double minY = Data.min(rows.get(choiceY));
		double maxY = Data.max(rows.get(choiceY));
		NumberAxis xAxis = new NumberAxis(minX-(int)(maxX-minX)/10,maxX+(int)(maxX-minX)/10,(int)(maxX-minX)/10);
		NumberAxis yAxis = new NumberAxis(minY-(int)(maxY-minY)/10,maxY+(int)(maxY-minY)/10,(int)(maxY-minY)/10);

		ScatterChart<Number,Number> bc = new ScatterChart<Number,Number>(xAxis,yAxis);
		bc.setTitle("Scatter Plot: "+attributes.get(choiceY)+" / "+attributes.get(choiceX));
		bc.setMinHeight(620);
		bc.setMinWidth(960);
		

		for (ArrayList<ArrayList<Double>> values : clusters) {
			
//		values.sort(compList(choiceX));
	    // convert Double to string		

		
	    xAxis.setLabel(attributes.get(choiceX));       
	    yAxis.setLabel(attributes.get(choiceY));

	    XYChart.Series series = new XYChart.Series();
	    series.setName("cluster"+ ++type);    

	    for (int i = 0; i < values.size(); i++) {
	    	series.getData().add(new XYChart.Data(values.get(i).get(choiceX), values.get(i).get(choiceY)));
		}
	    
	    bc.getData().add(series);
		}
	    bc.setFocusTraversable(true);
	    bc.setCacheShape(true);
		scrollPaneTable.setContent(bc);
		scrollPaneTable.setOpacity(1);

	}	

	public void ScatterChart(int choiceX, int choiceY, ArrayList<String> attributes, ArrayList<ArrayList<Double>> values, ScrollPane scrollPaneTable) {

		
		values.sort(compList(choiceX));
	    // convert Double to string		
		ArrayList<ArrayList<String>> stringValues = new ArrayList<ArrayList<String>>();
		for (ArrayList<Double> arrayList : values) {
			ArrayList<String> strList = new ArrayList<String>();			
				for (Double Double : arrayList) {
					strList.add(""+Double);
				}
				stringValues.add(strList);
		}
		
	    //Bar chart
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		ScatterChart<String,Number> bc = new ScatterChart<String,Number>(xAxis,yAxis);
		
		bc.setTitle("Scatter Plot: "+attributes.get(choiceY)+" / "+attributes.get(choiceX));
		bc.setMinHeight(650);
		bc.setMinWidth(994);
	    xAxis.setLabel(attributes.get(choiceX));       
	    yAxis.setLabel(attributes.get(choiceY));

	    XYChart.Series series = new XYChart.Series();
	    series.setName(attributes.get(choiceY));    

	    for (int i = 0; i < values.size(); i++) {
	    	series.getData().add(new XYChart.Data(""+values.get(i).get(choiceX), values.get(i).get(choiceY)));
		}
	    bc.setFocusTraversable(true);
	    bc.setCacheShape(true);
	    bc.getData().addAll(series);
		scrollPaneTable.setContent(bc);
		scrollPaneTable.setOpacity(1);
	}
	
	
	public static Comparator<ArrayList<Double>> compareAge = new Comparator<ArrayList<Double>>() {
		public int compare(ArrayList<Double> A1, ArrayList<Double> A2) {

			double As1 = (double) A1.get(0);
			double As2 = (double) A2.get(0);
			// ascending order
			if (As1 > As2) 		return 1 ;
			else if (As1 < As2) return -1;
			else 				return 0 ;
		}
	};
	
	public static Comparator<ArrayList<Double>> compareChestPain = new Comparator<ArrayList<Double>>() {
		public int compare(ArrayList<Double> A1, ArrayList<Double> A2) {

			double As1 = (double) A1.get(2);
			double As2 = (double) A2.get(2);
			// ascending order
			if (As1 > As2) 		return 1 ;
			else if (As1 < As2) return -1;
			else 				return 0 ;
		}
	};	
	
	public static Comparator<ArrayList<Double>> compareBP = new Comparator<ArrayList<Double>>() {
		public int compare(ArrayList<Double> A1, ArrayList<Double> A2) {

			double As1 = (double) A1.get(3);
			double As2 = (double) A2.get(3);
			// ascending order
			if (As1 > As2) 		return 1 ;
			else if (As1 < As2) return -1;
			else 				return 0 ;
		}
	};	
	
	public static Comparator<ArrayList<Double>> compareChlst = new Comparator<ArrayList<Double>>() {
		public int compare(ArrayList<Double> A1, ArrayList<Double> A2) {

			double As1 = (double) A1.get(4);
			double As2 = (double) A2.get(4);
			// ascending order
			if (As1 > As2) 		return 1 ;
			else if (As1 < As2) return -1;
			else 				return 0 ;
		}
	};
	
	public static Comparator<ArrayList<Double>> compareECG = new Comparator<ArrayList<Double>>() {
		public int compare(ArrayList<Double> A1, ArrayList<Double> A2) {

			double As1 = (double) A1.get(6);
			double As2 = (double) A2.get(6);
			// ascending order
			if (As1 > As2) 		return 1 ;
			else if (As1 < As2) return -1;
			else 				return 0 ;
		}
	};
		
	public static Comparator<ArrayList<Double>> compareHR = new Comparator<ArrayList<Double>>() {
		public int compare(ArrayList<Double> A1, ArrayList<Double> A2) {

			double As1 = (double) A1.get(7);
			double As2 = (double) A2.get(7);
			// ascending order
			if (As1 > As2) 		return 1 ;
			else if (As1 < As2) return -1;
			else 				return 0 ;
		}
	};
	
	public static Comparator<ArrayList<Double>> compareOP = new Comparator<ArrayList<Double>>() {
		public int compare(ArrayList<Double> A1, ArrayList<Double> A2) {

			double As1 = (double) A1.get(9);
			double As2 = (double) A2.get(9);
			// ascending order
			if (As1 > As2) 		return 1 ;
			else if (As1 < As2) return -1;
			else 				return 0 ;
		}
	};

	public static Comparator<ArrayList<Double>> compareST = new Comparator<ArrayList<Double>>() {
		public int compare(ArrayList<Double> A1, ArrayList<Double> A2) {

			double As1 = (double) A1.get(10);
			double As2 = (double) A2.get(10);
			// ascending order
			if (As1 > As2) 		return 1 ;
			else if (As1 < As2) return -1;
			else 				return 0 ;
		}
	};
	public static Comparator<ArrayList<Double>> compareVessels = new Comparator<ArrayList<Double>>() {
		public int compare(ArrayList<Double> A1, ArrayList<Double> A2) {

			double As1 = (double) A1.get(11);
			double As2 = (double) A2.get(11);
			// ascending order
			if (As1 > As2) 		return 1 ;
			else if (As1 < As2) return -1;
			else 				return 0 ;
		}
	};
		
	public static Comparator<ArrayList<Double>> compareThal = new Comparator<ArrayList<Double>>() {
		public int compare(ArrayList<Double> A1, ArrayList<Double> A2) {

			double As1 = (double) A1.get(12);
			double As2 = (double) A2.get(12);
			// ascending order
			if (As1 > As2) 		return 1 ;
			else if (As1 < As2) return -1;
			else 				return 0 ;
		}
	};
			
	private class CustomComparator implements Comparator<String>{

	    @Override
	    public int compare(String o1, String o2) {
	        if (o1 == null && o2 == null) return 0;
	        if (o1 == null) return -1;
	        if (o2 == null) return 1;

	        Double i1=null;
	        try{ i1=Double.valueOf(o1); } catch(NumberFormatException ignored){}
	        Double i2=null;
	        try{ i2=Double.valueOf(o2); } catch(NumberFormatException ignored){}

	        if(i1==null && i2==null) return o1.compareTo(o2);
	        if(i1==null) return -1;
	        if(i2==null) return 1;

	        return (int) (i1-i2);
	    }
	}
	
	public static Comparator<ArrayList<Double>> compList(int choice){
		switch(choice) {
		  case 0:
		    return compareAge;
		  case 2:
		    return compareChestPain;
		  case 3:
			    return compareBP;
		  case 4:
			    return compareChlst;
		  case 6:
			    return compareECG;
		  case 7:
			    return compareHR;
		  case 9:
			    return compareOP;
		  case 10:
			    return compareST;
		  case 11:
			    return compareVessels;
		  case 12:
			  	return compareThal;
		  default:
		    return compareAge;
		}
				
	}

	
	
}
