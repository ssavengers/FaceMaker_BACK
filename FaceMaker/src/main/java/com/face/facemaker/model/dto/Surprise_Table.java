package com.face.facemaker.model.dto;

public class Surprise_Table {
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

	public Surprise_Table() {
	}
	
	public Surprise_Table(String name, String src, int stage, double anger, double contempt, double fear, double happiness,
			double neutral, double sadness, double surprise) {
		super();
		this.name = name;
		this.src = src;
		this.stage = stage;
		this.anger = anger;
		this.contempt = contempt;
		this.fear = fear;
		this.happiness = happiness;
		this.neutral = neutral;
		this.sadness = sadness;
		this.surprise = surprise;
	}



	@Override
	public String toString() {
		return "Anger_Table [name=" + name + ", src=" + src + ", stage=" + stage + ", anger=" + anger + ", contempt="
				+ contempt + ", fear=" + fear + ", happiness=" + happiness + ", neutral=" + neutral + ", sadness="
				+ sadness + ", surprise=" + surprise + "]";
	}

	
}
