package Videogioco;

public class VideogiocoAzione extends Videogioco {

	public VideogiocoAzione(String nome, String genere) {
		super(nome, genere);
		
	}
	
	public void gioca() {
		System.out.println("Stai giocando a " + nome + " :Azione");
	}
	
	public void combatti() {
		System.out.println("Combattimento in corso...");
	}
}
