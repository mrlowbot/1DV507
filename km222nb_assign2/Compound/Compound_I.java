package km222nb_assign2.Compound;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * To me it was important that the box wouldn't be allowed to be scaled when
 * used. Also got help from another friend to understand the button structure!
 * Also i am sorry if i make some bad "meme" jokes. But it helps me think...
 * 
 * @author Karwan
 *
 */
public class Compound_I extends Application {

	public static void main(String[] args) {
		launch();
	}

	public void start(Stage stage) {
		// Heading
		VBox top = new VBox();
		Label heading = new Label("Compound-Interest");
		heading.setFont(new Font(27));
		top.getChildren().add(heading);

		// Labels and text fields
		GridPane grid = new GridPane();
		grid.setHgap(5);
		grid.setVgap(5);

		TextField amountField = new TextField();
		TextField interestField = new TextField();
		TextField yearsField = new TextField();
		Button calculate = new Button("Calculate");
		Button clear = new Button("Reset");

		grid.add(new Label("Start amount:"), 0, 0);
		grid.add(new Label("Interest:"), 0, 1);
		grid.add(new Label("Number of years:"), 0, 2);
		grid.add(amountField, 1, 0);
		grid.add(interestField, 1, 1);
		grid.add(yearsField, 1, 2);
		grid.add(calculate, 0, 3);
		grid.add(clear, 0, 4);

	
		VBox bottom = new VBox();
		Label result = new Label();
		bottom.getChildren().add(result);

	
		calculate.setOnAction(event -> {
			try {
				double amount = Double.parseDouble(amountField.getText());
				double interest = Double.parseDouble(interestField.getText());
				double years = Double.parseDouble(yearsField.getText());

				int calculation = (int) Math.round(amount * Math.pow((1 + (interest / 50)), years));
				result.setText("Total capital : " + calculation);
			} catch (NumberFormatException ex) {
				result.setText("Error: All fields must only contain numbers");
			}
		});

		// Clear event
		clear.setOnAction(event -> {
			amountField.clear();
			interestField.clear();
			yearsField.clear();
			result.setText("");
		});


		VBox layout = new VBox();
		layout.setPadding(new Insets(8));
		layout.getChildren().addAll(top, grid, bottom);

		Scene scene = new Scene(layout);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Compound-Interest");
		stage.show();
	}

}