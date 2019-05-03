package km222nb_assign2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 * The snowman is fat... and his name is Sir Snowman the III. Tried to give him
 * a top hat but was proven more difficult then i thought haha.
 * 
 * @author Karwan
 *
 */

public class Snowman extends Application {

	public static void main(String[] args) {
		launch(args); // Launching the FX.
	}

	@Override
	public void start(Stage primaryStage) {
		// Lanuching the FX from this!
		Rectangle RG = new Rectangle(0, 0, 650, 450);
		RG.setFill(Color.DEEPSKYBLUE);

		Rectangle Ground = new Rectangle();
		Ground.setX(0);
		Ground.setY(290);
		Ground.setWidth(650);
		Ground.setHeight(650);
		Ground.setFill(Color.WHITE);

		Circle SUN = new Circle(500, 75, 40, Color.YELLOW);

		Circle Head = new Circle(300, 160, 20, Color.WHITE);
		Circle MidBody = new Circle(300, 200, 30, Color.WHITE);
		Circle EndBody = new Circle(300, 250, 45, Color.WHITE);

		Line FirstArm = new Line(320, 180, 355, 175);
		FirstArm.setFill(Color.BLACK);
		FirstArm.setStrokeWidth(2);

		Line SecondArm = new Line(280, 180, 246, 175);
		SecondArm.setFill(Color.BLACK);
		SecondArm.setStrokeWidth(2);

		Circle leftEye = new Circle(290, 150, 3, Color.BLACK);
		Circle rightEye = new Circle(310, 150, 3, Color.BLACK);
		Circle SirButton1 = new Circle(300, 183, 3, Color.BLACK);
		Circle SirButton2 = new Circle(300, 194, 3, Color.BLACK);
		Circle SirButton3 = new Circle(300, 207, 3, Color.BLACK);

		Line mouth = new Line(290, 158, 310, 158);
		mouth.setStroke(Color.BLACK);

		Group root = new Group();
		root.getChildren().addAll(RG, Ground, SUN);
		root.getChildren().addAll(Head, MidBody, EndBody, FirstArm, SecondArm);
		root.getChildren().addAll(mouth, leftEye, rightEye);
		root.getChildren().addAll(SirButton1, SirButton2, SirButton3);
		Scene scene = new Scene(root, 600, 400);

		primaryStage.setTitle("{Sir Snowman The III}");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}