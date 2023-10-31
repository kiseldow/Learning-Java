package Libreria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utente {
	Integer id;
	String nome;
	String email;
	List<Libro> libriAcquistati = new ArrayList<>();
	
	public Utente(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
		email = nome + id + "@gmail.com";
	}
	
	public void acquistaLibro(List<Libro> listaLibri, String libroScelto) {
		boolean libroTrovato = false;
		for(Libro libro : listaLibri) {
			if(libro.getTitolo().equalsIgnoreCase(libroScelto)) {
				System.out.println("Libro presente nel catalogo");
				Libro copiaLibro = libro;
				libriAcquistati.add(copiaLibro);
				System.out.println("copia aggiunta alla libreria dell'utente");
				libroTrovato = true;
				break;
			}
			if(!libroTrovato) {
				System.out.println("Libro non presente nel catalogo.");
			}
		}
	}
	
	public void mostraDettagli() {
		System.out.println(id + " - " + nome + " - " + email + " - ");
	}
	
	public Recensione lasciaRecensione(Scanner scanner) {
		System.out.println("Digitare il nome del libro tra quelli che hai acquistato:");
		mostraLibreria();
		String titolo = scanner.nextLine();
		Libro libroDaRecensire = null;
		for(Libro libro : libriAcquistati) {
			if(libro.getTitolo().equalsIgnoreCase(titolo)) {
				 libroDaRecensire = libro;
			}
			else {
				System.out.println("Titolo non presente nella tua libreria");
				lasciaRecensione(scanner);
			}
		}
		System.out.println("Digitare valutazione da 0 a 5");
		Integer valutazione;
		while (!scanner.hasNextInt()) {
            System.out.println("Devi inserire un numero intero.");
            System.out.print("Inserisci un numero da 0 a 5: ");
            scanner.next(); // pulisco buffer
        }
        valutazione = scanner.nextInt();
        System.out.println("Lascia un commento!");
        String commento = scanner.nextLine();
        System.out.println("Ecco i dettagli della tua recensione:");
        System.out.println(titolo + "- Valutazione: " + valutazione + " - " + commento);
        Recensione recensione = new Recensione(this, libroDaRecensire, valutazione, commento);
        return recensione;
    }
	

	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	
	public void mostraLibreria() {
		for(Libro libro : libriAcquistati) {
			System.out.println("-------------");
			libro.mostraDettagli();
		}
	}
}
