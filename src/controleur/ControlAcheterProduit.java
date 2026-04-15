package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isHabitant(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}

	public String[] chercherEtalProduit(String produit) {
		Gaulois[] gaulois = village.rechercherVendeursProduit(produit);
		String[] vendeurEtal = null;
		if (gaulois != null) {
			vendeurEtal = new String[gaulois.length];
			for (int i = 0; i < gaulois.length; i++) {
				vendeurEtal[i] = gaulois[i].getNom();
			}

		}
		return vendeurEtal;
	}

	public int acheterProduit(String nomVendeur, int quantite) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(quantite);
	}
}
