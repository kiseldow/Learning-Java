package Libreria;

import java.util.ArrayList;
import java.util.List;

public class Test {

	final static int nLibri = 10;
	final static int nUtenti = 3;
	final static int nRecensioni = 15;

	public static void main(String[] args) {

		List<Libro> libri = new ArrayList<>();
		
		for (int i = 1; i < nLibri; i++) {
			String nome = "Libro" + i;
			String autore;
			String genere;
			if(i <= 3) {
				autore = "Autore" + 1;
				genere = "Genere" + 1;
			}
			else if (i <= 6) {
				autore = "Autore" + 2;
				genere = "Genere" + 2;
			}
			else {
				autore = "Autore" + 3;
				genere = "Genere" + 3;
			}
			
			
			libri.add(new Libro(i, nome, autore, genere));			
		}
		
		//Utente utente = new Utente(1, "UtenteTest");
		List<Utente> utenti = new ArrayList<>();
		for (int i = 1; i <= nUtenti; i++) {
			utenti.add(new Utente(i, "Utente"+i));			
			
		}
		
				
		List<Recensione> recensioni = new ArrayList<>();
		
		for (int i = 1; i < nRecensioni; i++) {
			Utente u = utenti.get(((int)(Math.random()*(nUtenti))));
			Libro l = libri.get(((int)(Math.random()*(nLibri-1))));
			u.acquistaLibro(libri, l.getTitolo());
			recensioni.add(new Recensione(u, l, ((int)(Math.random()*5)+1), "Recensione"+i));
		}
		
		for (Recensione recensione : recensioni) {
			System.out.println(recensione);
		}
		
		LibreriaOnline libreriaOnline = new LibreriaOnline();
		
		libreriaOnline.setListaLibri(libri);
		libreriaOnline.setListaRecensioni(recensioni);

		List<Libro> libriPopolari = libreriaOnline.libriPopolari();
		
		System.out.println("LIBRI DISPONIBILI");
		for (Libro libro : libri) {
			System.out.println(libro + " Valutazione media: " + libreriaOnline.valutazioneMedia(libro));
		}
		System.out.println("LIBRI POPOLARI");
		for (Libro libro : libriPopolari) {
			System.out.println(libro + " Valutazione media: " + libreriaOnline.valutazioneMedia(libro));
			
		}
		
		List<Libro> testRacc = libreriaOnline.raccomandaLibri(utenti.get(0));
		System.out.println(utenti.get(0).getNome());
		System.out.println("LIBRI RACCOMANDATI");
		for (Libro libro : testRacc) {
			libro.mostraDettagli();
		}
	}

}