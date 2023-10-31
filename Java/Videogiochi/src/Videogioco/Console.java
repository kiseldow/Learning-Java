// La classe console contiene il menu di accesso, log in e log out
// deve possedere le liste di tutti i giochi e gli utenti ed un solo admin
package Videogioco;

import java.util.LinkedList;
import java.util.Scanner;

public class Console {
	Admin admin;
	LinkedList<Utente> utenti = new LinkedList<Utente>();
	public LinkedList<Videogioco> catalogo = new LinkedList<Videogioco>();
	Scanner scanner = new Scanner(System.in);
	
	public Console() {
		//inizializzo un utente admin
		admin = new Admin("admin", "admin");
		utenti.add(admin);
	}
	
	public void menu() {
		System.out.println("--------------");
		System.out.println("Benvenuto");
		System.out.println("Effettuare Login? S/N");
		String scelta = scanner.nextLine();
		
		if(scelta.equalsIgnoreCase("s")) {
			Utente utenteLoggato = login();
			if(utenteLoggato != null) {
				mostraMenu(utenteLoggato);
			}
			else {
				System.out.println("Utente non loggato");
			}
		}
	}

	
	public void mostraMenu(Utente utente) {
		System.out.println("Benvenuto, " + utente.getNickname());
		while(true) {
			System.out.println("0) visualizza i Videogiochi del catalogo");
			System.out.println("1) Effettua  o controlla[ADMIN] una richiesta di inserimento nel catalogo");
			System.out.println("2) Aggiungi un gioco al catalogo [ADMIN]");
			System.out.println("3) Elimina videogioco dal catalogo");
			System.out.println("4) Log out");
			System.out.println("5) Log off");
			
			String scelta = scanner.nextLine();
			
			switch(scelta) {
			case "0":
				mostraCatalogo();
				break;
			case "1":
				if(utente instanceof Admin) {
					Videogioco videogioco = admin.controllaRichieste(catalogo, scanner);
					aggiungiAlCatalogo(videogioco);
				} else {
				utente.richiediVideogioco(scanner);
				System.out.println("Richiesta di inserimento nel catalogo effettuata.");
				}
				break;
			case "2":
				System.out.println("Richiesta di inserimento nel catalogo effettuata.");
                if (utente instanceof Admin) {
                    Videogioco videogioco = admin.aggiungiVideogioco(scanner);
                    aggiungiAlCatalogo(videogioco);
                } else {
                    System.out.println("Solo l'admin può aggiungere giochi al catalogo.");
                }
                break;
			case "3":
				mostraCatalogo();
				System.out.println("Inserisci il nome dle videogioco da rimuovere");
				String nome = scanner.nextLine();
				admin.eliminaVideiogoco(catalogo, nome);
			case "4":
				utente.setIsLogged(false);
				System.out.println("Logout effettuato.");
				menu();
				break;
			case "5":
				 System.out.println("Arrivederci!");
				 System.exit(0);
			default:
				System.out.println("Scelta non valida, riprova");
			}
		}
	}	
	
	public Utente login() {
		System.out.println("Inserisci nickname: ");
		String nick = scanner.nextLine();
		System.out.println("Inserisci password: ");
		String userPassword = scanner.nextLine();
		
		for(Utente utente : utenti) {
			if(utente.login(nick, userPassword)) {
				if(!utenti.contains(utente)) {
					utenti.add(utente);
					System.out.println("Utente non ancora registrato");
					System.out.println("Adesso sei stato registrato correttamente");
				}
				else {
					System.out.println("Utente gia` registrato");
					System.out.println("Bentornato!");
				}
				return utente;
			}
		}
		System.out.println("Dai inseriti non corretti, riprova.");
		return null;
	}
	
	public void aggiungiAlCatalogo(Videogioco videogioco) {
		if (videogioco != null) {
			catalogo.add(videogioco);
		}
		else {
			System.out.println("Proposta scartata");
		}
	}
	
	public void mostraCatalogo() {
		System.out.println(" Ecco la lista dei Videogiochi");
		for (Videogioco videogioco : catalogo) {
			System.out.println(videogioco.getNome() + " : Genere " + videogioco.getGenere());
		}
	}
}
