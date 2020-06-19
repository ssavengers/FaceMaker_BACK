package com.face.facemaker.model.dto;

public class Neutral_Table {
	String nickname;
	double anger;
	double contempt;
	double fear;
	double happiness;
	double neutral;
	double sadness;
	double surprise;

	public Neutral_Table() {
	}

	public Neutral_Table(String nickname, double anger, double contempt, double fear, double happiness, double neutral,
			double sadness, double surprise) {
		this.nickname = nickname;
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
		return "Anger_Table [nickname=" + nickname + ", anger=" + anger + ", contempt=" + contempt + ", fear=" + fear
				+ ", happiness=" + happiness + ", neutral=" + neutral + ", sadness=" + sadness + ", surprise="
				+ surprise + "]";
	}

}
