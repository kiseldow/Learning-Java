// l'admin deve avere la possibilita` di creare le istanze di videogiochi
// in base alle richieste dell'utente. Quindi ricevera` un oggetto videogioco
// lo trasformera`in un Videgioco[GENBERE] in base ai parametri ricevuti
package Videogioco;

import java.util.LinkedList;
import java.util.Scanner;

public class Admin extends Utente {
	
	public LinkedList<Videogioco> richieste = new LinkedList<Videogioco>();
	
	public Admin(String nickname, String password) {
		super(nickname, password);
	}
	
	public Videogioco aggiungiVideogioco(Scanner scanner) {
		System.out.println("Inserisci nome del gioco: ");
		String nome = scanner.nextLine();
		System.out.println("Inserisci genere del gioco: ");
		String genere = scanner.nextLine();
		if(genere.equalsIgnoreCase("azione")) {
			VideogiocoAzione videogioco = new VideogiocoAzione(nome, genere);
			return videogioco;
		}
		else if (genere.equalsIgnoreCase("strategia")) {
			VideogiocoStrategia videogioco = new VideogiocoStrategia(nome, genere);
			return videogioco;
		} else {
			System.out.println("Genere non valido");
			return null;
		}
	}
	
	
	public Videogioco controllaRichieste(LinkedList richieste, Scanner scanner) {
		
		// admin puo` scegliere se accettare o rifiutare la richiesta
		//Estraggo la prima richiesta di aggiunta di videogioco
		// e creo l'istanza corretta in base al genere selezionato
		// infine aggiungo il gioco al catalogo
		
		System.out.println("Ecco la prima richiesta in lista: ");
		Videogioco videogioco = (Videogioco) richieste.pop();
		videogioco.dettagli();
		System.out.println("Accettare o scartare il gioco? S/N");
		// metodo per inserire input utente
		
		String scelta = scanner.nextLine();
		if (scelta.equalsIgnoreCase("s")) {
			// decido se generare OGGETTO gioco d'azione o di strategia
			if(videogioco.getGenere().equalsIgnoreCase("azione")) {
				VideogiocoAzione videogiocoAzione = new VideogiocoAzione(videogioco.getNome(), videogioco.getGenere());
				System.out.println(videogiocoAzione.getNome() + " e` un nuovo gioco d'azione da aggiungere al catalogo.");
				return videogiocoAzione;
			}
			else if (videogioco.getGenere().equals("strategia")) {
				VideogiocoStrategia videogiocoStrategia = new VideogiocoStrategia(videogioco.getNome(), videogioco.getGenere());
				System.out.println(videogiocoStrategia.getNome() + " e` un nuovo gioco di strategia da aggiungere al catalogo.");
				return videogiocoStrategia;
			}
		}
		else if (scelta.equalsIgnoreCase("n")) {
			System.out.println("Videogioco scartato.");
			System.out.println("Visualizzare prossima richiesta? S/N");
			scanner.nextLine();
			if (scanner.nextLine().equalsIgnoreCase("s")) {
				// richiamo la funzione
				controllaRichieste(richieste, scanner);
			}
			else if (scelta.equalsIgnoreCase("n")) {
				return null;
			}
		}
		System.out.println("Errore di digitazione, ritenta");
		return controllaRichieste(richieste, scanner);
	}
	
	
	//metodo di eliminazione
	public Videogioco eliminaVideiogoco(LinkedList<Videogioco> catalogo, String nome) {
		for(Videogioco videogioco : catalogo) {
			if (videogioco.getNome().equalsIgnoreCase(nome)) {
				catalogo.remove(videogioco);
				return videogioco;
			}
		}
		System.out.println("Videogioco non trovato");
		return null;
	}
	
	//setter e getter
}
