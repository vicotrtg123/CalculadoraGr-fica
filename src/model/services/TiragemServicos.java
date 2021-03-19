package model.services;

import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.QuadCurve;

public class TiragemServicos {

	//Metodo que calcula a quantidade total de folhas 
	public static double QtdTotalFolhas(double perda, double Acerto, int QtdOrcamento, int montagem, int formato) {
		
		if(QtdOrcamento == 0) {
			Alerts.showAlert("Campo: Quantidade do or�amento", null, "Informar um valor diferente de 0", AlertType.ERROR);
		} else if (montagem ==0) {
			Alerts.showAlert("Campo: Quantidade de montagens", null, "Informar um valor diferente de 0", AlertType.ERROR);
		}else if(formato == 0) {
			Alerts.showAlert("Campo: Formato", null, "Informar um valor diferente de 0", AlertType.ERROR);
		}else {

			double imagensPorFolha = montagem * formato;
			double totalDeFolhas= (QtdOrcamento/imagensPorFolha);
			double follhasAdd= perda + Acerto;
			
			return Math.ceil(totalDeFolhas + follhasAdd) ;	
		}
		return 0.0;
		

	}
	//Metodo que calcula a quantidade de entradas na m�quina
	
	public static int QtdEntradasMaq(int corFrente, int corVerso, int QtdCorMaq) {
		int quantidadeDeEntradas = 0;
		
		if((corFrente + corVerso) > QtdCorMaq) {
			quantidadeDeEntradas =2;
		}else {
			quantidadeDeEntradas =1;
		}

		return quantidadeDeEntradas;
		
	}
	//Metodo que verifica quantas cores tem o or�amento para mulltiplicar a tiragem
	public static int multiplicadorTiragem(int corFrente , int corVerso) {
		if(corFrente >= 1 && corVerso >=1) {
			return 2;
		}else {
			return 1;
		}
	}
	//metodo que calcula a tiragem
	public static double calculoDeTiragem(double totalDeFolhas , int multiplicadorTiragem, int formato) {
		return (totalDeFolhas * formato) * multiplicadorTiragem;
	}
	
}
