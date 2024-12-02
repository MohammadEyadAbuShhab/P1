package guiAutos;

import business.Auto;
import business.AutoModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class AutoView {

	private AutoModel autoModel;
	private AutoControl autoControl;
	private Auto auto;

	private Pane pane = new Pane();
	private Label lblEingabe = new Label("Eingabe");
	private Label lblAnzeige = new Label("Anzeige");
	private Label lblKennzeichen = new Label("Kennzeichen:");
	private Label lblVermietetVonBis = new Label("Modell:");
	private Label lblTagesPreis = new Label("TagesPreis:");
	private Label lblTyp = new Label("Typ:");
	private Label lblModell = new Label("Vermietet von bis:");
	private TextField txtKennzeichen = new TextField();
	private TextField txtVermietetVonBis = new TextField();
	private TextField txtTagesPreis = new TextField();
	private TextField txtTyp = new TextField();
	private TextField txtModell = new TextField();
	private TextArea txtAnzeige = new TextArea();
	private Button btnEingabe = new Button("Eingabe");
	private Button btnAnzeige = new Button("Anzeige");
	private MenuBar mnbrMenuLeiste = new MenuBar();
	private Menu mnDatei = new Menu("Datei");
	private MenuItem mnItmCsvImport = new MenuItem("csv-Import");
	private MenuItem mnItmTxtImport = new MenuItem("txt-Import");
	private MenuItem mnItmCsvExport = new MenuItem("csv-Export");

	public AutoView(AutoModel autoModel, AutoControl autoControl, Stage primaryStage) {
		super();
		this.autoModel = autoModel;
		this.autoControl = autoControl;
		Scene scene = new Scene(this.pane, 700, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Verwaltung von Autos");
		primaryStage.show();
		this.initKomponenten();
		this.initListener();
	}

	private void initKomponenten() {
		// Labels
		lblEingabe.setLayoutX(20);
		lblEingabe.setLayoutY(40);
		Font font = new Font("Arial", 24);
		lblEingabe.setFont(font);
		lblEingabe.setStyle("-fx-font-weight: bold;");
		lblAnzeige.setLayoutX(400);
		lblAnzeige.setLayoutY(40);
		lblAnzeige.setFont(font);
		lblAnzeige.setStyle("-fx-font-weight: bold;");
		lblKennzeichen.setLayoutX(20);
		lblKennzeichen.setLayoutY(90);
		lblVermietetVonBis.setLayoutX(20);
		lblVermietetVonBis.setLayoutY(130);
		lblTagesPreis.setLayoutX(20);
		lblTagesPreis.setLayoutY(170);
		lblTyp.setLayoutX(20);
		lblTyp.setLayoutY(210);
		lblModell.setLayoutX(20);
		lblModell.setLayoutY(250);
		pane.getChildren().addAll(lblEingabe, lblAnzeige, lblKennzeichen, lblVermietetVonBis, lblTagesPreis, lblTyp,
				lblModell);

		// Textfelder
		txtKennzeichen.setLayoutX(170);
		txtKennzeichen.setLayoutY(90);
		txtKennzeichen.setPrefWidth(200);
		txtVermietetVonBis.setLayoutX(170);
		txtVermietetVonBis.setLayoutY(130);
		txtVermietetVonBis.setPrefWidth(200);
		txtTagesPreis.setLayoutX(170);
		txtTagesPreis.setLayoutY(170);
		txtTagesPreis.setPrefWidth(200);
		txtTyp.setLayoutX(170);
		txtTyp.setLayoutY(210);
		txtTyp.setPrefWidth(200);
		txtModell.setLayoutX(170);
		txtModell.setLayoutY(250);
		txtModell.setPrefWidth(200);
		pane.getChildren().addAll(txtKennzeichen, txtVermietetVonBis, txtTagesPreis, txtTyp, txtModell);

		// Textbereich
		txtAnzeige.setEditable(false);
		txtAnzeige.setLayoutX(400);
		txtAnzeige.setLayoutY(90);
		txtAnzeige.setPrefWidth(270);
		txtAnzeige.setPrefHeight(185);
		pane.getChildren().add(txtAnzeige);

		// Buttons
		btnEingabe.setLayoutX(20);
		btnEingabe.setLayoutY(290);
		btnAnzeige.setLayoutX(400);
		btnAnzeige.setLayoutY(290);
		pane.getChildren().addAll(btnEingabe, btnAnzeige);

		// Menue
		this.mnbrMenuLeiste.getMenus().add(mnDatei);
		this.mnDatei.getItems().add(mnItmCsvImport);
		this.mnDatei.getItems().add(mnItmTxtImport);
		this.mnDatei.getItems().add(new SeparatorMenuItem());
		this.mnDatei.getItems().add(mnItmCsvExport);
		pane.getChildren().add(mnbrMenuLeiste);
	}

	private void initListener() {
		btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				autoControl.nehmeAutoAuf();
			}
		});
		btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeAutosAn();
			}
		});
		mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				autoControl.leseAusDatei("csv");
			}
		});
		mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				autoControl.leseAusDatei("txt");
			}
		});
		mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				autoControl.schreibeAutoInCsvDatei();
			}
		});
	}

	public void zeigeAutosAn() {
		if (this.autoModel.getAuto() != null) {
			txtAnzeige.setText(this.autoModel.getAuto().gibAutoZurueck(' '));
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Autos aufgenommen!");
		}
	}

	void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	void zeigeFehlermeldungsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, "Fehler", meldung).zeigeMeldungsfensterAn();
	}

	public TextField getTxtKennzeichen() {
		return txtKennzeichen;
	}

	public void setTxtKennzeichen(TextField txtKennzeichen) {
		this.txtKennzeichen = txtKennzeichen;
	}

	public TextField getTxtVermietetVonBis() {
		return txtVermietetVonBis;
	}

	public void setTxtVermietetVonBis(TextField txtVermietetVonBis) {
		this.txtVermietetVonBis = txtVermietetVonBis;
	}

	public TextField getTxtTagesPreis() {
		return txtTagesPreis;
	}

	public void setTxtTagesPreis(TextField txtTagesPreis) {
		this.txtTagesPreis = txtTagesPreis;
	}

	public TextField getTxtTyp() {
		return txtTyp;
	}

	public void setTxtTyp(TextField txtTyp) {
		this.txtTyp = txtTyp;
	}

	public TextField getTxtModell() {
		return txtModell;
	}

	public void setTxtModell(TextField txtModell) {
		this.txtModell = txtModell;
	}

	public Label getLblEingabe() {
		return lblEingabe;
	}

	public void setLblEingabe(Label lblEingabe) {
		this.lblEingabe = lblEingabe;
	}

	public Label getLblAnzeige() {
		return lblAnzeige;
	}

	public void setLblAnzeige(Label lblAnzeige) {
		this.lblAnzeige = lblAnzeige;
	}

}
