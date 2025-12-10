/**
 * Classe abstraite représentant un média générique.
 * Elle contient un titre et une année de publication.
 * Les classes dérivées doivent implémenter la méthode getDescription().
 */


abstract class Media {
    private String titre;
    private int anneePublication;

    // Constructeur par défaut
    public Media() {}

    //Constructeur paramétré
    public Media(String titre, int anneePublication) {
        this.titre = titre;
        this.anneePublication = anneePublication;
    }

    // getter et setter démandé
    public String getTitre() {
        return titre;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    /**
     * Retourne la description spécifique du média.
     * @return description du média
     */
    public abstract String getDescription();

    /**
     * Affiche les détails du média.
     */
    public void afficherDetails() {
        System.out.println(titre + " (" + anneePublication + ") : " + getDescription());
    }


    @Override
    public String toString() {
        return titre + " (" + anneePublication + ")";
    }

}
