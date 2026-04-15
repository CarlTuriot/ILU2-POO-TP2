package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	private void achatVendeur(String nomAcheteur, String produit, String nomVendeur) {
		int quantiteVoulu = Clavier
				.entrerEntier("Bonjour " + nomAcheteur + "\nCombien de " + produit + " voulez-vous acheter ?");
		int quantiteAcheter = controlAcheterProduit.acheterProduit(nomVendeur, quantiteVoulu);
		if (quantiteAcheter == 0) {
			System.out.println(nomAcheteur + " veut acheter " + quantiteVoulu + " " + produit
					+ ", malheureusement il n'y en a plus !");
		} else if (quantiteVoulu == quantiteAcheter) {
			System.out.println(nomAcheteur + " achète " + quantiteVoulu + " " + produit + " à " + nomVendeur);
		} else {
			System.out.println(nomAcheteur + " veut acheter " + quantiteVoulu + " " + produit + ", malheureusement "
					+ nomVendeur + " n'en a plus que " + quantiteAcheter + ". " + nomAcheteur
					+ " achète tout le stock de " + nomVendeur + ".");
		}
	}

	private void donneesEtalProduitNotNull(String[] donneesEtalProduit, String nomAcheteur, String produit) {
		System.out.println("Chez quel commerçant voulez-vous acheter des fleurs ?");
		for (int i = 0; i < donneesEtalProduit.length; i++) {
			System.out.println((i + 1) + " " + donneesEtalProduit[i]);
		}
		int numeroVendeur = Clavier.entrerEntier("") - 1;
		String nomVendeur = null;
		try {
			nomVendeur = donneesEtalProduit[numeroVendeur];
			System.out.println(nomAcheteur + " se déplace jusqu'a l'étale de vendeur " + nomVendeur);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("numéro de vendeur non reconnu");
		}

		achatVendeur(nomAcheteur, produit, nomVendeur);
	}

	public void acheterProduit(String nomAcheteur) {
		boolean acheteurReconnu = controlAcheterProduit.isHabitant(nomAcheteur);
		if (!acheteurReconnu) {
			System.out.println("Je suis désolée " + nomAcheteur
					+ " mais il faut etre un habitant de notre village pour commercer ici.");
		} else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			String[] donneesEtalProduit = controlAcheterProduit.chercherEtalProduit(produit);
			if (donneesEtalProduit != null) {

				donneesEtalProduitNotNull(donneesEtalProduit, nomAcheteur, produit);

			} else {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			}
		}
	}
}
