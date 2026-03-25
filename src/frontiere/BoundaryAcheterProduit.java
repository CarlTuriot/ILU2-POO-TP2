package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean acheteurReconnu = controlAcheterProduit.isHabitant(nomAcheteur);
		if(!acheteurReconnu) {
			System.out.println("Je suis désolée " + nomAcheteur 
					+ " mais il faut etre un habita,t de notre village pour commercer ici.");
		} else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			
			String[] donneesEtalProduit = controlAcheterProduit.chercherEtalProduit(produit);
		}
	}
}
