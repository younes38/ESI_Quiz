package application;

import java.io.Serializable;
import java.util.Vector;

public class Qcu extends Question implements Serializable {
	private Vector<String> propositions ;
	private int propCorrect;
	private int reponse;
	public Qcu(String notion,String question, Vector<String> propositions, int propCorrect) {
		super(question, notion);
		super.setType(2);
		this.propositions = new Vector<>(propositions);
		this.propCorrect = propCorrect;
	
	}
	
	
	
	public Qcu(String question, String notion) {
		super(question, notion);
		this.propositions = new Vector<>() ; 
		this.propCorrect = 0 ; 
	}



	public Vector<String> getPropositions() {
		return propositions;
	}

	public void setPropositions(Vector<String> propositions) {
		this.propositions = new Vector<>(propositions);
	}
	
	public int getPropCorrect() {
		return propCorrect;
	}
	public void setPropCorrect(int propCorrect) {
		this.propCorrect = propCorrect;
	}
	public int getReponse() {
		return reponse;
	}
	public void setReponse(int reponse) {
		this.reponse = reponse;
	}

/*---------------------------------------------------------------------------------------*/
	public double verifierReponse() {
		if (this.propCorrect==this.reponse-1) return (1.0);
		else return (0.0);
		
	} ;
/*--------------------------------------------------------------------------------------*/
		public void afficherQuestion() {
		System.out.println(super.getQuestion() + " ?" );
		int cp = 1 ;
		for (String pr : propositions) {
			System.out.println( cp++ + " - " + pr );
		}
	}
		
		public Question copyQuestion ()  {
			Question question = new Qcu(super.getQuestion(), super.getNotion()) ; 
			question.setIsAnswered(super.getIsAnswered());
			question.setType(super.getType());

			((Qcu)question).setPropCorrect(this.propCorrect);
			
			for (int i =0 ; i<this.getPropositions().size();i++) {
				String prop = this.getPropositions().get(i) ; 

				((Qcu)question).getPropositions().add(prop);
			}
	return question;
		}
		
}