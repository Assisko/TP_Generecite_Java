import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Membre {
    private String nom;
    private int id;
    private List<Media> mediasEmpruntes;


    //Quand on crée un membre, on lui donne un nom et un id.
    //La liste des emprunts est initialisée vide.
    public Membre(String nom, int id) {
        this.nom = nom;
        this.id = id;
        this.mediasEmpruntes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    //Ajoute un média emprunté dans sa liste.
    public void emprunterMedia(Media media) {
        mediasEmpruntes.add(media);
    }

    public List<Media> getMediasEmpruntes() {
        return mediasEmpruntes;
    }

    @Override
    public String toString() {
        return "Membre {" + nom + ", id=" + id + "}";
    }

    // Important pour utiliser Membre dans Set(pour éviter les doublons), et comme clé de Map
    //Deux membres sont considérés égaux si leur id est identique.
    //Le nom n’est pas pris en compte.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Membre)) return false;
        Membre membre = (Membre) o;
        return id == membre.id;
    }
//Le hashCode est basé sur l’id → obligatoire pour respecter la cohérence avec equals
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
