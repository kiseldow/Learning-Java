// La classe videogioco e` la generalizzazione base
// essendo ogni gioco dotato di genere
// ogni gioco dovra` estendere la classe Videogioco

package Videogioco;

public class Videogioco {
	String nome;
	String genere;
	
	public Videogioco(String nome, String genere) {
		this.nome = nome;
		this.genere = genere;
	}
	
	private void gioca() {
		System.out.println("Stai giocando a " + nome);
	}
	
	//setter e getter
	public void dettagli() {
		System.out.println("Nome del videogioco: " + nome);
	    System.out.println("Genere del videogioco: " + genere);
		
	}

	public String getNome() {
		
		return this.nome;
	}
	public String getGenere() {
		return this.genere;
	}
}
