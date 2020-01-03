package application;

import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Vector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import application.Qcm;
import application.Qcu;
import application.Qo;
import application.Question;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.util.Random;

public class LoginController {
	
	@FXML
	TextField username ; 
	
	@FXML
	PasswordField passwrd ;
	
	@FXML
	Label loginFailed ; 
	
	@FXML 
	RadioButton radioBtnFormateur;
	
	@FXML
	RadioButton radioBtnApp ; 
	public boolean radioButtonclicked (ActionEvent e) {
		return true;
	}
	
	public void prin (ActionEvent e) throws IOException {
		
		if (    ( username.getText().equals("y")) && (passwrd.getText().equals("y")) && (radioBtnFormateur.isSelected()) && (!radioBtnApp.isSelected())) {
			 
				Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow() ; 		
				Parent root =FXMLLoader.load(getClass().getResource("PageOne.fxml"))  ; 
				stage.setScene(new Scene(root));
			}
			
		else {
			
			loginFailed.setText("Nom d'utilisateur ou mot de passe incorrect");
			}
		
	
	}	
	
	
	

	
	public void genQuiz (ActionEvent e) throws IOException {
		Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("PageTwo.fxml"));
		stage.setScene(new Scene(root));
	}
	@FXML
	TextField nomQuiz ;
	@FXML
	DatePicker dateOuv;
	@FXML
	DatePicker dateExp;
	@FXML
	Label genQuizLblFailed;
	@FXML
	Label genQuizLblSuccess ; 
	@FXML
	RadioButton math;
	@FXML
	RadioButton chimie;
	@FXML
	RadioButton elcf;
	@FXML
	Slider mathSlider;
	@FXML
	Slider chimieSlider;
	@FXML
	Slider elcfSlider;
	
	public void genQuizBtn (ActionEvent e) throws IOException {
		if (nomQuiz.getText().equals("")) genQuizLblFailed.setText("Veuillez Saisire le nom du Quiz");
		
		
		
		else {
			if (dateOuv.getValue().compareTo(dateExp.getValue())>0) genQuizLblFailed.setText("Date Expiration Doit etre apres date d'ouverture");
			else {
				if ((!math.isSelected()) && (!chimie.isSelected()) && (!elcf.isSelected())) {
					genQuizLblFailed.setText("Sélectionner au moins une notion");
				}
				else {
					genQuizLblFailed.setText("");
					/*La création d'un quiz ------ les questions sont static  ----------------------------------*/
					 
				
					
					Vector<String> propositions = new Vector<>() ;
					Vector<Integer> propCorrect = new Vector<>() ;
					Vector<String> reponseCorrectes = new Vector<>(); 
					String question ;
					String notion ;
					int propC ;
					
					/* ************************************* */
					question = "parmi les nombres suivants, lequels sont premier ?" ;
					System.out.println(question);
					notion = "Mathematic" ;
					propositions.add("0") ;
					propositions.add("1") ;
					propositions.add("2") ;
					propositions.add("3") ;
					propositions.add("4") ;
					propCorrect.add(2) ;
					propCorrect.add(3) ;
					Qcm qcm = new Qcm(notion, question, propositions, propCorrect);
				
					propCorrect.clear();
					propositions.clear();
					
					/* ************************************* */
					question = "quels sont les nombres divisble par 8" ;
					
					notion = "Mathematic" ;
					propositions.add("16") ;
					propositions.add("0") ;
					propositions.add("2") ;
					propositions.add("5") ;
					propositions.add("20") ;
					propCorrect.add(0) ;
					propCorrect.add(1) ;
					Qcm qcm1 = new Qcm(notion, question, propositions, propCorrect);

					propCorrect.clear();
					propositions.clear();
					
					
					/* ****************** QCU ******************* */
					question = "Quel le carré du nombre 3" ;
					notion = "Mathematic" ;
					propositions.add("9") ;
					propositions.add("15") ;
					propositions.add("3") ;
					propositions.add("10") ;
					propositions.add("4") ;
					propC = 0 ;
					
					Qcu qcu = new Qcu(notion, question, propositions, propC);
					propositions.clear();
					
					/* ****************** QCU ******************* */
					question = "Si le rayon d'un cercle mesure 10 cm, combien mesure son diamètre ?" ;
					notion = "Mathematic" ;
					propositions.add("25") ;
					propositions.add("5") ;
					propositions.add("20") ;
					propositions.add("31.4") ;
					propositions.add("7") ;
					propC = 1 ;
					Qcu qcu1 = new Qcu(notion, question, propositions, propC);
					propositions.clear();
					
					/* ****************** QCU ******************* */
					question = "Combien de côtés possède un hexagone ?" ;
					notion = "Mathematic" ;
					propositions.add("6") ;
					propositions.add("5") ;
					propositions.add("8") ;
					propositions.add("9") ;
					propositions.add("4") ;
					propC = 0 ;
					Qcu qcu2 = new Qcu(notion, question, propositions, propC);
					propositions.clear();
					
					

					Vector<Question> questions = new Vector<>() ;
				// Les Question du module Mathematique //
					questions.add(qcm) ;

					questions.add(qcu);
					
					questions.add(qcu1) ;
					
					questions.add(qcm1);

					questions.add(qcu2); 
					
					//----- Le module Chimie ------------------------**-----------//
					
					
					question = "Un atome est composé au minimum :";
					notion = "Chimie" ;
					
					propositions.add("D'un proton et d'un électron") ;
					propositions.add("D'un proton et d'un neutron") ;
					propositions.add("D'un proton, d'un neutron et d'un électron") ;
					propC = 2 ; 
					Qcu qcuC1 = new Qcu(notion, question, propositions, propC);
					propCorrect.clear();
					propositions.clear();
					
					
					question = "Parmi ces gaz , lequels sont noble ?" ; 
					notion = "Chimie" ; 
					propositions.add("Oxygène") ;
					propositions.add("l'hélium") ;
					propositions.add("Hydrogène") ;
					propositions.add("l'argon") ;
					propCorrect.add(1) ;
					propCorrect.add(3) ;
					Qcm  qcmC1 = new Qcm("Chimie", question, propositions, propCorrect) ; 
					propositions.clear();
					propCorrect.clear();
					
					question = "Quel est le symbole chimique du chlore?";
					reponseCorrectes.add("Cl") ; 
					Qo qoC1= new Qo("Chimie", question, reponseCorrectes) ;  
					reponseCorrectes.clear();
					/////////////////////////////////////////////////////////////////
					
					questions.add(qcuC1) ;
					questions.add(qcmC1);
					questions.add(qoC1);
					
					/*Les Question du module Electricité*/
					question ="Quelle unité du système international mesure l'intensité du courant électrique ?" ; 
					notion = "Electricite" ; 
					propositions.add("Le Watt") ;
					propositions.add("L'ampère") ;
					propositions.add("Le volte") ;
					propC = 1 ; 
					Qcu qcuE1= new Qcu(notion, question,propositions, propC) ;

					propositions.clear(); 
					
					question = "Parmi les lois suivantes , lequels permis de calculer l'intensité";
					notion = "Electricite" ; 
					propositions.add("R*I") ;
					propositions.add("I*E/2") ;
					propositions.add("q/c") ;
					propositions.add("P*c/t") ;
					propCorrect.add(0);
					propCorrect.add(2);
					Qcm qcmE1 = new Qcm(notion, question, propositions, propCorrect) ; 
					propCorrect.clear();
					propositions.clear();
					
					question ="Quelle unité du système international mesure la résistance électrique ?" ; 
					
					notion = "Electricite" ; 
					propositions.add("Ohm") ;
					propositions.add("L'amère") ;
					propositions.add("Le volte") ;
					propC = 0 ; 
					Qcu qcuE2= new Qcu(notion, question,propositions, propC) ;

					propositions.clear(); 
					
					
					questions.add(qcuE1) ; 
					questions.add(qcuE2);
					questions.add(qcmE1) ;
					int nbrQuesMath = 0 ; 
					int nbrQuesChimie = 0 ; 
					int nbrQuestElcf =0;
					
					Vector<Integer> tabint = new Vector<>() ; 
					int myrand=0;
					Vector<Question> tabQes = new Vector<>() ;
					Random random = new Random();
					boolean cond =true; 
					
					
					
					
					if (math.isSelected()) {
						for (int r=0 ;r<(int)mathSlider.getValue();r++) {

							cond = true ;
							while (cond) {
								cond = false ; 
								myrand = random.nextInt(5)+1 ;
								for (int oo=0;oo<tabint.size();oo++) {
									if (tabint.get(oo)==myrand) cond =true;
								}
							}

							tabint.add(myrand) ; 
							
							tabQes.add(questions.get(myrand)) ; 
							
							
							
						}
						
					}
					tabint.clear();
					if(chimie.isSelected()) {
						for (int r=0 ;r<(int)chimieSlider.getValue();r++) {

							cond = true ;
							while (cond) {
								cond = false ; 
								myrand = random.nextInt(3)+1 ;
								for (int oo=0;oo<tabint.size();oo++) {
									if (tabint.get(oo)==myrand) cond =true;
								}
							}

							tabint.add(myrand) ; 
							
							tabQes.add(questions.get(myrand+4)) ; 
							
							
							
						}
					}
					tabint.clear();
					if(elcf.isSelected()) {
						for (int r=0 ;r<(int)elcfSlider.getValue();r++) {

							cond = true ;
							while (cond) {
								cond = false ; 
								myrand = random.nextInt(3)+1 ;
								for (int oo=0;oo<tabint.size();oo++) {
									if (tabint.get(oo)==myrand) cond =true;
								}
							}

							tabint.add(myrand) ; 
							
							tabQes.add(questions.get(myrand+7)) ; 
							
						}
					}
					Vector<Quiz> tableauQuiz = new Vector<>();
					Quiz quiz = new Quiz(nomQuiz.getText(),tabQes, dateOuv.getValue(), dateExp.getValue()); // Le Quiz est générer avec succes 
					
					
					/*-----------------------desirialisation*/ 
					ObjectInputStream in;
					
					try {
						in = new ObjectInputStream (new BufferedInputStream(new FileInputStream(new File("QuizList.txt")))) ; 
					//	System.out.println("AA SAHBI je suis La à +    -- >"+in.available());
						while (   true ) {
							int i=0;
							System.out.println("L'objet numéro ++  " +i);
						//	((Quiz)in.readObject()).afficher();;
							tableauQuiz.add((Quiz)in.readObject());
							i++;
						}
							
					}
					catch (EOFException ee) {
					//	System.out.println("hhhhhhh");
					}
					catch (ClassNotFoundException eo) {
							eo.printStackTrace();
						}
					
					catch (IOException eo) {
						eo.printStackTrace();
					}
					
					
					// La partie serialisation de l'objet -----------------*-*-*-*-*-*-*-*-*-*-*--------------------------- /
					System.out.println("La taille de tableau de Quiz est "+tableauQuiz.size());

					tableauQuiz.add(quiz) ;
					System.out.println("La taille de tableau de Quiz est "+tableauQuiz.size());
					ObjectOutputStream out ;

					try {

						
						out = new ObjectOutputStream (new BufferedOutputStream(new FileOutputStream(new File("QuizList.txt")))) ; 
						for(int y=0;y<tableauQuiz.size();y++) {
							out.writeObject(tableauQuiz.get(y));
						}
//						out.writeObject(quiz);
					//	out.
						
						out.close();

					}
					catch (FileNotFoundException eo) {
						eo.printStackTrace();
					}
					catch (IOException eo){
						eo.printStackTrace();
					}
				
					
					
					/*------------------------------------------------------------------------------------------*/
					
					
					genQuizLblSuccess.setText("Quiz est générer avec succes ");
				}
				
			}
			
		}
		
	}
	
	public void afficherQuiz (ActionEvent e) throws IOException {
	
		Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("PageThree.fxml"));
		stage.setScene(new Scene(root));
	}
	@FXML
	TextArea txtQuiz;
	public void afflo (ActionEvent e) {
		ObjectInputStream in;
		txtQuiz.setEditable(false);
		try {
			in = new ObjectInputStream (new BufferedInputStream(new FileInputStream(new File("QuizList.txt")))) ; 
			
			while (true) {
				//((Quiz)in.readObject()).afficher();
				Quiz quiz = ((Quiz)in.readObject()) ; 
				//txtQuiz.appendText("Quiz"+'\n');
				txtQuiz.appendText("-------- Quiz : "+quiz.getNomQuiz() +"-----------"+ '\n');
				for (int y=0;y<quiz.getTabQuestion().size();y++) {
					txtQuiz.appendText(y+" | "+quiz.getTabQuestion().get(y).getQuestion()+" ?" + '\n');
					if (quiz.getTabQuestion().get(y).getType()==1) {
						for (int u =0 ; u<((Qcm)quiz.getTabQuestion().get(y)).getPropositions().size();u++) {
							txtQuiz.appendText("  -"+((Qcm)quiz.getTabQuestion().get(y)).getPropositions().get(u)+'\n');
						}
					}
					if(quiz.getTabQuestion().get(y).getType()==2) {
						for (int u =0 ; u<((Qcu)quiz.getTabQuestion().get(y)).getPropositions().size();u++) {
							txtQuiz.appendText("   -"+((Qcu)quiz.getTabQuestion().get(y)).getPropositions().get(u)+'\n');
						}
					}
					
				}
				txtQuiz.appendText("**************************************"+'\n');
				
			}
			

		}
		catch (EOFException ee) {
			System.out.println("hhhhhhh");
		}
		catch (ClassNotFoundException eo) {
				eo.printStackTrace();
			}
		
		catch (IOException eo) {
			eo.printStackTrace();
		}
		
		
		
		
		
	
		
		}

	
	

}



