package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}


	public boolean isHabitant(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}


	public String[] chercherEtalProduit(String produit) {
		Gaulois[] gaulois = village.rechercherVendeursProduit(produit);
		
		Etal etal=rechercherEtal(gaulois);
		controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).etatEtal();
		return null;
	} 
}
