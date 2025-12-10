import java.util.Comparator;
/**
 * Comparateur pour trier les livres par auteur, puis titre.
 */

public class LivreComparator implements Comparator<Livre> {
    @Override
    public int compare(Livre l1, Livre l2) {
        int comp = l1.getAuteur().compareTo(l2.getAuteur()); // comparer par auteur
        if (comp == 0) {
            return l1.getTitre().compareTo(l2.getTitre()); // si même auteur, comparer titre
        }
        return comp;
    }
}
