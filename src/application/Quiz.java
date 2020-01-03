package application;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

import org.w3c.dom.css.ElementCSSInlineStyle;

public class Quiz implements Serializable{
	
	private String nomQuiz ;
	private Vector<Question> tabQuestion;
	private LocalDate dateOuverture;
	private LocalDate dateExpiration;
	
	
	
	
	public String getNomQuiz() {
		return nomQuiz;
	}
	public void setNomQuiz(String nomQuiz) {
		this.nomQuiz = nomQuiz;
	}
	public LocalDate getDateOuverture() {
		return dateOuverture;
	}
	public void setDateOuverture(LocalDate dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	public LocalDate getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(LocalDate dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	
	
	public Vector<Question> getTabQuestion() {
		return tabQuestion;
	}
	public Question getQuestion(int i) {
		if (i >=0 && i < tabQuestion.size()) return tabQuestion.get(i) ;
		 return null ;
	}
	public void setTabQuestion(Vector<Question> tabQuestion) {
		this.tabQuestion = new Vector<>(tabQuestion);
	}
	
	public void addQuestion(Question q) {
		tabQuestion.add(q) ;
	}
	public Quiz (String nom, LocalDate dateO, LocalDate dateE) {
		nomQuiz = nom ;
		dateOuverture = dateO ;
		dateExpiration = dateE ;
		this.tabQuestion = new Vector<>();
	}
	public void afficher() {
		System.out.println("Affichage d'un quizz");
		System.out.println("nom du Quizz : " + this.nomQuiz);
		int cp = 1 ;
		//System.out.println("Kayn wahd Quespoaz"+tabQuestion.size());

		for (int  i= 0;i< tabQuestion.size(); i++) {
			System.out.println(cp++ + "/" );
			tabQuestion.get(i).afficherQuestion();
			
		}
	}
	
	
	
	public Quiz(String nomQuiz, Vector<Question> tabQuestion, LocalDate dateOuverture, LocalDate dateExpiration) {
		super();
		this.nomQuiz = nomQuiz;
		this.tabQuestion = tabQuestion;
		this.dateOuverture = dateOuverture;
		this.dateExpiration = dateExpiration;
	}
	/****************************/
	public double evaluerQuiz () {
		double noteQuiz = 0.0 ; 
		for (int idxTabQuestion = 0 ; idxTabQuestion <tabQuestion.size();idxTabQuestion++) {
			noteQuiz= noteQuiz + (double) ((double) 1/tabQuestion.size())*tabQuestion.get(idxTabQuestion).verifierReponse() ; 
		}

		return noteQuiz ; 
	}
	
	// added 26/06/2019
	public int tauxAccolplissementQuiz() {
		int cp = 0 ;
		for(int i = 0; i< this.tabQuestion.size(); i++) {
			cp += tabQuestion.get(i).getIsAnswered() ;
		}
		return (int) cp*100/this.tabQuestion.size() ;
	}
	
	public void afficherAnswered() {
		for (int i = 0; i< tabQuestion.size(); i++)
			System.out.println( " Question" +(i+1) + " : "  + tabQuestion.get(i).getIsAnswered());
		
	}
	
}
