package beans;

public class Ville {
	
	public String codeCommuneINSEE;
	public String nomCommune;
	public String codePostal;
	public String libelleAcheminement;
	public String ligne5;
	public String latitude;
	public String longitude;
	
	public Ville() {
		super();
	}
	public Ville(String codeCommuneINSEE, String nomCommune, String codePostal, String libelleAcheminement,
			String ligne5, String latitude, String longitude) {
		super();
		this.codeCommuneINSEE = codeCommuneINSEE;
		this.nomCommune = nomCommune;
		this.codePostal = codePostal;
		this.libelleAcheminement = libelleAcheminement;
		this.ligne5 = ligne5;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String getCodeCommuneINSEE() {
		return codeCommuneINSEE;
	}
	public void setCodeCommuneINSEE(String codeCommuneINSEE) {
		this.codeCommuneINSEE = codeCommuneINSEE;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCode_postal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}

	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}

	public String getLigne5() {
		return ligne5;
	}

	public void setLigne5(String ligne5) {
		this.ligne5 = ligne5;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public double getDistance(Ville ville2) {

        double distance = 0;

        double longitudeVille1 = Double.valueOf(this.getLongitude());
        double longitudeVille2 = Double.valueOf(ville2.getLongitude());

        double latitudeVille1 = Double.valueOf(this.getLatitude());
        double latitudeVille2 = Double.valueOf(ville2.getLatitude());


        double un = (longitudeVille2 - longitudeVille1) * Math.cos((latitudeVille2 + latitudeVille1)/2);
        double delta = latitudeVille2 - latitudeVille1;
        double pyth = Math.sqrt(Math.pow(un, 2) + Math.pow(delta, 2));

        distance = 1.852 * 60 * pyth;

        return distance;
    }
	
}