package produit;

public class Poisson extends Produit {
	private String dateDePeche;
	
	public Poisson(String dateDePeche) {
		super("poisson", Unite.KILOGRAMME);
		this.dateDePeche = dateDePeche;
	}
	
	@Override
	public String description() {
		return "poisson pêché " + dateDePeche;
	}
	
	@Override
	public double calculerPrix(int prix) {
		return prix;
	}

	public String getDateDePeche() {
		return dateDePeche;
	}
}
