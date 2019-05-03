package km222nb_assign3;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TinyPainter extends Application {
	/**
	 * I struggled quite a lot with the button to not get it cover up by the things
	 * that are drawn. Think i made it, had some friends help me as well.
	 * 
	 * @author Karwan
	 *
	 */
	private static Line drawLine(double startX, double startY, double size, Color col) {
		Line line;
		line = new Line(startX, startY, startX, startY);
		line.setStrokeWidth(size);
		line.setStroke(col);

		return line;
	}

	private static Rectangle drawRectangle(double startX, double startY, double height, double width, Color col) {
		Rectangle REACT = new Rectangle();
		REACT.setWidth(width);
		REACT.setHeight(height);
		REACT.setFill(col);
		REACT.setX(startX);
		REACT.setY(startY);

		return REACT;
	}

	private static Circle drawCircle(double startX, double startY, double radius, Color col) {
		Circle CRIC = new Circle();
		CRIC.setCenterX(startX);
		CRIC.setCenterY(startY);
		CRIC.setRadius(radius);
		CRIC.setFill(col);

		return CRIC;
	}

	public void start(Stage mainStage) {

		// Shape lists
		ArrayList<Line> lineList = new ArrayList<Line>();
		ArrayList<Rectangle> dotList = new ArrayList<Rectangle>();
		ArrayList<Rectangle> rectList = new ArrayList<Rectangle>();
		ArrayList<Circle> circList = new ArrayList<Circle>();

		// Layouts
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(5);
		grid.setPadding(new Insets(5, 5, 5, 5)); // top, right, bottom, left

		HBox menu = new HBox();
		menu.setSpacing(10);

		// Nodes
		ComboBox<String> shapeSel = new ComboBox<String>();
		shapeSel.getItems().addAll("Line", "Dot", "Rectangle", "Circle");
		shapeSel.getSelectionModel().select("Line");

		// Add sizes to size selection box
		ComboBox<Double> sizeSel = new ComboBox<Double>();
		for (Double d = 0.5; d <= 40; d = d + 0.5) {
			sizeSel.getItems().add(d);
		}
		sizeSel.getSelectionModel().select(0);

		ColorPicker colourSel = new ColorPicker();

		// Drawing canvas
		Pane canvas = new Pane();
		canvas.setPrefSize(GridPane.REMAINING, GridPane.REMAINING);
		canvas.setMaxSize(GridPane.REMAINING, GridPane.REMAINING);

		// Clear button
		Button clear = new Button();
		clear.setText("Clear");
		clear.setOnAction(clearCanvas -> {
			canvas.getChildren().clear();
			lineList.clear();
			dotList.clear();
			rectList.clear();
			circList.clear();
		});

		canvas.setOnMousePressed(mouse -> {
			if (shapeSel.getSelectionModel().getSelectedItem().equals("Line")) {
				Line newLine = drawLine(mouse.getX(), mouse.getY(), sizeSel.getSelectionModel().getSelectedItem(),
						colourSel.getValue());
				canvas.getChildren().add(newLine);
				lineList.add(newLine);
			}

			if (shapeSel.getSelectionModel().getSelectedItem().equals("Dot")) {
				Rectangle newDot;
				double startX = mouse.getX();
				double startY = mouse.getY();
				double size = sizeSel.getSelectionModel().getSelectedItem();

				if (startY > size / 2.0 - 1) { // Can't draw over menu
					newDot = drawRectangle(startX - (size / 2.0), startY - (size / 2.0), size, size,
							colourSel.getValue());
					canvas.getChildren().add(newDot);
					dotList.add(newDot);
				}
			}

			if (shapeSel.getSelectionModel().getSelectedItem().equals("Rectangle")) {
				Rectangle newRect = drawRectangle(mouse.getX(), mouse.getY(), 1, 1, colourSel.getValue());
				canvas.getChildren().add(newRect);
				rectList.add(newRect);
			}

			if (shapeSel.getSelectionModel().getSelectedItem().equals("Circle")) {
				Circle newCirc = drawCircle(mouse.getX(), mouse.getY(), 1, colourSel.getValue());
				canvas.getChildren().add(newCirc);
				circList.add(newCirc);
			}
		});

		canvas.setOnMouseDragged(mouse -> {
			if (shapeSel.getSelectionModel().getSelectedItem().equals("Line")) {
				Line endLine = lineList.get(lineList.size() - 1);
				Double size = endLine.getStrokeWidth();
				endLine.setEndX(mouse.getX());
				if (mouse.getY() < size) {
					endLine.setEndY(size / 2.0);
				} // Can't draw over menu
				else {
					endLine.setEndY(mouse.getY());
				}
			}

			if (shapeSel.getSelectionModel().getSelectedItem().equals("Rectangle")) {
				Rectangle rect = rectList.get(rectList.size() - 1);

				Double mouseXPos = mouse.getX();
				Double mouseYPos = mouse.getY();

				if (mouseXPos > rect.getX()) {
					rect.setWidth(mouse.getX() - rect.getX());
				} else {
					rect.setWidth(rect.getX() - mouse.getX());
					rect.setTranslateX(mouse.getX() - rect.getX());
				}

				if (mouseYPos > rect.getY()) {
					rect.setHeight(mouse.getY() - rect.getY());
				}

				else if (mouseYPos <= -1) { // Can't draw over menu
					rect.setHeight(rect.getY());
				}

				else {
					rect.setHeight(rect.getY() - mouse.getY());
					rect.setTranslateY(mouse.getY() - rect.getY());
				}
			}

			if (shapeSel.getSelectionModel().getSelectedItem().equals("Circle")) {
				Circle circ = circList.get(circList.size() - 1);

				Double mouseXPos = mouse.getX();
				Double mouseYPos = mouse.getY();
				Double circleXPos = circ.getCenterX();
				Double circleYPos = circ.getCenterY();
				double radius = Math
						.sqrt((Math.pow(circleXPos - mouseXPos, 2)) + (Math.pow(circleYPos - mouseYPos, 2)));

				if (radius >= circleYPos) { // Can't draw over menu
					circ.setRadius(circleYPos);
				}

				else {
					circ.setRadius(radius);
				}

			}
		});

		menu.getChildren().addAll(shapeSel, sizeSel, colourSel, clear);
		grid.add(menu, 0, 0);
		grid.add(canvas, 0, 1, 3, 1);

		Scene mainScene = new Scene(grid, 800, 600);
		mainStage.setTitle("Tiny Painter");
		mainStage.setResizable(false);
		mainStage.setScene(mainScene);
		mainStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}