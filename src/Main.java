import java.util.*;

/**
 * Classe principale du TP .
 * Initialise les médias et les membres, propose un menu interactif
 * permettant de tester les fonctionnalités : tri, filtrage, polymorphisme, génériques.
 */



public class Main {
    private static List<Media> medias = new ArrayList<>();
    private static Map<Membre, List<Media>> emprunts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initialiserDonnees();
        menuPrincipal();
        scanner.close();
    }

    private static void initialiserDonnees() {
        // Mes données existantes
        medias.add(new Livre("Harry Potter", 1997, "J.K. Rowling", 500));
        medias.add(new Livre("Clean Code", 2008, "Robert C. Martin", 450));
        medias.add(new CD("Random Access Memories", 2013, "Daft Punk", 75));
        medias.add(new CD("Discovery", 2001, "Daft Punk", 60));

        Membre m1 = new Membre("Alice", 1);
        Membre m2 = new Membre("Hawa", 2);
        Membre m3 = new Membre("Jenifer", 3);
        Membre m4 = new Membre("Ali", 4);

        Set<Membre> membres = new HashSet<>(Arrays.asList(m1, m2, m3, m4));
        for (Membre m : membres) {
            emprunts.put(m, new ArrayList<>());
        }

        emprunts.get(m1).add(medias.get(0));
        emprunts.get(m2).add(medias.get(1));
        emprunts.get(m3).add(medias.get(2));
        emprunts.get(m4).add(medias.get(1));
    }

    private static void menuPrincipal() {
        boolean continuer = true;
        while (continuer) {
            afficherMenu();
            try {
                int choix = Integer.parseInt(scanner.nextLine());
                switch (choix) {
                    case 1: afficherEmprunts(); break;
                    case 2: afficherDetailsPolymorphisme(); break;
                    case 3: trierMedias(); break;
                    case 4: filtrerApres2010(); break;
                    case 5: filtrerLivres(); break;
                    case 6: mediasEmpruntesSansDoublons(); break;
                    case 7: testEmpruntable(); break;
                    case 8: copierListeMedias(); break;

                    case 0: continuer = false; System.out.println("Au revoir !"); break;
                    default: System.out.println("Choix invalide !");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Erreur : Saisissez un nombre valide !");
            }
            System.out.println();
        }
    }

    private static void afficherMenu() {
        System.out.println("=== BIBLIOTHÈQUE - TP Généricité ===");
        System.out.println("1. Afficher les emprunts");
        System.out.println("2. Détails (polymorphisme)");
        System.out.println("3. Trier médias (année ↓)");
        System.out.println("4. Médias après 2010");
        System.out.println("5. Seulement les livres");
        System.out.println("6. Médias empruntés (sans doublons)");
        System.out.println("7. Test Empruntable");
        System.out.println("8. Copier la liste des médias");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }

    // Toutes tes méthodes existantes (copie-colle depuis l'ancienne Main)
    private static void afficherEmprunts() {
        System.out.println("Les emprunts détaillés :");
        emprunts.forEach((m, list) -> {
            System.out.print(m + " → ");
            for (Media md : list) {
                System.out.print(md.getTitre() + " : " + md.getDescription() + " | ");
            }
            System.out.println();
        });
    }

    private static void afficherDetailsPolymorphisme() {
        System.out.println("\nDétails (polymorphisme) :");
        for (Media md : medias) {
            md.afficherDetails();
        }
    }

    private static void trierMedias() {
        Collections.sort(medias, new MediaComparator());
        List<Livre> livres = new ArrayList<>();
        for (Media m : medias) if (m instanceof Livre) livres.add((Livre) m);
        Collections.sort(livres, new LivreComparator());

        System.out.println("\nTri MediaComparator : Liste des Médias disponible (livre et cd)");
        medias.forEach(md -> System.out.println(md + " : " + md.getDescription()));
        System.out.println("\nTri LivreComparator : (uniquement les livres)");
        livres.forEach(l -> System.out.println(l + " : " + l.getDescription()));
    }

    private static void filtrerApres2010() {
        List<Media> apres2010 = GenericUtils.filtrer(medias, m -> m.getAnneePublication() > 2010);
        System.out.println("\nMédias après 2010 :");
        GenericUtils.afficherListe(apres2010);
    }

    private static void filtrerLivres() {
        List<Media> livres = GenericUtils.filtrer(medias, m -> m instanceof Livre);
        System.out.println("\nSeulement les livres :");
        GenericUtils.afficherListe(livres);
    }

    private static void mediasEmpruntesSansDoublons() {
        Set<Media> distincts = new HashSet<>();
        for (List<Media> list : emprunts.values()) {
            distincts.addAll(list);
        }
        System.out.println("\nMédias empruntés (sans doublons) :");
        distincts.forEach(m -> System.out.println(m + " : " + m.getDescription()));
    }

    private static void testEmpruntable() {
        System.out.println("\nTest Empruntable :");
        if (!medias.isEmpty()) ((Empruntable) medias.get(0)).emprunter();
        if (medias.size() > 2) ((Empruntable) medias.get(2)).emprunter();
    }

    private static void copierListeMedias() {
        List<Media> copie = new ArrayList<>();

        GenericUtils.copierCollection(medias, copie);

        System.out.println("\nCopie de la liste des médias :");
        GenericUtils.afficherListe(copie);
    }

}
