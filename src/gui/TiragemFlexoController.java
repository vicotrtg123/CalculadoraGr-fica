package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TiragemFlexoController implements Initializable{

	@FXML
	private TextField txtAltura;
	
	@FXML
	private TextField txtQtdOrc;
	
	@FXML
	private TextField txtMontagem;
	
	@FXML
	private TextField txtCorFrente;
	
	@FXML
	private TextField txtCorVerso;
	
	@FXML
	private TextField txtQtdCoresMaquina;
	
	@FXML
	private TextField txtQtdFolhasAcerto;
	
	@FXML
	private TextField txtQtdFolhasPerda;
	
	@FXML
	private Label labelResultado;
	
	@FXML
	private Button btCalcular;
	
	@FXML
	private CheckBox checkTiraRetira;
	
	//Metodo do botão calcular
	@FXML
	public void onBtCalcularAction() {
	}
	
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
