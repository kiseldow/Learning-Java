//Il fornitore esegue il rifornimento di materie prime per la preparazione di dolci
//Il rifornimento viene effettuato con dei valori aleatori 
//Agisce solo quando viene eseguito il suo metodo, quindi su richiesta del Proprietario

package Dolci;

import java.util.Random;
import java.util.List;

public class Fornitore {
	private String nome;
	private String cognome;
	
	public void rifornisci(List<Ingrediente> scorta) {
		// genero valori casuali e li aggiungo alla quantita` della scorta
				for(Ingrediente ingrediente : scorta) {
					Integer random = ((int) (Math.random() * 10));
					if(ingrediente.getNome().equalsIgnoreCase("latte")) {
						ingrediente.setQuantita(ingrediente.getQuantita() + random);
					}
					else if(ingrediente.getNome().equalsIgnoreCase("uova")) {
						ingrediente.setQuantita(ingrediente.getQuantita() + random);
					}
					else if(ingrediente.getNome().equalsIgnoreCase("burro")) {
						ingrediente.setQuantita(ingrediente.getQuantita() + random);
					}
					else if(ingrediente.getNome().equalsIgnoreCase("lievito")) {
						ingrediente.setQuantita(ingrediente.getQuantita() + random);
					}
				}
	}
}
