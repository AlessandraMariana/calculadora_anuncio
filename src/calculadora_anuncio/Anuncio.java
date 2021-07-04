package calculadora_anuncio;

public class Anuncio {
	public String nome_anuncio;
	public String cliente;
	public String data_inicio;
	public String data_termino;
	int investimento_dia;
	
	int converter_data(String data) {
		int data_convertida;
		String[] data_atual = data.split("/");
		int dia_data_atual = Integer.parseInt(data_atual[0]);
		int mes_data_atual = Integer.parseInt(data_atual[1]);
		int ano_data_atual = Integer.parseInt(data_atual[2]);
		
		data_convertida = dia_data_atual + (mes_data_atual * 30) + (ano_data_atual * 365);
		return data_convertida;
	}
	
	void calcular_alcance(int investimento_total) {
		int visualizacoes = 0;
		int novas_visualizacoes = 0;
		int cliques = 0;
		int compatilhamentos = 0;
		int contador = 0;
		
		visualizacoes = investimento_total * 30;
		novas_visualizacoes = visualizacoes;
		
		while ((contador < 4) && (novas_visualizacoes >= 100)){
		  cliques = (novas_visualizacoes / 100) * 12;
		    
		  if (cliques >= 20) {  
			 compatilhamentos = (cliques / 20) * 3;
		  }
		
		  visualizacoes = visualizacoes + (compatilhamentos * 40);
		  novas_visualizacoes = compatilhamentos * 40;
		  contador = contador + 1;
		}
		
		
		
		System.out.printf("Projeção aproximada da quantidade máxima de pessoas que visualizarão o mesmo anúncio: %d\n", (visualizacoes));
	  }
	
	//                             Data no formato: dd/mm/AAAA
	public static int calcular_data(String data1, String data2) {
		
		String[] data_inicio = data1.split("/");
		String[] data_fim = data2.split("/");
		int dia_data_inicio = Integer.parseInt(data_inicio[0]);
		int mes_data_inicio = Integer.parseInt(data_inicio[1]);
		int ano_data_inicio = Integer.parseInt(data_inicio[2]);
		int dia_data_fim = Integer.parseInt(data_fim[0]);
		int mes_data_fim = Integer.parseInt(data_fim[1]);
		int ano_data_fim = Integer.parseInt(data_fim[2]);
		int dia_resultado, mes_resultado, ano_resultado;
		
		ano_resultado = ano_data_fim - ano_data_inicio;
		mes_resultado = mes_data_fim - mes_data_inicio;
		
		dia_resultado = dia_data_fim - dia_data_inicio;
		dia_resultado = dia_resultado + mes_resultado * 30;
		dia_resultado = dia_resultado + ano_resultado * 365;
		
		return dia_resultado;
	}
	
	
}

