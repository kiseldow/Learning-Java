package Ristorante;

import java.util.Scanner;

public class Interfaccia {
	
	private Scanner scanner = new Scanner(System.in);
	private PrenotazioneServiceImpl prenotazioneService;
	
	public Interfaccia(PrenotazioneServiceImpl servizio) {
		this.prenotazioneService = servizio;
	}
		
	 public void start() {
	        System.out.println("Benvenuto al sistema di prenotazione del ristorante!");

	        while (true) {
	            System.out.println("\nOpzioni disponibili:");
	            System.out.println("1. Prenota tavolo");
	            System.out.println("2. Annulla prenotazione");
	            System.out.println("3. Visualizza tavoli disponibili");
	            System.out.println("4. Esci");

	            int scelta = scanner.nextInt();
	           // scanner.nextLine(); // Consuma la nuova riga

	            switch (scelta) {
	                case 1:
	                    prenotaTavolo();
	                    break;
	                case 2:
	                    annullaPrenotazione();
	                    break;
	                case 3:
	                    visualizzaTavoliDisponibili();
	                    break;
	                case 4:
	                    System.out.println("Grazie per aver usato il sistema di prenotazione.");
	                    return;
	                default:
	                    System.out.println("Scelta non valida. Riprova.");
	            }
	        }
	    }
	 
	 private Prenotazione prenotaTavolo() {
		 System.out.println("Per quante persone prenotare?");
		 int persone = scanner.nextInt();
		 
		 prenotazioneService.getTavoliDisponibili(persone);
		 
		 System.out.println("Inserisci id tavolo da prenotare");
		 int idTavolo = scanner.nextInt();
		 
		 System.out.println("Inserisci id per la prenotazione");
		 int id = scanner.nextInt();
		 
		 System.out.println("Inserisci il giorno");
		 int giorno = scanner.nextInt();
		 
		 System.out.println("Inserisci l'orario");
		 int ora = scanner.nextInt();
		 
		 
		 //raccolgo le informazioni del tavolo
		 Tavolo tavolo = null;
		 Prenotazione prenotazione = null;
		 for(Tavolo tavoloDaTrovare : prenotazioneService.getTavoli()) {
			 if(tavoloDaTrovare.getId() == id) {
				 tavolo = tavoloDaTrovare;
				 break;
			 }
		 }
		 
		 // se non trova il tavolo
		 if (tavolo == null) {
		        System.out.println("Tavolo non trovato");
		        return null;
		    }
		 
		 //Controllo se il tavolo ha gia` ricevuto prenotazioni, altrimenti ne creo una nuova
		 else if(tavolo != null) {
			 for(Prenotazione prenotazioneDaTrovare : prenotazioneService.getPrenotazioni()) {
				 if(prenotazioneDaTrovare.getTavolo().getId() == tavolo.getId()) {
					 prenotazione = prenotazioneDaTrovare;
					 break;
				 }
			 }
			 
			 // creo una nuova prenotazione
			 if(prenotazione == null) {
				 prenotazione = new Prenotazione();
				 prenotazione.setId(id);
				 prenotazione.setDataT(giorno);
				 prenotazione.setOrario(ora);
				 prenotazione.setTavolo(tavolo);
				 
			 }
			 
			 //altrimenti aggiungo data e ora ad una prenotazione gia` esistente
			 else if(prenotazione != null) {
				 prenotazione.setData(giorno);
				 prenotazione.setOrario(ora);
				 
			 }
		 }
		 // alla fine restituisco a prescindere la prenotazione
		 return prenotazione;
	    }

	 public void annullaPrenotazione() {
		    System.out.println("Inserisci id prenotazione");
		    int id = scanner.nextInt();
		    
		    System.out.println("Inserisci data prenotazione");
		    int data = scanner.nextInt();
		    
		    System.out.println("Inserisci ora prenotazione");
		    int ora = scanner.nextInt();
		    
		    prenotazioneService.annullaPrenotazione(id,data,ora);
		    
		}

	    private void visualizzaTavoliDisponibili() {
	        int persone = scanner.nextInt();
	        System.out.println("Inserisci per quante persone");
	        prenotazioneService.getTavoliDisponibili(persone);
	    }
}
