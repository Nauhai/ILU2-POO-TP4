package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	private int poids;
	private Gaulois chasseur;
	
	public Sanglier(int poids, Gaulois chasseur) {
		super("sanglier", Unite.KILOGRAMME);
		this.poids = poids;
		this.chasseur = chasseur;
	}
	
	@Override
	public String description() {
		return "sanglier de " + poids + " kg chassé par " + chasseur.getNom();
	}
	
	@Override
	public double calculerPrix(int prix) {
		return poids/1000.0*prix;
	}

	public int getPoids() {
		return poids;
	}

	public Gaulois getChasseur() {
		return chasseur;
	}
}
