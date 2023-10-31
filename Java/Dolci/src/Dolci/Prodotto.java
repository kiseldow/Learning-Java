package Dolci;
import java.util.List;

public class Prodotto {
	
	private String nome;
	private Float prezzo;
	private List<Ingrediente> ingredienti;
	private String descrizione;
	private Integer quantitaDisponibile;
	private	Integer quantitaCarrello;
	
	
	public Prodotto(String nome, Float prezzo, Integer quantitaCarrello) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
		this.quantitaCarrello = quantitaCarrello;
	}
	
	public Prodotto(String nome, Float prezzo, List<Ingrediente> ingredienti, String descrizione,
			Integer quantitaDisponibile) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
		this.ingredienti = ingredienti;
		this.descrizione = descrizione;
		this.quantitaDisponibile = quantitaDisponibile;
	}


	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public Float getPrezzo() {
		return prezzo;
	}




	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}




	public List<Ingrediente> getIngredienti() {
		return ingredienti;
	}




	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}




	public String getDescrizione() {
		return descrizione;
	}




	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}




	public Integer getQuantitaDisponibile() {
		return quantitaDisponibile;
	}




	public void setQuantitaDisponibile(Integer quantitaDisponibile) {
		this.quantitaDisponibile = quantitaDisponibile;
	}




	public Integer getQuantitaCarrello() {
		return quantitaCarrello;
	}




	public void setQuantitaCarrello(Integer quantitaCarrello) {
		this.quantitaCarrello = quantitaCarrello;
	}
	
	
	public void vendi(Integer quantitaVenduta) {
		System.out.println("Quantità disponibile : " + quantitaDisponibile);
		System.out.println("Quantità vendute: " + quantitaVenduta);
		this.quantitaDisponibile-=quantitaVenduta;
		System.out.println("Quantita rimanenti: " + quantitaDisponibile);
	}

	public void setQuantita(Integer quantitaDisponibile) {
		this.quantitaDisponibile = quantitaDisponibile;
	}
	public Integer getQuantita() {
		return quantitaDisponibile;
	}
}