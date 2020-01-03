 package application;

import java.io.Serializable;
import java.util.Vector;

public class Qo extends Question implements Serializable  {
	private String reponse ;
	private Vector<String> reponsePrevu;
	public Qo(String notion,String question, Vector<String> reponsePrevu) {
		super(question, notion);
		super.setType(3);
		this.reponsePrevu = new Vector<>(reponsePrevu) ;
		
	}
	
	
	
	public Qo(String question, String notion) {
		super(question, notion);
		this.reponsePrevu = new Vector<>();
	}



	public String getReponse() {
		return reponse;
	}


	public void setReponse(String reponse) {
		this.reponse = reponse;
	}


	public Vector<String> getReponsePrevu() {
		return reponsePrevu;
	}



	public void setReponsePrevu(Vector<String> reponsePrevu) {
		this.reponsePrevu = new Vector<>(reponsePrevu);
	}


	
	
	public double verifierReponse () {
		
		for (int idx = 0 ; idx <reponsePrevu.size();idx++) {
			if (reponse.toLowerCase()==reponsePrevu.get(idx).toLowerCase() ) return 1.0 ; 
		}

		return 0.0 ; 
	} ;
	
	public void afficherQuestion() {
		System.out.println(super.getQuestion() + " ?" );
		
	}
	public Question copyQuestion ()  {
		Question question = new Qo(super.getQuestion(), super.getNotion()) ; 
		question.setIsAnswered(super.getIsAnswered());
		question.setType(super.getType());

		
		for (int i =0 ; i<this.getReponsePrevu().size();i++) {
			String prop = this.getReponsePrevu().get(i) ; 

			((Qo)question).getReponsePrevu().add(prop);
		}
return question;

	}
}