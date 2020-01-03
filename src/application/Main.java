package application;
	
import java.io.IOException;

import javafx.application.Application;import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private double xOffset = 0;
    private double yOffset = 0;
    
	@Override
	public void start(Stage primaryStage) throws IOException {
		

			Parent root =FXMLLoader.load(getClass().getResource("Login.fxml"))  ; 
			Scene scene = new Scene(root);
		//	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//	primaryStage.initStyle(primaryStage.TRANSPARENT);
	        primaryStage.initStyle(StageStyle.UNDECORATED);

	    
	        root.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					xOffset = event.getSceneX();
					yOffset = event.getSceneY();

				}
				
	        	
			});
	        root.setOnMouseDragged(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					primaryStage.setX(event.getSceneX()-xOffset);
					primaryStage.setY(event.getScreenY()-yOffset);
					
				}
	        	
	        }); 
	        
	        
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
