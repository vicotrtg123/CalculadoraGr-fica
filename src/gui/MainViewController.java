package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemTiragem;
	
	@FXML
	private MenuItem menuItemAjuda;
	
	
	@FXML
	public void onMenuItemTiragemAction(ActionEvent event) {
		loadView("/gui/TiragemOpcoes.fxml");
	}
	
	@FXML
	public void onMenuItemAjudaAction() {
		loadView("/gui/About.fxml");
	}
	
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

	private synchronized void loadView(String nomeAbsoluto) {
		try {
			FXMLLoader loader =  new FXMLLoader(getClass().getResource(nomeAbsoluto));
			VBox novoVbox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainVbox =(VBox) ((ScrollPane)mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVbox.getChildren().get(0);
			mainVbox.getChildren().clear();
			mainVbox.getChildren().add(mainMenu);
			mainVbox.getChildren().addAll(novoVbox.getChildren());
		}
		catch (IOException e) {
			Alerts.showAlert("Erro", "Erro para carregar a view", e.getMessage(), AlertType.ERROR);
		}
	}
	
}
