import java.util.Comparator;

/**
 * Comparateur pour trier les médias par année décroissante, puis titre.
 */



// MediaComparator pour trier les médias
public class MediaComparator implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int comp = Integer.compare(m2.getAnneePublication(), m1.getAnneePublication()); // décroissant
        if (comp == 0) {
            return m1.getTitre().compareTo(m2.getTitre());
        }
        return comp;
    }
}
