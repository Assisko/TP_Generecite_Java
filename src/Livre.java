/**
 * Classe représentant un livre.
 * Hérite de Media et implémente Empruntable.
 */

public class Livre extends Media implements Empruntable {
    //champ privé
    private String auteur;
    private int nbPages;

    //Constructeur paramétré
    public Livre(String titre, int anneePublication, String auteur, int nbPages) {
        super(titre, anneePublication);
        this.auteur = auteur;
        this.nbPages = nbPages;
    }

    //Getter et setter necessaire
    public String getAuteur() {
        return auteur;
    }

    @Override
    public String getDescription() {
        return "Livre de " + auteur + ", " + nbPages + " pages.";
    }

//Affiche un message lorsqu’un livre est emprunté.
    @Override
    public void emprunter() {
        System.out.println("Le livre \"" + getTitre() + "\" a été emprunté.");
    }
}
