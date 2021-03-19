package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.exceptions.ValidationException;
import model.services.TiragemServicos;

public class TiragemController implements Initializable {

	@FXML
	private TextField txtFormato;
	
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
	
if(testeInicializazaoCaposVaziu() == 0) {
	int formato = Utils.tryParseToInt(txtFormato.getText());
	double acerto = Utils.tryParseToDouble(txtQtdFolhasAcerto.getText());
	double perda = Utils.tryParseToDouble(txtQtdFolhasPerda.getText());
	int montagem = Utils.tryParseToInt(txtMontagem.getText());
	int QtdOrc = Utils.tryParseToInt(txtQtdOrc.getText());
	int corFrente = Utils.tryParseToInt(txtCorFrente.getText());
	int corVerso = Utils.tryParseToInt(txtCorVerso.getText());
	int qtdCorMaq = Utils.tryParseToInt(txtQtdCoresMaquina.getText());
			
	double totaldeFolhas = TiragemServicos.QtdTotalFolhas(perda, acerto, QtdOrc, montagem, formato);
	int multiplicadortiragem = TiragemServicos.multiplicadorTiragem(corFrente, corVerso);
	double tiragemFinal = (TiragemServicos.calculoDeTiragem(totaldeFolhas, multiplicadortiragem, formato));

		
	labelResultado.setText(String.format("%.2f", totaldeFolhas));
}

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
		Constraints.setTextFieldInteger(txtQtdOrc);
		
		//Definindo o tamanho maximo de caracteres que um text pode ter
		Constraints.setTextFieldMaxLength(txtCorFrente, 1);
		Constraints.setTextFieldMaxLength(txtCorVerso, 1);
		Constraints.setTextFieldMaxLength(txtFormato, 1);
		Constraints.setTextFieldMaxLength(txtMontagem, 1);
		Constraints.setTextFieldMaxLength(txtQtdCoresMaquina, 1);
		
		
	}
	
	//Verifica se os campos estão vazio e retorna um erro
	public int testeInicializazaoCaposVaziu() {
		int contadorErros = 0;
		
		if (txtFormato.getText()==null || txtFormato.getText().trim().equals("")) {
			Alerts.showAlert("Campo: Formato", null, "O campo não pode ser vaziu", AlertType.ERROR);
			contadorErros += 1;
		}

		if (txtQtdFolhasAcerto.getText()==null || txtQtdFolhasAcerto.getText().trim().equals("")) {
			Alerts.showAlert("Campo: Qtd Folhas Acerto", null, "O campo não pode ser vaziu", AlertType.ERROR);
			contadorErros += 1;
		}
		
		if (txtQtdFolhasPerda.getText()==null || txtQtdFolhasPerda.getText().trim().equals("")) {
			Alerts.showAlert("Campo: Qtd Folhas Perda", null, "O campo não pode ser vaziu", AlertType.ERROR);
			contadorErros += 1;
		}
		
		if (txtMontagem.getText()==null || txtMontagem.getText().trim().equals("")) {
			Alerts.showAlert("Campo: Montagem", null, "O campo não pode ser vaziu", AlertType.ERROR);
			contadorErros += 1;
		}
		
		if (txtQtdOrc.getText()==null || txtQtdOrc.getText().trim().equals("")) {
			Alerts.showAlert("Campo: Quantidade do orçamento", null, "O campo não pode ser vaziu", AlertType.ERROR);
			contadorErros += 1;
		}
		
		if (txtCorFrente.getText()==null || txtCorFrente.getText().trim().equals("")) {
			Alerts.showAlert("Campo: Cores Frente", null, "O campo não pode ser vaziu", AlertType.ERROR);
			contadorErros += 1;
		}
		
		if (txtCorVerso.getText()==null || txtCorVerso.getText().trim().equals("")) {
			Alerts.showAlert("Campo: Cores Verso", null, "O campo não pode ser vaziu", AlertType.ERROR);
			contadorErros += 1;
		}	
			
		if (txtQtdCoresMaquina.getText()==null || txtQtdCoresMaquina.getText().trim().equals("")) {
			Alerts.showAlert("Campo: Qtd Cores Máquina", null, "O campo não pode ser vaziu", AlertType.ERROR);
			contadorErros += 1;
		}
		return contadorErros;
	}

	//Metodo que inicializa a tela
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		
	}
}
