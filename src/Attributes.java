
public class Attributes {

	int age ;
	boolean sex ;
	int chestPain  ;
	double bloodPress ;
	double cholesterol ;
	boolean sugar ;
	int ecg ;
	double maxHR ;
	boolean angine ;
	double oldPeak ;
	int slopeST ;
	int vessels ;
	int thal ;
	boolean disease;
	
	public Attributes(int age, boolean sex, int chestPain, double bloodPress, double cholesterol, boolean sugar,
			int ecg, double maxHR, boolean angine, double oldPeak, int slopeST, int vessels, int thal,
			boolean disease) {
		super();
		this.age = age;
		this.sex = sex;
		this.chestPain = chestPain;
		this.bloodPress = bloodPress;
		this.cholesterol = cholesterol;
		this.sugar = sugar;
		this.ecg = ecg;
		this.maxHR = maxHR;
		this.angine = angine;
		this.oldPeak = oldPeak;
		this.slopeST = slopeST;
		this.vessels = vessels;
		this.thal = thal;
		this.disease = disease;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public int getChestPain() {
		return chestPain;
	}

	public void setChestPain(int chestPain) {
		this.chestPain = chestPain;
	}

	public double getBloodPress() {
		return bloodPress;
	}

	public void setBloodPress(double bloodPress) {
		this.bloodPress = bloodPress;
	}

	public double getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(double cholesterol) {
		this.cholesterol = cholesterol;
	}

	public boolean isSugar() {
		return sugar;
	}

	public void setSugar(boolean sugar) {
		this.sugar = sugar;
	}

	public int getEcg() {
		return ecg;
	}

	public void setEcg(int ecg) {
		this.ecg = ecg;
	}

	public double getMaxHR() {
		return maxHR;
	}

	public void setMaxHR(double maxHR) {
		this.maxHR = maxHR;
	}

	public boolean isAngine() {
		return angine;
	}

	public void setAngine(boolean angine) {
		this.angine = angine;
	}

	public double getOldPeak() {
		return oldPeak;
	}

	public void setOldPeak(double oldPeak) {
		this.oldPeak = oldPeak;
	}

	public int getSlopeST() {
		return slopeST;
	}

	public void setSlopeST(int slopeST) {
		this.slopeST = slopeST;
	}

	public int getVessels() {
		return vessels;
	}

	public void setVessels(int vessels) {
		this.vessels = vessels;
	}

	public int getThal() {
		return thal;
	}

	public void setThal(int thal) {
		this.thal = thal;
	}

	public boolean isDisease() {
		return disease;
	}

	public void setDisease(boolean disease) {
		this.disease = disease;
	}
	
	
}
