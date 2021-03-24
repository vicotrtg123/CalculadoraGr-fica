package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TiragemOpcoesController implements Initializable{

	@FXML
	private Button btTiragem;
	
	@FXML
	private Button btTiragemMiolo;
	
	@FXML
	private Button btTiragemFlexo;
	
	@FXML
	public void onBtTiragemFlexoAction(ActionEvent evento) {
		Stage parenteStage = Utils.currentStage(evento);
		
		criarTelaCalculoTiragemFlexo("/gui/TiragemFlexo.fxml", parenteStage);
	}
	
	@FXML
	public void onBtTiragemAction(ActionEvent evento) {
		Stage parenteStage = Utils.currentStage(evento);
		
		criarTelaCalculoTiragem("/gui/Tiragem.fxml", parenteStage);
	}
	
	@FXML
	public void onBtTiragemMioloAction(ActionEvent evento) {
		Stage parenteStage = Utils.currentStage(evento);
		
		criarTelaCalculoTiragemMiolo("/gui/TiragemMiolo.fxml", parenteStage);
		
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	//Metodo que abre a tela do calculo da tiragem
	private void criarTelaCalculoTiragem(String nomeAbsoluto, Stage parentstage) {
		try {
			FXMLLoader loader =  new FXMLLoader(getClass().getResource(nomeAbsoluto));
			Pane pane = loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Digite os dados para o calculo da tiragem");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(true);
			dialogStage.initOwner(parentstage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
			
			
		}
		catch (IOException e) {
			Alerts.showAlert("Erro", "Erro para criar a janela de calculo de Tiragem", e.getMessage(), AlertType.ERROR);
		}
		
		
	}
	//Metodo que cria a tela do calculo de tiragem Miolo
	private void criarTelaCalculoTiragemMiolo(String nomeAbsoluto, Stage parentstage) {
		try {
			FXMLLoader loader =  new FXMLLoader(getClass().getResource(nomeAbsoluto));
			Pane pane = loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Digite os dados para o calculo da tiragem");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(true);
			dialogStage.initOwner(parentstage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
			
			
		}
		catch (IOException e) {
			Alerts.showAlert("Erro", "Erro para criar a janela de calculo de TiragemMiolo", e.getMessage(), AlertType.ERROR);
		}
		
		
	}
	
	//Metodo que cria a tela do calculo de tiragem Flexo
		private void criarTelaCalculoTiragemFlexo(String nomeAbsoluto, Stage parentstage) {
			try {
				FXMLLoader loader =  new FXMLLoader(getClass().getResource(nomeAbsoluto));
				Pane pane = loader.load();
				
				Stage dialogStage = new Stage();
				dialogStage.setTitle("Digite os dados para o calculo da tiragem");
				dialogStage.setScene(new Scene(pane));
				dialogStage.setResizable(true);
				dialogStage.initOwner(parentstage);
				dialogStage.initModality(Modality.WINDOW_MODAL);
				dialogStage.showAndWait();
				
				
			}
			catch (IOException e) {
				Alerts.showAlert("Erro", "Erro para criar a janela de calculo de TiragemMiolo", e.getMessage(), AlertType.ERROR);
			}
			
			
		}
}
