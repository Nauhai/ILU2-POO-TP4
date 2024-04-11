package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;

public class ScenarioTest {
	public static void main(String[] args) {
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Asterix", 6);
		
		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = {sanglier1, sanglier2};
		Sanglier[] sangliersAsterix = {sanglier3, sanglier4};
		
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = {poisson1};
		
		IEtal[] marche = new IEtal[3];
		
		Etal<Sanglier> etalSanglier1 = new Etal<>();
		etalSanglier1.installerVendeur(obelix, sangliersObelix, 8);
		
		Etal<Sanglier> etalSanglier2 = new Etal<>();
		etalSanglier2.installerVendeur(asterix, sangliersAsterix, 10);
		
		Etal<Poisson> etalPoisson = new Etal<>();
		etalPoisson.installerVendeur(ordralfabetix, poissons, 7);
		
		marche[0] = etalSanglier2;
		marche[1] = etalSanglier1;
		marche[2] = etalPoisson;
		
		afficherEtatMarche(marche);
		
		int aAcheter = 3;
		int achete = 0;
		int numEtal = 0;
		while (achete < aAcheter) {
			int dispo = marche[numEtal].contientProduit("sanglier", aAcheter-achete);
			double prix = marche[numEtal].acheterProduit(dispo);
			System.out.println("À l'étal " + numEtal + " je paye " + prix + " sous.");
			achete += dispo;
			numEtal++;
		}
		System.out.println("Je voulais " + aAcheter + " sangliers, j'en ai acheté " + achete);
		
		System.out.println();
		
		afficherEtatMarche(marche);
	}
	
	public static void afficherEtatMarche(IEtal[] marche) {
		System.out.println("ETAT MARCHE");
		for (int i = 0; i < marche.length; i++) {
			System.out.println(marche[i].etatEtal());
		}
	}
	
}
