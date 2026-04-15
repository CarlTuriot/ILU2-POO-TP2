package controleur;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur) != null;
	}

	public String[] libererEtal(String nomVendeur) {
		if (controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur) == null) {
			return null;
		}
		String[] donneesEtal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).etatEtal();
		controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).libererEtal();
		return donneesEtal;
	}

}
