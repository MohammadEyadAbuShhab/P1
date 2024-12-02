package main;

import guiAutos.AutoControl;
import guiFahrzeuguebersicht.FahrzeuguebersichtControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		new AutoControl(primaryStage);
		Stage fensterFahrzeugUebersicht = new Stage();
		new FahrzeuguebersichtControl(fensterFahrzeugUebersicht);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
