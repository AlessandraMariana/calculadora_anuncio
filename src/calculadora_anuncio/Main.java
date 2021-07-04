package calculadora_anuncio;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Anuncio Modelo = new Anuncio();
		ArrayList<Anuncio> todos_os_anuncios = new ArrayList<Anuncio>();
		int aux_data_inicio_filtro, aux_data_fim_filtro, aux_data_inicio, aux_data_fim;
		int dias_totais = 0;
		int opcao = 0;
		int	opcao_filtro = 0;
		String data_inicial_filtragem = "";
		String data_final_filtragem = "";
		
		
		
		while (opcao != 3){	
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("-------------AGÊNCIA DIVULGA TUDO ----------------------");
			System.out.println("-------------Selecione sua opção ----------------------");
			System.out.println("OPÇÃO 1: CADASTRAR NOVO ANÚNCIO");
			System.out.println("OPÇÃO 2: VISUZALIZAR RELATÓRIO DE ANÚNCIO");
			System.out.println("OPÇÃO 3: SAIR");
			opcao = input.nextInt();
			
			if (opcao == 1) {
				
				System.out.println("-------------CADASTRO DE ANUNCIO----------------------");
				
				System.out.println("Digite o nome do anúncio: \n");
				Modelo.nome_anuncio = input.nextLine();
				
				System.out.println("Digite o nome do cliente: ");
				Modelo.cliente = input.nextLine();
				
				System.out.println("Digite a data de início(formato: dd/mm/aaaa): ");
				Modelo.data_inicio = input.nextLine();
				
				System.out.println("Digite a data de término(formato: dd/mm/aaaa): ");
				Modelo.data_termino = input.nextLine();
				
				System.out.println("Digite o valor do investimento diário: ");
				Modelo.investimento_dia = input.nextInt();
				
				todos_os_anuncios.add(Modelo);
				dias_totais = Anuncio.calcular_data(Modelo.data_inicio, Modelo.data_termino);
				System.out.printf("Total de dias: %d\n", dias_totais);
				
			} else if(opcao == 2) {
				System.out.println("-------------RELATÓRIO DE ANÚNCIOS----------------------");
				System.out.println("-------Selecione o tipo de filtragem--------------------\n");
				System.out.println("OPÇÃO 1: Por intervalo de tempo");
				System.out.println("OPÇÃO 2: Por cliente\n");
				
				if (opcao_filtro == 1) {
					
					System.out.println("Data inicial de filtragem: ");
					data_inicial_filtragem = input.nextLine();
					System.out.println("Data Final de filtragem: ");
					data_final_filtragem = input.nextLine();
					
					
					
					for (int i = 0; i < todos_os_anuncios.size(); i++) {
						aux_data_inicio = Modelo.converter_data(todos_os_anuncios.get(i).data_inicio);
						aux_data_fim = Modelo.converter_data(todos_os_anuncios.get(i).data_termino);
						
						if ((aux_data_inicio_filtro >= aux_data_inicio) && (aux_data_fim_filtro <= aux_data_fim)){
							System.out.println("Cliente: \n");
							System.out.println("Valor total investido: " + (dias_totais * todos_os_anuncios.get(i).investimento_dia));
							System.out.println("Qtd máx de visualizações: " + (todos_os_anuncios.get(i).calcular_alcance(todos_os_anuncios.get(i).investimento_dia)));
						}
						
						
						
						
					}
					
					
					
				} else if (opcao_filtro == 2) {
					
				} else {
					System.out.printf("Opção inválida");
				}
				
				
				
				System.out.println("-------Selecione o tipo de filtragem--------------------\n");
				for (int i = 0; i < todos_os_anuncios.size(); i++) {
					System.out.printf("Anuncio %d: " + todos_os_anuncios.get(i).cliente + "\n", i+1);
				}
				opcao_anuncio = input.nextInt();
				
			} else if(opcao == 3){
				
			} else {
				System.out.println("\n\n-----------------Opção Inválida, tente novamente!----------------------- \n\n\n\n");
			}
			
			
			
		}
		
		
		
		Anuncio.calcular_alcance(Modelo.investimento_dia);
	}
}


