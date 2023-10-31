package Ristorante;

public class Tavolo {
	private int id;
	private int numeroPosti;
	private boolean stato;
	
	public Tavolo(int id, int numeroPosti, boolean stato) {
		this.id = id;
		this.numeroPosti = numeroPosti;
		this.stato = false;
	}
	
	
	//Metodi getter
	public int getId() {
		return id;
	}
	
	public int getNumeroPosti() {
		return numeroPosti;
	}
	
	public boolean getStato() {
		return stato;
	}
	
	//Metodi setter
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNumeroPosti(int posti) {
		this.numeroPosti = posti;
	}
	
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	
	public String dettagli() {
	    String statoTavolo = (stato) ? "Occupato" : "Libero";
	    return "Tavolo #" + id + ", Numero posti: " + numeroPosti + ", Stato: " + statoTavolo;
	}
}
