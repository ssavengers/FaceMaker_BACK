package com.face.facemaker.model.dto;

public class Sadness_Table {
	String name;
	String src;
	int stage;
	double anger;
	double contempt;
	double fear;
	double happiness;
	double neutral;
	double sadness;
	double surprise;

	public Sadness_Table() {
	}
	


	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getSrc() {
		return src;
	}




	public void setSrc(String src) {
		this.src = src;
	}




	public int getStage() {
		return stage;
	}




	public void setStage(int stage) {
		this.stage = stage;
	}




	public double getAnger() {
		return anger;
	}




	public void setAnger(double anger) {
		this.anger = anger;
	}




	public double getContempt() {
		return contempt;
	}




	public void setContempt(double contempt) {
		this.contempt = contempt;
	}




	public double getFear() {
		return fear;
	}




	public void setFear(double fear) {
		this.fear = fear;
	}




	public double getHappiness() {
		return happiness;
	}




	public void setHappiness(double happiness) {
		this.happiness = happiness;
	}




	public double getNeutral() {
		return neutral;
	}




	public void setNeutral(double neutral) {
		this.neutral = neutral;
	}




	public double getSadness() {
		return sadness;
	}




	public void setSadness(double sadness) {
		this.sadness = sadness;
	}




	public double getSurprise() {
		return surprise;
	}




	public void setSurprise(double surprise) {
		this.surprise = surprise;
	}




	@Override
	public String toString() {
		return "Anger_Table [name=" + name + ", src=" + src + ", stage=" + stage + ", anger=" + anger + ", contempt="
				+ contempt + ", fear=" + fear + ", happiness=" + happiness + ", neutral=" + neutral + ", sadness="
				+ sadness + ", surprise=" + surprise + "]";
	}

	
}
