//Questa classe e` responsabile per la creazione e la gestione delle pprenotazioni
//E` possibile controllare la disponibilita` in base al numero di persone viene mostrata la disponibilita`
// relativamente a data e orario.

package Ristorante;

import java.util.List;
import java.util.ArrayList;


public class PrenotazioneServiceImpl implements PrenotazioneService {
	private List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
	public List<Tavolo> tavoli = new ArrayList<Tavolo>();
	
	PrenotazioneServiceImpl(List<Tavolo> tavoli) {
		this.tavoli = tavoli;
	}
	
	public List<Tavolo> getTavoli(){
		return tavoli;
	}
	
	public List<Prenotazione> getPrenotazioni(){
		return prenotazioni;
	}
	
	@Override
	public Prenotazione prenotaTavolo(Prenotazione nuovaPrenotazione) {
		prenotazioni.add(nuovaPrenotazione);
		return nuovaPrenotazione;
	}

	@Override
	public void annullaPrenotazione(int id, int data, int ora) {
		Prenotazione prenotazioneDaAnnullare = null;

	    // Trova la prenotazione con l'ID specifico
	    for (Prenotazione prenotazione : prenotazioni) {
	        if (prenotazione.getId() == id) {
	            prenotazioneDaAnnullare = prenotazione;
	            break;
	        }
	    }

	    if (prenotazioneDaAnnullare != null) {
	        // Imposta i booleani corrispondenti per data e ora su true (disponibili)
	        prenotazioneDaAnnullare.setDataT(data);
	        prenotazioneDaAnnullare.setOrarioT(ora);
	        System.out.println("Data e ora della prenotazione annullate con successo.");
	    } else {
	        System.out.println("Nessuna prenotazione trovata con l'ID specifico.");
	    }
	}
	
	//Questa classe verifica la disponibilita` di prenotare un tavolo in base al numero di persone
	// Scarta i tavoli con meno persone rispetto a quanto richiesto e mostra all'utente
	// date e orari di disponibilita` relativamente al mese corrente.
	
	@Override
	public void getTavoliDisponibili(int persone) {
	    List<Tavolo> tavoliDisponibili = new ArrayList<Tavolo>();

	    for (Tavolo tavolo : tavoli) {
	        boolean tavoloOccupato = false;

	        // Verifica se il tavolo è stato prenotato in una delle prenotazioni
	        for (Prenotazione prenotazione : prenotazioni) {
	            if (prenotazione.getTavolo() == tavolo &&
	                prenotazione.getNumeroPersone() == persone &&
	                !prenotazione.nessunOrarioDisponibile() &&
	                !prenotazione.nessunGiornoDisponibile()) {
	                tavoloOccupato = true;
	                break;
	            }
	        }

	        if (!tavoloOccupato) {
	            tavoliDisponibili.add(tavolo);
	        }
	    }

	    if (tavoliDisponibili.isEmpty()) {
	        System.out.println("Nessun tavolo disponibile.");
	        return;
	    }

	    // Mostra dettagli dei tavoli disponibili
	    // per ogni giorno prenotazione, che e` relativa ad un tavolo,
	    // mostra tutti i giorni e le date di disponibilita`
	    for (Tavolo tavolo : tavoliDisponibili) {
	        System.out.println("Tavolo disponibile: " + tavolo.dettagli());
	        System.out.println("Nei giorni: ");

	        for (Prenotazione prenotazione : prenotazioni) {
	            if (prenotazione.getTavolo().getId() == tavolo.getId()) {
	                if (!prenotazione.nessunGiornoDisponibile()) {
	                    System.out.println("Giorni disponibili:");
	                    for (int giorno = 1; giorno <= prenotazione.data.length; giorno++) {
	                        if (prenotazione.isGiornoDisponibile(giorno)) {
	                            System.out.println("Giorno " + giorno + " disponibile");
	                        }
	                    }
	                } else {
	                    System.out.println("Nessun giorno disponibile per questa prenotazione.");
	                }

	                if (!prenotazione.nessunOrarioDisponibile()) {
	                    System.out.println("Orari disponibili:");
	                    for (int i = 0; i < prenotazione.orario.length; i++) {
	                        if (prenotazione.orario[i]) {
	                            int orario = 1900 + (i * 100);
	                            System.out.println("Orario: " + orario);
	                        }
	                    }
	                } else {
	                    System.out.println("Nessun orario disponibile per questa prenotazione.");
	                }
	            }
	        }
	    }
	}
}
