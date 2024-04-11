package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.IVillage;
import villagegauloisold.DepenseMarchand;
import villagegaulois.Etal;

public class Scenario {

	public static void main(String[] args) {

		IVillage village = new IVillage() {
			private static final int NB_ETALS_MAX = 5;
			private Etal[] etals = new Etal[NB_ETALS_MAX];
			private int nbEtal = 0;
			
			@Override
			public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur,
					P[] produit, int prix) {
				if (nbEtal < NB_ETALS_MAX) {
					etal.installerVendeur(vendeur, produit, prix);
					etals[nbEtal++] = etal;
					return true;
				} else {
					return false;
				}
			}
			
			@Override
			public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee) {
				DepenseMarchand[] depenses = new DepenseMarchand[nbEtal];
				int i = 0;
				int achetes = 0;
				int numEtal = 0;
				while (achetes < quantiteSouhaitee && numEtal < nbEtal) {
					int dispo = etals[numEtal].contientProduit(produit, quantiteSouhaitee-achetes);
					if (dispo > 0) {
						double prix = etals[numEtal].acheterProduit(dispo);
						depenses[i] = new DepenseMarchand(etals[numEtal].getVendeur(), dispo, produit, prix);
						i++;
						achetes+=dispo;
					}
					numEtal++;
				}
				return depenses;
			}
			
			@Override
			public String toString() {
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < nbEtal; i++) {
					builder.append(etals[i].etatEtal());
					builder.append("\n");
				}
				return builder.toString();
			}
		};

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		DepenseMarchand[] depense = village.acheterProduit("sanglier", 3);

		for (int i = 0; i < depense.length && depense[i] != null; i++) {
			System.out.println(depense[i]);
		}

		System.out.println(village);

	}

}
