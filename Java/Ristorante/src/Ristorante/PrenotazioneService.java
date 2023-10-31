package Ristorante;

import java.util.List;

public interface PrenotazioneService {
	
	 void annullaPrenotazione(int id, int data, int ora) ;
	
	 void getTavoliDisponibili(int persone);

	Prenotazione prenotaTavolo(Prenotazione nuovaPrenotazione);
}
