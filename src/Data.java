import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Data extends File{

	private static final long serialVersionUID = 1L;
	
	Integer[][] DataClause;
	private int NbrInstances;
	private int NbrAttributes;
	
	
	public Data(String chemin) {
		super(chemin);
	}
	
	
	
	public Integer[][] getDataClause() {
		return DataClause;
	}

	public void setDataClause(Integer[][] dataClause) {
		DataClause = dataClause;
	}
	
	
	
	public void Initialize() {
		DataClause = new Integer[NbrInstances][NbrAttributes];
		for(int i = 0; i < NbrInstances; i++) {
			for(int j = 0; j < NbrAttributes; j++) {
				DataClause[i][j] = -1;
			}
		}
	}

	public ArrayList<ArrayList<Double>> extractData() {
		// we need to set the numbers variables clauses here
		//	this.Initialize();
		
		BufferedReader reader = null;
		String line;
		Pattern pattern = Pattern.compile("[^@%].*");
		Pattern patternDescription = Pattern.compile("@(.*)");
		Matcher matcher = null;
		
		ArrayList<String[]> attributes = new ArrayList<String[]>();
		ArrayList<ArrayList<Double>> datas = new ArrayList<ArrayList<Double>>();
		Attributes at = null;
		int i = 0;
		
		try {
			reader = new BufferedReader(new FileReader(this.getAbsolutePath()));
			
			while((line = reader.readLine()) != null) {
				line = line.trim().replaceAll(" +"," ");
				matcher = pattern.matcher(line);
				if(matcher.matches()) {
					attributes.add(line.split(","));
					datas.add(convertHeartStat(line.split(",")));
					i++;
				}
			}
			this.NbrAttributes = attributes.get(0).length;
			this.NbrInstances = i;
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return datas;
	}
	
	public String getDescription() {
		
		BufferedReader reader = null;
		String line;
		Pattern pattern = Pattern.compile("@(.*)");
		String description = "";
		Matcher matcher = null;
		
		try {
			reader = new BufferedReader(new FileReader(this.getAbsolutePath()));
			
			while((line = reader.readLine()) != null) {

				matcher = pattern.matcher(line);
				if(matcher.matches()) {
					description = description + matcher.group(1)+"\n";	
				}	
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return description;
	}
	
	
	
	public static double Mean(ArrayList<Double> set) {
		double sum=0; int n=0;
		for (Double d : set) {
			sum+=d;
			n++;
		}
		return sum/n;
	}
	public static double Median(ArrayList<Double> set) {
			Collections.sort(set);
		    int middle = set.size() / 2;
		    middle = middle > 0 && middle % 2 == 0 ? middle - 1 : middle;
		    return set.get(middle);
	}

	public static double lQMedian(ArrayList<Double> set) {
		Collections.sort(set);
	    int quart = set.size() / 4;
	    quart = quart > 0 && quart % 2 == 0 ? quart - 1 : quart;
	    return set.get(quart);
}
	public static double uQMedian(ArrayList<Double> set) {
		Collections.sort(set);
	    int quart = 3*set.size() / 4;
	    quart = quart > 0 && quart % 2 == 0 ? quart - 1 : quart;
	    return set.get(quart);
}
	public static double uLimit(ArrayList<Double> set) {
		Collections.sort(set);
		double Q1 = lQMedian(set);
		double Q3 = uQMedian(set);
		
		double IQR = Q3 - Q1;
		double uLimit = Q3 + 1.5*IQR;
		return uLimit;
}
	
	public static double lLimit(ArrayList<Double> set) {
		Collections.sort(set);
		double Q1 = lQMedian(set);
		double Q3 = uQMedian(set);
		
		double IQR = Q3 - Q1;
		double lLimit = Q1 - 1.5*IQR;
		return lLimit;
}
	
	public static double min(ArrayList<Double> set) {
		Collections.sort(set);
		return set.get(0);
}	
	public static double max(ArrayList<Double> set) {
		Collections.sort(set);
		return set.get(set.size()-1);
}	
	
	
    public static double Mode(ArrayList<Double> arr)
    {
        HashMap<Double, Integer> arrayVals = new HashMap();
        int maxOccurences = 1;
        double mode =  arr.get(0);

        for(int i = 0; i<arr.size(); i++)
        {   
            double currentIndexVal = arr.get(i);
            if(arrayVals.containsKey(currentIndexVal)){
                int currentOccurencesNum = (Integer) arrayVals.get(currentIndexVal);
                currentOccurencesNum++;
                arrayVals.put(currentIndexVal, currentOccurencesNum );
                if(currentOccurencesNum >= maxOccurences)
                {
                    mode = currentIndexVal;
                    maxOccurences = currentOccurencesNum;
                }
            }
            else{
                arrayVals.put(arr.get(i), 1);
            }
        }

        return mode;
    }
   
    
	public ArrayList<Double> convertHeartStat(String[] line) {
		ArrayList<Double> dataLine = new ArrayList<Double>();
		// Age,	  Sex,	Chest pain,	BloodPress,	cholestoral, Sugar >120, ECG,	maxHR, angine, oldPeak,	slopeST, vessels,	thal   , Dis
		// float, bool,	int(1-4),	float	,	float,			bool,	(0-2),	float, bool,	float,	(1-3), 	 (0-3),		(3,6,7), bool
		double age = Integer.parseInt(line[0]);
		double sex = Integer.parseInt(line[1]);
		//String sex = 1==Integer.parseInt(line[1]) ? "female": "male";
		double chestPain  = Integer.parseInt(line[2]);
		double bloodPress = Double.parseDouble(line[3]);
		double cholesterol = Double.parseDouble(line[4]);
		double sugar = Integer.parseInt(line[5]);
		//boolean sugar = 1==Integer.parseInt(line[5]);
		double ecg = Integer.parseInt(line[6]);
		double maxHR =  Double.parseDouble(line[7]);
		double angine = Integer.parseInt(line[8]);
		//boolean angine = 1==Integer.parseInt(line[8]);
		double oldPeak = Double.parseDouble(line[9]);
		double slopeST = Integer.parseInt(line[10]);
		double vessels = Integer.parseInt(line[11]);
		double thal = Integer.parseInt(line[12]);
		double disease = line[13].equals("present") ? 1:0;
		//String disease = ""+line[13];
		//boolean disease = line[13].equals("present");
		
		dataLine.add(age);
		dataLine.add(sex);
		dataLine.add(chestPain);
		dataLine.add(bloodPress);
		dataLine.add(cholesterol);
		dataLine.add(sugar);
		dataLine.add(ecg);
		dataLine.add(maxHR);
		dataLine.add(angine);
		dataLine.add(oldPeak);
		dataLine.add(slopeST);
		dataLine.add(vessels);
		dataLine.add(thal);
		dataLine.add(disease);
		
		return dataLine;
		
	}
	

	
	
	public int getNbrInstances() {
		return NbrInstances;
	}

	public void setNbrInstances(int NbrInstances) {
		NbrInstances = NbrInstances;
	}

	public int getNbrAttributes() {
		return NbrAttributes;
	}

	public void setNbrAttributes(int NbrAttributes) {
		NbrAttributes = NbrAttributes;
	}


	
	



}
