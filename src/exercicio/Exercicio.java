package exercicio;

import java.util.GregorianCalendar;

import utilitarios.Console;
import utilitarios.LtpUtil;

public class Exercicio {

	public static void main(String[] args) {
		menu();
		System.out.println("\nFinal dos testes.");
		System.exit(0);
	}

	private static void menu() {
		int opcao = 0;
		do{
			System.out.println("\nMENU DOS EXERC�CIOS DE DATAS");
			System.out.println("1 - Dia da semana");
			System.out.println("2 - Diferen�a em dias");
			System.out.println("3 - Adicionar dias na data");
			System.out.println("4 - Data e Hora");
			System.out.println("0 - Sair");
			opcao = Console.readInt("Informe a Op��o: ");
			switch (opcao){
			case 1:
				diaSemana();
				break;
			case 2:
				difDatasDias();
				break;
			case 3:
				addDiasData();
				break;
			case 4:
				dataHora();
				break;
			case 0: break;
			default:
				System.out.println("OP��O INV�LIDA");
				break;
			}
		}while (opcao!=0);
		
	}

	private static void dataHora() {
		System.out.println("\nReceber e validar Data e Hora\n");
		String dataHora;
		GregorianCalendar objHorario = new GregorianCalendar();
		while (true){
			dataHora = Console.readLine("Date e Hora: d/M/a h:m:s ");
			if (!LtpUtil.validarDataHora(dataHora, objHorario)){
				System.out.println("Data hora inv�lido. ");
				continue;
			}else{
				
			}
					
		}
		
	}

	private static void addDiasData() {
		System.out.println("\nADICIONAR DIAS NA DATAS\n");
		String data;
		GregorianCalendar objData = new GregorianCalendar();
		int ano = new GregorianCalendar().get(GregorianCalendar.YEAR);
		int mes = new GregorianCalendar().get(GregorianCalendar.MONTH);
		int dia = new GregorianCalendar().get(GregorianCalendar.DAY_OF_MONTH);
		GregorianCalendar dataHoje = new GregorianCalendar(ano, mes, dia);
		while(true){
			data = Console.readLine("informar a data: ");
			if (!LtpUtil.validarData(data, objData)){
				System.out.println("DATA INV�LIDA.");
				continue;
			}else{
				if(objData.compareTo(dataHoje)>=0){
					break;
				}else{
					System.out.println("DATA INFERIOR A DATA CORRENTE.");
				}
			}
		}
		int numDias = Console.readInt("Informe o n� de dias: ");
		GregorianCalendar objDataResp = (GregorianCalendar)objData.clone();
		objDataResp.add(GregorianCalendar.DAY_OF_MONTH, numDias);
		System.out.println("Data Resposta: " + LtpUtil.formatarData(objDataResp, "dd/MM/yyyy EEEE"));
		
	}

	private static void difDatasDias() {
		System.out.println("\nDIFEREN�A DE DATAS EM DIAS\n");
		String data;
		GregorianCalendar objDataInicial = new GregorianCalendar();
		GregorianCalendar objDataFinal = new GregorianCalendar();
		while (true) {
			data = Console.readLine("INFORME A DATA INICIAL: ");
			if (!LtpUtil.validarData(data, objDataInicial)){
				System.out.println("DATA INICIAL INV�LIDA");
				continue;
			}
			data = Console.readLine("INFORME A DATA FINAL: ");
			if (!LtpUtil.validarData(data, objDataFinal)){
				System.out.println("DATA FINAL INV�LIDA");
				continue;
			}
			if (objDataFinal.after(objDataInicial)){
				break;
			}else{
				System.out.println("DATA FINAL TEM QUE SER MAIOR QUE A INICIAL");
			}
		}
		long dias = (objDataFinal.getTimeInMillis() - objDataInicial.getTimeInMillis())/86400000;
		System.out.println("Dias: " + dias);
		
	}

	private static void diaSemana() {
		System.out.println("\nDIA DA SEMANA\n");
		
		String data;
		GregorianCalendar objData = new GregorianCalendar();
		while(true){
			data = Console.readLine("Informe a data: dd/mm/aaaa ");
			if(LtpUtil.validarData(data, objData)){
				break;
			}else{
				System.out.println("Data Inv�lida.");
			}
		}
		//System.out.println("Dia da semana:");
		
	}
	
	

}
