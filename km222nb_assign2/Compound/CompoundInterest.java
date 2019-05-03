package km222nb_assign2.Compound;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CompoundInterest extends Application {
	
	//Calculates the rate
	public Long calcCompLong(double p,double r,double t) {
		return Math.round(p*Math.pow((1+r/100.0),t));
	}
	

	public boolean isNumber(String s) {
		return s.matches("^[\\d\\-\\.]+$");
	}
	
	@Override
	public void start(Stage primaryStage) {
		int labelSize = 15;
		
		//Nodes
		Text header = new Text(0,0,"Compound-Interest");
	    header.setTextAlignment(TextAlignment.CENTER);
	    header.setFont(Font.font("Helvetica",30));
	    
	    Label amountLabel = new Label("Start amount:");
	    amountLabel.setFont(Font.font("Helvetica",labelSize));
	    Label interestLabel = new Label("Interest:");
	    interestLabel.setFont(Font.font("Helvetica",labelSize));
	    Label yearsLabel = new Label("Number of\nyears:");
	    yearsLabel.setFont(Font.font("Helvetica",labelSize));
	    Label resultLabel = new Label("");
	    resultLabel.setFont(Font.font("Helvetica",labelSize));
	    
	    final TextField ammountField = new TextField();
	    final TextField interestField = new TextField();
	    final TextField yearField = new TextField();
	    
	    Button calculateButton = new Button("Calculate");
	    calculateButton.setAlignment(Pos.BASELINE_LEFT);
	    calculateButton.setOnAction(bCalc -> {
	    	String aFS = ammountField.getText();
	    	String iFS = interestField.getText();
	    	String yFS = yearField.getText();
	    		
	    	if (aFS.isEmpty() || iFS.isEmpty() || yFS.isEmpty()) {
	    		resultLabel.setText("Field(s) are empty!");
	    	}
	    	
	    	else if (isNumber(aFS) && isNumber(iFS) && isNumber(yFS)) {
	    		Long result = calcCompLong(Double.parseDouble(aFS),Double.parseDouble(iFS),Double.parseDouble(yFS));
	    		resultLabel.setText("Total: "+result);
	    	}
	    	
	    	else {
	    		resultLabel.setText("You didn't enter a number fam...?");
	    	}
	    });
	    
	    

		HBox topHBox = new HBox();
		topHBox.setSpacing(10);
		topHBox.setAlignment(Pos.CENTER);
		topHBox.getChildren().add(header);
		

		VBox leftVBox = new VBox();
		leftVBox.setPadding(new Insets(14,5,5,5)); 
		leftVBox.setSpacing(16);
		leftVBox.setAlignment(Pos.CENTER_LEFT);
		leftVBox.getChildren().addAll(amountLabel,interestLabel,yearsLabel);
		

		VBox rightVBox = new VBox();
		rightVBox.setPadding(new Insets(10,5,5,3));
		rightVBox.setSpacing(14);
		rightVBox.setAlignment(Pos.CENTER_LEFT);
		rightVBox.getChildren().addAll(ammountField,interestField,yearField);
		
		HBox middleBox = new HBox();
		middleBox.setPadding(new Insets(0,0,5,0));
		middleBox.setAlignment(Pos.CENTER);
		middleBox.getChildren().addAll(leftVBox,rightVBox);
		
		VBox bottomVBox = new VBox();
		bottomVBox.setPadding(new Insets(5,0,5,10));
		bottomVBox.setSpacing(4);
		bottomVBox.getChildren().addAll(calculateButton,resultLabel);
		
	    VBox root = new VBox();
	    root.getChildren().addAll(topHBox,middleBox,bottomVBox);
	    
		Scene scene = new Scene(root);
		primaryStage.setTitle("Compound Interest");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}