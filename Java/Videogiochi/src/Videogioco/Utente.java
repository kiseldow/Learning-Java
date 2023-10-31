// ogni utente ha un nickname e una password e puo` richiedere i videogiochi
package Videogioco;

import java.util.Scanner;

public class Utente {
	
	String nickname;
	String password;
	boolean isLogged = false;
	
	public Utente(String nickname, String password) {
		this.nickname = nickname;
		this.password = password;
	}
	
	
	public Videogioco richiediVideogioco(Scanner scanner){
		System.out.println("Inserisci nome del gioco: ");
		String nome = scanner.nextLine();
		System.out.println("Inserisci genere del gioco: ");
		String genere = scanner.nextLine();
		Videogioco videogioco = new Videogioco(nome, genere);
		return videogioco;
	}
	
	//setter e getter
	
	//Metodo per simulare l'accesso alla piattaforma
	//L'utente accede se digita correttamente i suoi dati di accesso
	public boolean login(String nick, String userPassword) {
		
		if(nick.equals(nickname)&& userPassword.equals(password)) {
			System.out.println("Login effettuato");
			setIsLogged(true);
			return true;
		}
		else{
			System.out.println("Dati inseriti non corretti, riprova");
			setIsLogged(false);
			return false;
		}	
	}
	public void setIsLogged(boolean b) {
		isLogged = b;
	}
	public String getNickname() {
		return nickname;
	}
}
