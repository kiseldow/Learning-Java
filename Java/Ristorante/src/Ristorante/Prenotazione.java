// Questa classe gestisce e rappresenta le prenotazioni del ristorante
// Ogni prenotazione e` relativa ad un tavolo e tiene traccia dei giorni del mese
// in cui il tavolo e` occupato, cosi` come degli orari
// E` prevista la possibilita` di modifiare lo stato della prenotazione
// e associare la prenotazione ad una specifica tabella

package Ristorante;

import java.util.Arrays;

public class Prenotazione {
	private int id;
	boolean[] data = new boolean[31]; //giorno della prenotazione
	boolean[] orario =  new boolean[4]; // tra 1900 e 2200
	private int numeroPersone;
	private Tavolo tavolo;
	
	
	
	  public Prenotazione() {
	       
	        // Inizializza la disponibilità dei giorni (tutti true inizialmente)
	        for (int i = 0; i < data.length; i++) {
	            data[i] = true;
	        }

	        // Inizializza la disponibilità degli orari (tutti true inizialmente)
	        for (int i = 0; i < orario.length; i++) {
	            orario[i] = true;
	        }
	    }
	
	 // Verifica se il giorno è disponibile
    public boolean isGiornoDisponibile(int giorno) {
        if (giorno >= 1 && giorno <= data.length) {
            return data[giorno - 1];
        } else {
            throw new IllegalArgumentException("Giorno non valido.");
        }
    }

    // Metodo per verificare se non ci sono giorni disponibili
    public boolean nessunGiornoDisponibile() {
        for (boolean giornoDisponibile : data) {
            if (giornoDisponibile) {
                // Se trovi almeno un giorno disponibile, restituisci false
                return false;
            }
        }
        // Se nessun giorno è disponibile, restituisci true
        return true;
    }

    // Metodo per sapere se non ci sono orari disponibili
    public boolean nessunOrarioDisponibile() {
        for (boolean orarioDisponibile : orario) {
            if (orarioDisponibile) {
                // Se trovi almeno un orario disponibile, restituisci false
                return false;
            }
        }
        // Se nessun orario è disponibile, restituisci true
        return true;
    }

    // Metodi Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setData(int giorno) {
        if (giorno >= 1 && giorno <= data.length) {
            data[giorno - 1] = false;
        } else {
            throw new IllegalArgumentException("Giorno non valido.");
        }
    }

    public void setOrario(int orario) {
        if (orario >= 1900 && orario <= 2200) {
            // Calcola l'indice dell'orario
            int index = (orario - 1900) / 100;
            if (index >= 0 && index < this.orario.length) {
                this.orario[index] = false;
            } else {
                throw new IllegalArgumentException("L'orario non è disponibile o non è valido.");
            }
        } else {
            throw new IllegalArgumentException("L'orario deve essere compreso tra 1900 e 2200.");
        }
    }
    
    public void setDataT(int giorno) {
        if (giorno >= 1 && giorno <= data.length) {
            data[giorno - 1] = true;
        } else {
            throw new IllegalArgumentException("Giorno non valido.");
        }
    }

    public void setOrarioT(int orario) {
        if (orario >= 1900 && orario <= 2200) {
            // Calcola l'indice dell'orario
            int index = (orario - 1900) / 100;
            if (index >= 0 && index < this.orario.length) {
                this.orario[index] = true;
            } else {
                throw new IllegalArgumentException("L'orario non è disponibile o non è valido.");
            }
        } else {
            throw new IllegalArgumentException("L'orario deve essere compreso tra 1900 e 2200.");
        }
    }

    public void setNumeroPersone(int numeroPersone) {
        this.numeroPersone = numeroPersone;
    }

    public void setTavolo(Tavolo tavolo) {
        this.tavolo = tavolo;
    }

    // Metodi Getter
    public int getId() {
        return id;
    }

    public int getNumeroPersone() {
        return numeroPersone;
    }

    public Tavolo getTavolo() {
        return tavolo;
    }

    public String dettagli() {
        return "Prenotazione #" + id +
                "\nData: " + Arrays.toString(data) +
                "\nOrario: " + Arrays.toString(orario) +
                "\nNumero Persone: " + numeroPersone +
                "\nTavolo: " + tavolo.dettagli();
    }
	
}
