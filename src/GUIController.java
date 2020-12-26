import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.Map.Entry;

import com.jfoenix.controls.JFXTextArea;
import com.sun.javafx.scene.layout.region.Margins;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class GUIController {
	
	@FXML
	private Stage stage;
	
	@FXML
	private Pane MainPanel;
	
	@FXML
	private JFXTextArea solutionText;
	
	@FXML
	private ScrollPane solutionScrollPane;
	
	@FXML
	private Label totalTime;
	
	@FXML 
	private Label methodName;
	
	@FXML
	private Label summary;
	
	@FXML
	private Label optimal;
	
	@FXML
	private Label solLabel;
	
	@FXML
	private Label totalTimeLabel;
	
	@FXML
	private ScrollPane scrollPaneBarChart;
	
	@FXML
	private ScrollPane scrollPaneTable;
	
	@FXML
	private ScrollPane scrollPaneLineChart;
	
	@FXML
	private ScrollPane scrollPaneLineChartGenetic;

	@FXML
	private HBox mmmH;	

	@FXML
	private VBox mmmV;	

	@FXML
	private Pane mmm;
	
	@FXML 
	private ScatterChart scatterChart;

	
	@FXML
	private Label meanL;
	
	@FXML
	private Label medianL;
	
	@FXML
	private Label cholestoralLabel;
	
	@FXML
	private Label HRLabel;
	
	@FXML
	private Label bloodLabel;
	
	@FXML
	private Label modeL;
	
	
	@FXML
	private VBox meanV;
	
	@FXML
	private VBox medianV;
	
	@FXML
	private VBox modeV;
	
	@FXML
	private JFXTextArea mean1;
	
	@FXML
	private JFXTextArea median1;
	
	@FXML
	private JFXTextArea mode1;
	
	
	@FXML
	private JFXTextArea mean2;
	
	@FXML
	private JFXTextArea median2;
	
	@FXML
	private JFXTextArea mode2;

	@FXML
	private JFXTextArea mean3;
	
	@FXML
	private JFXTextArea median3;
	
	@FXML
	private JFXTextArea mode3;
	
	@FXML
	private Pane tablePane;

	@FXML
	private ComboBox<String> comboX;
	@FXML
	private ComboBox<String> comboY;

	@FXML
	private ComboBox<String> comboHist;

	@FXML
	private Group XYgroup;

	@FXML
	private Group HistGroup;
	
	@FXML
	private HBox boxplotAttributes;
	
	@FXML
	private Label second;	
	
	@FXML
	private Label third;	
	
	@FXML
	private Label showbtn;	
	
	@FXML
	private Label mmmbtn;	
	
	@FXML
	private Label whiskerbtn;	
	
	@FXML
	private Label histogrambtn;	
	
	@FXML
	private Label scatterbtn;	
	
	@FXML
	private Label aprioribtn;		
	
	@FXML
	private Label eclatbtn;	
	
	@FXML
	private Label kmedoidbtn;	
	
	@FXML
	private Label claransbtn;	
	
	@FXML
	private Label scatterpcabtn;	
	
	@FXML
	private HBox suppConf;	
	
	
	@FXML
	private ComboBox<Integer> supp;	
	
	
	@FXML	
	private ComboBox<Integer> conf;	
		
	@FXML	
	private Label confLabel;		
	
	@FXML	
	private HBox kmedHbox;		
	

	@FXML	
	private ComboBox<Integer> kmed;	
		

	@FXML	
	private ComboBox<Integer> kerror;	
		
	@FXML	
	private HBox clarHbox;		
	

	@FXML	
	private ComboBox<Integer> kclar;	
		

	@FXML	
	private ComboBox<Integer> maxiter;	
			
	@FXML	
	private ComboBox<Integer> maxpart;	
	
	Data file;
	Data allfiles;
	ArrayList<Data> DirFiles;
	Label timeLabel = new Label();
	ArrayList<ArrayList<Double>> data = new ArrayList<ArrayList<Double>>();
	ArrayList<ArrayList<ArrayList<Double>>> kmedoidsData = new ArrayList<ArrayList<ArrayList<Double>>>();
	ArrayList<ArrayList<Double>> clanransData = new ArrayList<ArrayList<Double>>();
	ArrayList<ArrayList<String>> aprioriData = new ArrayList<ArrayList<String>>();


	public void OpacitySetting(int scene, double level) {
		// set opacity (level)
		if(scene==0) {
			scrollPaneTable.setOpacity(level);
		}if(scene==1) {
		mmmH.setOpacity(level);
		mmmV.setOpacity(level);
		meanV.setOpacity(level);
		medianV.setOpacity(level);
		modeV.setOpacity(level);
		}
		else if(scene==2) {

		}else if(scene==3) {
			XYgroup.setOpacity(level);
			
		}else if (scene==4) {
			XYgroup.setOpacity(level);
		}
		
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
		
	}

	
	public static void FileAlert(String title, String message, boolean exit) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(message);
		alert.showAndWait();
		if(exit) System.exit(0);
	}
	
	public static ButtonType chartAlert(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(message);						
		Optional<ButtonType> result = alert.showAndWait();
		return result.get();
	}

	public void options(int i ) {
		
		if(i==3) {
		showbtn.setDisable(true);
		showbtn.setOpacity(0);
		mmmbtn.setDisable(true);
		mmmbtn.setOpacity(0);
		whiskerbtn.setDisable(true);
		whiskerbtn.setOpacity(0);
		histogrambtn.setDisable(true);
		histogrambtn.setOpacity(0);
		scatterbtn.setDisable(true);
		scatterbtn.setOpacity(0);
		
		aprioribtn.setDisable(false);
		aprioribtn.setOpacity(1);
		eclatbtn.setDisable(false);
		eclatbtn.setOpacity(1);
		kmedoidbtn.setDisable(false);
		kmedoidbtn.setOpacity(1);
		claransbtn.setDisable(false);
		claransbtn.setOpacity(1);
		scatterpcabtn.setDisable(false);
		scatterpcabtn.setOpacity(1);
		
		
		}else {
			aprioribtn.setDisable(true);
			aprioribtn.setOpacity(0);
			eclatbtn.setDisable(true);
			eclatbtn.setOpacity(0);
			kmedoidbtn.setDisable(true);
			kmedoidbtn.setOpacity(0);
			claransbtn.setDisable(true);
			claransbtn.setOpacity(0);
			scatterpcabtn.setDisable(true);
			scatterpcabtn.setOpacity(0);
			
			
			showbtn.setDisable(false);
			showbtn.setOpacity(1);
			mmmbtn.setDisable(false);
			mmmbtn.setOpacity(1);
			whiskerbtn.setDisable(false);
			whiskerbtn.setOpacity(1);
			histogrambtn.setDisable(false);
			histogrambtn.setOpacity(1);
			scatterbtn.setDisable(false);
			scatterbtn.setOpacity(1);
			
			
		}
	}
	
	
	public void thirdOption() {
		mmm.setDisable(true);
		scrollPaneTable.setDisable(false);
		boxplotAttributes.setDisable(true);
		boxplotAttributes.setOpacity(0);
		XYgroup.setDisable(true);
		XYgroup.setOpacity(0);
		OpacitySetting(1,0);
		OpacitySetting(0,0);
		summary.setDisable(false);
		summary.setOpacity(1);
		summary.setText("DataMining Techniques:");
		HistGroup.setDisable(true);
		HistGroup.setOpacity(0);

		options(3);
		
		
		
		String description = this.file.getDescription();
		GUI ui = new GUI();
		ui.describe(description,scrollPaneTable, data);	
	}

	
	public void secondOption() {
		
		options(2);

		
		
		mmm.setDisable(true);
		scrollPaneTable.setDisable(false);
		boxplotAttributes.setDisable(true);
		boxplotAttributes.setOpacity(0);
		XYgroup.setDisable(true);
		XYgroup.setOpacity(0);
		OpacitySetting(1,0);
		OpacitySetting(0,0);
		summary.setDisable(false);
		summary.setOpacity(1);
		summary.setText("Description of the attributes:");
		HistGroup.setDisable(true);
		HistGroup.setOpacity(0);
		
		String description = this.file.getDescription();
		GUI ui = new GUI();
		ui.describe(description,scrollPaneTable, data);	
		}
	
	public void DataImport() {
		FileChooser chooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text file", "*.txt");
		chooser.getExtensionFilters().add(extFilter);
		List<File> liste = chooser.showOpenMultipleDialog(this.stage);
		
		if(liste != null) {	
			if(liste.size() == 1) {
				this.file = new Data(liste.get(0).getAbsolutePath());
				this.file.extractData();
				data = this.file.extractData();
				}		
		}
		ArrayList<String> attributes = new ArrayList<String>();
		attributes.addAll(Arrays.asList("Age","Sex","Chest Pain","Blood P.","cholestoral","Sugar>120mg","ECG","max HR","e.i.angina","old Peak","slope ST","Vessels","Thal","Disease"));	
		comboX.getItems().addAll(attributes);
	    comboX.setValue(attributes.get(3));
		comboY.getItems().addAll(attributes);
	    comboY.setValue(attributes.get(0));
	    comboHist.getItems().addAll(attributes);
	    comboHist.setValue(attributes.get(0));
	    mmm.setDisable(true);
		scrollPaneTable.setDisable(false);
		boxplotAttributes.setDisable(true);
		boxplotAttributes.setOpacity(0);
		XYgroup.setDisable(true);
		XYgroup.setOpacity(0);
		OpacitySetting(1,0);
		OpacitySetting(0,0);
		summary.setDisable(false);
		summary.setOpacity(1);
		String description = this.file.getDescription();
		GUI ui = new GUI();
		ui.describe(description,scrollPaneTable, data);
		second.setDisable(false);
		third.setDisable(false);
		
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for (int i = 1; i < 100; i++) {
			ints.add(i);
		}
		
		
		supp.getItems().addAll(ints);
		conf.getItems().addAll(ints);
		
		supp.setValue(2);
		conf.setValue(80);
		
		ArrayList<Integer> kints = new ArrayList<Integer>();
		for (int i = 2; i <= 50; i++) {
			kints.add(i);
		}
		ArrayList<Integer> kerr = new ArrayList<Integer>();
		for (int i = 300; i <= 3000; i+=50) {
			kerr.add(i);
		}		

		
		kmed.getItems().addAll(kints);
		kerror.getItems().addAll(kerr);

		kmed.setValue(3);
		kerror.setValue(3000);


		ArrayList<Integer> citer = new ArrayList<Integer>();
		for (int i = 5; i <= 100; i++) {
			citer.add(i);
		}		

		ArrayList<Integer> cpart = new ArrayList<Integer>();
		for (int i = 2; i <= 100; i++) {
			cpart.add(i);
		}		

		
		kmed.getItems().addAll(kints);
		kerror.getItems().addAll(kerr);

		kmed.setValue(3);
		kerror.setValue(3000);
		
		kclar.getItems().addAll(kints);
		maxiter.getItems().addAll(citer);
		maxpart.getItems().addAll(cpart);
		
		kclar.setValue(3);
		maxiter.setValue(20);
		maxpart.setValue(5);

	}

	
	public void ShowData() {

			if(this.file == null) {
				//No Data selected
				FileAlert("ERROR", "NO DATA FOUND", false);	
			} else {
				GUI ui = new GUI();
				//	ui.lineChart(list, scrollPaneLineChartGenetic);
				boxplotAttributes.setDisable(true);
				boxplotAttributes.setOpacity(0);
				XYgroup.setDisable(true);
				XYgroup.setOpacity(0);
				mmm.setDisable(true);
				scrollPaneTable.setDisable(false);
				OpacitySetting(1,0);
				OpacitySetting(0,1);
				summary.setText("Dataset content");
				summary.setDisable(false);
				summary.setOpacity(1);
				HistGroup.setDisable(true);
				HistGroup.setOpacity(0);
				
				suppConf.setDisable(true);
				suppConf.setOpacity(0);

				kmedHbox.setDisable(true);
				kmedHbox.setOpacity(0);
				
				clarHbox.setDisable(true);
				clarHbox.setOpacity(0);
				ArrayList<String> attributes = new ArrayList<String>();
				attributes.addAll(Arrays.asList("Age","Sex","Chest Pain","Blood P.","cholestoral","Sugar>120mg","ECG","max HR","e.i.angina","old Peak","slope ST","Vessels","Thal","Disease"));	
				ui.tableView(attributes, data, scrollPaneTable);	
			
			
			}
	}
	
	

	public void ThreeMs() {
		if(this.file == null) {
			//No Data selected
			FileAlert("ERROR", "NO DATA FOUND", false);	
		} else {
		OpacitySetting(1,1);
		OpacitySetting(0,0);
		OpacitySetting(2,0);
		
		suppConf.setDisable(true);
		suppConf.setOpacity(0);
		boxplotAttributes.setDisable(true);
		boxplotAttributes.setOpacity(0);
		
		XYgroup.setDisable(true);
		XYgroup.setOpacity(0);
		mmm.setDisable(false);
		scrollPaneTable.setDisable(true);
		summary.setDisable(true);
		summary.setOpacity(0);
		HistGroup.setDisable(true);
		HistGroup.setOpacity(0);
		suppConf.setDisable(true);
		suppConf.setOpacity(0);
		clarHbox.setDisable(true);
		clarHbox.setOpacity(0);
		
		kmedHbox.setDisable(true);
		kmedHbox.setOpacity(0);
		Thread t = new Thread(new Runnable() {	
			public void run() {
		
				ArrayList<Double> bloodPressure = new ArrayList<Double>() ;
				ArrayList<Double> cholestoral = new ArrayList<Double>() ;
				ArrayList<Double> maxHR = new ArrayList<Double>() ;
				
				for (ArrayList<Double> att : data) {
					bloodPressure.add((double) att.get(3));
				}
				for (ArrayList<Double> att : data) {
					cholestoral.add((double) att.get(4));
				}
				for (ArrayList<Double> att : data) {
					maxHR.add((double) att.get(7));
				}
				
				mean1.setText(""+String.format("%.3f",Data.Mean(bloodPressure)));
				median1.setText(""+(int)Data.Median(bloodPressure));
				mode1.setText(""+(int)Data.Mode(bloodPressure));
				mean2.setText(""+String.format("%.3f",Data.Mean(cholestoral)));
				median2.setText(""+(int)Data.Median(cholestoral));
				mode2.setText(""+(int)Data.Mode(cholestoral));
				mean3.setText(""+String.format("%.3f",Data.Mean(maxHR)));
				median3.setText(""+(int)Data.Median(maxHR));
				mode3.setText(""+(int)Data.Mode(maxHR));
					
				

				}
			});
			t.setDaemon(true);
			t.start();
		}
	}
	
	public ArrayList<ArrayList<Double>> binnedData(ArrayList<ArrayList<Double>> Originaldata){
		// getting K using Sturge’s Rule
		
		ArrayList<ArrayList<Double>> data = new ArrayList<ArrayList<Double>>(Originaldata);
		ArrayList<ArrayList<Double>> clean = new ArrayList<ArrayList<Double>>();
		clean = new ArrayList<ArrayList<Double>>(cleanData(data));
		
		ArrayList<Double> age = new ArrayList<Double>() ;
		ArrayList<Double> bloodPressure = new ArrayList<Double>() ;
		ArrayList<Double> cholestoral = new ArrayList<Double>() ;
		ArrayList<Double> maxHR = new ArrayList<Double>() ;

		for (ArrayList<Double> att : clean) {
			age.add((double) att.get(0));
		}
		for (ArrayList<Double> att : clean) {
			bloodPressure.add((double) att.get(3));
		}
		for (ArrayList<Double> att : clean) {
			cholestoral.add((double) att.get(4));
		}
		for (ArrayList<Double> att : clean) {
			maxHR.add((double) att.get(7));
		}
		double uAge = Data.max(age);
		double lAge = Data.min(age);
		double uBp = Data.max(bloodPressure);
		double lBp = Data.min(bloodPressure);
		double uHr = Data.max(maxHR);
		double lHr = Data.min(maxHR);
		double uChs = Data.max(cholestoral);
		double lChs = Data.min(cholestoral);
		
		//Sturge’s Rule K = 1+ 3.322*log(size)
		double ageK =(int) (1+3.322*Math.log10(uAge-lAge));
		double bpK =(int) (1+3.322*Math.log10(uBp-lBp));
		double chsK =(int) (1+3.322*Math.log10(uChs-lChs));
		double hrK =(int) (1+3.322*Math.log10(uHr-lHr));
//		ageK = 4;
//		bpK = 4;
//		chsK= 4;
//		hrK= 4;
		double ageInterval = Math.ceil((uAge-lAge)/ageK);
		double bpInterval = Math.ceil((uBp-lBp)/bpK);
		double chsInterval = Math.ceil((uChs-lChs)/chsK);
		double hrInterval = Math.ceil((uHr-lHr)/hrK);

		System.out.println(ageK+" "+bpK+" "+chsK+" "+hrK);
		System.out.println(ageInterval+" "+bpInterval+" "+chsInterval+" "+hrInterval);
		
		double ageNumber[] = new double[(int) ageK];
		double ageSum[] = new double[(int) ageK];
		double bpNumber[] = new double[(int) bpK];
		double bpSum[] = new double[(int) bpK];
		double chsNumber[] = new double[(int) chsK];
		double chsSum[] = new double[(int) chsK];
		double hrNumber[] = new double[(int) hrK];
		double hrSum[] = new double[(int) hrK];
		// get mean for each interval
		for (int i = 0; i < ageSum.length; i++) {
			ageSum[i] = 0;
		}
		for (int i = 0; i < ageNumber.length; i++) {
			ageNumber[i] = 0;
		}
		for (int i = 0; i < bpSum.length; i++) {
			bpSum[i] = 0;
		}
		for (int i = 0; i < bpNumber.length; i++) {
			bpNumber[i] = 0;
		}
		for (int i = 0; i < chsSum.length; i++) {
			chsSum[i] = 0;
		}
		for (int i = 0; i < chsNumber.length; i++) {
			chsNumber[i] = 0;
		}
		for (int i = 0; i < hrSum.length; i++) {
			hrSum[i] = 0;
		}
		for (int i = 0; i < hrNumber.length; i++) {
			hrNumber[i] = 0;
		}
		
		for (Double x : age) {
			for(int i=0;i<ageK; i++) {
				if(x>=(lAge+i*ageInterval)&& x<lAge+(i+1)*ageInterval) {
					ageSum[i]+=x;
					ageNumber[i]++;
					break;
				}
			}
		}
		for (Double x : bloodPressure) {
			for(int i=0;i<bpK; i++) {
				if(x>=(lBp+i*bpInterval)&& x<lBp+(i+1)*bpInterval) {
					bpSum[i]+=x;
					bpNumber[i]++;
					break;
				}
			}
		}
		for (Double x : cholestoral) {
			for(int i=0;i<chsK; i++) {
				if(x>=(lChs+i*chsInterval)&& x<lChs+(i+1)*chsInterval) {
					chsSum[i]+=x;
					chsNumber[i]++;
					break;
				}
			}
		}
		for (Double x : maxHR) {
			for(int i=0;i<hrK; i++) {
				if(x>=(lHr+i*hrInterval)&& x<lHr+(i+1)*hrInterval) {
					hrSum[i]+=x;
					hrNumber[i]++;
					break;
				}
			}
		}
		
		for (ArrayList<Double>list :clean) {
			// this will be a lot
			int index= 0;
			for(int i=0;i<ageK;i++) {
				if(list.get(0) >=(lAge+i*ageInterval)&& list.get(0) <lAge+(i+1)*ageInterval) {
					index = i;
					break;
				}
			}
			list.set(0, ((int)(100*ageSum[index]/ageNumber[index]))/100.0);
			index=0;
			for(int i=0;i<bpK;i++) {
				if(list.get(3) >=(lBp+i*bpInterval)&& list.get(3) <lBp+(i+1)*bpInterval) {
					index = i;
					break;
				}
			}
			list.set(3, ((int)(100*bpSum[index]/bpNumber[index]))/100.0);
			index=0;
			for(int i=0;i<chsK;i++) {
				if(list.get(4) >=(lChs+i*chsInterval)&& list.get(4) <lChs+(i+1)*chsInterval) {
					index = i;
					break;
				}
			}
			list.set(4, ((int)(100*chsSum[index]/chsNumber[index]))/100.0);
			index=0;
			for(int i=0;i<hrK;i++) {
				if(list.get(7) >=(lHr+i*hrInterval)&& list.get(7) <lHr+(i+1)*hrInterval) {
					index = i;
					break;
				}
			}
			list.set(7, ((int)(100*hrSum[index]/hrNumber[index]))/100.0);
			index=0;
		}
		
		return clean;
	}

	public ArrayList<ArrayList<Double>> cloneArray(ArrayList<ArrayList<Double>> original) {
		ArrayList<ArrayList<Double>> copy = new ArrayList<ArrayList<Double>>();
		for (ArrayList<Double> arrayList : original) {
			ArrayList<Double> list = new ArrayList<Double>();
			for (Double item: arrayList) {
				list.add(new Double(item));
			}
			copy.add(list);
		}
		return copy;
	}

	public ArrayList<Integer> cloneArrayOne(ArrayList<Integer> original) {
		ArrayList<Integer> copy = new ArrayList<Integer>();
		for (Integer item : original) {
			copy.add(item);
		}
		return copy;
	}
	
	public ArrayList<ArrayList<Integer>> cloneArrayInt(ArrayList<ArrayList<Integer>> original) {
		ArrayList<ArrayList<Integer>> copy = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> arrayList : original) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (Integer item: arrayList) {
				list.add(new Integer(item));
			}
			copy.add(list);
		}
		return copy;
	}
	
	
	
	public ArrayList<Map<ArrayList<String>, Integer>> apriori(int support,int confidence, ArrayList<ArrayList<String>> strData){
		// TODO: this is the one
		ArrayList<String> all = new ArrayList<String>();

		for (ArrayList<String> arrayList : strData) {
			for (String data : arrayList) {
				all.add(data);
			}
		}

		Map<ArrayList<String>, Integer> mapItem1 = new HashMap<ArrayList<String>, Integer>();
		Map<ArrayList<String>, Integer> mapItem2 = new HashMap<ArrayList<String>, Integer>();
		Map<ArrayList<String>, Integer> mapItem3 = new HashMap<ArrayList<String>, Integer>();
		Map<ArrayList<String>, Integer> mapItem4 = new HashMap<ArrayList<String>, Integer>();
		
		// count freq returns a map of Item,freq
		
		for (String string : all) {
			ArrayList<String> al = new ArrayList<String>();
			al.add(string);
			//mapItem1.put(al , freqItems(new ArrayList<String>(Arrays.asList(string)),strData));
			if(freqItems(al,strData)>=support)
			mapItem1.put(al , freqItems(al,strData));
		}
    	
    	mapItem2 = aprioriFunction(support, confidence, mapItem1, mapItem1, strData);
    	mapItem3 = aprioriFunction(support, confidence, mapItem1, mapItem2, strData);
    	mapItem4 = aprioriFunction(support, confidence, mapItem2, mapItem2, strData);


		
		return new ArrayList<Map<ArrayList<String>, Integer>>(Arrays.asList(mapItem1,mapItem2,mapItem3,mapItem4));
	}
	

	public ArrayList<Map<ArrayList<String>, ArrayList<Integer>>> eclat(int support,int confidence, ArrayList<ArrayList<String>> strData){
		// TODO: this is the one
		
		ArrayList<Map<ArrayList<String>, ArrayList<Integer>>> instanceList = new ArrayList<Map<ArrayList<String>, ArrayList<Integer>>>();

		
		ArrayList<String> all = new ArrayList<String>();

		for (ArrayList<String> arrayList : strData) {
			for (String data : arrayList) {
				all.add(data);
			}
		}

		Map<ArrayList<String>, ArrayList<Integer>> mapItem = new HashMap<ArrayList<String>, ArrayList<Integer>>();
		Map<ArrayList<String>, ArrayList<Integer>> mapItem2 = new HashMap<ArrayList<String>, ArrayList<Integer>>();
		Map<ArrayList<String>, ArrayList<Integer>> mapItem3 = new HashMap<ArrayList<String>, ArrayList<Integer>>();
		Map<ArrayList<String>, ArrayList<Integer>> mapItem4 = new HashMap<ArrayList<String>, ArrayList<Integer>>();

		for (String string : all) {
			ArrayList<String> al = new ArrayList<String>();
			al.add(string);
			if(instanceItems(al,strData).size()>=support)
				mapItem.put(al, instanceItems(al,strData));
		}

    	mapItem2 = eclatFunction(support, confidence, mapItem, mapItem );
    	mapItem3 = eclatFunction(support, confidence, mapItem, mapItem2 );    	
    	mapItem4 = eclatFunction(support, confidence, mapItem2, mapItem2 );
   
    	instanceList.add(mapItem);
    	instanceList.add(mapItem2);
    	instanceList.add(mapItem3);
    	instanceList.add(mapItem4);
		
		
		return instanceList;
	}

	
	public Map<ArrayList<String>, ArrayList<Integer>> eclatFunction(int support, int confidence, Map<ArrayList<String>, ArrayList<Integer>> mapItem1, Map<ArrayList<String>, ArrayList<Integer>> mapItem2) {
		Map<ArrayList<String>, ArrayList<Integer>> mapItem = new HashMap<ArrayList<String>, ArrayList<Integer>>();
		
    	for (Entry<ArrayList<String>, ArrayList<Integer>> val : mapItem1.entrySet()) {
    		if(val.getValue().size()>=support) {

    			for (Entry<ArrayList<String>, ArrayList<Integer>> val2 : mapItem2.entrySet()) {
    				
    				if(Collections.disjoint(val.getKey(),val2.getKey())) {
            			ArrayList<String> temp = new ArrayList<String>(val.getKey());    

            			for (String item : val2.getKey()) {
    						if(!val.getKey().contains(item)) {
    							temp.add(item);
    						}
    					}

						if( !mapContains( mapItem, temp)) {
							ArrayList<Integer> f = 
									new ArrayList<Integer>(intersectionInt(val.getValue(),val2.getValue()));
							if(f.size()>=support)
								mapItem.put(temp,f);
						}
    				}
				}
    		}
		}
		
		return mapItem;
		
	}
	
	public Map<ArrayList<String>, Integer> aprioriFunction(int support, int confidence, Map<ArrayList<String>, Integer> mapItem1, Map<ArrayList<String>, Integer> mapItem2, ArrayList<ArrayList<String>> strData) {
		Map<ArrayList<String>,Integer> mapItem = new HashMap<ArrayList<String>, Integer>();
		
		
    	for (Entry<ArrayList<String>, Integer> val : mapItem1.entrySet()) {
    		for (Entry<ArrayList<String>, Integer> val2 : mapItem2.entrySet()) {
    			
    			if(Collections.disjoint(val.getKey(),val2.getKey())) {
        			ArrayList<String> temp = new ArrayList<String>(val.getKey());    
        			
    				for (String item : val2.getKey()) {
						if(!val.getKey().contains(item)) {
							temp.add(item);
						}
					}
    				if( !mapContains( mapItem, temp)) {
    					int f = freqItems(temp,strData);
    					if(f>=support)
    						mapItem.put(temp,f);
    				}
    			}
			}
		}
		
		return mapItem;
	}
	
	public ArrayList<Integer> instanceItems(ArrayList<String> itemSet, ArrayList<ArrayList<String>> bd) { 

		ArrayList<Integer> intersection = new ArrayList<Integer>();
		for (int i = 0; i < bd.size(); i++) {
			if(bd.get(i).containsAll(itemSet)) {
				intersection.add(i);
			}
		}
		return intersection;
    } 

	public ArrayList<Integer> intersectionInt(ArrayList<Integer> one, ArrayList<Integer> two){	
		ArrayList<Integer> disjunction = new ArrayList<Integer>();
		for (Integer string : two) {
			if(one.contains(string))
				disjunction.add(string);
		}
		return disjunction;
	}
	
	public ArrayList<String> intersection(ArrayList<String> one, ArrayList<String> two){	
		ArrayList<String> disjunction = new ArrayList<String>();
		for (String string : two) {
			if(one.contains(string))
				disjunction.add(string);
		}
		return disjunction;
	}
	

	
	public ArrayList<Association> associationMap(Map<ArrayList<String>, Integer> mapItem,Map<ArrayList<String>, Integer> mapItem2) {

		ArrayList<Association> associations = new ArrayList<Association>();
		for (Entry<ArrayList<String>, Integer> val : mapItem.entrySet()) {
        	for (Entry<ArrayList<String>, Integer> val2 : mapItem2.entrySet()) {
        		if(val2.getKey().containsAll(val.getKey())) {
					associations.add(new Association( val.getKey(),val2.getKey(), val.getValue(), val2.getValue()));

        		}
        	}
		}
	return associations;
	}
	


	public boolean mapContains(Map<ArrayList<String>, ?> mapItem, ArrayList<String> list) {
		
		for (Entry<ArrayList<String>, ?> val: mapItem.entrySet()) {
			if(val.getKey().containsAll(list)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static int freqItems(ArrayList<String> itemSet, ArrayList<ArrayList<String>> bd) { 
		int count=0;

		for (ArrayList<String> line : bd) {
			if(line.containsAll(itemSet)) {
				count++;
			}
		}
		
		return count;
    } 

	
	

	
	public ArrayList<Double> getAttribute(ArrayList<ArrayList<Double>> data, int index){
		ArrayList<Double> col = new ArrayList<Double>() ;
		for (ArrayList<Double> att : data) {
			col.add((double) att.get(index));
		}
		return col;
	}
	public ArrayList<String> getAttribute(ArrayList<ArrayList<Double>> data, int index, String prefix){
		ArrayList<String> col = new ArrayList<String>() ;
		for (ArrayList<Double> att : data) {
			col.add( prefix+att.get(index).toString());
		}
		return col;
	}	
	

	public Cluster kmedoids(int k, int error, ArrayList<ArrayList<Double>> data) {
		// TODO:
		// normalized dataset between 0 - 1
		ArrayList<ArrayList<Double>> set = new ArrayList<ArrayList<Double>>(normalized(data));
			
		// if you want classic kmedoids, just set a High minError, it won't lookup maxIter either
		
//		for (ArrayList<Integer> cluster : clustering(k,0,set)) {
//			System.out.println(cluster);
//		}
		
		Cluster cl  = new Cluster();
		cl = clustering(k,0,10,error,set);
		return cl; //first;
	}
	
	public Cluster clustering(int k, int subsets, int maxIter, double minError, ArrayList<ArrayList<Double>> set) {
		//TODO: will get the function of clustering for k an clarans
		// choose k from a set (0 for kmedoids, subset for clarans)
		double error= set.size();
		double previousError = set.size()*set.get(0).size();	
		ArrayList<ArrayList<Integer>> oldClusters = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> indexes = new ArrayList<Integer>();	
		ArrayList<Integer> medoids = new ArrayList<Integer>();

		
		for (int i = 0; i < set.size(); i++) {
			indexes.add(i); // list to choose from
		}
		for (int i = 0; i < k; i++) {
			int rand = new Random().nextInt(indexes.size());
			ArrayList<Integer> cluster = new ArrayList<Integer>();
			medoids.add(indexes.get(rand));
			oldClusters.add(cluster); // adds empty cluster
			indexes.remove(rand);
		}
		
		int x = 0;
		ArrayList<ArrayList<Integer>> clusters = null;
		ArrayList<Integer> prevMeds = new ArrayList<Integer>();
		while(error<=previousError ||  error>minError && x<maxIter) {	

			clusters = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < k; i++) {
				ArrayList<Integer> cluster = new ArrayList<Integer>();
				clusters.add(cluster); // adds empty cluster
			}
			
			double totalDistance = 0;
			int best = 0; // first best is the first			
			for (int instance = 0; instance < set.size(); instance++) {
				for (int medoid = 0; medoid < medoids.size(); medoid++)  {	
					if(euclideanDistance(set.get(instance), set.get(medoids.get(best)))
						>euclideanDistance(set.get(instance), set.get(medoids.get(medoid)))) {	
						best = medoid;
					}
				}
				
				totalDistance += euclideanDistance(set.get(instance), set.get(medoids.get(best)));
				clusters.get(best).add(instance);
				// scatter plot to visualise, do some to make x,y to be chosen
			}
			
			
			int replacing = new Random().nextInt(k);
			int previousM = medoids.get(replacing);
			int newM = new Random().nextInt(indexes.size());
			medoids.set(replacing, indexes.get(newM));
			indexes.add(previousM);
			indexes.remove(newM);
			error = totalDistance;
			if(error<=previousError) {				
//				System.out.print("\n"+ (++x) +":  "+error+" vs "+previousError+"\nMedoids: ");
//				for (Integer m : medoids) {
//					System.out.print(m+", ");	
//				}
//				System.out.println();	
				previousError = error;
				error = 0;
				oldClusters = cloneArrayInt(clusters);
				prevMeds = cloneArrayOne(medoids);
			}else {
				// System.out.print(".");
				
//				System.out.print("\n~"+ (x+1) +":  "+error+" vs "+previousError+"\nworse Medoids: ");
//				for (Integer m : medoids) {
//					System.out.print(m+", ");	
//				} System.out.println();
				
//				medoids.set(replacing, previousM);
//				indexes.remove(indexes.indexOf(previousM));
//				indexes.add(newM);
				medoids = prevMeds;
				clusters = oldClusters;
			//	break;
			}
		}
		
		
//		System.out.println("Best, cost:  "+previousError+ " last refused "+error);
//		System.out.print("Medoids: ");
//		for (Integer m : medoids) {
//			System.out.print(m+", ");	
//		}
//		System.out.println();	

		for (ArrayList<Integer> cluster : clusters) {
			System.out.println("Size:"+cluster.size()+"\t:"+cluster);	
		}

		Cluster clusterSet = new Cluster();
		clusterSet.setError(previousError);
		clusterSet.setClusters(clusters);
		clusterSet.setMedoids(medoids);
		
		return clusterSet;
	}
	
	
	public ArrayList<ArrayList<Integer>> setClusters(){
		return new ArrayList<ArrayList<Integer>>();
	}
	
	
	public double euclideanDistance(ArrayList<Double> instance1, ArrayList<Double> instance2) {
		double sum = 0;
		for (int i = 0; i < instance1.size(); i++) {
			double dx = instance1.get(i)-instance2.get(i);	
			sum += dx*dx;
		}
		return Math.sqrt(sum);
	}	
	
	
	public Cluster clarans(int k, int subSetsNumber,int maxIter,ArrayList<ArrayList<Double>> data) {
		// TODO: max Iter
		ArrayList<ArrayList<Double>> set = new ArrayList<ArrayList<Double>>(normalized(data));

		ArrayList<ArrayList<Integer>> bestCluster = new ArrayList<ArrayList<Integer>>();
		Cluster chosenClusterSet = new Cluster();	
		
		double lastBestError = 1000;
		
		int bestGlobalError = 1000;
		int bestOne = 0;
		
		for (int iter = 0; iter < maxIter; iter++) {

		ArrayList<Cluster> clusterSets = new ArrayList<Cluster>();	
		
		ArrayList<Integer> indexes = new ArrayList<Integer>();	
		ArrayList<ArrayList<Integer>> subSets = new ArrayList<ArrayList<Integer>>();	
		ArrayList<ArrayList<ArrayList<Double>>> dataSubSets = new ArrayList<ArrayList<ArrayList<Double>>>();	
		ArrayList<ArrayList<Integer>> subSetsMedoids = new ArrayList<ArrayList<Integer>>();	
		ArrayList<ArrayList<Integer>> subSetError = new ArrayList<ArrayList<Integer>>();	

		for (int i = 0; i < set.size(); i++) {
			indexes.add(i); // list to choose from
		}
		
		for (int i = 0; i < subSetsNumber-1; i++) {
			ArrayList<Integer> sub = new ArrayList<Integer>();
			for (int j = 0; j < set.size()/subSetsNumber; j++) {
				int rand = new Random().nextInt(indexes.size());
				sub.add(indexes.get(rand));
				indexes.remove(rand);
			}
			subSets.add(sub);
		}
		
		// adding the last subset (gets the rest)
		ArrayList<Integer> sub = new ArrayList<Integer>();
		while(!indexes.isEmpty()) {
			int rand = new Random().nextInt(indexes.size());
			sub.add(indexes.get(rand));
			indexes.remove(rand);
		}			
		subSets.add(sub);
		
		
		for (ArrayList<Integer> subS : subSets) {
			ArrayList<ArrayList<Double>> dataSub = new ArrayList<ArrayList<Double>>();
			for (Integer instance : subS) {
				dataSub.add(set.get(instance));
			}
			dataSubSets.add(dataSub);
		}

		for (ArrayList<ArrayList<Double>> dataSub : dataSubSets) {
			Cluster c = new Cluster();
			System.out.println("size-----------" + dataSub.size());
			c = clustering(k,subSetsNumber,maxIter,1000,dataSub);
			clusterSets.add(c);
		}

		
		
		// error for all
		double bestError = 10000;

		int best = 0;
		int previousError = 10000;
		int bestSubSet = 0;
		ArrayList<Integer> bestMedoids = new ArrayList<Integer>();
		ArrayList<ArrayList<ArrayList<Integer>>> bestGlobalClusters = new ArrayList<ArrayList<ArrayList<Integer>>>();
		
		for (Cluster cluster : clusterSets) {
			bestGlobalClusters.add(new ArrayList<ArrayList<Integer>>());
		}
		
		
		for (int i = 0; i< clusterSets.size();i++) {
			for (Integer m : clusterSets.get(bestSubSet).getMedoids()) {
				bestGlobalClusters.get(i).add(new ArrayList<Integer>());
			}
			

				double totalDistance = 0;
				for (int instance = 0; instance < set.size(); instance++) {
					
					for (int medoid= 0 ; medoid<clusterSets.get(i).getMedoids().size(); medoid++) {
						if(euclideanDistance(set.get(instance), set.get(clusterSets.get(i).getMedoids().get(best)))
								>euclideanDistance(set.get(instance), set.get(clusterSets.get(i).getMedoids().get(medoid)))) {	
								best = medoid;
							}
	
					}
					totalDistance += euclideanDistance(set.get(instance), set.get(clusterSets.get(i).getMedoids().get(best)));					
					bestGlobalClusters.get(i).get(best).add(instance);
					
					// scatter plot to visualise, do some to make x,y to be chosen
				}
				if(totalDistance<bestError) {
					bestSubSet = i;
					bestError = totalDistance;
					bestOne = i;
					lastBestError = bestError;
				}		
		
		}
				
		System.out.println("Best Chosen Medoids "+ clusterSets.get(bestSubSet).getMedoids()+ " error: "+bestError);
		//return bestGlobalClusters.get(bestSubSet); //first;
		
		if(bestError<bestGlobalError) {
			bestCluster = cloneArrayInt(bestGlobalClusters.get(bestSubSet));
			bestError = bestGlobalError;
			chosenClusterSet = new Cluster(bestGlobalClusters.get(bestSubSet), clusterSets.get(bestSubSet).getMedoids(), lastBestError);
			
		}
		
	}
		

		return chosenClusterSet;
	
	
	
	}
	

	
	public ArrayList<ArrayList<Double>> normalized(ArrayList<ArrayList<Double>> data) {
		ArrayList<ArrayList<Double>> normal = new ArrayList<ArrayList<Double>>();

		
		ArrayList<ArrayList<Double>> rows = new ArrayList<ArrayList<Double>>();
		rows = transpose(data);
		
		for (ArrayList<Double> line : data) {
			ArrayList<Double> instance = new  ArrayList<Double>();

			
//			// original normalizing			
//			for (int i = 0; i < line.size()-1; i++) {
//				Double min = new Double(Data.min(rows.get(i)));
//				Double max = new Double(Data.max(rows.get(i)));
//				instance.add(( (line.get(i) - min)/(max-min) ));
//			}
			
			// to not get sex in distance
			Double min = new Double(Data.min(rows.get(0)));
			Double max = new Double(Data.max(rows.get(0)));
			instance.add(( (line.get(0) - min)/(max-min) ));
			instance.add(0.0);
			for (int i = 2; i < line.size()-1; i++) {
				min = new Double(Data.min(rows.get(i)));
				max = new Double(Data.max(rows.get(i)));
				instance.add(( (line.get(i) - min)/(max-min) ));
		//		instance.add(line.get(i) );
			}
			normal.add(instance);
		}
		
//		int j = 0;
//		for (ArrayList<Double> arrayList : normal) {
//			System.out.print(++j+" "+arrayList.size()+" ");
//			System.out.println(arrayList);			
//		}
		
		return normal;
	}

	
    public static ArrayList<ArrayList<String>> transposeStr(ArrayList<ArrayList<String>> matrixIn) {
    ArrayList<ArrayList<String>> matrixOut = new ArrayList<ArrayList<String>>();
    if (!matrixIn.isEmpty()) {
        int noOfElementsInList = matrixIn.get(0).size();
        for (int i = 0; i < noOfElementsInList; i++) {
            ArrayList<String> col = new ArrayList<String>();
            for (ArrayList<String> row : matrixIn) {
                col.add(row.get(i));
            }
            matrixOut.add(col);
        }
    }

    return matrixOut;
}

    public static ArrayList<ArrayList<Double>> transpose(ArrayList<ArrayList<Double>> matrixIn) {
    ArrayList<ArrayList<Double>> matrixOut = new ArrayList<ArrayList<Double>>();
    if (!matrixIn.isEmpty()) {
        int noOfElementsInList = matrixIn.get(0).size();
        for (int i = 0; i < noOfElementsInList; i++) {
            ArrayList<Double> col = new ArrayList<Double>();
            for (ArrayList<Double> row : matrixIn) {
                col.add(row.get(i));
            }
            matrixOut.add(col);
        }
    }

    return matrixOut;
}
	
	public ArrayList<ArrayList<Double>> cleanData(ArrayList<ArrayList<Double>> originalData) {
		
		ArrayList<ArrayList<Double>> data = new ArrayList<ArrayList<Double>>(originalData);
		ArrayList<ArrayList<Double>> clean = new ArrayList<ArrayList<Double>>();
		
		ArrayList<Double> age = new ArrayList<Double>() ;
		ArrayList<Double> bloodPressure = new ArrayList<Double>() ;
		ArrayList<Double> cholestoral = new ArrayList<Double>() ;
		ArrayList<Double> maxHR = new ArrayList<Double>() ;

		for (ArrayList<Double> att : data) {
			age.add((double) att.get(0));
		}
		for (ArrayList<Double> att : data) {
			bloodPressure.add((double) att.get(3));
		}
		for (ArrayList<Double> att : data) {
			cholestoral.add((double) att.get(4));
		}
		for (ArrayList<Double> att : data) {
			maxHR.add((double) att.get(7));
		}
		// these declarations are for optimization
		double uAge = Data.uLimit(age);
		double lAge = Data.lLimit(age);
		double uBp = Data.uLimit(bloodPressure);
		double lBp = Data.lLimit(bloodPressure);
		double uHr = Data.uLimit(maxHR);
		double lHr = Data.lLimit(maxHR);
		double uChs = Data.uLimit(cholestoral);
		double lChs = Data.lLimit(cholestoral);

		for (ArrayList<Double> line : data) {
			if((line.get(0)>uAge||line.get(0)<lAge)
				|| (line.get(3)>uBp||line.get(3)<lBp)
				|| (line.get(4)>uChs||line.get(4)<lChs)
				|| (line.get(7)>uHr||line.get(7)<lHr) ) {
			}else {
				clean.add(line);
			}
		}

		return clean;
	}

	public void createItemsets(ArrayList<ArrayList<String>> itemSet1, ArrayList<ArrayList<String>> bd) {
		
	}
	
	
	
	public ArrayList<ArrayList<String>> stringify(ArrayList<ArrayList<Double>> bd) {
		// get the binned data
		// make it a string of only those 4
		// 0 3 4 7
		ArrayList<ArrayList<String>> strDB = new ArrayList<ArrayList<String>>();

		for (ArrayList<Double> arrayList : bd) {
			ArrayList<String> strLine = new ArrayList<String>();
			strLine.add("age_"+arrayList.get(0));
			strLine.add("blood_pressure_"+arrayList.get(3));
			strLine.add("cholestoral_"+arrayList.get(4));
			strLine.add("max_hr_"+arrayList.get(7));
		strDB.add(strLine);
		}
	
		return strDB;
	}
	
	
	
	public static int freqItems(double[] itemSet, ArrayList<ArrayList<Double>> bd) { 
		int count=0;
		int[] position  = new int[4];
		boolean all = false;
		

		position[0] = 0;
		position[1] = 3;
		position[2] = 4;
		position[3] = 7;

		for (ArrayList<Double> line: bd) {
    		all = false;
    		for (int j = 0; j < itemSet.length; j++) {

    			if(itemSet[j]!=-1) {
	            	if(line.get(position[j]) == itemSet[j]) {
	            		all = true;
	            	}else {
	            		all = false;
	            		break;
	            	}
    			}
        	}
        	if(all) {
        		count++;
        	}
        	
        }

		return count;
    } 

	public static Map<String,Integer> countFrequenciesStr(ArrayList<String> column) { 
        // hashmap to store the frequency of element 
        Map<String, Integer> hm = new HashMap<String, Integer>(); 
  
        for (String i : column) { 
            Integer j = hm.get(i); 
            hm.put(i, (j == null) ? 1 : j + 1);
        } 
        return hm;
    } 
	
	
	public static Map<Double,Integer> countFrequencies(ArrayList<Double> column) { 
        // hashmap to store the frequency of element 
        Map<Double, Integer> hm = new HashMap<Double, Integer>(); 
  
        for (Double i : column) { 
            Integer j = hm.get(i); 
            hm.put(i, (j == null) ? 1 : j + 1);
        } 
        return hm;
    } 
	
	public static void displayFrequencies(ArrayList<Double> list) { 
        // hashmap to store the frequency of element 
        HashMap<String, Integer> hm = new HashMap<String, Integer>(); 
  
        for (Double i : list) { 
            Integer j = hm.get(""+i); 
            hm.put(""+i, (j == null) ? 1 : j + 1); 
        } 
  
        // displaying the occurrence of elements in the arraylist 
        for (Map.Entry<String, Integer> val : hm.entrySet()) { 
            System.out.println("Element " + val.getKey() + " "
                               + "occurs"
                               + ": " + val.getValue() + " times"); 
        } 
    } 
	

	
	
	public void Histograms() {
		
		suppConf.setDisable(true);
		suppConf.setOpacity(0);
		
		kmedHbox.setDisable(true);
		kmedHbox.setOpacity(0);
		
		clarHbox.setDisable(true);
		clarHbox.setOpacity(0);
		
		//this.data = this.binnedData();	
//		this.binnedData();
		

//		System.out.println(data.size());
//		normalized(data);

		//User select at least one file
		if(this.file == null ) {
			//No Data selected
			FileAlert("ERROR", "NO DATA FOUND", false);	
		} else {
				GUI ui = new GUI();
				//	ui.lineChart(list, scrollPaneLineChartGenetic);
				XYgroup.setDisable(false);
				XYgroup.setOpacity(1);
				mmm.setDisable(true);
				scrollPaneTable.setDisable(false);
				OpacitySetting(1,0);
				OpacitySetting(0,1);
				OpacitySetting(2,1);
				boxplotAttributes.setDisable(true);
				boxplotAttributes.setOpacity(0);
				summary.setDisable(true);
				summary.setOpacity(0);
				HistGroup.setDisable(false);
				HistGroup.setOpacity(1);
				XYgroup.setDisable(true);
				XYgroup.setOpacity(0);
				ArrayList<String> attributes = new ArrayList<String>();
				attributes.addAll(Arrays.asList("Age","Sex","Chest Pain","Blood P.","cholestoral","Sugar>120mg","ECG","max HR","e.i.angina","old Peak","slope ST","Vessels","Thal","Disease"));	
				
				// converting it to columns of values
				// yes I know this is bad programming
				// should've created a class for the data.
				// might do it for part two
				// I just wanted to try stuff
				// we worry about optimization later
				
				ArrayList<ArrayList<Double>> dataColumns = new ArrayList<ArrayList<Double>>();
				for (int i = 0; i < attributes.size(); i++) {
					ArrayList<Double> column = new ArrayList<Double>();
					for (ArrayList<Double> obj : data) {
						column.add((Double) obj.get(i));
					}
					dataColumns.add(column);
				}
				
				ArrayList<Map<Double, Integer>> map = new ArrayList<Map<Double, Integer>>();
				for (ArrayList<Double> column : dataColumns) {
					Map<Double, Integer> m = new HashMap<Double, Integer>();
					m = countFrequencies(column);
					map.add(m);
				}
				
				//displayFrequencies(dataColumns.get(0));
			    int x = (int) comboHist.getSelectionModel().getSelectedIndex();
				ui.HistogramChart(x, attributes, map.get(x), scrollPaneTable);
		    	//ui.BadHistogramChart(x, attributes, data, scrollPaneTable);

				comboHist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
				{
				    public void changed(ObservableValue<? extends String> ov,
				            final String oldvalue, final String newvalue)
				    {
				    	int x = (int) comboHist.getSelectionModel().getSelectedIndex();
						ui.HistogramChart(x, attributes, map.get(x), scrollPaneTable);
				    	//ui.BadHistogramChart(x, attributes, data, scrollPaneTable);
		        }});				
		}
		
	}	

	public void ScatterClusters() {
		kmedHbox.setDisable(true);
		kmedHbox.setOpacity(0);
		
		
		clarHbox.setDisable(true);
		clarHbox.setOpacity(0);
		
		suppConf.setDisable(true);
		suppConf.setOpacity(0);
		//User select at least one file
		if(this.file == null ) {
			//No Data selected
			FileAlert("ERROR", "NO DATA FOUND", false);	
		} else {
			GUI ui = new GUI();
			XYgroup.setDisable(false);
			XYgroup.setOpacity(1);
			mmm.setDisable(true);
			scrollPaneTable.setDisable(false);
			OpacitySetting(1,0);
			OpacitySetting(0,1);
			boxplotAttributes.setDisable(true);
			boxplotAttributes.setOpacity(0);
			summary.setDisable(true);
			summary.setOpacity(0);
			HistGroup.setDisable(true);
			HistGroup.setOpacity(0);
			
			clarHbox.setDisable(true);
			clarHbox.setOpacity(0);
			
			ArrayList<String> attributes = new ArrayList<String>();
			attributes.addAll(Arrays.asList("Age","Sex","Chest Pain","Blood P.","cholestoral","Sugar>120mg","ECG","max HR","e.i.angina","old Peak","slope ST","Vessels","Thal","Disease"));	

		    
			int y = (int) comboX.getSelectionModel().getSelectedIndex();
			int x = (int) comboY.getSelectionModel().getSelectedIndex();
			
			// get clusters, then for each of data. add series 
			// it's either here or GUI

			//__________________________________

			ArrayList<ArrayList<ArrayList<Double>>> clustersData = new ArrayList<ArrayList<ArrayList<Double>>>(); 
			
			for (ArrayList<Integer> clusters : clarans(new Random().nextInt(10)+3,new Random().nextInt(20)+3,10,data).getClusters()) {
				ArrayList<ArrayList<Double>> currentData = new ArrayList<ArrayList<Double>>(); 
				for (Integer instance : clusters) {
					currentData.add(data.get(instance));
					}
				clustersData.add(currentData);
			}		
			
			ui.ScatterChartClusters(y,x,attributes,clustersData, data, scrollPaneTable);
			//__________________________________
					    
			comboX.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
			{
			    public void changed(ObservableValue<? extends String> ov,
			            final String oldvalue, final String newvalue)
			    {
			    	int y = (int) comboX.getSelectionModel().getSelectedIndex();
			    	int x = (int) comboY.getSelectionModel().getSelectedIndex();
			    	ui.ScatterChartClusters(y,x,attributes,clustersData, data, scrollPaneTable);
	        }});
			comboY.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
			{
			    public void changed(ObservableValue<? extends String> ov,
			            final String oldvalue, final String newvalue)
			    {
			    	int x = (int) comboX.getSelectionModel().getSelectedIndex();
			    	int y = (int) comboY.getSelectionModel().getSelectedIndex();
			    	ui.ScatterChartClusters(y,x,attributes,clustersData, data, scrollPaneTable);
	        }});	

		}
	}
	
	
	public void Scatter() {
		kmedHbox.setDisable(true);
		kmedHbox.setOpacity(0);
		
		clarHbox.setDisable(true);
		clarHbox.setOpacity(0);
		//User select at least one file
		if(this.file == null ) {
			//No Data selected
			FileAlert("ERROR", "NO DATA FOUND", false);	
		} else {
			GUI ui = new GUI();
			XYgroup.setDisable(false);
			XYgroup.setOpacity(1);
			mmm.setDisable(true);
			scrollPaneTable.setDisable(false);
			OpacitySetting(1,0);
			OpacitySetting(0,1);
			boxplotAttributes.setDisable(true);
			boxplotAttributes.setOpacity(0);
			summary.setDisable(true);
			summary.setOpacity(0);
			HistGroup.setDisable(true);
			HistGroup.setOpacity(0);
			
			suppConf.setDisable(true);
			suppConf.setOpacity(0);
			ArrayList<String> attributes = new ArrayList<String>();
			attributes.addAll(Arrays.asList("Age","Sex","Chest Pain","Blood P.","cholestoral","Sugar>120mg","ECG","max HR","e.i.angina","old Peak","slope ST","Vessels","Thal","Disease"));	

		    
			int x = (int) comboX.getSelectionModel().getSelectedIndex();
			int y = (int) comboY.getSelectionModel().getSelectedIndex();
			ui.ScatterChart(x,y,attributes, data, scrollPaneTable);

			
			comboX.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
			{
			    public void changed(ObservableValue<? extends String> ov,
			            final String oldvalue, final String newvalue)
			    {
			    	int x = (int) comboX.getSelectionModel().getSelectedIndex();
			    	int y = (int) comboY.getSelectionModel().getSelectedIndex();

					ui.ScatterChart(x,y, attributes, data, scrollPaneTable);
	        }});
			comboY.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
			{
			    public void changed(ObservableValue<? extends String> ov,
			            final String oldvalue, final String newvalue)
			    {
			    	int x = (int) comboX.getSelectionModel().getSelectedIndex();
			    	int y = (int) comboY.getSelectionModel().getSelectedIndex();

					ui.ScatterChart(x,y, attributes, data, scrollPaneTable);
	        }});	

		}
	}
	
	public void WhiskerBox() {
		
		GUI ui = new GUI();
		XYgroup.setDisable(true);
		XYgroup.setOpacity(0);
		mmm.setDisable(true);
		scrollPaneTable.setDisable(true);
		scrollPaneTable.setOpacity(0);
		OpacitySetting(1,0);
		OpacitySetting(0,0);
		boxplotAttributes.setDisable(false);
		boxplotAttributes.setOpacity(1);
		summary.setDisable(true);
		summary.setOpacity(0);
		HistGroup.setDisable(true);
		HistGroup.setOpacity(0);
		
		
		clarHbox.setDisable(true);
		clarHbox.setOpacity(0);
		
		suppConf.setDisable(true);
		suppConf.setOpacity(0);
		
		
		kmedHbox.setDisable(true);
		kmedHbox.setOpacity(0);
		
		ArrayList<String> attributes = new ArrayList<String>();
		boxplotAttributes.getChildren().clear();
		attributes.addAll(Arrays.asList("Age","Sex","Chest Pain","Blood P.","cholestoral","Sugar>120mg","ECG","max HR","e.i.angina","old Peak","slope ST","Vessels","Thal","Disease"));	
		
		ui.boxPlot(attributes, data, scrollPaneTable, boxplotAttributes);
		
	}
	
	
	public void aprioriUI() {
		//User select at least one file
		if(this.file == null ) {
			//No Data selected
			FileAlert("ERROR", "NO DATA FOUND", false);	
		} else {
			GUI ui = new GUI();
			XYgroup.setDisable(true);
			XYgroup.setOpacity(0);
			mmm.setDisable(true);
			scrollPaneTable.setDisable(false);
			OpacitySetting(1,0);
			OpacitySetting(0,1);
			boxplotAttributes.setDisable(true);
			boxplotAttributes.setOpacity(0);
			summary.setDisable(true);
			summary.setOpacity(0);
			HistGroup.setDisable(true);
			HistGroup.setOpacity(0);
			
			suppConf.setDisable(false);
			suppConf.setOpacity(1);

			
			confLabel.setDisable(false);
			confLabel.setOpacity(1);		
			
			conf.setDisable(false);
			conf.setOpacity(1);
			
			
			clarHbox.setDisable(true);
			clarHbox.setOpacity(0);
			
			kmedHbox.setDisable(true);
			kmedHbox.setOpacity(0);
			
			int s = supp.getSelectionModel().getSelectedItem();
			int c = conf.getSelectionModel().getSelectedItem();
			
		
			
			
			double timeStart = System.currentTimeMillis();
						
			aprioriData = stringify(binnedData(cloneArray(data)));
			
			ArrayList<Map<ArrayList<String>, Integer>> Items = new ArrayList<Map<ArrayList<String>, Integer>>();
			Items = apriori(s,c, aprioriData);
			
			double executionTime = System.currentTimeMillis()- timeStart;
			summary.setText("A-Priori: "+ executionTime+"ms");
			
			
			
			
			

			
			// from 0 - 5 : Associations 11 12 13 21 22 31
			

			
			
			summary.setDisable(false);
			summary.setOpacity(1);
			
				ArrayList<ArrayList<Association>> ar = new ArrayList<ArrayList<Association>>(); 
			
			
			ar.add(associationMap(Items.get(0),Items.get(1)));
			ar.add(associationMap(Items.get(0),Items.get(2)));
			ar.add(associationMap(Items.get(0),Items.get(3)));
			ar.add(associationMap(Items.get(1),Items.get(2)));
			ar.add(associationMap(Items.get(1),Items.get(3)));
			ar.add(associationMap(Items.get(2),Items.get(3)));

			ui.apriori(4,scrollPaneTable, Items,ar,c,1);

			
			
			conf.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>()
			{

				public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
					double timeStart = System.currentTimeMillis();
					int s = supp.getSelectionModel().getSelectedItem();
					int c = conf.getSelectionModel().getSelectedItem();
					
					ui.apriori(4,scrollPaneTable, apriori(s,c, aprioriData),ar,c,1);

					double executionTime = System.currentTimeMillis()- timeStart;
					summary.setText("A-Priori: "+ executionTime+"ms");
										
				}});
			
			supp.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>()
			{
				
				public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
					double timeStart = System.currentTimeMillis();
					int s = supp.getSelectionModel().getSelectedItem();
					int c = conf.getSelectionModel().getSelectedItem();
					
					ui.apriori(4,scrollPaneTable, apriori(s,c, aprioriData),ar,c,1);

					double executionTime = System.currentTimeMillis()- timeStart;
					summary.setText("A-Priori: "+ executionTime+"ms");
										
				}});

		}
	}
		
	public void eclatUI() {
		//User select at least one file
		if(this.file == null ) {
			//No Data selected
			FileAlert("ERROR", "NO DATA FOUND", false);	
		} else {
			GUI ui = new GUI();
			XYgroup.setDisable(true);
			XYgroup.setOpacity(0);
			mmm.setDisable(true);
			scrollPaneTable.setDisable(false);
			OpacitySetting(1,0);
			OpacitySetting(0,1);
			boxplotAttributes.setDisable(true);
			boxplotAttributes.setOpacity(0);
			summary.setDisable(true);
			summary.setOpacity(0);
			HistGroup.setDisable(true);
			HistGroup.setOpacity(0);
			
			suppConf.setDisable(false);
			suppConf.setOpacity(1);
			
			conf.setDisable(true);
			conf.setOpacity(0);			
			confLabel.setDisable(true);
			confLabel.setOpacity(0);
			
			kmedHbox.setDisable(true);
			kmedHbox.setOpacity(0);
			
			clarHbox.setDisable(true);
			clarHbox.setOpacity(0);
			
			int s = supp.getSelectionModel().getSelectedItem();
			int c = conf.getSelectionModel().getSelectedItem();
			
			aprioriData = stringify(binnedData(cloneArray(data)));
			
			double timeStart = System.currentTimeMillis();
	
			ui.eclat(4,scrollPaneTable, eclat(s,c, aprioriData));
			
			double executionTime = System.currentTimeMillis()- timeStart;
			
			summary.setText("ECLAT: "+ executionTime+"ms");
			summary.setDisable(false);
			summary.setOpacity(1);

			
			supp.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>()
			{
				
				public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
					double timeStart = System.currentTimeMillis();
					int s = supp.getSelectionModel().getSelectedItem();
					int c = conf.getSelectionModel().getSelectedItem();
					
					
					ui.eclat(4,scrollPaneTable, eclat(s,c, aprioriData));

					double executionTime = System.currentTimeMillis()- timeStart;
					summary.setText("ECLAT: "+ executionTime+"ms");
										
				}});
			
			
			// from 0 - 5 : Associations 11 12 13 21 22 31
			


		}
	}
	
	
	public void kmedoidUI() {
		GUI ui = new GUI();
		XYgroup.setDisable(true);
		XYgroup.setOpacity(0);
		mmm.setDisable(true);
		scrollPaneTable.setDisable(false);
		OpacitySetting(1,0);
		OpacitySetting(0,1);
		boxplotAttributes.setDisable(true);
		boxplotAttributes.setOpacity(0);
		summary.setDisable(true);
		summary.setOpacity(0);
		HistGroup.setDisable(true);
		HistGroup.setOpacity(0);
		
		suppConf.setDisable(true);
		suppConf.setOpacity(0);
		
		kmedHbox.setDisable(false);
		kmedHbox.setOpacity(1);
		
		clarHbox.setDisable(true);
		clarHbox.setOpacity(0);
		int k= 3;
		k = kmed.getSelectionModel().getSelectedItem();
		int err = 3000;
		err = kerror.getSelectionModel().getSelectedItem();
		
		double timeStart = System.currentTimeMillis();
		ui.kmedoid(0,scrollPaneTable, kmedoids(k,err, data), data);
		double executionTime = System.currentTimeMillis()- timeStart;
		
		summary.setText("K-medoids: "+ executionTime+"ms");
		summary.setDisable(false);
		summary.setOpacity(1);

		

		kmed.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>()
		{
			
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				int k = kmed.getSelectionModel().getSelectedItem();
				int err = kerror.getSelectionModel().getSelectedItem();
				System.out.println("\n\n"+k);
				double timeStart = System.currentTimeMillis();
				ui.kmedoid(0,scrollPaneTable, kmedoids(k, err, data), data);
				double executionTime = System.currentTimeMillis()- timeStart;
				
				summary.setText("K-medoids: "+ executionTime+"ms");
									
			}});
		
		kerror.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>()
		{
			
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				int k = kmed.getSelectionModel().getSelectedItem();
				int err = kerror.getSelectionModel().getSelectedItem();
				System.out.println("\n\n"+k);
				double timeStart = System.currentTimeMillis();
				ui.kmedoid(0,scrollPaneTable, kmedoids(k, err, data), data);
				double executionTime = System.currentTimeMillis()- timeStart;
				
				summary.setText("K-medoids: "+ executionTime+"ms");
									
			}});
		
		
		// from 0 - 5 : Associations 11 12 13 21 22 31
		
		
	}
	
	public void claransUI() {
		int k = 3;
		int i = 10;
		int s = 5;
		
		
		kmedHbox.setDisable(true);
		kmedHbox.setOpacity(0);
		
		clarHbox.setDisable(false);
		clarHbox.setOpacity(1);
		GUI ui = new GUI();
		XYgroup.setDisable(true);
		XYgroup.setOpacity(0);
		mmm.setDisable(true);
		scrollPaneTable.setDisable(false);
		OpacitySetting(1,0);
		OpacitySetting(0,1);
		boxplotAttributes.setDisable(true);
		boxplotAttributes.setOpacity(0);
		summary.setDisable(true);
		summary.setOpacity(0);
		HistGroup.setDisable(true);
		HistGroup.setOpacity(0);

		
		suppConf.setDisable(true);
		suppConf.setOpacity(0);
		
		
		k = kclar.getSelectionModel().getSelectedItem();
		i = maxiter.getSelectionModel().getSelectedItem();
		s = maxpart.getSelectionModel().getSelectedItem();

		
		
		double timeStart = System.currentTimeMillis();
		ui.clarans(0, scrollPaneTable, clarans(k, s, i,data), data);
		double executionTime = System.currentTimeMillis()- timeStart;
		
		summary.setText("CLARANS: "+ executionTime+"ms");
		summary.setDisable(false);
		summary.setOpacity(1);


		kclar.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>()
		{
			
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				int k = kclar.getSelectionModel().getSelectedItem();
				int i = maxiter.getSelectionModel().getSelectedItem();
				int s = maxpart.getSelectionModel().getSelectedItem();

				
				double timeStart = System.currentTimeMillis();
				ui.clarans(0, scrollPaneTable, clarans(k, s, i,data), data);
				double executionTime = System.currentTimeMillis()- timeStart;
				
				summary.setText("CLARANS: "+ executionTime+"ms");
									
			}});
		
		maxiter.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>()
		{
			
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				int k = kclar.getSelectionModel().getSelectedItem();
				int i = maxiter.getSelectionModel().getSelectedItem();
				int s = maxpart.getSelectionModel().getSelectedItem();

				
				
				double timeStart = System.currentTimeMillis();
				ui.clarans(0, scrollPaneTable, clarans(k, s, i,data), data);
				double executionTime = System.currentTimeMillis()- timeStart;
				
				summary.setText("CLARANS: "+ executionTime+"ms");
			}});
		
		maxpart.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>()
		{
			
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				
				int k = kclar.getSelectionModel().getSelectedItem();
				int i = maxiter.getSelectionModel().getSelectedItem();
				int s = maxpart.getSelectionModel().getSelectedItem();

				double timeStart = System.currentTimeMillis();
				ui.clarans(0, scrollPaneTable, clarans(k, s, i,data), data);
				double executionTime = System.currentTimeMillis()- timeStart;
				
				summary.setText("CLARANS: "+ executionTime+"ms");
									
			}});
		
		
	}

	//---------------------------------------> G E T T E R S __ S E T T E R S <----------------------------------------------
	
	public Pane getMainPanel() {
		return MainPanel;
	}

	public void setMainPanel(Pane mainPanel) {
		MainPanel = mainPanel;
	}

	public JFXTextArea getSolutionText() {
		return solutionText;
	}

	public void setSolutionText(JFXTextArea solutionText) {
		this.solutionText = solutionText;
	}

	public ScrollPane getSolutionScrollPane() {
		return solutionScrollPane;
	}

	public void setSolutionScrollPane(ScrollPane solutionScrollPane) {
		this.solutionScrollPane = solutionScrollPane;
	}
	
	
	
	
	
	
	
	
	
	
}

















