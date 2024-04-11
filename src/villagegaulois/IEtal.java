package villagegaulois;

import personnages.Gaulois;

public interface IEtal {
	
	Gaulois getVendeur();
	
	double donnerPrix();
	
	int contientProduit(String produit, int quantiteSouhaitee);
	
	double acheterProduit(int quantiteSouhaitee);
	
	String etatEtal();
}
