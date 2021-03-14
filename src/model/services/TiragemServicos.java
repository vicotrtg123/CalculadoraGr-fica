package model.services;

import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.QuadCurve;

public class TiragemServicos {

	//Metodo que calcula a quantidade total de folhas 
	public static double QtdTotalFolhas(double perda, double Acerto, int QtdOrcamento, int montagem, int formato) {
		
		if(QtdOrcamento == 0) {
			Alerts.showAlert("Campo: Quantidade do orçamento", null, "Informar um valor diferente de 0", AlertType.ERROR);
		} else if (montagem ==0) {
			Alerts.showAlert("Campo: Quantidade de montagens", null, "Informar um valor diferente de 0", AlertType.ERROR);
		}else if(formato == 0) {
			Alerts.showAlert("Campo: Formato", null, "Informar um valor diferente de 0", AlertType.ERROR);
		}else {

			int imagensPorFolha = montagem * formato;
			double totalDeFolhas= (QtdOrcamento/imagensPorFolha) + perda + Acerto;
			
			
			return totalDeFolhas;	
		}
		return 0.0;

	}
	//Metodo que calcula a quantidade de entradas na máquina
	
	public static int QtdEntradasMaq(int corFrente, int corVerso, int QtdCorMaq) {
		int quantidadeDeEntradas = 0;
		
		if((corFrente + corVerso) > QtdCorMaq) {
			quantidadeDeEntradas =2;
		}else {
			quantidadeDeEntradas =1;
		}

		return quantidadeDeEntradas;
		
	}
	
}
