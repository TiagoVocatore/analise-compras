package desafio.executavel;

import java.io.IOException;
import java.util.List;

import desafio.processamento.Processando;


public class Principal {

	public static void main(String[] args) throws IOException {

		Processando processando = new Processando();

		processando.Inicia();
		
		System.out.println("Valor total de compras realizadas: ");
		System.out.println(processando.valorTotalCompras());
		
		System.out.println("\nRetornando as compras do creditor Amazon Uk Marketplace: ");
		List<String> amazonUk = processando.retornandoComprasAmazonUk();
		for (String linha: amazonUk) {
			System.out.println(linha);
		}

		System.out.println("\nRetornando o maior valor do Amazon Uk Marketplace: ");
		System.out.println(processando.maiorValorAmazonUk());

		System.out.println("\nRetornando o total de compras do creditor Amazon EU acrecido 5%: ");
		List<String> amazonEu = processando.valorAtualizadoAmazonEu();
		for (String linha: amazonEu) {
			System.out.println(linha);
		}

		System.out.println("\nRetornando o valor total de cada Service Area: ");
		List<String> serviceAreas = processando.retornandoServiceAreas();
		for (String serviceArea: serviceAreas) {
			System.out.println("Valor total do Service Area "+serviceArea
					+": "+processando.agrupandoServiceAreas(serviceArea));	
		}


		processando.gerandoArquivo();
	}

}
