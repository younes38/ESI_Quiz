package application;

import java.io.Serializable;
import java.util.Vector;

public class Qcm extends Question implements Serializable {
	private Vector<String> propositions ;
	private Vector<Integer> propCorrect;
	private Vector<Integer> tabReponse;
	
	
	
	public Qcm(String notion,String question, Vector<String> propositions, Vector<Integer> propCorrect) {
		super(question, notion);
		super.setType(1);
		this.propositions = new Vector<>(propositions) ;
		
		this.propCorrect = new Vector<>(propCorrect);
		this.tabReponse = new Vector<>() ;  
	}
	public Qcm (String question , String notion) {
		super(question, notion) ; 
		this.propositions = new Vector<>() ;
		this.propCorrect = new Vector<>();
		this.tabReponse = new Vector<>() ;  


	}
	
	
	public Vector<String> getPropositions() {
		return propositions;
	}
	public void setPropositions(Vector<String> propositions) {
		this.propositions  = new Vector<>(propositions) ;
	}
	
	public Vector<Integer> getPropCorrect() {
		return propCorrect;
	}
	public void setPropCorrect(Vector<Integer> propCorrect) {
		this.propCorrect = new Vector<>(propCorrect);
	}
	public Vector<Integer> getTabReponse() {
		return tabReponse;
	}
	public void setTabReponse(Vector<Integer> tabReponse) {
		this.tabReponse = new Vector<>(tabReponse);
	}
	public void afficherQuestion() {
		System.out.println(super.getQuestion() + " ?" );
		int cp = 1 ;
		for (String pr : propositions) {
			System.out.println( cp++ + " - " + pr );
		}
	}
	/************/
//	public double verifierReponse( Vector <Integer> tabReponse  ) {
	public double verifierReponse() {

		double res=0.0 ; // la note

	//------------------------------------------------------------------------------------------ préparer le 1er tableau qui contient la valeur true dans la case d'idex proposition corrext et false ailleur
		if (tabReponse.size()!=0) {
			Vector<Boolean> tabBoolPropCorrect = new Vector<Boolean>();
			tabBoolPropCorrect.setSize(propositions.size());
			//System.out.println(tabBoolPropCorrect.size());
			for (int idxPropositions =0 ; idxPropositions < propositions.size();idxPropositions++) { // initailisation du tableau par des valeurs false
				tabBoolPropCorrect.set(idxPropositions,false) ; 
			}
			for(int idxPropCorrect=0;idxPropCorrect<propCorrect.size();idxPropCorrect++) {
				tabBoolPropCorrect.set(propCorrect.get(idxPropCorrect),true) ; 
			}
		//---------------------------------------------------------------------------------- le 2 eme tableau contient la valeur true dans la case d'index reponse choisi par apprenant et false ailleur
			Vector<Boolean> tabBoolTabReponse = new Vector<Boolean>() ; // initialiser tous le tableau a faux
			tabBoolTabReponse.setSize(propositions.size());
			for (int idxPropositions =0 ; idxPropositions < propositions.size();idxPropositions++) {
				tabBoolTabReponse.set(idxPropositions, false) ;
			}
			
			
			for(int idxTabReponse =0 ; idxTabReponse <this.tabReponse.size();idxTabReponse++) {   // setting chosen answers as true
				tabBoolTabReponse.set(tabReponse.get(idxTabReponse)-1, true);
			}
			
			
		//--------------------------------------------------------------------------------------
		//---------- La comparaison entre les deux tableau Afin de déduire la note -----------------------------------
			for (int idx = 0 ; idx <propositions.size();idx++) {
				if (tabBoolPropCorrect.get(idx)==tabBoolTabReponse.get(idx)) res ++ ; 
				else res -- ; 
			}	
		}
	return  (res / propositions.size()) ; 		
	};
	
	public Question copyQuestion ()  {
		Question question = new Qcm(super.getQuestion(),super.getNotion());

		question.setIsAnswered(super.getIsAnswered());
		question.setType(super.getType());
		for (int i =0 ; i<this.getPropositions().size();i++) {
			String prop = this.getPropositions().get(i) ; 

			((Qcm)question).getPropositions().add(prop);
		}
		
		
		for (int i =0 ; i<this.getPropCorrect().size();i++) {
			int propCorrect = this.getPropCorrect().get(i) ; 
			((Qcm)question).getPropCorrect().add(propCorrect) ; 
		}
		/*for (int i =0 ; i<this.getTabReponse().size();i++) {
			int prop = this.getTabReponse().get(i) ; 
			((Qcm)question).getTabReponse().add(prop) ; 
		}*/

return question ;
	}
	
	
}
