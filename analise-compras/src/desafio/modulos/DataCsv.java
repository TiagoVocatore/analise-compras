package desafio.modulos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataCsv {

	private String serviceArea;
	private String accountDescription;
	private String creditor;
	private LocalDate journalDate;
	private int journalReference;
	private double total;

	public DataCsv() {

	}

	public DataCsv(String linha) {

		String colunas[] = linha.split(";");

		this.serviceArea = colunas[0];
		this.accountDescription = colunas[1];
		this.creditor = colunas[2];
		this.journalDate = LocalDate.parse(colunas[3], DateTimeFormatter.ofPattern("d/M/yyyy"));
		this.journalReference = Integer.parseInt(colunas[4]);
		this.total = Double.parseDouble(colunas[5]);

	}

	public String getServiceArea() {
		return serviceArea;
	}

	public void setServiceArea(String serviceArea) {
		this.serviceArea = serviceArea;
	}

	public String getAccountDescription() {
		return accountDescription;
	}

	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}

	public String getCreditor() {
		return creditor;
	}

	public void setCreditor(String creditor) {
		this.creditor = creditor;
	}

	public LocalDate getJournalDate() {
		return journalDate;
	}

	public void setJournalDate(LocalDate journalDate) {
		this.journalDate = journalDate;
	}

	public int getJournalReference() {
		return journalReference;
	}

	public void setJournalReference(int journalReference) {
		this.journalReference = journalReference;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}


}
