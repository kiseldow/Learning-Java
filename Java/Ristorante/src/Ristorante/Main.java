package Ristorante;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] argss) {
		Tavolo tavolo1 = new Tavolo(1, 4, false);
		Tavolo tavolo2 = new Tavolo(2, 2, false);
		Tavolo tavolo3 = new Tavolo(3, 6, false);
		Tavolo tavolo4 = new Tavolo(4, 8, false);

		// Aggiungi i tavoli a una lista (se necessario)
		List<Tavolo> listaTavoli = new ArrayList<>();
		listaTavoli.add(tavolo1);
		listaTavoli.add(tavolo2);
		listaTavoli.add(tavolo3);
		listaTavoli.add(tavolo4);
		
		PrenotazioneServiceImpl pizzeria = new PrenotazioneServiceImpl(listaTavoli);
		Interfaccia prenotazione = new Interfaccia(pizzeria);
		prenotazione.start();
	}
}
