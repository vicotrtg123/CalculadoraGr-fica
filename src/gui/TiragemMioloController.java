package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TiragemMioloController implements Initializable {

	@FXML
	private TextField txtFormato;
	
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
	
	@FXML
	private TextField txtQtdPaginas;
	
	@FXML
	public void onBtCalcularAction() {
		
			System.out.println(checkTiraRetira.selectedProperty().getValue());
	
		
	}
	
	
	//Metodo que define caracteristicas da inicialização da tela
	private void initializeNodes() {
		//Definindo o que cada text pode receber
		Constraints.setTextFieldInteger(txtCorFrente);
		Constraints.setTextFieldInteger(txtCorVerso);
		Constraints.setTextFieldInteger(txtFormato);
		Constraints.setTextFieldInteger(txtMontagem);
		Constraints.setTextFieldInteger(txtQtdCoresMaquina);
		Constraints.setTextFieldDouble(txtQtdFolhasAcerto);
		Constraints.setTextFieldDouble(txtQtdFolhasPerda);
		Constraints.setTextFieldInteger(txtQtdPaginas);
		
		//Definindo o tamanho maximo de caracteres que um text pode ter
		Constraints.setTextFieldMaxLength(txtCorFrente, 1);
		Constraints.setTextFieldMaxLength(txtCorVerso, 1);
		Constraints.setTextFieldMaxLength(txtFormato, 1);
		Constraints.setTextFieldMaxLength(txtMontagem, 1);
		Constraints.setTextFieldMaxLength(txtQtdCoresMaquina, 1);
		Constraints.setTextFieldMaxLength(txtQtdPaginas, 6);
		
		
	}

	//Metodo que inicializa a tela
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		
	}

}
