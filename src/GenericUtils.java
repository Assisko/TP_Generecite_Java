import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * Classe utilitaire pour les méthodes génériques.
 */

public class GenericUtils {

    // Méthode générique qui copie tous les éléments d'une collection vers une autre.
    // L'utilisation de <T> permet de garder le type des objets (pas de cast nécessaire).

    public static <T> void copierCollection(Collection<T> source, Collection<T> destination) {
        destination.addAll(source);
    }

    // Affiche n'importe quelle liste d'objets, peu importe son type (T).
    public static <T> void afficherListe(List<T> liste)
    {
        for (T element : liste) {
            System.out.println(element);// grâce au polymorphisme, toString() est appelé correctement
        }
    }

    // Méthode générique de filtrage :
    // On reçoit une liste et un critère (Predicate<T>), et on retourne une liste filtrée.
    public static <T> List<T> filtrer(List<T> liste, Predicate<T> critere)
    {
        List<T> resultat = new ArrayList<>();
        for (T element : liste)
        {
            // Predicate<T>.test(element) retourne true si l'élément correspond au critère

            if (critere.test(element)) {
                resultat.add(element);
            }
        }
        return resultat;//liste des éléments filtrés
    }
}
