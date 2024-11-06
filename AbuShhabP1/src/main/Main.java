package main;

//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
import gui.AutoControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		new AutoControl(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
