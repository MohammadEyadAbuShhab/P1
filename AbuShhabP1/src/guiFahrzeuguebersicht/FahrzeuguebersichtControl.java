/**
 * 
 */
package guiFahrzeuguebersicht;

import business.AutoModel;
import javafx.stage.Stage;
import ownUtil.Observer;

/**
 * @author Student

 *
 */
public class FahrzeuguebersichtControl implements Observer {
	private FahrzeuguebersichtView fahrzeuguebersichtView;
	private AutoModel autosModel;
	
	public FahrzeuguebersichtControl(Stage primaryStage){
		this.autosModel = AutoModel.getAutoModel(); 		
		this.fahrzeuguebersichtView = new FahrzeuguebersichtView(this, primaryStage, autosModel);
		autosModel.addObserver(this);
	}
	@Override
	public void update() {
		fahrzeuguebersichtView.zeigeAutosAn();
		
	}

}
