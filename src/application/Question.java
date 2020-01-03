package application;

import java.io.Serializable;

public class Question implements Serializable{
	private String question ;
	private String notion;
	private int isAnswered ; 
	private int type ;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Question(String question, String notion) {
		this.question = question;
		this.notion = notion;
		this.isAnswered = 0 ;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getNotion() {
		return notion;
	}
	public void setNotion(String notion) {
		this.notion = notion;
	}
	public double verifierReponse () {
		return 1.1 ;} ;
	public void afficherQuestion() {} ;
	//////////////////////////////////////////////////////////////////

	
	
	public int getIsAnswered() {
		return isAnswered;
	}
	public void setIsAnswered(int isAnswered) {
		this.isAnswered = isAnswered;
	}
	public Question copyQuestion ()  {
		Question question = new Question(this.getQuestion(),this.getNotion()) ; 
		
		question.isAnswered = this.getIsAnswered() ; 
		question.type = this.getType() ; 
		return question ; 
	}; 
	////////////////////////////////////////////////////////////////////

}