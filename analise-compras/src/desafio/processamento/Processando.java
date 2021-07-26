package desafio.processamento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import desafio.modulos.DataCsv;

public class Processando {

	public List <DataCsv> arquivoData = new ArrayList<DataCsv>();
	public List <String> amazonUkMarketPlace = new ArrayList<String>();
	public List <String> amazonEu = new ArrayList<String>();
	public List<String> serviceAreaAgrupado = new ArrayList<String>();

	public void Inicia() throws IOException {
		List<String> lendoData = Files.readAllLines(Path.of("c:\\arquivos\\data.txt"));

		lendoData.remove(0);
		// System.out.println(lendoData.size());
		lendoData.remove(4581);

		processandoData(lendoData);

	}

	private void processandoData(List <String> lendoData) {

		for (String linha: lendoData) {

			if (linha.length()==0) {
				lendoData.remove(linha);
			}

			else {
				this.arquivoData.add(new DataCsv(linha));
			}

		}	

	}

	public String valorTotalCompras() {
		double valorTotalCompras = 0;

		for (DataCsv dataCsv: this.arquivoData) {
			valorTotalCompras+= dataCsv.getTotal();
		}

		return String.format("%.2f", valorTotalCompras);

	}
	public List<String> retornandoComprasAmazonUk() {

		for (DataCsv dataCsv: this.arquivoData) {

			if (dataCsv.getCreditor().equalsIgnoreCase("AMAZON UK MARKETPLACE")) {


				this.amazonUkMarketPlace.add("Service Area: "+dataCsv.getServiceArea()+" - Total: "
						+dataCsv.getTotal());


			}

		}

		return this.amazonUkMarketPlace;

	}

	public double maiorValorAmazonUk() {

		double maiorValor= 0;

		for (DataCsv dataCsv: this.arquivoData) {

			if (dataCsv.getCreditor().equalsIgnoreCase("AMAZON UK MARKETPLACE") &&
					dataCsv.getTotal() > maiorValor) {

				maiorValor = dataCsv.getTotal();

			}

		}

		return maiorValor;

	}

	public List<String> valorAtualizadoAmazonEu() {

		for (DataCsv dataCsv: this.arquivoData) {

			if (dataCsv.getCreditor().equalsIgnoreCase("AMAZON EU")) {

				double novoTotal = dataCsv.getTotal() + (dataCsv.getTotal() * 0.05);

				this.amazonEu.add("Creditor: "+dataCsv.getCreditor()
				+" - total: "+dataCsv.getTotal()+" novo total: "+String.format("%.2f", novoTotal));

			}		

		}

		return this.amazonEu;
	}

	public List<String> retornandoServiceAreas(){
		List<String> serviceAreas = new ArrayList<String>();


		for (DataCsv dataCsv: this.arquivoData) {

			if(!serviceAreas.contains(dataCsv.getServiceArea())) {
				serviceAreas.add(dataCsv.getServiceArea());
			}
		}

		return serviceAreas;

	}

	public String agrupandoServiceAreas(String serviceArea) {

		double valorTotalServiceArea  = 0;

		for (DataCsv dataCsv: this.arquivoData) {

			if (dataCsv.getServiceArea().equals(serviceArea)) {

				valorTotalServiceArea += dataCsv.getTotal();

			}
		}


		return String.format("%.2f", valorTotalServiceArea);
	}


	public void gerandoArquivo() throws IOException {

		Files.write(Path.of("c:\\arquivos\\relatorio.txt"),this.amazonEu);
	}


}
