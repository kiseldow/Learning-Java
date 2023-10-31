package Libreria;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class LibreriaOnline {
	public List<Utente> listaUtenti = new ArrayList<>();
	public List<Libro> listaLibri = new ArrayList<>();
	public List<Recensione> listaRecensioni = new ArrayList<>();
	
	public void interfaccia() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Benvenuto!!");
        boolean continua = true;
        
        while (continua) {
            System.out.println("Opzioni:");
            System.out.println("1. Aggiungi utente");
            System.out.println("2. Aggiungi libro");
            System.out.println("3. Aggiungi recensione");
            System.out.println("6. Fatti consigliare un libro");
            System.out.println("4. Mostra libri e utenti");
            System.out.println("5. Esci");
            System.out.print("Seleziona un'opzione: ");

            int scelta = scanner.nextInt();
            
            switch(scelta) {
	            case 1:
	                // Aggiungi un utente
	            	System.out.println("Inserisci ID utente");
	            	Integer id = scanner.nextInt();
	            	scanner.nextLine(); // pulisco buffer
	            	System.out.println("Inserisci nome utente");
	            	String nome = scanner.nextLine();
	                System.out.println("ID: " + id + ", Nome: " + nome); // Aggiungi questa riga per debug
	                Utente utente = new Utente(id,nome);
	                aggiungiUtente(utente);
	                break;
	            case 2:
	                // Aggiungi un libro
	            	System.out.println("Inserisci ID libro");
	            	Integer id1 = scanner.nextInt();
	            	scanner.nextLine(); // pulisco buffer
	            	System.out.println("Inserisci titolo libro");
	                String titolo = scanner.nextLine();
	                System.out.println("Inserisci genere libro");
	            	String autore = scanner.nextLine();
	            	System.out.println("Inserisci autore libro");
	                String genere = scanner.nextLine();
	                System.out.println("ID: " + id1 + ", Titolo: " + titolo + "Genere: " + genere + ", Autore: " + autore);
	                Libro libro = new Libro(id1,titolo, autore, genere);
	                aggiungiLibro(libro);
	                break;
	            case 3:
	                // Aggiungi una recensione
	            	System.out.println("Inserisci il tuo id");
	            	mostraUtenti();
	            	Integer id2 = scanner.nextInt();
	            	boolean utenteRegistrato = false;
	            	for(Utente utente1 : listaUtenti) {
	            		if(utente1.getId().equals(id2)) {
	            			utenteRegistrato = true;
	            			System.out.println(utente1.getNome() + " : puoi inserire la recensione");
	            			Recensione recensione = aggiungiRecensione(utente1);
	            			listaRecensioni.add(recensione);
	            			break;
	            		}
	            		if(!utenteRegistrato)
	            			System.out.println("Utente non registrato, registrati prima di procedere");
	            		}
	            case 4:
	                // Mostra libri e utenti
	            	mostraCatalogo();
	            	mostraUtentiRegistrati();
	                break;
	            case 5:
	                continua = false;
	                break;
	            case 6:
	            	//consiglia un libro
	            	System.out.println("Inserisci il tuo id");
	            	mostraUtenti();
	            	Integer id3 = scanner.nextInt();
	            	boolean utenteRegistrato1 = false;
	            	for(Utente utente2 : listaUtenti) {
	            		if(utente2.getId().equals(id3)) {
	            			utenteRegistrato1 = true;
	            			System.out.println(utente2.getNome() + " : Prova uno dei nostri consigliati.");
	            			List<Libro> libriRaccomandati = raccomandaLibri(utente2);
	            			if(libriRaccomandati.isEmpty()) {
	            				System.out.println("Non ci sono libri raccomandati al momento.");
	            			} 
	            			else {
	            				for(Libro libro1 : libriRaccomandati) {
	            					libro1.mostraDettagli();
	            				}
	            			}
	            			break;
	            		}
	            		if(!utenteRegistrato1)
	            			System.out.println("Utente non registrato, registrati prima di procedere");
	            		}
	            default:
	                System.out.println("Opzione non valida. Riprova.");
	            }
            }
        
        
	}
	
	public List<Libro> raccomandaLibri(Utente utente) {

		List<Libro> libriRaccomandati = new ArrayList<>();
		List<String> genereLibri = new ArrayList<>();

		if (!utente.libriAcquistati.isEmpty()) {

			for (Libro libro : utente.libriAcquistati) {
				if (!genereLibri.contains(libro.getGenere())) {
					genereLibri.add(libro.getGenere());
				}
			}
			
			if (!genereLibri.isEmpty()) {
				for (String genere : genereLibri) {
					for (Recensione recensione : listaRecensioni) {
						if (genere.equals(recensione.getLibro().getGenere()) && 
								recensione.getValutazione() >= 4 && 
								!libriRaccomandati.contains(recensione.getLibro())
								&& !utente.libriAcquistati.contains(recensione.getLibro())) {
								libriRaccomandati.add(recensione.getLibro());
						}
					}
				}
			}

			for (Libro libroUtente : utente.libriAcquistati) {
				for (Libro libroLibreria : mostraLibri()) {
					if (libroUtente.getAutore().equals(libroLibreria.getAutore()) && !libriRaccomandati.contains(libroLibreria)) {
						libriRaccomandati.add(libroLibreria);
					}
				}
			}

		}
		else {
			libriRaccomandati = libriPopolari();		
		}

		return libriRaccomandati;

	}	
	
	public List<Libro> libriPopolari() {
		
		List<Libro> libriPopolari = new ArrayList<>();
		
		for (Recensione recensione : listaRecensioni) {
			if (valutazioneMedia(recensione.getLibro()) >= 4 && !libriPopolari.contains(recensione.getLibro())) {
				libriPopolari.add(recensione.getLibro());
			}
		}
		
		return libriPopolari;
	}
	
	public Integer valutazioneMedia(Libro libro) {
		
		float valutazione = 0F;
		Integer nLibri = 0;
		
		for (Recensione recensione : listaRecensioni) {
			if(recensione.getLibro().equals(libro)) {
				valutazione += recensione.getValutazione();
				nLibri++;
			}
				
		}	
		
		Integer media = 0;
		if(nLibri > 0) {
			media = Math.round(valutazione/nLibri);
		}
		
		return media;
	}
	
	public List<Utente> mostraUtenti() {
		return listaUtenti;
	}
	
	public void aggiungiUtente(Utente newUtente) {
	    boolean utentePresente = false;

	    for (Utente utente : listaUtenti) {
	        if (utente.getEmail().equals(newUtente.getEmail())) {
	            utentePresente = true;
	            break; // Esci dal ciclo una volta trovato l'utente
	        }
	    }

	    if (utentePresente) {
	        System.out.println("Utente gia` registrato");
	    } else {
	        System.out.println("Utente " + newUtente.getNome());
	        System.out.println("Utente registrato");
	        listaUtenti.add(newUtente);
	    }
	}
	
	public void aggiungiLibro(Libro newLibro) {
	    boolean libroPresente = false;

	    for (Libro libro : listaLibri) {
	        if (libro.getTitolo().equals(newLibro.getTitolo())) {
	            libroPresente = true;
	            break; // Esci dal ciclo una volta trovato il libro
	        }
	    }

	    if (libroPresente) {
	        System.out.println("Libro gia` presente in libreria");
	    } else {
	        System.out.println("Libro: " + newLibro.getTitolo() + " aggiunto alla lista libri");
	        listaLibri.add(newLibro);
	    }
	}
	
	public Recensione aggiungiRecensione(Utente utente) {
		Scanner scanner = new Scanner(System.in);
		Recensione recensione = utente.lasciaRecensione(scanner);
		return recensione;
	}
	
	public void mostraCatalogo() {
		if (listaLibri.isEmpty()) {
	        System.out.println("Nessun libro presente nella libreria.");
	    } else {
	        System.out.println("Elenco dei libri nella libreria:");
	        for (Libro libro : listaLibri) {
	            libro.mostraDettagli();
	        }
	    }
	}
	public List<Libro> mostraLibri() {
	   return listaLibri;
	}
	
	public void mostraUtentiRegistrati() {
	    if (listaUtenti.isEmpty()) {
	        System.out.println("Nessun utente presente nella lista.");
	    } else {
	        System.out.println("Elenco degli utenti:");
	        for (Utente utente : listaUtenti) {
	            utente.mostraDettagli();
	        }
	    }
	}
	
	public List<Libro> getListaLibri() {
		return listaLibri;
	}

	public void setListaLibri(List<Libro> listaLibri) {
		this.listaLibri = listaLibri;
	}

	public void setListaRecensioni(List<Recensione> listaRecensioni) {
        this.listaRecensioni = listaRecensioni;
    }
	
	public Integer valutazioneMedia(List<Recensione> recensioni, Libro libro) {

        Integer valutazione = 0;
        Integer nLibri = 0;

        for (Recensione recensione : recensioni) {
            if(recensione.getLibro().equals(libro)) {
                valutazione += recensione.getValutazione();
                nLibri++;
            }

        }

        Integer media = 0;
        if(nLibri > 0) {
            media = Math.round(valutazione/nLibri);
        }

        return media;
    }
	
	public List<Libro> libriPopolari(List<Recensione> recensioni, LibreriaOnline libreria) {

        List<Libro> libriPopolari = new ArrayList<>();

        for (Recensione recensione : recensioni) {
            if (recensione.getValutazione() >= 4 && !libriPopolari.contains(recensione.getLibro())) {
                libriPopolari.add(recensione.getLibro());
            }
        }

        return libriPopolari;
    }
}
