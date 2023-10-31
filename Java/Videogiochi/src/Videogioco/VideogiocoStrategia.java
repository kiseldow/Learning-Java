package Videogioco;

public class VideogiocoStrategia extends Videogioco{

	public VideogiocoStrategia(String nome, String genere) {
		super(nome, genere);
		
	}

	public void gioca() {
		System.out.println("Stai giocando a " + nome + " :Strategia");
	}
	
	public void pianifica() {
		System.out.println("Pianificazione strategica in corso...");
	}
}
