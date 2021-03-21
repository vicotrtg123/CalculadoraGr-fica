package model.services;

import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.QuadCurve;

public class TiragemServicos {

	// Metodo que calcula a quantidade total de folhas
	public static double QtdTotalFolhas(double perda, double Acerto, int QtdOrcamento, int montagem, int formato) {

		if (QtdOrcamento == 0) {
			Alerts.showAlert("Campo: Quantidade do or�amento", null, "Informar um valor diferente de 0",
					AlertType.ERROR);
		} else if (montagem == 0) {
			Alerts.showAlert("Campo: Quantidade de montagens", null, "Informar um valor diferente de 0",
					AlertType.ERROR);
		} else if (formato == 0) {
			Alerts.showAlert("Campo: Formato", null, "Informar um valor diferente de 0", AlertType.ERROR);
		} else {

			double imagensPorFolha = montagem * formato;
			double totalDeFolhas = (QtdOrcamento / imagensPorFolha);
			double follhasAdd = perda + Acerto;

			return Math.ceil(totalDeFolhas + follhasAdd);
		}
		return 0.0;

	}
	// Metodo que calcula a quantidade de entradas na m�quina

	public static int QtdEntradasMaq(int corFrente, int corVerso, int QtdCorMaq) {
		int quantidadeDeEntradas = 0;

		if ((corFrente + corVerso) > QtdCorMaq) {
			quantidadeDeEntradas = 2;
		} else {
			quantidadeDeEntradas = 1;
		}

		return quantidadeDeEntradas;

	}

	// Metodo que verifica quantas cores tem o or�amento para mulltiplicar a tiragem
	public static int multiplicadorTiragem(int corFrente, int corVerso) {
		if (corFrente >= 1 && corVerso >= 1) {
			return 2;
		} else {
			return 1;
		}
	}

	// metodo que calcula a tiragem
	public static double calculoDeTiragem(double totalDeFolhas, int multiplicadorTiragem, int formato) {
		return (totalDeFolhas * formato) * multiplicadorTiragem;
	}

	// Metodo que calcula a quantidade total de folhas para calculos com p�ginas
	public static double QtdTotalFolhasPaginas(double perda, double Acerto, int QtdOrcamento, int montagem, int formato,
			int qtdPaginas, boolean mioloDobrado, int frenteVerso) {
		int verificaFV = 0;

		if (QtdOrcamento == 0) {
			Alerts.showAlert("Campo: Quantidade do or�amento", null, "Informar um valor diferente de 0",
					AlertType.ERROR);
		} else if (montagem == 0) {
			Alerts.showAlert("Campo: Quantidade de montagens", null, "Informar um valor diferente de 0",
					AlertType.ERROR);
		} else if (formato == 0) {
			Alerts.showAlert("Campo: Formato", null, "Informar um valor diferente de 0", AlertType.ERROR);
		} else if (qtdPaginas == 0) {
			Alerts.showAlert("Campo: Qtd P�ginas", null, "Informar um valor diferente de 0", AlertType.ERROR);
		} else {

			if (frenteVerso == 2) {
				verificaFV = 2;
			} else {
				verificaFV = 1;
			}

			if (mioloDobrado == false) {
				double paginasPorFolha = (montagem * formato) * verificaFV;
				double totalPaginas = qtdPaginas * QtdOrcamento;
				double folhasTotais = totalPaginas / paginasPorFolha;
				double folhasAdd = Acerto + perda;

				return Math.ceil(folhasTotais + folhasAdd);
			} else {

				if (frenteVerso == 2) {
					verificaFV = 2;
				} else {
					verificaFV = 1;
				}

				double paginasPorFolha = ((montagem * formato) * 2) * verificaFV;
				double totalPaginas = qtdPaginas * QtdOrcamento;
				double folhasTotais = totalPaginas / paginasPorFolha;
				double folhasAdd = Acerto + perda;

				return Math.ceil(folhasTotais + folhasAdd);

			}

		}
		return 0.0;

	}

	// metodo que calcula a quantidade de entradas na m�quina
	public static int qtdEntradas(int corFrente, int corVerso, int qtdCoresMaquina) {
		int qtdTotalCores = corFrente + corVerso;

		if (qtdTotalCores > qtdCoresMaquina) {
			return qtdTotalCores / qtdCoresMaquina;
		} else {
			return 1;
		}
	}

	// metodo que calcula a tiragem de or�amentos com p�ginas
	public static double calculoDeTiragemPaginas(double totalDeFolhas, int qtdEntradas, int formato) {
		return (totalDeFolhas * formato) * qtdEntradas;
	}

}
