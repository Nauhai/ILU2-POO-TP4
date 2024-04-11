package produit;

public interface IProduit {

	String description();

	String getNom();

	double calculerPrix(int prix);
}