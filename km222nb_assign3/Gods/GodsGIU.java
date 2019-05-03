package km222nb_assign3.Gods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * I made it easier and added all the text files within the map. So yeah... 
 * 
 * @author Karwan
 *
 */
public class GodsGIU extends Application {
	@Override
	public void start(Stage primaryStage) {


		VBox left = new VBox();
		VBox right = new VBox();

		BorderPane pane = new BorderPane();

		Text text = new Text("Mythological Gods");
		text.setFont(Font.font("Century", 17));


		ArrayList<Gods> norse = new ArrayList<Gods>();
		norse.add(new Gods("Apollo", "Music", readFile("src\\km222nb_assign3\\Gods\\Apollo.txt")));
		norse.add(new Gods("Aphrodite", "Beauty", readFile("src\\km222nb_assign3\\Gods\\Aphrodite.txt")));
		norse.add(new Gods("Ares", "War", readFile("src\\km222nb_assign3\\Gods\\Ares.txt")));
		norse.add(new Gods("Hermes", "Boundaries", readFile("src\\km222nb_assign3\\Gods\\Hermes.txt")));
		norse.add(new Gods("Hestia", "Virgin", readFile("src\\km222nb_assign3\\Gods\\Hestia.txt")));
		norse.add(new Gods("Hera", "Queen", readFile("src\\km222nb_assign3\\Gods\\Hera.txt")));
		norse.add(new Gods("Poseidon", "Sea", readFile("src\\km222nb_assign3\\Gods\\Poseidon.txt")));
		norse.add(new Gods("Zeus", "God of all Gods", readFile("src\\km222nb_assign3\\Gods\\Zeus.txt")));
		ListView<String> norseList = new ListView<String>();
		for (Gods s : norse) {
			norseList.getItems().add(s.getName());
		}

	
		Text title = new Text();
		Text race = new Text();
		Text selected = new Text();

		title.setFont(Font.font("Century", 20));
		race.setFont(Font.font("Century", 14));


		left.getChildren().addAll(norseList);
		right.getChildren().addAll(title, race, selected);

		norseList.getSelectionModel().selectedItemProperty().addListener((ov, old_val, new_val) -> {
			for (Gods s : norse) {
				if (new_val.equals(s.getName())) {
					title.setText(new_val);
					race.setText(s.getRace());
					selected.setText(s.getDesc());
				}
			}
		});


		ScrollPane scroll = new ScrollPane();
		scroll.setContent(right);


		pane.setTop(text);
		pane.setLeft(left);
		pane.setCenter(scroll);

		Scene scene = new Scene(pane, 900, 400);


		primaryStage.setTitle("Gods");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}


	private String readFile(String file) {
		File inFile = new File(file);
		StringBuilder sbText = new StringBuilder();
		String text;
		try (Scanner scan = new Scanner(inFile);) {
			while (scan.hasNext()) {
				text = scan.nextLine();
				sbText.append(text + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
		return sbText.toString();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
