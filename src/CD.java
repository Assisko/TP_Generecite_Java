public class CD extends Media implements Empruntable{
    private String artiste;
    private int duree; // en minutes

    public CD(String titre, int anneePublication, String artiste, int duree) {
        super(titre, anneePublication);
        this.artiste = artiste;
        this.duree = duree;
    }

    @Override
    public String getDescription() {
        return "CD de " + artiste + ", durée : " + duree + " min.";
    }

    @Override
    public void emprunter() {
        System.out.println("Le CD \"" + getTitre() + "\" a été emprunté.");
    }
}
